package com.marsRover.marsRoverProject.location;

/**
 * Coordinate class, which consist of an integer value in X-axis and an integer value in Y-axis. 
 * @author Maximo Librandi
 *
 */
public class Coordinate {
	private int coordX;
	private int coordY;
	
	/** Constructor **/
	public Coordinate(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
}
