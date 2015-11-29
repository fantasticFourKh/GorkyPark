package ua.park.gorky.web.command.adminCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.db.dao.user.IUserDAO;
import ua.park.gorky.db.dao.user.UserDAO;
import ua.park.gorky.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllUsersCommand extends Command {

	private static final long serialVersionUID = -2740994109923238199L;
	private static final Logger LOGGER = LoggerFactory.getLogger(AllUsersCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		IUserDAO dao = new UserDAO();
		List<User> users = dao.getAllUsers();
		request.setAttribute("users", users);
		LOGGER.debug("Command finished");
		return Path.PAGE_ALL_USERS;
	}

}
