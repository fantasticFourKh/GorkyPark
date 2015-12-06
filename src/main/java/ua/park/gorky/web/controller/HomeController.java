package ua.park.gorky.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.service.api.INewsService;
import ua.park.gorky.web.constants.WebConsts;

import java.util.List;

/**
 * @author Vladyslav_Yemelianov
 */
@Controller
public class HomeController extends AbstractController {

    @Autowired
    private INewsService newsService;

    @RequestMapping(value = WebConsts.Mapping.HOME, method = RequestMethod.GET)
    public ModelAndView goHome() {
        List<News> newsList = newsService.getAll();

        ModelAndView modelAndView = createMaV(WebConsts.View.INDEX);
        modelAndView.addObject(WebConsts.ClientSideEntities.NEWS, newsList);
        return modelAndView;
    }
}
