package com.marsRover.marsRoverProject;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
	private int sizeX;
	private int sizeY;
	private List<Rover> roversInPlateau; 
	
	public Plateau(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.roversInPlateau = new ArrayList<Rover>();
	}
	
	public void addRover(Rover newRover) {
		roversInPlateau.add(newRover);
	}
	
	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
}
