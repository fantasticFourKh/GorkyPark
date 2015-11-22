
package ua.park.gorky.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.entity.constants.Path;
import ua.park.gorky.db.dao.comment.CommentDAO;
import ua.park.gorky.db.dao.comment.ICommentDAO;
import ua.park.gorky.db.dao.news.INewsDAO;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Main extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private static void process(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setContentType("text/html");

        INewsDAO dao = new NewsDAO();
        List<News> news = dao.getAllNews();

        ICommentDAO commentDAO = new CommentDAO();

        for (News n : news) {
            if (n.getBody().length() >= 400) {
                n.setBody(n.getBody().substring(0, 400) + "...");
            }
            List<Comment> comments = commentDAO.getCommentsByIdNews(n.getId());
            n.setCommentCount(comments.size());

        }

        session.setAttribute("news", news);

        LOGGER.debug("Command finished");

        session.setAttribute("flag", 1);

        RequestDispatcher rd = request
                .getRequestDispatcher(Path.PAGE_MAIN_NEWS);

        rd.forward(request, response);


    }
}

