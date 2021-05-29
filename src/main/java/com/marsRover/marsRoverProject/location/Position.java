package com.marsRover.marsRoverProject.location;

public class Position {
	private Coordinate coordinates;
	private Direction compassDirection;
	
	public Position(int coordX, int coordY, char direction) {
		coordinates = new Coordinate(coordX, coordY);
		compassDirection = Direction.getDirection(direction);
	}
	
	public int getCoordX() {
		return coordinates.getCoordX();
	}
	
	public int getCoordY() {
		return coordinates.getCoordY();
	}
	
	public Direction getCompassDirection() {
		return compassDirection;
	}
	
	public void setCoordX(int coordX) {
		coordinates.setCoordX(coordX);
	}
	
	public void setCoordY(int coordY) {
		coordinates.setCoordY(coordY);
	}
	
	public void setCompassDirection(char direction){
		compassDirection = Direction.getDirection(direction);
	}
}
