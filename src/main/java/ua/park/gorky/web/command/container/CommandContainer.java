package ua.park.gorky.web.command.container;

import org.apache.log4j.Logger;
import ua.park.gorky.web.command.*;
import ua.park.gorky.web.command.adminCommand.AllUsersCommand;
import ua.park.gorky.web.command.adminCommand.BlockUserCommand;
import ua.park.gorky.web.command.attraction.AddAttractionCommand;
import ua.park.gorky.web.command.attraction.AttractionAddPageCommand;
import ua.park.gorky.web.command.attraction.AttractionCatalogCommand;
import ua.park.gorky.web.command.attraction.AttractionInfoCommand;

import java.util.Map;
import java.util.TreeMap;

/**
 * Holder for all commands.
 * 
 * @author Petrov Vladyslav
 * 
 */
public class CommandContainer {

	private static Map<String, Command> commands = new TreeMap<String, Command>();

	private static final Logger LOG = Logger.getLogger(CommandContainer.class);

	static {
		//Out of control
		commands.put("main", new NewsCommand());
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("register", new RegisterCommand());
		commands.put("registerPage", new RegisterPageCommand());
		commands.put("sort", new SortCommand());
		commands.put("search", new SearchCommand());
		commands.put("attractionCatalog", new AttractionCatalogCommand());
		commands.put("showAttraction", new AttractionInfoCommand());
		commands.put("orderTicketPage", new TicketOrderPageCommand());
		
		//USER
		commands.put("profile", new ProfileCommand());
		commands.put("showUserProfile", new UserProfileCommand());
		commands.put("newComment", new NewCommentCommand());
		commands.put("changeUserPassword", new ChangeUserPasswordCommand());
		commands.put("deleteComment", new DeleteCommentCommand());
		commands.put("oneNewsComment", new OneNewsCommentCommand());
		commands.put("attractionAddPage", new AttractionAddPageCommand());
		commands.put("orderTicket", new TicketOrderCommand());
		commands.put("allTickets", new AllTicketsCommand());
		commands.put("basket", new BasketCommand());
		commands.put("deleteCartItem", new DeleteCartItemCommand());
		commands.put("transaction", new TransactionCommand());
		commands.put("ticketsUser", new MyTicketsCommand());
		
		//ADMIN
		commands.put("addAttraction", new AddAttractionCommand());
		commands.put("allUsers", new AllUsersCommand());
		commands.put("deleteNews", new DeleteNewsCommand());
		commands.put("addNews", new AddNewsCommand());
		commands.put("blockUser", new BlockUserCommand());
		
		
		commands.put("imageGenerator", new ImageGeneretorCommand());

		LOG.debug("Command container was successfully initialized");
		LOG.trace("Number of commands --> " + commands.size());
	}

	public static Command get(String name) {
		if (name == null || !commands.containsKey(name)) {
			return commands.get("noCommand");
		}
		return commands.get(name);
	}

}