package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when the starting direction of a rover is not valid (not in {'N','W','S','E'})
 * @author Maximo Librandi
 *
 */
public class InvalidRoverStartingDirectionException extends Exception {
	private String message; 
	
	public InvalidRoverStartingDirectionException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
