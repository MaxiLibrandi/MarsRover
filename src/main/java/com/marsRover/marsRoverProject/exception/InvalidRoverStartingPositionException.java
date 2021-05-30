package com.marsRover.marsRoverProject.exception;

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
