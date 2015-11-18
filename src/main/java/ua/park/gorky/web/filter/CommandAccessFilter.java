package ua.park.gorky.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.core.entity.Role;
import ua.park.gorky.core.entity.constants.Path;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class CommandAccessFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandAccessFilter.class);

	private Map<Role, List<String>> accessMap = new HashMap<>();
	private List<String> commons = new ArrayList<String>();
	private List<String> outOfControl = new ArrayList<String>();

	public void destroy() {
		LOGGER.debug("Filter destruction starts");
		LOGGER.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		LOGGER.debug("Filter starts");

		if (accessAllowed(request)) {
			LOGGER.debug("Filter finished");
			chain.doFilter(request, response);
		} else {
			String errorMessasge = "You do not have permission to access the requested resource";

			request.setAttribute("errorMessage", errorMessasge);
			LOGGER.trace("Set the request attribute: errorMessage --> "
					+ errorMessasge);

			((HttpServletResponse) response)
					.sendRedirect(Path.SERVLET_MAIN_NEWS);
		}
	}

	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String commandName = request.getParameter("command");
		if (commandName == null || commandName.isEmpty()) {
			return false;
		}

		if (outOfControl.contains(commandName)) {
			return true;
		}

		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			return false;
		}

		Role userRole = Role.valueOf((String) session.getAttribute("userRole"));

		LOGGER.trace("USER ROLE --> " + userRole.getName());

		if (userRole.getName() == null) {
			return false;
		}

		if (userRole.equals(Role.ADMIN)) {
			return accessMap.get(Role.ADMIN).contains(commandName);
		}
		
		return commons.contains(commandName); 
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOGGER.debug("Filter initialization starts");

		accessMap.put(Role.ADMIN, asList(fConfig.getInitParameter("admin")));
		LOGGER.trace("Access map --> " + accessMap);

		commons = asList(fConfig.getInitParameter("common"));
		LOGGER.trace("Common commands --> " + commons);

		outOfControl = asList(fConfig.getInitParameter("out-of-control"));
		LOGGER.trace("Out of control commands --> " + outOfControl);

		LOGGER.debug("Filter initialization finished");
	}

	/**
	 * Extracts parameter values from string.
	 * 
	 * @param str
	 *            parameter values string.
	 * @return list of parameter values.
	 */
	private List<String> asList(String str) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

}