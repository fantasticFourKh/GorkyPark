package ua.park.gorky.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;

/**
 * @author Vladyslav
 */
@Controller
@RequestMapping("/attraction")
public class BasicAttractionController {

    @Autowired
    private IAttractionDAO attractionDAO;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(ModelMap map) {
        ModelAndView modelAndView = new ModelAndView("ViewName");
        return modelAndView;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("attractions");
        modelAndView.addObject("attractions", attractionDAO.getAttractions());
        return modelAndView;
    }
}
