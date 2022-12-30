package life4fun.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import life4fun.utils.ApplicationUtils;

/**
 * Application Lifecycle Listener implementation class AppInitListener
 *
 */
@WebListener
public class AppInitListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public AppInitListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute(ApplicationUtils.CONTEXT_PATH_KEY,
				sce.getServletContext().getContextPath());
	}

}
