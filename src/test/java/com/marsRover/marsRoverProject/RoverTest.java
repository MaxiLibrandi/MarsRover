package com.marsRover.marsRoverProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidCommandException;
import com.marsRover.marsRoverProject.exception.InvalidPlateauSizeException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;
import com.marsRover.marsRoverProject.location.Direction;


/**
 * UnitTest for the Rover class
 * Testing the constructor, isInGrid method, setCommand method and move method.
 * @author Maximo Librandi
 *
 */
class RoverTest {
	private final static Logger LOGGER = LogManager.getLogger(RoverTest.class);
	Rover roverInTest;
	
	@BeforeEach
	void setUp() throws Exception {
		try {
			roverInTest = new Rover(1, "0", "2", "S");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
	}

	@Test
	void testConstructor() {
		Assertions.assertEquals(1, roverInTest.getId());
		Assertions.assertEquals(0, roverInTest.getCoordX());
		Assertions.assertEquals(2, roverInTest.getCoordY());
		Assertions.assertEquals(Direction.SOUTH, roverInTest.getDirection());
		Assertions.assertFalse(roverInTest.getExecuteCommands());
	}
	
	@Test 
	void testIsInGridTrue() {
		Assertions.assertTrue(roverInTest.isInGrid(0, 2));
	}
	
	@Test 
	void testIsInGridFalse() {
		Assertions.assertFalse(roverInTest.isInGrid(1, 1));
	}
	
	@Test 
	void testSetCommandSequence() {
		String commands = "MMLMLMMRM";
		try {
			roverInTest.setCommandSequence(commands);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(9,roverInTest.getCommands().size());
		Assertions.assertEquals(commands, roverInTest.getCommandSequence());
	}
	
	@Test 
	void testMove() {
		String commands = "MMLMLMMRM";
		try {
			roverInTest.setCommandSequence(commands);
			roverInTest.move(new Plateau("5", "5"));
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidPlateauSizeException e) {
			LOGGER.error(e);
		}
		Assertions.assertTrue(roverInTest.getExecuteCommands());
		Assertions.assertEquals(2, roverInTest.getCoordX());
		Assertions.assertEquals(2, roverInTest.getCoordY());
		Assertions.assertEquals(Direction.EAST, roverInTest.getDirection());
	}
}
