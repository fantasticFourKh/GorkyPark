
package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 
 * Sort news
 * 
 * @author Petrov Vladyslav
 * 
 */

public class SearchCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		INewsDAO dao = new NewsDAO();

		String text = request.getParameter("query");

		HttpSession session = request.getSession();

		List<News> news = null;

		if (text.isEmpty()) {
			LOGGER.error("Empty text field");
			return Path.COMMAND_MAIN;
		} else {
			news = dao.getNewsByTitleBody(text);
		}

		if(news.isEmpty()) {
			LOGGER.error("No news found\tquery = " + text);
			request.setAttribute("queryerror", "������ �� �������!");
			return Path.PAGE_MAIN_NEWS;
		}


		for (News n : news) {
			if (n.getBody().length() >= 400) {
				n.setBody(n.getBody().substring(0, 400) + "...");
			}
		}

		session.setAttribute("news", news);

		LOGGER.debug("Search command finished");

		return Path.PAGE_MAIN_NEWS;
	}
}

