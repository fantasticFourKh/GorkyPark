package ua.park.gorky.web.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.park.gorky.core.bean.AdminUserBean;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.service.api.IRoleService;
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
@RequestMapping(value = WebConsts.Mapping.ADMIN)
public class AdminUserController extends AbstractController implements UserBeanValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private IBeanValidator beanValidator;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = WebConsts.Mapping.USER + WebConsts.Mapping.PAGE, method = RequestMethod.GET)
    public ModelAndView getRegPage() {
        ModelAndView modelAndView = createMaV(WebConsts.View.ADMIN_REGISTER);
        modelAndView.addObject(WebConsts.ClientSideEntities.ROLES, roleService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = WebConsts.Mapping.USER + WebConsts.Mapping.VIEW, method = RequestMethod.GET)
    public ModelAndView getAll() {
        List<User> users = userService.getAll();
        ModelAndView modelAndView = createMaV(WebConsts.View.ALL_USERS);
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = WebConsts.Mapping.USER + WebConsts.Mapping.STATUS, method = RequestMethod.POST)
    public ModelAndView changeUserStatus(@RequestParam int id) {
        User user = userService.get(id);
        if (user == null) {
            LOGGER.debug("User not found by id: " + id);
            return getNotFoundError("No user was found.");
        }
        changeUserStatus(user);
        LOGGER.debug(user.getLogin() + " status changed to: " + user.isStatusBanned());
        return createMaV(WebConsts.REDIRECT + WebConsts.REFERER);
    }

    private void changeUserStatus(User user) {
        if (user.isStatusBanned()) {
            user.setStatusBanned(false);
        } else {
            user.setStatusBanned(true);
        }
    }

    @RequestMapping(value = WebConsts.Mapping.USER + WebConsts.Mapping.ADD, method = RequestMethod.POST)
    public ModelAndView registerUser(HttpSession session, ModelMap modelMap) {
        AdminUserBean bean = buildBean(modelMap);
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
        LOGGER.info(bean.getLogin() + " registered with role " + bean.getRole());

        return modelAndView;
    }

    private AdminUserBean buildBean(ModelMap modelMap) {
        String login = (String) modelMap.get("inputLogin");
        String pass = (String) modelMap.get("inputPassword");
        String repeatPass = (String) modelMap.get("inputRepeatPassword");
        String firstName = (String) modelMap.get("inputFName");
        String lastName = (String) modelMap.get("inputLName");
        String email = (String) modelMap.get("inputEmail");
        String phone = (String) modelMap.get("inputPhone");
        String date = (String) modelMap.get("inputDob");
        String role = (String) modelMap.get("selectRole");

        AdminUserBean bean = new AdminUserBean();
        bean.setLogin(login);
        bean.setPassword(pass);
        bean.setRepeatPassword(repeatPass);
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        bean.setEmail(email);
        bean.setPhone(phone);
        bean.setDob(date);
        bean.setRole(role);
        return bean;
    }
}
