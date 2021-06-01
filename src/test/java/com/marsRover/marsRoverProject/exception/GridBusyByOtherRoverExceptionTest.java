package com.marsRover.marsRoverProject.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Plateau;
import com.marsRover.marsRoverProject.Rover;

/**
 * UnitTest for the GridBusyByOtherRoverException class.
 * Testing possible ways of doing the exception be thrown (when moving a rover or when adding a new rover to the plateau).
 * @author Maximo Librandi
 *
 */
class GridBusyByOtherRoverExceptionTest {
	private final static Logger LOGGER = LogManager.getLogger(GridBusyByOtherRoverExceptionTest.class);
	Plateau plateauUsedInTest;
	Rover roverInPlateau; 
	Rover newRover;
	
	@BeforeEach
	void setUp() throws Exception {
		plateauUsedInTest = new Plateau("5", "5");
		roverInPlateau = new Rover(1, "3", "3", "N");
		roverInPlateau.setCommandSequence("MRM");
		plateauUsedInTest.addRover(roverInPlateau);
	}
	
	@Test
	void testGridBusyExceptionWhileAddingRoverToPlateau() {
		try {
			newRover = new Rover(2, "3", "3", "E");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			plateauUsedInTest.addRover(newRover);
		});	
	}
	
	@Test
	void testGridBusyExceptionWhileAddingRoverToPlateauAfterAnotherMoved() {
		try {
			roverInPlateau.move(plateauUsedInTest);
			newRover = new Rover(2, "4", "4", "S");
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			plateauUsedInTest.addRover(newRover);
		});	
	}
	
	@Test
	void testGridBusyExceptionWhileMovingRoverNorth() {
		try {
			newRover = new Rover(2, "3", "2", "N");
			newRover.setCommandSequence("MMLM");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			newRover.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testGridBusyExceptionWhileMovingRoverSouth() {
		try {
			newRover = new Rover(2, "3", "4", "S");
			newRover.setCommandSequence("MMLM");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			newRover.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testGridBusyExceptionWhileMovingRoverEast() {
		try {
			newRover = new Rover(2, "2", "3", "E");
			newRover.setCommandSequence("MMLM");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			newRover.move(plateauUsedInTest);
		});	
	}
	
	@Test
	void testGridBusyExceptionWhileMovingRoverWest() {
		try {
			newRover = new Rover(2, "4", "3", "W");
			newRover.setCommandSequence("MMLM");
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		}
		Assertions.assertThrows(GridBusyByOtherRoverException.class, () -> {
			newRover.move(plateauUsedInTest);
		});	
	}
}
