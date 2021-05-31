package com.marsRover.marsRoverProject;

import java.util.ArrayList;
import java.util.List;

import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidPlateauSizeException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

/**
 * Plateau class which consists of size (X, Y) and rovers.
 * @author Maximo Librandi
 *
 */
public class Plateau {
	private int sizeX;
	private int sizeY;
	private List<Rover> roversInPlateau; 
	
	/** Constructor **/
	public Plateau(String inputSizeX, String inputSizeY) throws InvalidPlateauSizeException{
		int sizeX = Integer.parseInt(inputSizeX);
		int sizeY = Integer.parseInt(inputSizeY);
		if (sizeX < 0 || sizeY < 0) {
			throw new InvalidPlateauSizeException(sizeX + " " + sizeY + " is a non-valid size for the Plateau");
		}
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.roversInPlateau = new ArrayList<Rover>();
	}
	
	/** Method to add a rover if it is not out of the plateau or the position is not busy. **/
	public void addRover(Rover newRover) throws RoverOutOfPlateauException, GridBusyByOtherRoverException {
		if (newRover.getCoordX() > this.getSizeX() || newRover.getCoordY() > this.getSizeY()) {
			throw new RoverOutOfPlateauException(newRover.getCoordX() + " " + newRover.getCoordY() + " position is out of Plateau");
		}
		if (isGridBusy(newRover.getCoordX(), newRover.getCoordY())) {
			throw new GridBusyByOtherRoverException(newRover.getCoordX() + " " + newRover.getCoordY() + " position is busy by other rover");
		}
		roversInPlateau.add(newRover);
	}
	
	/** Method to check if the new coordinates are within the limits **/ 
	public boolean isMovementInsidePlateau(int newCoordX, int newCoordY) {
		return newCoordX >= 0 && newCoordX <= sizeX && newCoordY >= 0 && newCoordY <= sizeY;
	}
	
	/** Method to check whether a specific position is busy by a rover **/ 
	public boolean isGridBusy(int coordX, int coordY) {
		for (Rover rover: roversInPlateau) {
			if (rover.isInGrid(coordX, coordY)) {
				return true;
			}
		}
		return false;
	}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	
	public List<Rover> getRoversInPlateau() {
		return roversInPlateau;
	}
	
	@Override
	public String toString() {
		return "Plateau size is: " + getSizeX() + " " + getSizeY();
	}
}
