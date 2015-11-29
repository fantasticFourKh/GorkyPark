package ua.park.gorky.db.dao.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.db.connection.MySQLConnection;
import ua.park.gorky.db.constants.DbTables;
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
public class NewsDAO implements INewsDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsDAO.class);

    private static final String ADD_NEWS = "INSERT INTO News (id_user, title, body, news_picture," +
            " post_date) VALUES (?,?,?,?,?)";

    private static final String DELETE_NEWS = "DELETE FROM News WHERE id_news = ?;";

    private static final String GET_ALL_NEWS = "SELECT * FROM News;";

    private static final String GET_NEWS_BY_ID = "SELECT * FROM News WHERE id_news = ?;";

    private static final String GET_NEWS_BY_TITLE_BODY = "SELECT * FROM News WHERE title LIKE ? OR body LIKE ? ORDER BY id_News DESC;";

    private static final String DELETE_COMMENT_BY_NEWS = "DELETE FROM Comment WHERE id_news = ?;";

    private static final int FIRST = 1;

    private IUserDAO userDAO = new UserDAO();

    @Override
    public void addNews(News news) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(ADD_NEWS)) {
            int k = FIRST;
            pstm.setInt(k++, news.getUser().getId());
            pstm.setString(k++, news.getTitle());
            pstm.setString(k++, news.getBody());
            pstm.setString(k++, news.getNewsPicture());
            pstm.setTimestamp(k, news.getPostDate());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to add news" + news, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public void deleteNewsById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try {
            PreparedStatement pstm = con.prepareStatement(DELETE_COMMENT_BY_NEWS);
            pstm.setInt(FIRST, id);
            pstm.executeUpdate();

            pstm = con.prepareStatement(DELETE_NEWS);
            pstm.setInt(FIRST, id);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to delete news with id=" + id, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public News getNewsById(int id) {
        Connection con = MySQLConnection.getWebInstance();
        try (PreparedStatement pstm = con.prepareStatement(GET_NEWS_BY_ID)) {
            pstm.setInt(FIRST, id);
            ResultSet rs = pstm.executeQuery();
            rs.relative(FIRST);
            return extractNews(rs);
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get news with id = " + id, ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public List<News> getAllNews() {
        Connection con = MySQLConnection.getWebInstance();
        List<News> news = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement(GET_ALL_NEWS)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                news.add(extractNews(rs));
            }
            return news;
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get news", ex);
        } finally {
            commit(con);
        }
    }

    @Override
    public List<News> getNewsByTitleBody(String text) {
        Connection con = MySQLConnection.getWebInstance();
        List<News> newses = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement(GET_NEWS_BY_TITLE_BODY)) {
            int k = FIRST;
            pstm.setString(k++, "%" + text + "%");
            pstm.setString(k, "%" + text + "%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                newses.add(extractNews(rs));
            }
            return newses;
        } catch (SQLException ex) {
            rollback(con);
            throw new DBLayerException("Failed to get news with query=" + text, ex);
        } finally {
            commit(con);
        }
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

    private News extractNews(ResultSet rs) {
        News news = new News();
        try {
            news.setId(rs.getInt(DbTables.News.ID));
            news.setTitle(rs.getString(DbTables.News.TITLE));
            news.setBody(rs.getString(DbTables.News.BODY));
            news.setPostDate(rs.getTimestamp(DbTables.News.POST_DATE));
            news.setNewsPicture(rs.getString(DbTables.News.PICTURE));

            User user = userDAO.getUserById(rs.getInt(DbTables.User.ID));
            news.setUser(user);

            return news;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
