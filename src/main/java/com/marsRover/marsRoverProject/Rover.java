package com.marsRover.marsRoverProject;

import java.util.List;
import com.marsRover.marsRoverProject.command.ICommand;
import com.marsRover.marsRoverProject.location.Direction;
import com.marsRover.marsRoverProject.location.Position;

public class Rover {
	private int id;
	private Position position;
	private List<ICommand> commands;
	
	public Rover(int id, int coordX, int coordY, char direction) {
		this.id = id;
		this.position = new Position(coordX, coordY, direction);
	}
	
	public void addCommands(List<ICommand> newCommands) {
		commands = newCommands;
	}
	
	public void move() {
		for(ICommand command : commands) {
			command.execute(this);
		}
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
	
}
