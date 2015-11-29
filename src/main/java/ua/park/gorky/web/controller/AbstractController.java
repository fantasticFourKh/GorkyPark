package ua.park.gorky.web.controller;

import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.bean.ViewBean;
import ua.park.gorky.web.constants.WebConsts;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav
 */
public abstract class AbstractController {
    protected ModelAndView createMaV(String viewName) {
        return new ModelAndView(viewName);
    }

    protected ModelAndView createMaV() {
        return new ModelAndView();
    }

    protected void sendError(Map<String, List<String>> errors, ModelAndView modelAndView, String viewName) {
        modelAndView.setViewName(viewName);
        modelAndView.addObject(WebConsts.ClientSideEntities.VALIDATION_ERRORS, errors);
    }

    protected ModelAndView getModelWithErrors(Map<String, List<String>> errors, ModelAndView modelAndView,
                                            HttpSession session, ViewBean bean) {
        sendError(errors, modelAndView, WebConsts.View.REGISTER);
        session.setAttribute(WebConsts.ClientSideEntities.USER_INVALID_BEAN, bean);
        return modelAndView;
    }
}
