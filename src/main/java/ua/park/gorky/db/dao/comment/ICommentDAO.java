package ua.park.gorky.db.dao.comment;

import org.springframework.stereotype.Repository;
import ua.park.gorky.core.entity.Comment;

import java.util.List;

/**
 * Created by Владислав on 18.11.2015.
 */
@Repository
public interface ICommentDAO {

    void deleteCommentById(int id);

    void addComment(Comment comment);

    List<Comment> getCommentsByIdNews(int idNews);
}
