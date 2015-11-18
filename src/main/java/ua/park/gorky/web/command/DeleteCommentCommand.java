
package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.exception.DBLayerException;
import ua.park.gorky.db.constants.DbTables.Comment;
import ua.park.gorky.db.dao.comment.CommentDAO;
import ua.park.gorky.db.dao.comment.ICommentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommentCommand extends Command {

	private static final long serialVersionUID = -5254283321080992040L;

	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteCommentCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		int id = Integer.parseInt(request.getParameter(Comment.ID));

		ICommentDAO dao = new CommentDAO();

		try {
			dao.deleteCommentById(id);
			response.sendRedirect(request.getHeader("referer"));
			LOGGER.debug("Command finished");
			return null;
		} catch (DBLayerException ex) {
			response.sendRedirect(request.getHeader("referer"));
			LOGGER.error(ex.getMessage());
			return null;
		}
	}

}

