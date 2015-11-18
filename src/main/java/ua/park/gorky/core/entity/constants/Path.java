package ua.park.gorky.core.entity.constants;

public class Path {

	public static final String ATTRACTION_IMAGES = "D:\\Images";
	public static final String NEWS_IMAGES = "D:\\Images\\News";
	
	//Pages
	
	public static final String PAGE_MAIN_NEWS = "/WEB-INF/jsp/index.jsp";
	
	public static final String PAGE_BASKET = "/WEB-INF/jsp/client/basket.jsp";
	
	public static final String SERVLET_MAIN_NEWS = "index.html";
	
	public static final String PAGE_RELOGIN = "/WEB-INF/jsp/login.jsp";
	
	public static final String PAGE_PROFILE = "/WEB-INF/jsp/client/profile.jsp";
	
	public static final String PAGE_USER_PROFILE = "/WEB-INF/jsp/client/user_profile.jsp";
	
	public static final String PAGE_ONE_NEWS = "WEB-INF/jsp/client/news.jsp";
	
	public static final String PAGE_REGISTER = "/WEB-INF/jsp/register.jsp";
	
	public static final String PAGE_ATTRACTION_CATALOG = "/WEB-INF/jsp/client/attractionCatalog.jsp";
	
	public static final String PAGE_ATTRACTION = "/WEB-INF/jsp/client/attractionInfo.jsp";
	
	public static final String PAGE_ADD_ATTRACTION = "/WEB-INF/jsp/admin/attraction_add.jsp";
	
	public static final String PAGE_TICKETS = "/WEB-INF/jsp/client/tickets.jsp";
	
	public static final String PAGE_ORDER_TICKET = "/WEB-INF/jsp/client/ticket.jsp";
	
	public static final String PAGE_ALL_TICKETS = "/WEB-INF/jsp/admin/all_tickets.jsp";
	
	public static final String PAGE_ALL_USERS = "/WEB-INF/jsp/admin/users.jsp";
	
	//Commands
	
	public static final String COMMAND_REGISTER_PAGE = "controller?command=registerPage";
	
	public static final String COMMAND_VIEW_ATTRATIONS = "controller?command=attractionCatalog";
	
	public static final String COMMAND_MAIN = "controller?command=main";
	
	public static final String COMMAND_PROFILE = "controller?command=profile";
	
	public static final String COMMAND_VIEW_TICKETS = "controller?command=ticketsUser";

	public static final String COMMAND_BLOCK_USER = "controller?command=blockUser";

	public static final String COMMAND_VIEW_USERS = "controller?command=allUsers";
	
}
