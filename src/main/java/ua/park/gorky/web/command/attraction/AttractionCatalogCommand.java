package ua.park.gorky.web.command.attraction;

import org.apache.log4j.Logger;
import ua.park.gorky.Path;
import ua.park.gorky.db.DAOImpl;
import ua.park.gorky.web.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Attraction catalog command. Service allowing to see a list of attractions in
 * the system.
 * 
 * @author Vladyslav Petrov
 * 
 * @version 1.0
 * 
 */
public class AttractionCatalogCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOG = Logger
			.getLogger(AttractionCatalogCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		DAOImpl dao = new DAOImpl();
		request.setAttribute("attractions", dao.getAttractions());
		LOG.debug("Command finished");
		return Path.PAGE_ATTRACTION_CATALOG;
	}

}