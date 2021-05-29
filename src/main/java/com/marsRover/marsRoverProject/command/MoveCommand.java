package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

public class MoveCommand implements ICommand {

	public MoveCommand() {
	
	}
	
	@Override
	public void execute(Rover roverInMovement, Plateau currentPlateauState) throws RoverOutOfPlateauException, GridBusyByOtherRoverException {
		int currentRoverCoordX = roverInMovement.getCoordX();
		int currentRoverCoordY = roverInMovement.getCoordY();
		switch (roverInMovement.getDirection()) {
		case NORTH:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX, currentRoverCoordY+1)) {
				throw new RoverOutOfPlateauException();	
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX, currentRoverCoordY+1)) {
				throw new GridBusyByOtherRoverException();
			}
			roverInMovement.setCoordY(currentRoverCoordY+1);
			break;
		case WEST:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX-1, currentRoverCoordY)) {
				throw new RoverOutOfPlateauException();
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX-1, currentRoverCoordY)) {
				throw new GridBusyByOtherRoverException();
			}
			roverInMovement.setCoordX(currentRoverCoordX-1);
			break;
		case SOUTH:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX, currentRoverCoordY-1)) {
				throw new RoverOutOfPlateauException();
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX, currentRoverCoordY-1)) {
				throw new GridBusyByOtherRoverException();
			}
			roverInMovement.setCoordY(currentRoverCoordY-1);
			break;
		case EAST:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX+1, currentRoverCoordY)) {
				throw new RoverOutOfPlateauException();
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX+1, currentRoverCoordY)) {
				throw new GridBusyByOtherRoverException();
			}
			roverInMovement.setCoordX(currentRoverCoordX+1);
			break;
		}
	}

}
