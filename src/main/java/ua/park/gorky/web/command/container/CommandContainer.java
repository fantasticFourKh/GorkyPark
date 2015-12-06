package ua.park.gorky.web.command.container;

import ua.park.gorky.web.command.*;

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

	static {
		//Out of control
		commands.put("sort", new SortCommand());
		commands.put("search", new SearchCommand());

		//USER

		//ADMIN

	}

	public static Command get(String name) {
		if (name == null || !commands.containsKey(name)) {
			return commands.get("noCommand");
		}
		return commands.get(name);
	}

}