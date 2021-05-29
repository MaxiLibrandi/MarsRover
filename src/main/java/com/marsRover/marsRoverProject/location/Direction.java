package com.marsRover.marsRoverProject.location;

public enum Direction {
	NORTH('N'),
	WEST('W'),
	SOUTH('S'),
	EAST('E'); 
		
	private char representativeChar; 
	
	private Direction(char representativeChar) {
		this.representativeChar = representativeChar;
	}
	
	public char getRepresentativeChar() {
		return representativeChar;
	}
	
	public static Direction getDirection(char representativeChar) {
		if (representativeChar == Direction.NORTH.getRepresentativeChar()) {
			return Direction.NORTH;
		}
		if (representativeChar == Direction.WEST.getRepresentativeChar()) {
			return Direction.WEST;
		}
		if (representativeChar == Direction.SOUTH.getRepresentativeChar()) {
			return Direction.SOUTH;
		}
		if (representativeChar == Direction.EAST.getRepresentativeChar()) {
			return Direction.EAST;
		}
		return null;
	}
}
