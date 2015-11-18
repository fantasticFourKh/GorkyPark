package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.User;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.core.entity.constants.Utility;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Register command.
 * 
 * @author Vladyslav Petrov
 *
 **/


public class AddNewsCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOGGER = LoggerFactory.getLogger(AddNewsCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();

		String redirRegister = Path.SERVLET_MAIN_NEWS;

		String errorMessage = null;

		String title = request.getParameter("title");
		String desc = request.getParameter("desc");

		String picPath = null;
		String savePath = Path.NEWS_IMAGES;
		
		if (title.isEmpty() || desc.isEmpty()) {
			errorMessage = "��������� �� ��� ���� �����";
			session.setAttribute("addErrorMessage", errorMessage);
			response.sendRedirect(redirRegister + "#add_news");
			LOGGER.error("ErrorMessage --> " + errorMessage);
			return null;
		} else {

			INewsDAO dao = new NewsDAO();
			
			User user = (User) session.getAttribute("user");

			News news = new News();
			Timestamp postDate = Utility.getDate();

			
			Part part = request.getPart("image");
			picPath = savePath + File.separator + Utility.createNewPath();
			part.write(picPath);
			
			news.setTitle(title);
			news.setBody(desc);
			news.setUser(user);
			news.setNewsPicture(picPath);
			news.setPostDate(postDate);

			try {
				dao.addNews(news);
				String message = "�������� ����������";
				session.setAttribute("message", message);
				LOGGER.error("message --> " + message);
				response.sendRedirect(redirRegister);
				return null;
			} catch (DBLayerException ex) {
				errorMessage = "������";
				session.setAttribute("addErrorMessage", errorMessage);
				response.sendRedirect(request.getHeader("referer")
						+ "#add_news");
				LOGGER.error("ErrorMessage --> " + errorMessage);
				return null;
			}
		}

	}
}
