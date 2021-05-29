package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.location.Direction;

public class TurnLeftCommand implements ICommand {

	public TurnLeftCommand() {
		
	}
	
	@Override
	public void execute(Rover roverInMovement) {
		switch (roverInMovement.getDirection()) {
		case NORTH:
			roverInMovement.setDirection(Direction.WEST.getRepresentativeChar());
			break;
		case WEST:
			roverInMovement.setDirection(Direction.SOUTH.getRepresentativeChar());
			break;
		case SOUTH:
			roverInMovement.setDirection(Direction.EAST.getRepresentativeChar());
			break;
		case EAST:
			roverInMovement.setDirection(Direction.NORTH.getRepresentativeChar());
			break;
		}
	}

}
