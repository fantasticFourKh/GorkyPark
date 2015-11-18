package ua.park.gorky.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        initCommandContainer();
    }

    private void initCommandContainer() {
        try {
            Class.forName("ua.park.gorky.web.command.container.CommandContainer");
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException(
                    "Cannot initialize Command Container");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

}
