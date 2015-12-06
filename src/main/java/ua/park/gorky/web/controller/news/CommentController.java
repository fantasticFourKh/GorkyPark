package ua.park.gorky.web.controller.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.park.gorky.core.bean.CommentBean;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.core.service.api.ICommentService;
import ua.park.gorky.core.service.api.INewsService;
import ua.park.gorky.core.util.CollectionUtil;
import ua.park.gorky.core.validator.api.IBeanValidator;
import ua.park.gorky.web.constants.WebConsts;
import ua.park.gorky.web.controller.AbstractController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
@RequestMapping(value = WebConsts.Mapping.COMMENT)
public class CommentController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private IBeanValidator beanValidator;

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = WebConsts.Mapping.DELETE, method = RequestMethod.GET)
    public String delete(HttpSession session, @RequestParam(value = "commentId") int id) {
        User currentUser = getCurrentUser(session);
        try {
            commentService.delete(id);
            LOGGER.debug("Comment with id: %d was deleted by %s", id, currentUser.getLogin());
        } catch (DBLayerException e) {
            LOGGER.debug("Comment with id: %d wasn't found. Request sent by %s", id, currentUser.getLogin());
        }
        return WebConsts.REDIRECT_REFERER;
    }

    @RequestMapping(value = WebConsts.Mapping.EDIT, method = RequestMethod.POST)
    public String updateComment(HttpSession session, ModelMap modelMap) {
        CommentBean commentBean = buildBean(modelMap);
        Map<String, List<String>> errorMap = beanValidator.validateBean(commentBean);
        if (CollectionUtil.isNotEmpty(errorMap)) {
            session.setAttribute(WebConsts.ClientSideEntities.VALIDATION_ERRORS, errorMap);
            LOGGER.debug("Errors found in comment : " + errorMap.toString());
            return WebConsts.REDIRECT_REFERER;
        }
        int articleId = Integer.parseInt(commentBean.getArticleId());
        News news = newsService.get(articleId);
        if (news == null) {
            LOGGER.error("Article not found by id: " + articleId);
            return WebConsts.REDIRECT_REFERER;
        }
        clearSessionFromObj(session, WebConsts.ClientSideEntities.VALIDATION_ERRORS);
        commentService.update(commentBean);
        return WebConsts.REDIRECT_REFERER;
    }

    @RequestMapping(value = WebConsts.Mapping.ADD, method = RequestMethod.POST)
    public String createComment(HttpSession session, ModelMap modelMap) {
        CommentBean commentBean = buildBean(modelMap);
        Map<String, List<String>> errorMap = beanValidator.validateBean(commentBean);
        if (CollectionUtil.isNotEmpty(errorMap)) {
            session.setAttribute(WebConsts.ClientSideEntities.VALIDATION_ERRORS, errorMap);
            LOGGER.debug("Errors found in comment : " + errorMap.toString());
            return WebConsts.REDIRECT_REFERER;
        }
        int articleId = Integer.parseInt(commentBean.getArticleId());
        News news = newsService.get(articleId);
        if (news == null) {
            LOGGER.error("Article not found by id: " + articleId);
            return WebConsts.REDIRECT_REFERER;
        }
        clearSessionFromObj(session, WebConsts.ClientSideEntities.VALIDATION_ERRORS);
        commentService.create(commentBean);
        return WebConsts.REDIRECT_REFERER;
    }


    private CommentBean buildBean(ModelMap modelMap) {
        String articleId = (String) modelMap.get("id_news");
        String body = (String) modelMap.get("commentBody");

        CommentBean bean = new CommentBean();
        bean.setArticleId(articleId);
        bean.setBody(body);
        return bean;
    }
}
