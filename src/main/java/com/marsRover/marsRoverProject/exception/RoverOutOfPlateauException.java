package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when a rover is trying to go outside of the Plateau.
 * This can be when the Rover is inserted into the Plateau or when the rover is moving
 * @author Maximo Librandi
 *
 */
public class RoverOutOfPlateauException extends Exception {
	private String message; 
	
	public RoverOutOfPlateauException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
