package com.marsRover.marsRoverProject.command;

import java.util.ArrayList;
import java.util.List;

import com.marsRover.marsRoverProject.exception.InvalidCommandException;

/**
 * CommandProducer class which creates a List of ICommands taking a string as input
 * @author Maximo Librandi
 *
 */
public class CommandProducer {
	
	/** Static method to create the specific command objects for then the rover to execute **/
	public static List<ICommand> produceCommands(String commandList) throws InvalidCommandException{
		List<ICommand> commands = new ArrayList<ICommand>();
		for (int i = 0; i < commandList.length(); i++) {
			switch(commandList.charAt(i)) {
				case 'L':
					commands.add(new TurnLeftCommand());
					break;
				case 'R':
					commands.add(new TurnRightCommand());
					break;
				case 'M':
					commands.add(new MoveCommand());
					break;
				default:
					throw new InvalidCommandException(commandList.charAt(i) + " is a non-valid command");
			}	
		}
		return commands;
	}
}
