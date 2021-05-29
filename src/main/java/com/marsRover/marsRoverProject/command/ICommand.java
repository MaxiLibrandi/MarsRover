package com.marsRover.marsRoverProject.command;

import com.marsRover.marsRoverProject.Rover;

public interface ICommand {

	public abstract void execute(Rover roverInMovement);
}
