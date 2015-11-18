package ua.park.gorky.web.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.park.gorky.web.command.adminCommand.AllUsersCommand;
import ua.park.gorky.web.command.adminCommand.BlockUserCommand;

import java.util.Map;
import java.util.TreeMap;

/**
 * Holder for all commands.
 * 
 * @author Petrov Vladyslav
 * 
 */
public class CommandContainer {

	private static Map<String, Command> commands = new TreeMap<>();

	private static final Logger LOGGER = LoggerFactory.getLogger(CommandContainer.class);

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

		//USER
		commands.put("profile", new ProfileCommand());
		commands.put("showUserProfile", new UserProfileCommand());
		commands.put("newComment", new NewCommentCommand());
		commands.put("changeUserPassword", new ChangeUserPasswordCommand());
		commands.put("deleteComment", new DeleteCommentCommand());
		commands.put("oneNewsComment", new OneNewsCommentCommand());
		commands.put("attractionAddPage", new AttractionAddPageCommand());

		//ADMIN
		commands.put("addAttraction", new AddAttractionCommand());
		commands.put("allUsers", new AllUsersCommand());
		commands.put("deleteNews", new DeleteNewsCommand());
		commands.put("addNews", new AddNewsCommand());
		commands.put("blockUser", new BlockUserCommand());
		
		
		commands.put("imageGenerator", new ImageGeneretorCommand());

		LOGGER.debug("Command container was successfully initialized");
		LOGGER.trace("Number of commands --> " + commands.size());
	}

	public static Command get(String name) {
		if (name == null || !commands.containsKey(name)) {
			return commands.get("noCommand");
		}
		return commands.get(name);
	}

}