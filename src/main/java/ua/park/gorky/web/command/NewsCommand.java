package ua.park.gorky.web.command;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Login command.
 * 
 * @author Vladyslav Petrov
 * 
 */
public class NewsCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(NewsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		response.sendRedirect(Path.SERVLET_MAIN_NEWS);
		LOGGER.debug("Command finished");
		return null;

	}
}