package ua.park.gorky.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("Application started.");
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

}
