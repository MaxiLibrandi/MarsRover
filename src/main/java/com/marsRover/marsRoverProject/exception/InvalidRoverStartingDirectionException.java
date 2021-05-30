package com.marsRover.marsRoverProject.exception;

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
