package ua.park.gorky.web.command.attraction;

import ua.park.gorky.Path;
import ua.park.gorky.web.command.Command;

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
