package ua.park.gorky.web.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContextListener.class);

	public void contextInitialized(ServletContextEvent sce) {

		log("Servlet context initialization starts");

		ServletContext servletContext = sce.getServletContext();
//		initLog4J(servletContext);
		initCommandContainer();

		log("Servlet context initialization finished");
	}

	/*private void initLog4J(ServletContext servletContext) {
		log("Log4J initialization started");
		try {
			PropertyConfigurator.configure(servletContext
					.getRealPath("WEB-INF/log4j.properties"));
		} catch (Exception ex) {
			LOGGER.error("Cannot configure Log4j", ex);
		}
		log("Log4J initialization finished");
		LOGGER.debug("Log4j has been initialized");
	}
*/
	private void initCommandContainer() {

		try {
			Class.forName("ua.park.gorky.web.command.CommandContainer");
		} catch (ClassNotFoundException ex) {
			throw new IllegalStateException(
					"Cannot initialize Command Container");
		}
	}

	private void log(String msg) {
		System.out.println("[ContextListener] " + msg);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log("Servlet context destruction finished");
	}

}
