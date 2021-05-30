package com.marsRover.marsRoverProject.location;

import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;

/**
 * Position class which consist of the coordinates and the direction. 
 * @author Maximo Librandi
 *
 */
public class Position {
	private Coordinate coordinates;
	private Direction compassDirection;
	
	/** Constructor, which validates the input values **/
	public Position(int coordX, int coordY, char direction) throws InvalidRoverStartingPositionException, InvalidRoverStartingDirectionException {
		if (coordX < 0 || coordY < 0) {
			throw new InvalidRoverStartingPositionException(coordX + " " + coordY + " is a non-valid starting position");
		}
		if (Direction.getDirection(direction) == null) {
			throw new InvalidRoverStartingDirectionException(direction + " is a non-valid direction");
		}
		coordinates = new Coordinate(coordX, coordY);
		compassDirection = Direction.getDirection(direction);
	}
	
	public String getStringPosition() {
		return coordinates.getCoordX() + " " + coordinates.getCoordY() + " " + compassDirection.getRepresentativeChar();
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
