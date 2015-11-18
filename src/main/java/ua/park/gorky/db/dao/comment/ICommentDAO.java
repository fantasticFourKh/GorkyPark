package ua.park.gorky.db.dao.comment;

import ua.park.gorky.core.entity.Comment;

import java.util.List;

/**
 * Created by Владислав on 18.11.2015.
 */
public interface ICommentDAO {

    void deleteCommentById(int id);

    void addComment(Comment comment);

    List<Comment> getCommentsByIdNews(int idNews);
}
