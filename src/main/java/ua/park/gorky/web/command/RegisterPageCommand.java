package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command, that redirects the user to the login page
 * 
 * @author Petrov Vladyslav
 * 
 */
public class RegisterPageCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterPageCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		response.sendRedirect(request.getHeader("referer"));

		List<Role> roles = new ArrayList<>();
		for (Role role : Role.values()) {
			roles.add(role);
		}

		session.setAttribute("roles", roles);
		
		session.setAttribute("registerCommand", "register");
		LOGGER.debug("Command finished");
		return null;
	}

}