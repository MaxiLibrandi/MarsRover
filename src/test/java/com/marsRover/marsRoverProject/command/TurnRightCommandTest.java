package com.marsRover.marsRoverProject.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;

/**
 * UnitTest for the TurnRightCommand class
 * Testing the rotation in the 4 possible directions, according to cardinal direction where the rover is pointing to.
 * @author Maximo Librandi
 *
 */
class TurnRightCommandTest {
	private final static Logger LOGGER = LogManager.getLogger(TurnRightCommandTest.class);
	private TurnRightCommand turnRightCommand;
	private Rover roverInMovement;
	private Plateau plateau;
	
	@BeforeEach
	void setUp() throws Exception {
		turnRightCommand = new TurnRightCommand();
		plateau = new Plateau("10", "10");
	}

	@Test
	void testTurnNorthToEast() {
		try {
			roverInMovement = new Rover(1, "5", "5", "N");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		turnRightCommand.execute(roverInMovement, plateau);
		Assertions.assertEquals(5, roverInMovement.getCoordX());
		Assertions.assertEquals(5, roverInMovement.getCoordY());
		Assertions.assertEquals('E',roverInMovement.getDirection().getRepresentativeChar());
	}
	
	@Test
	void testTurnEathToSouth() {
		try {
			roverInMovement = new Rover(1, "5", "5", "E");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		turnRightCommand.execute(roverInMovement, plateau);
		Assertions.assertEquals(5, roverInMovement.getCoordX());
		Assertions.assertEquals(5, roverInMovement.getCoordY());
		Assertions.assertEquals('S',roverInMovement.getDirection().getRepresentativeChar());
	}
	
	@Test
	void testTurnSouthToWest() {
		try {
			roverInMovement = new Rover(1, "5", "5", "S");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		turnRightCommand.execute(roverInMovement, plateau);
		Assertions.assertEquals(5, roverInMovement.getCoordX());
		Assertions.assertEquals(5, roverInMovement.getCoordY());
		Assertions.assertEquals('W',roverInMovement.getDirection().getRepresentativeChar());
	}
	
	@Test
	void testTurnWestToNorth() {
		try {
			roverInMovement = new Rover(1, "5", "5", "W");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		turnRightCommand.execute(roverInMovement, plateau);
		Assertions.assertEquals(5, roverInMovement.getCoordX());
		Assertions.assertEquals(5, roverInMovement.getCoordY());
		Assertions.assertEquals('N',roverInMovement.getDirection().getRepresentativeChar());
	}

}
