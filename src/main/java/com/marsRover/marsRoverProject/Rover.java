package com.marsRover.marsRoverProject;

import java.util.List;
import com.marsRover.marsRoverProject.command.ICommand;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;
import com.marsRover.marsRoverProject.location.Direction;
import com.marsRover.marsRoverProject.location.Position;

public class Rover {
	private int id;
	private Position position;
	private List<ICommand> commands;
	
	public Rover(int id, String inputCoordX, String inputCoordY, String inputDirection) throws InvalidRoverStartingPositionException, InvalidRoverStartingDirectionException {
		int coordX = Integer.parseInt(inputCoordX);
		int coordY = Integer.parseInt(inputCoordY);
		char direction = inputDirection.charAt(0);
		this.id = id;
		this.position = new Position(coordX, coordY, direction);
	}
	
	public void addCommands(List<ICommand> newCommands) {
		commands = newCommands;
	}
	
	public void move(Plateau currentPlateauState) throws RoverOutOfPlateauException, GridBusyByOtherRoverException {
		for(ICommand command : commands) {
			command.execute(this, currentPlateauState);
		}
	}
	
	public boolean isInGrid(int coordX, int coordY) {
		return position.getCoordX() == coordX && position.getCoordY() == coordY;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCoordX() {
		return position.getCoordX();
	}
	
	public int getCoordY() {
		return position.getCoordY();
	}
	
	public Direction getDirection() {
		return position.getCompassDirection();
	}
	
	public String getStringPosition() {
		return position.getStringPosition();
	}
	
	public void setCoordX(int coordX) {
		position.setCoordX(coordX);
	}
	
	public void setCoordY(int coordY) {
		position.setCoordY(coordY);
	}
	
	public void setDirection(char direction) {
		position.setCompassDirection(direction);
	}
	
	@Override
	public String toString() {
		return "Rover ID: " + getId() + "| Position: (" + getCoordX() + "," + getCoordY() + "," + getDirection().getRepresentativeChar() + ")";		
	}
	
}
