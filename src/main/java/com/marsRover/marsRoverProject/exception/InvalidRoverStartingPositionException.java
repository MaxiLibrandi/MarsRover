package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when the starting position of a rover is not valid (<0 in any X-axis or Y-axis)
 * @author Maximo Librandi
 *
 */
public class InvalidRoverStartingPositionException extends Exception {
	private String message; 
	
	public InvalidRoverStartingPositionException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
