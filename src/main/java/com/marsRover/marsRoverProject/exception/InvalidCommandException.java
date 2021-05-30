package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when an input command is not valid
 * @author Maximo Librandi
 *
 */
public class InvalidCommandException extends Exception {
	private String message; 
	
	public InvalidCommandException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
