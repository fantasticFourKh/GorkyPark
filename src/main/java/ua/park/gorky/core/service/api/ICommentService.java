package ua.park.gorky.core.service.api;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.CommentBean;
import ua.park.gorky.core.entity.Comment;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public interface ICommentService {
    void create(CommentBean bean);

    void update(CommentBean bean);

    void delete(int commentId);

    List<Comment> findByArticle(int articleId);
}
