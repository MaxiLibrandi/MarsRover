package com.marsRover.marsRoverProject.command;

import java.util.ArrayList;
import java.util.List;

import com.marsRover.marsRoverProject.exception.InvalidCommandException;

public class CommandProducer {
	
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
					throw new InvalidCommandException();
			}	
		}
		return commands;
	}
}