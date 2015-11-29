package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Comment;
import ua.park.gorky.core.entity.News;
import ua.park.gorky.core.constants.Path;
import ua.park.gorky.db.dao.comment.CommentDAO;
import ua.park.gorky.db.dao.comment.ICommentDAO;
import ua.park.gorky.web.sorter.Sorter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


/**
 * Sort news
 *
 * @author Petrov Vladyslav
 */

public class SortCommand extends Command {

    private static final long serialVersionUID = -3071536593627692473L;

    private static final Logger LOGGER = LoggerFactory.getLogger(SortCommand.class);

    @SuppressWarnings("unchecked")
    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        List<News> news = (List<News>) session.getAttribute("news");

        ICommentDAO commentDAO = new CommentDAO();
        for (News n : news) {
            List<Comment> comments = commentDAO.getCommentsByIdNews(n.getId());
            n.setCommentCount(comments.size());
        }

        int sort = Integer.parseInt(request.getParameter("sortType"));

        String flag1 = String.valueOf(session.getAttribute("flag"));
        int flag = Integer.parseInt(flag1);

        switch (sort) {
            case 1:
                if (flag == 1) {
                    Collections.sort(news, Sorter.SORT_BY_COMMENT);
                    flag = 0;
                } else {
                    Collections.sort(news, Sorter.SORT_BY_COMMENT_REVERSE);
                    flag = 1;
                }
                break;
            case 2:
                if (flag == 1) {
                    Collections.sort(news, Sorter.SORT_NEWS_BY_DATE_REVERSE);
                    flag = 0;
                } else {
                    Collections.sort(news, Sorter.SORT_NEWS_BY_DATE);
                    flag = 1;
                }
                break;
            default:
                break;
        }

        session.setAttribute("flag", flag);

        for (News n : news) {
            if (n.getBody().length() >= 400) {
                n.setBody(n.getBody().substring(0, 400) + "...");
            }
        }

        session.setAttribute("news", news);

        LOGGER.debug("Sort command finished");

        return Path.PAGE_MAIN_NEWS;
    }

}

