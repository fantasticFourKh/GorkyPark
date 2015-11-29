package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login command. Service allowing to identify the user in the system.
 * </br><b>Parameters:</b> login, password
 *
 * @author Vladyslav Petrov
 * @version 1.0
 */
public class LoginCommand extends Command {

    private static final long serialVersionUID = -3071536593627692473L;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        LOGGER.trace("Login --> " + login + "\tPassword --> " + password);

        if (login.isEmpty() || password.isEmpty()) {
            response.sendRedirect(request.getHeader("referer"));
            session.setAttribute("errorMessage", "�������� �����/������");
            LOGGER.debug("Incorrect login/password");
            return null;
        }

        try {
            IUserDAO dao = new UserDAO();
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user = dao.getUserByLoginPassword(user);

            if (user.isStatusBanned()) {
                response.sendRedirect(request.getHeader("referer"));
                session.setAttribute("rightErrorMessage",
                        "������������ ������������");
                LOGGER.debug("User has been blocked");
                return null;
            }

            Role role = Role.getRole(user);

            response.sendRedirect(request.getHeader("referer"));

            session.setAttribute("user", user);
            session.setAttribute("userRole", role);
            LOGGER.debug("Login: --> user = " + user.getLogin() + " Role = "
                    + role);
            return null;

        } catch (DBLayerException ex) {
            response.sendRedirect(request.getHeader("referer"));
            session.setAttribute("rightErrorMessage", ex.getMessage());
            LOGGER.debug(ex.getMessage());
            return null;
        }
    }
}