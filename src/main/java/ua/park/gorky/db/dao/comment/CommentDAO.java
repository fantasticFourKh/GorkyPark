package ua.park.gorky.db.dao.comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.db.connection.MySQLConnection;
import ua.park.gorky.db.constants.DbTables;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 18.11.2015.
 */
public class CommentDAO implements ICommentDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentDAO.class);
    private static final int FIRST = 1;

    private IUserDAO userDAO = new UserDAO();
    private INewsDAO newsDAO = new NewsDAO();

    private static final String DELETE_COMMENT_BY_ID = "DELETE FROM comment WHERE id_comment = ?;";

    private static final String ADD_COMMENT = "INSERT INTO comment (id_user, id_news,"
            + " body, wrote_date) VALUES (?,?,?,?)";

    private static final String GET_COMMENTS_BY_ID_NEWS = "SELECT * FROM comment WHERE id_news = ?";

    @Override
    public void deleteCommentById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(DELETE_COMMENT_BY_ID)) {
            pstm.setInt(FIRST, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to delete comment with id=" + id, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void addComment(Comment comment) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(ADD_COMMENT)) {
            int k = FIRST;
            pstm.setInt(k++, comment.getUser().getId());
            pstm.setInt(k++, comment.getNews().getId());
            pstm.setString(k++, comment.getBody());
            pstm.setTimestamp(k, comment.getWroteDate());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to add comment" + comment, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public List<Comment> getCommentsByIdNews(int idNews) {
        Connection con = MySQLConnection.getWebInstance();
        List<Comment> comments = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement(GET_COMMENTS_BY_ID_NEWS)) {
            pstm.setInt(FIRST, idNews);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                comments.add(extractComment(rs));
            }
            return comments;
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get comment with idnews = " + idNews, ex);
        } finally {
            commit(con);
        }
    }

    private Comment extractComment(ResultSet rs) {
        Comment comment = new Comment();
        try {
            comment.setId(rs.getInt(DbTables.Comment.ID));
            comment.setBody(rs.getString(DbTables.Comment.BODY));
            comment.setWroteDate(rs.getTimestamp(DbTables.Comment.WROTE_DATE));

            News news = newsDAO.getNewsById(rs.getInt(DbTables.Comment.ID_NEWS));
            comment.setNews(news);

            User user = userDAO.getUserById(rs.getInt(DbTables.Comment.ID_USER));
            comment.setUser(user);
            return comment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                LOGGER.error("RollBack: " + ex.getMessage());
            }
        }
    }

    private void commit(Connection con) {
        if (con != null) {
            try {
                con.commit();
                con.close();
            } catch (SQLException ex) {
                LOGGER.error("Commit: " + ex.getMessage());
            }
        }
    }


}
