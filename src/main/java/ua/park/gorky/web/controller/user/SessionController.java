package ua.park.gorky.web.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.service.api.IRoleService;
import ua.park.gorky.core.service.api.IUserService;
import ua.park.gorky.web.constants.WebConsts;
import ua.park.gorky.web.controller.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Vladyslav
 */
@Controller
public class SessionController extends AbstractController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = WebConsts.Mapping.LOGOUT, method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return WebConsts.View.INDEX;
    }

    @RequestMapping(value = WebConsts.Mapping.LOGIN, method = RequestMethod.POST)
    public String login(HttpServletRequest request) {
        String login = request.getParameter("inputLogin");
        String pass = request.getParameter("inputPassword");
        HttpSession session = request.getSession();
        String referer = request.getHeader(WebConsts.REFERER);
        String redirect = WebConsts.REDIRECT + referer;

        if (StringUtils.isBlank(login) || StringUtils.isBlank(pass)) {
            setErrorAttribute(session, "No values found");
            return redirect;
        }

        User user = userService.getByLogin(login);

        if (user == null) {
            setErrorAttribute(session, "No user with this login");
            return redirect;
        }

        if (!user.getPassword().equals(pass)) {
            setErrorAttribute(session, "Invalid password for account");
            return redirect;
        }

        Role userRole = roleService.get(user.getIdRole());
        session.setAttribute(WebConsts.LOGGED_USER, user);
        session.setAttribute(WebConsts.LOGGED_USER_ROLE, userRole);
        return redirect;
    }

    private void setErrorAttribute(HttpSession session, String msg) {
        session.setAttribute(WebConsts.ClientSideEntities.INVALID_LOGIN, msg);
    }
}
