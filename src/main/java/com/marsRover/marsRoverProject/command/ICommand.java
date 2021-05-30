package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

/**
 * Command interface. Each possible command should implement it.
 * @author Maximo Librandi
 *
 */
public interface ICommand {
	public abstract void execute(Rover roverInMovement, Plateau currentPlateauState) throws RoverOutOfPlateauException, GridBusyByOtherRoverException;
}
