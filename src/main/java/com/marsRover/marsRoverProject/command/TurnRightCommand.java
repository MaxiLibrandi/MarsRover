package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.location.Direction;

/**
 * Turn Right command class
 * @author Maximo Librandi
 *
 */
public class TurnRightCommand implements ICommand {

	/** Constructor **/
	public TurnRightCommand() {
	
	}
	
	/** Considering current cardinal direction, it will turn the rover 90 degrees to the right **/
	@Override
	public void execute(Rover roverInMovement, Plateau currentPlateauState) {
		switch (roverInMovement.getDirection()) {
		case NORTH:
			roverInMovement.setDirection(Direction.EAST.getRepresentativeChar());
			break;
		case WEST:
			roverInMovement.setDirection(Direction.NORTH.getRepresentativeChar());
			break;
		case SOUTH:
			roverInMovement.setDirection(Direction.WEST.getRepresentativeChar());
			break;
		case EAST:
			roverInMovement.setDirection(Direction.SOUTH.getRepresentativeChar());
			break;
		}
	}

}
