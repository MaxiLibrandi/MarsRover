package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

/**
 * Move Forward command class
 * @author Maximo Librandi
 *
 */
public class MoveCommand implements ICommand {

	/** Constructor **/
	public MoveCommand() {
	
	}
	
	/** Considering the current cardinal direction, the command will set the new position (X or Y) for the rover in action. 
	 *  This will consider possible errors, like rover out of plateau or grid busy by other rover, when trying to move 
	 *  **/
	@Override
	public void execute(Rover roverInMovement, Plateau currentPlateauState) throws RoverOutOfPlateauException, GridBusyByOtherRoverException {
		int currentRoverCoordX = roverInMovement.getCoordX();
		int currentRoverCoordY = roverInMovement.getCoordY();
		switch (roverInMovement.getDirection()) {
		case NORTH:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX, currentRoverCoordY+1)) {
				throw new RoverOutOfPlateauException(currentRoverCoordX + " " + (currentRoverCoordY+1) + " position is out of Plateau");	
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX, currentRoverCoordY+1)) {
				throw new GridBusyByOtherRoverException(currentRoverCoordX + " " + (currentRoverCoordY+1) + " position is busy by other rover");
			}
			roverInMovement.setCoordY(currentRoverCoordY+1);
			break;
		case WEST:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX-1, currentRoverCoordY)) {
				throw new RoverOutOfPlateauException((currentRoverCoordX-1) + " " + (currentRoverCoordY) + " position is out of Plateau");
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX-1, currentRoverCoordY)) {
				throw new GridBusyByOtherRoverException((currentRoverCoordX-1) + " " + (currentRoverCoordY) + " position is busy by other rover");
			}
			roverInMovement.setCoordX(currentRoverCoordX-1);
			break;
		case SOUTH:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX, currentRoverCoordY-1)) {
				throw new RoverOutOfPlateauException(currentRoverCoordX + " " + (currentRoverCoordY-1) + " position is out of Plateau");
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX, currentRoverCoordY-1)) {
				throw new GridBusyByOtherRoverException(currentRoverCoordX + " " + (currentRoverCoordY-1) + " position is busy by other rover");
			}
			roverInMovement.setCoordY(currentRoverCoordY-1);
			break;
		case EAST:
			if (!currentPlateauState.isMovementInsidePlateau(currentRoverCoordX+1, currentRoverCoordY)) {
				throw new RoverOutOfPlateauException((currentRoverCoordX+1) + " " + (currentRoverCoordY) + " position is out of Plateau");
			}
			if (currentPlateauState.isGridBusy(currentRoverCoordX+1, currentRoverCoordY)) {
				throw new GridBusyByOtherRoverException((currentRoverCoordX+1) + " " + (currentRoverCoordY) + " position is busy by other rover");
			}
			roverInMovement.setCoordX(currentRoverCoordX+1);
			break;
		}
	}

}
