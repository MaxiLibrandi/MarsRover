package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when a grid that is busy by a rover is trying to be reached by another one
 * @author Maximo Librandi
 *
 */
public class GridBusyByOtherRoverException extends Exception {
	private String message; 
	
	public GridBusyByOtherRoverException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
