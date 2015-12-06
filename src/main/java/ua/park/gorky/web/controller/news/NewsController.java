package ua.park.gorky.web.controller.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.park.gorky.core.bean.NewsBean;
import ua.park.gorky.core.entity.Comment;
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
@RequestMapping(value = WebConsts.Mapping.NEWS)
public class NewsController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);
    private static final String ARTICLE_ID = "articleId";

    @Autowired
    private IBeanValidator beanValidator;

    @Autowired
    private INewsService newsService;

    @Autowired
    private ICommentService commentService;

    @RequestMapping(value = WebConsts.Mapping.PAGE, method = RequestMethod.GET)
    public String getAddPage() {
        return WebConsts.View.NEWS_NEW;
    }

    @RequestMapping(value = WebConsts.Mapping.ID, method = RequestMethod.GET)
    public ModelAndView getOneArticle(@PathVariable(value = ARTICLE_ID) int id) {
        News news = newsService.get(id);
        if (news == null) {
            return getNotFoundError("No article found.");
        }
        List<Comment> commentList = commentService.findByArticle(news.getId());
        return createMaV(WebConsts.View.NEWS)
                .addObject(WebConsts.ClientSideEntities.NEWS, news)
                .addObject(WebConsts.ClientSideEntities.COMMENTS, commentList);
    }

    @RequestMapping(value = WebConsts.Mapping.DELETE, method = RequestMethod.GET)
    public String deleteArticle(HttpSession session, @RequestParam(value = ARTICLE_ID) int id) {
        User currentUser = getCurrentUser(session);
        try {
            newsService.delete(id);
            LOGGER.debug("Article with id: %d was deleted by %s", id, currentUser.getLogin());
        } catch (DBLayerException e) {
            LOGGER.error("Article with id: %d not found. Request sent by %s", id, currentUser.getLogin());
        }
        return WebConsts.REDIRECT_REFERER;
    }

    @RequestMapping(value = WebConsts.Mapping.ADD, method = RequestMethod.POST)
    public ModelAndView addArticle(HttpSession session, ModelMap modelMap) {
        NewsBean newsBean = buildBean(modelMap);
        Map<String, List<String>> errorsMap = beanValidator.validateBean(newsBean);
        ModelAndView modelAndView = createMaV();
        if (CollectionUtil.isNotEmpty(errorsMap)) {
            modelAndView.setViewName(WebConsts.View.NEWS_NEW);
            return getModelWithErrors(errorsMap, modelAndView, WebConsts.ClientSideEntities.NEWS_INVALID_BEAN, session, newsBean);
        }
        clearSessionFromObj(session, WebConsts.ClientSideEntities.NEWS_INVALID_BEAN);
        newsService.create(newsBean);
        LOGGER.debug(newsBean + " created.");
        modelAndView.setViewName(WebConsts.REDIRECT + WebConsts.Mapping.HOME);
        return modelAndView;
    }

    private NewsBean buildBean(ModelMap modelMap) {
        String title = (String) modelMap.get("inputTitle");
        String description = (String) modelMap.get("inputDesc");

        NewsBean bean = new NewsBean();
        bean.setTitle(title);
        bean.setDescription(description);
        return bean;
    }
}
