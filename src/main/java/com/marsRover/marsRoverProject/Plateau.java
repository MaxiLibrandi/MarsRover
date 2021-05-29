package com.marsRover.marsRoverProject;

import java.util.ArrayList;
import java.util.List;

import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidPlateauSizeException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

public class Plateau {
	private int sizeX;
	private int sizeY;
	private List<Rover> roversInPlateau; 
	
	public Plateau(String inputSizeX, String inputSizeY) throws InvalidPlateauSizeException{
		int sizeX = Integer.parseInt(inputSizeX);
		int sizeY = Integer.parseInt(inputSizeY);
		if (sizeX < 0 || sizeY < 0) {
			throw new InvalidPlateauSizeException();
		}
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.roversInPlateau = new ArrayList<Rover>();
	}
	
	public void addRover(Rover newRover) throws RoverOutOfPlateauException, GridBusyByOtherRoverException {
		if (newRover.getCoordX() > this.getSizeX() || newRover.getCoordY() > this.getSizeY()) {
			throw new RoverOutOfPlateauException();
		}
		if (isGridBusy(newRover.getCoordX(), newRover.getCoordY())) {
			throw new GridBusyByOtherRoverException();
		}
		roversInPlateau.add(newRover);
	}
	
	public boolean isMovementInsidePlateau(int newCoordX, int newCoordY) {
		return newCoordX >= 0 && newCoordX <= sizeX && newCoordY >= 0 && newCoordY <= sizeY;
	}
	
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
}
