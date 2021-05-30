package com.marsRover.marsRoverProject.exception;

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
