
package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.constants.DbTables;
import ua.park.gorky.db.dao.news.NewsDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteNewsCommand extends Command {

    private static final long serialVersionUID = -5254283321080992040L;

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteNewsCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException {

        int idNews = Integer.parseInt(request.getParameter(DbTables.News.ID));

        try {
            new NewsDAO().deleteNewsById(idNews);
            response.sendRedirect(request.getHeader("referer"));
            LOGGER.debug("Delete command finished");
            return null;
        } catch (DBLayerException ex) {
            response.sendRedirect(request.getHeader("referer"));
            LOGGER.error(ex.getMessage());
            return null;
        }
    }

}

