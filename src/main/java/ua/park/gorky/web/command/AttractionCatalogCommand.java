package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.db.dao.attraction.AttractionDAO;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(AttractionCatalogCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		IAttractionDAO dao = new AttractionDAO();
		request.setAttribute("attractions", dao.getAttractions());
		LOGGER.debug("Command finished");
		return Path.PAGE_ATTRACTION_CATALOG;
	}

}