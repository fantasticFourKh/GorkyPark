package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Subscriber command to change the password
 * 
 * @author Petrov Vladyslav
 * 
 */
public class ChangeUserPasswordCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(AddAttractionCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();

		String curPass = request.getParameter("curPass");
		String newPass = request.getParameter("newPass");
		String newPass2 = request.getParameter("newPass2");

		User user = (User) session.getAttribute("user");

		IUserDAO dao = new UserDAO();

		if (curPass.isEmpty() || newPass.isEmpty() || newPass2.isEmpty()) {
			session.setAttribute("errorMessage_1", "��������� �� ��� ����");
			LOGGER.error("ErrorMessage:     "
					+ session.getAttribute("errorMessage_1"));
			response.sendRedirect(Path.COMMAND_PROFILE);
			return null;
		} else {

			if (!newPass.equals(newPass2)) {
				session.setAttribute("errorMessage_1", "������ �� ���������");
				LOGGER.error("ErrorMessage:     "
						+ session.getAttribute("errorMessage_1"));
				response.sendRedirect(Path.COMMAND_PROFILE);
				return null;
			}

			if (user.getPassword().equals(curPass)) {
				if (curPass.equals(newPass)) {
					session.setAttribute("errorMessage_1", "������ ���������");
					LOGGER.error("ErrorMessage:     "
							+ session.getAttribute("errorMessage_1"));
					response.sendRedirect(Path.COMMAND_PROFILE);
					return null;
				}

				if (!UserValidator.validateLoginPassword(newPass)) {
					session.setAttribute(
							"errorMessage_1",
							"����������� ����� ������ = 3, ������������ = 16. ���������� �������: a-z, A-Z, 0-9, _, -");
					LOGGER.error("ErrorMessage:     "
							+ session.getAttribute("errorMessage_1"));
					response.sendRedirect(Path.COMMAND_PROFILE);
					return null;
				} else {
					user.setPassword(newPass);
					session.setAttribute("message_1", "������ ������� �������");
					LOGGER.error("Message:     "
							+ session.getAttribute("message_1"));
					dao.updateUserPassword(user);
				}
			} else {
				session.setAttribute("errorMessage_1", "�������� ������ !");
				LOGGER.error("ErrorMessage:     "
						+ session.getAttribute("errorMessage_1"));
				response.sendRedirect(Path.COMMAND_PROFILE);
				return null;
			}
		}

		response.sendRedirect(Path.COMMAND_PROFILE);

		LOGGER.debug("Command finished");
		return null;
	}
}