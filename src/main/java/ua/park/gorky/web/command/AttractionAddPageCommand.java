package ua.park.gorky.web.command;

import ua.park.gorky.core.entity.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AttractionAddPageCommand extends Command {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306415828547221336L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		return Path.PAGE_ADD_ATTRACTION;
	}

}
