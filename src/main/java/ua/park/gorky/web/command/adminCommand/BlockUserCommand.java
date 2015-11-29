package ua.park.gorky.web.command.adminCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.core.exception.DBLayerException;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;
import ua.park.gorky.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * 
 * @author Vladislav
 * @version 1.0
 * @since 05.05.2015
 * 
 * �����, ��������������� ��� ���������� �������������.
 * 
 * @see AllUsersCommand
 * 
 */
public class BlockUserCommand extends Command {

	private static final long serialVersionUID = 2227599620355326961L;
	private static final Logger LOGGER = LoggerFactory.getLogger(BlockUserCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int idUser = Integer.parseInt(request.getParameter("id"));

		IUserDAO dao = new UserDAO();

		User user = dao.getUserById(idUser);

		if (user.isStatusBanned()) {
			user.setStatusBanned(false);
		} else {
			user.setStatusBanned(true);
		}

		try {
			dao.updateUserStatus(user);
			response.sendRedirect(Path.COMMAND_VIEW_USERS);
			LOGGER.debug("Command finished");
			return null;
		} catch (DBLayerException ex) {
			LOGGER.debug(ex.getMessage());
			return null;
		}
	}

}
