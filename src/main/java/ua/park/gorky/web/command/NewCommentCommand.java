
package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.entity.constants.Utility;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.constants.DbTables;
import ua.park.gorky.db.dao.comment.CommentDAO;
import ua.park.gorky.db.dao.comment.ICommentDAO;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Register command.
 * 
 * @author Vladyslav Petrov
 * 
 */

public class NewCommentCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();

		String body = request.getParameter("comment");
		int idNews = Integer.parseInt(request.getParameter(DbTables.News.ID));
		User user = (User) session.getAttribute("user");
		
		String errorMessageComment = null;
		
		System.out.println("ERROR --> " + user);
		
		if(body.isEmpty()) {
			errorMessageComment = "���� ������ !";
			session.setAttribute("errorMessageComment", errorMessageComment);
			LOGGER.debug("Command finished");
			response.sendRedirect(request.getHeader("referer"));
			return null;
		}
		
		ICommentDAO dao = new CommentDAO();
		INewsDAO newsDAO = new NewsDAO();
		News news = newsDAO.getNewsById(idNews);

		Comment comment = new Comment();
		
		comment.setBody(body);
		comment.setNews(news);
		comment.setUser(user);
		comment.setWroteDate(Utility.getDate());

		try {
			dao.addComment(comment);
			LOGGER.debug("Command finished");
			response.sendRedirect(request.getHeader("referer"));
			return null;
		} catch (DBLayerException ex) {
			errorMessageComment = ex.getMessage();
			session.setAttribute("errorMessageComment", errorMessageComment);
			LOGGER.error(ex.getMessage());
			response.sendRedirect(request.getHeader("referer"));
			return null;
		}
	}
}
