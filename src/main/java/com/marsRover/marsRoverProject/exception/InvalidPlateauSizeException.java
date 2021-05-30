package com.marsRover.marsRoverProject.exception;

/**
 * Exception for when the Plateau size inserted as input is not valid (<0)
 * @author Maximo Librandi
 *
 */
public class InvalidPlateauSizeException extends Exception {
	private String message; 
	
	public InvalidPlateauSizeException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
