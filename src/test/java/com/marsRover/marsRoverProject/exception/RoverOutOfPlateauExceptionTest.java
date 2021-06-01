package com.marsRover.marsRoverProject.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;


/**
 * UnitTest for the RoverOutOfPlateauException class.
 * Testing possible ways of doing the exception be thrown (when moving a rover or when adding a new rover to the plateau).
 * @author Maximo Librandi
 *
 */
class RoverOutOfPlateauExceptionTest {
	private final static Logger LOGGER = LogManager.getLogger(RoverOutOfPlateauExceptionTest.class);
	Plateau plateauUsedInTest;
	Rover roverUsedInTest;
	
	@BeforeEach
	void setUp() throws Exception {
		plateauUsedInTest = new Plateau("2", "2");
	}

	@Test
	void testRoverOutOfPlateauMovingNorth() {
		try {
			roverUsedInTest = new Rover(1, "0", "0", "N");
			roverUsedInTest.setCommandSequence("RMLMMM");
			plateauUsedInTest.addRover(roverUsedInTest);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			roverUsedInTest.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauMovingEast() {
		try {
			roverUsedInTest = new Rover(1, "0", "0", "N");
			roverUsedInTest.setCommandSequence("RMMM");
			plateauUsedInTest.addRover(roverUsedInTest);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			roverUsedInTest.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauMovingSouth() {
		try {
			roverUsedInTest = new Rover(1, "0", "0", "N");
			roverUsedInTest.setCommandSequence("RMRM");
			plateauUsedInTest.addRover(roverUsedInTest);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			roverUsedInTest.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauMovingWest() {
		try {
			roverUsedInTest = new Rover(1, "0", "0", "N");
			roverUsedInTest.setCommandSequence("MLM");
			plateauUsedInTest.addRover(roverUsedInTest);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			roverUsedInTest.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauWhileAddingBecauseCoordX() {
		try {
			roverUsedInTest = new Rover(1, "3", "0", "N");
			roverUsedInTest.setCommandSequence("LRLR");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			plateauUsedInTest.addRover(roverUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauWhileAddingBecauseCoordY() {
		try {
			roverUsedInTest = new Rover(1, "0", "3", "N");
			roverUsedInTest.setCommandSequence("LRLR");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			plateauUsedInTest.addRover(roverUsedInTest);
		});	
	}
	
	@Test
	void testRoverOutOfPlateauWhileAddingBecauseBothCoords() {
		try {
			roverUsedInTest = new Rover(1, "3", "3", "N");
			roverUsedInTest.setCommandSequence("LRLR");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(RoverOutOfPlateauException.class, () -> {
			plateauUsedInTest.addRover(roverUsedInTest);
		});	
	}

}
