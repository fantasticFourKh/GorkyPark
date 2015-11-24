package ua.park.gorky.web.controller;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav
 */
public abstract class AbstractController {
    protected ModelAndView createMaV(String viewName) {
        return new ModelAndView(viewName);
    }
}
