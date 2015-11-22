package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.core.entity.constants.Utility;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.core.entity.exception.DataRepeatException;
import ua.park.gorky.core.entity.exception.ValidateException;
import ua.park.gorky.core.entity.validator.UserValidator;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Register command. Service that provides a new user
 * registration.</br><b>Possible user
 * roles:</b></br>User</br>Editor</br>Administrator </br><b>Parameters:</b> login ,
 * password, first_name, last_name, email, phone, dob, role
 * 
 * @author Vladyslav Petrov
 * @version 1.1
 * 
 */
public class RegisterCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();

		String redirRegister = Path.COMMAND_REGISTER_PAGE;

		String rightErrorMessage = null;

		IUserDAO dao = new UserDAO();

		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String date = request.getParameter("dob");

		String roleName = null;
		Role role;
		if (session.getAttribute("userRole") != null) {
			role = Role.ADMIN;
		} else {
			role = Role.USER;
		}

		boolean status = false;

		User user = new User();

		Timestamp regDate = Utility.getDate();
		user.setIdRole(role.getId());
		user.setLogin(login);
		user.setPassword(pass);
		user.setFirstName(first_name);
		user.setLastName(last_name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setStatusBanned(status);
		user.setRegDate(regDate);
		user.setSalt("lalka");

		Date dob = null;
		try {
			dob = Date.valueOf(date);
			user.setDob(dob);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
		}

		if (login.isEmpty() || pass.isEmpty() || first_name.isEmpty()
				|| last_name.isEmpty() || email.isEmpty() || phone.isEmpty()
				|| date.isEmpty()) {

			rightErrorMessage = "��������� �� ��� ���� �����";
			session.setAttribute("rightErrorMessage", rightErrorMessage);
			session.setAttribute("regUser", user);
			response.sendRedirect(redirRegister);
			LOGGER.error("rightErrorMessage --> " + rightErrorMessage);
			return null;
		} else {
			try {
				dao.checkForMatches(user);

			} catch (DataRepeatException ex) {
				rightErrorMessage = ex.getMessage();
				session.setAttribute("rightErrorMessage", rightErrorMessage);
				session.setAttribute("regUser", user);
				response.sendRedirect(redirRegister);
				LOGGER.error("rightErrorMessage --> " + rightErrorMessage);
				return null;
			}

			try {
				new UserValidator().validateUser(user);
			} catch (ValidateException ex) {
				rightErrorMessage = ex.getMessage();
				session.setAttribute("rightErrorMessage", rightErrorMessage);
				session.setAttribute("regUser", user);
				response.sendRedirect(redirRegister);
				LOGGER.error("rightErrorMessage --> " + rightErrorMessage);
				return null;
			}

			try {
				dao.addUser(user);
				String message = "�������� �����������";
				session.setAttribute("message", message);
				LOGGER.error("message --> " + message);
				response.sendRedirect(request.getHeader("referer"));
				session.removeAttribute("registerCommand");
				return null;
			} catch (DBLayerException ex) {
				rightErrorMessage = "������";
				session.setAttribute("rightErrorMessage", rightErrorMessage);
				response.sendRedirect(redirRegister);
				session.setAttribute("regUser", user);
				LOGGER.error("rightErrorMessage --> " + ex.getMessage());
				return null;
			}
		}

	}
}