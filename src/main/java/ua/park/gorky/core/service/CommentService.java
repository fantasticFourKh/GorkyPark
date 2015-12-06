package ua.park.gorky.core.service;

import org.springframework.stereotype.Service;
import ua.park.gorky.core.bean.CommentBean;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.service.api.ICommentService;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Service
public class CommentService implements ICommentService {
    @Override
    public void create(CommentBean bean) {

    }

    @Override
    public void update(CommentBean bean) {

    }

    @Override
    public void delete(int commentId) {

    }

    @Override
    public List<Comment> findByArticle(int articleId) {
        return null;
    }
}
