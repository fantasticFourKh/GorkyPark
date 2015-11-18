package ua.park.gorky.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.web.command.Command;
import ua.park.gorky.web.command.CommandContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 2423353715955164816L;

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		LOGGER.debug("Controller starts");

		String commandName = request.getParameter("command");
		LOGGER.trace("Request parameter: command --> " + commandName);

		Command command = CommandContainer.get(commandName);
		LOGGER.trace("Obtained command --> " + command);

		String forward = command.execute(request, response);
		LOGGER.trace("Forward address --> " + forward);

		LOGGER.debug("Controller finished, now go to forward address --> " + forward);

		if (forward != null) {
			RequestDispatcher disp = request.getRequestDispatcher(forward);
			disp.forward(request, response);

		}
	}

}