package ua.park.gorky.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.park.gorky.core.bean.UserBean;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.service.api.IUserService;
import ua.park.gorky.core.util.CollectionUtil;
import ua.park.gorky.core.validator.additional.UserBeanValidator;
import ua.park.gorky.core.validator.api.IBeanValidator;
import ua.park.gorky.web.constants.WebConsts;
import ua.park.gorky.web.controller.AbstractController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Vladyslav
 */
@Controller
@RequestMapping(value = WebConsts.Mapping.USER)
public class UserController extends AbstractController implements UserBeanValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IBeanValidator beanValidator;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = WebConsts.Mapping.PAGE, method = RequestMethod.GET)
    public String getPage() {
        return WebConsts.View.REGISTER;
    }

    @RequestMapping(value = WebConsts.Mapping.ID, method = RequestMethod.GET)
    public ModelAndView getProfile(@PathVariable int id) {
        User user = userService.get(id);
        if (user == null) {
            return getNotFoundError("User was not found.");
        }
        ModelAndView modelAndView = createMaV(WebConsts.View.USER_PROFILE);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = WebConsts.Mapping.PROFILE, method = RequestMethod.GET)
    public String getProfile() {
        return WebConsts.View.PROFILE;
    }

    @RequestMapping(value = WebConsts.Mapping.ADD, method = RequestMethod.POST)
    public ModelAndView createNew(HttpSession session, ModelMap modelMap) {
        UserBean bean = buildBean(modelMap);
        Map<String, List<String>> errors = beanValidator.validateBean(bean);

        ModelAndView modelAndView = createMaV();

        if (CollectionUtil.isNotEmpty(errors)) {
            LOGGER.debug(errors.toString() + " occurred while registration.");
            return getModelWithErrors(errors, modelAndView, WebConsts.ClientSideEntities.USER_INVALID_BEAN, session, bean);
        }
        validateDob(errors, bean.getDob());
        comparePasswords(errors, bean.getPassword(), bean.getRepeatPassword());
        if (CollectionUtil.isNotEmpty(errors)) {
            LOGGER.debug(errors.toString() + " occurred while registration.");
            return getModelWithErrors(errors, modelAndView, WebConsts.ClientSideEntities.USER_INVALID_BEAN, session, bean);
        }
        clearSessionFromObj(session, WebConsts.ClientSideEntities.USER_INVALID_BEAN);
        userService.create(bean);
        LOGGER.debug(bean.getLogin() + " registered.");

        return modelAndView;
    }

    private UserBean buildBean(ModelMap modelMap) {
        String login = (String) modelMap.get("inputLogin");
        String pass = (String) modelMap.get("inputPassword");
        String repeatPass = (String) modelMap.get("inputRepeatPassword");
        String firstName = (String) modelMap.get("inputFName");
        String lastName = (String) modelMap.get("inputLName");
        String email = (String) modelMap.get("inputEmail");
        String phone = (String) modelMap.get("inputPhone");
        String date = (String) modelMap.get("inputDob");

        UserBean bean = new UserBean();
        bean.setLogin(login);
        bean.setPassword(pass);
        bean.setRepeatPassword(repeatPass);
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setEmail(email);
        bean.setPhone(phone);
        bean.setDob(date);
        return bean;
    }

}
