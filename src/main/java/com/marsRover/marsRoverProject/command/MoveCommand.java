package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Rover;

public class MoveCommand implements ICommand {

	public MoveCommand() {
	
	}
	
	@Override
	public void execute(Rover roverInMovement) {
		switch (roverInMovement.getDirection()) {
		case NORTH:
			roverInMovement.setCoordY(roverInMovement.getCoordY()+1);
			break;
		case WEST:
			roverInMovement.setCoordX(roverInMovement.getCoordX()-1);
			break;
		case SOUTH:
			roverInMovement.setCoordY(roverInMovement.getCoordY()-1);
			break;
		case EAST:
			roverInMovement.setCoordX(roverInMovement.getCoordX()+1);
			break;
		}
	}

}
