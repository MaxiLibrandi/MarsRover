package com.marsRover.marsRoverProject.exception;

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
