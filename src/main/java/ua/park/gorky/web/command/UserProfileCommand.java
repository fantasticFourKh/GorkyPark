package ua.park.gorky.web.command;

import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.db.dao.user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfileCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4316924911952297805L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new UserDAO().getUserById(id);
		request.setAttribute("pageUser", user);
		return Path.PAGE_USER_PROFILE;
	}

}
