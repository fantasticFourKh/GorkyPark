
package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.db.constants.DbTables;
import ua.park.gorky.db.dao.comment.CommentDAO;
import ua.park.gorky.db.dao.comment.ICommentDAO;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Register command.
 * 
 * @author Vladyslav Petrov
 * 
 */

public class OneNewsCommentCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(OneNewsCommentCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int idNews = Integer.parseInt(request.getParameter(DbTables.News.ID));
		
		ICommentDAO commentDAO = new CommentDAO();
		INewsDAO newsDAO = new NewsDAO();

		News news = newsDAO.getNewsById(idNews);
		List<Comment> comments = commentDAO.getCommentsByIdNews(idNews);
		news.setCommentCount(comments.size());

		request.setAttribute("comments", comments);
		request.setAttribute("news", news);

		LOGGER.debug("Command finished");
		return Path.PAGE_ONE_NEWS;
	}
}
