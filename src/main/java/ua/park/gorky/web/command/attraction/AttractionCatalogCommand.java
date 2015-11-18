package ua.park.gorky.web.command.attraction;

import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.db.dao.attraction.AttractionDAO;
import ua.park.gorky.db.dao.attraction.IAttractionDAO;
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
 */
public class AttractionCatalogCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private final IAttractionDAO attractionDAO = new AttractionDAO();

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		request.setAttribute("attractions", attractionDAO.getAttractions());
		return Path.PAGE_ATTRACTION_CATALOG;
	}

}