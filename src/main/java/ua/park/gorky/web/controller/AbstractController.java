package ua.park.gorky.web.controller;

import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.bean.ViewBean;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.core.constants.Utility;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.web.constants.WebConsts;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
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

    protected void setErrorsToModel(Map<String, List<String>> errors, ModelAndView modelAndView, String viewName) {
        modelAndView.setViewName(viewName);
        modelAndView.addObject(WebConsts.ClientSideEntities.VALIDATION_ERRORS, errors);
    }

    protected ModelAndView getNotFoundError(String message) {
        ModelAndView modelAndView = createMaV(WebConsts.View.ERROR);
        modelAndView.addObject(WebConsts.ClientSideEntities.ERROR_CODE, WebConsts.ErrorCodes.NOT_FOUND);
        modelAndView.addObject(WebConsts.ClientSideEntities.ERROR_MSG, message);
        return modelAndView;
    }

    protected ModelAndView getModelWithErrors(Map<String, List<String>> errors, ModelAndView modelAndView, String invalidBeanName,
                                              HttpSession session, ViewBean bean) {
        setErrorsToModel(errors, modelAndView, WebConsts.View.REGISTER);
        session.setAttribute(invalidBeanName, bean);
        return modelAndView;
    }

    protected void clearSessionFromObj(HttpSession session, String beanName) {
        session.removeAttribute(beanName);
    }

    protected String writePartToFile(Part imagePart) throws IOException {
        String savePath = Path.ATTRACTION_IMAGES;

        File folder = new File(savePath);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String picPath = savePath + File.separator + Utility.createNewPath();
        imagePart.write(picPath);
        return picPath;
    }

    protected User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute(WebConsts.LOGGED_USER);
    }
}
