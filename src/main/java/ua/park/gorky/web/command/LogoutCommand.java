package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logout command.
 * 
 * @author Vladyslav Petrov
 * 
 */
public class LogoutCommand extends Command {

	private static final long serialVersionUID = -2785976616686657267L;

	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		response.sendRedirect(Path.SERVLET_MAIN_NEWS);
		LOGGER.debug("Command finished");
		return null;
	}

}