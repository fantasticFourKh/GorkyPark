package ua.park.gorky.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.service.api.IAttractionService;

/**
 * @author Vladyslav
 */
@Controller
@RequestMapping("/attraction")
public class BasicAttractionController {

    @Autowired
    private IAttractionService attractionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(ModelMap map) {
        ModelAndView modelAndView = new ModelAndView("ViewName");
        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("attractions", attractionService.getAll());
        return modelAndView;
    }
}
