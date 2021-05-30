package com.marsRover.marsRoverProject.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

/**
 * UnitTest for the MoveCommand class
 * Testing the movements in the 4 possible directions, according to cardinal directions.
 * @author Maximo Librandi
 *
 */
class MoveCommandTest {
	private final static Logger LOGGER = LogManager.getLogger(MoveCommandTest.class);
	private MoveCommand moveCommand;
	private Rover roverInMovement;
	private Plateau plateau;
	
	@BeforeEach
	void setUp() throws Exception {
		moveCommand = new MoveCommand();
		plateau = new Plateau("10", "10");
	}

	@Test
	public void testMoveNorth() {
		try {
			roverInMovement = new Rover(1, "0", "0", "N");
			moveCommand.execute(roverInMovement, plateau);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(0, roverInMovement.getCoordX());
		Assertions.assertEquals(1, roverInMovement.getCoordY());
		Assertions.assertEquals('N',roverInMovement.getDirection().getRepresentativeChar());
	}
	
	@Test
	public void testMoveSouth() {
		try {
			roverInMovement = new Rover(1, "1", "1", "S");
			moveCommand.execute(roverInMovement, plateau);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(1, roverInMovement.getCoordX());
		Assertions.assertEquals(0, roverInMovement.getCoordY());
		Assertions.assertEquals('S',roverInMovement.getDirection().getRepresentativeChar());
		
	}
	
	@Test
	public void testMoveWest() {
		try {
			roverInMovement = new Rover(1, "1", "1", "W");
			moveCommand.execute(roverInMovement, plateau);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(0, roverInMovement.getCoordX());
		Assertions.assertEquals(1, roverInMovement.getCoordY());
		Assertions.assertEquals('W',roverInMovement.getDirection().getRepresentativeChar());
	}
	
	@Test
	public void testMoveEast() {
		try {
			roverInMovement = new Rover(1, "0", "0", "E");
			moveCommand.execute(roverInMovement, plateau);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(1, roverInMovement.getCoordX());
		Assertions.assertEquals(0, roverInMovement.getCoordY());
		Assertions.assertEquals('E',roverInMovement.getDirection().getRepresentativeChar());
	}
}
