package ua.park.gorky.web.command.attraction;

import ua.park.gorky.Path;
import ua.park.gorky.db.DAOImpl;
import ua.park.gorky.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Attraction info command. Service allowing user to view information about the
 * selected attraction and book a ticket.
 * </br><b>Parameters:</b> id - id of the Attraction in the database
 * @author Vladyslav Petrov
 * @version 1.0
 * 
 */
public class AttractionInfoCommand extends Command {

	private static final long serialVersionUID = 6758979415702026134L;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("attraction", new DAOImpl().getAttractionById(id));
		return Path.PAGE_ATTRACTION;
	}

}
