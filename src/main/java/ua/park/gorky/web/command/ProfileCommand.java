package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5254283321080992040L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		LOGGER.debug("Command finished");
		return Path.PAGE_PROFILE;
	}

}
