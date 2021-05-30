package com.marsRover.marsRoverProject.exception;

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
