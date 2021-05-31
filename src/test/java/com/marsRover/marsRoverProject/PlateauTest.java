package com.marsRover.marsRoverProject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidPlateauSizeException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;

/**
 * UnitTest for the Plateau class
 * Testing the constructor, addRover method, isMovementInsidePlateau and isGridBusy boolean methods.
 * @author Maximo Librandi
 *
 */
class PlateauTest {
	private final static Logger LOGGER = LogManager.getLogger(PlateauTest.class);
	Plateau plateauInTest;
	
	@BeforeEach
	void setUp() throws Exception {
		try {
			plateauInTest = new Plateau("5","7");
		} catch (InvalidPlateauSizeException e) {
			LOGGER.error(e);
		}
	}

	@Test
	void testConstructor() {
		Assertions.assertEquals(5, plateauInTest.getSizeX());
		Assertions.assertEquals(7, plateauInTest.getSizeY());
		Assertions.assertEquals(0, plateauInTest.getRoversInPlateau().size());
	}
	
	@Test
	void testAddRover() {
		Rover newRover = null;
		try {
			newRover = new Rover(1,"0","0","N");
			plateauInTest.addRover(newRover);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertEquals(newRover, plateauInTest.getRoversInPlateau().get(0));
	}
	
	@Test
	void testIsMovementInsidePlateauTrue() {
		Assertions.assertTrue(plateauInTest.isMovementInsidePlateau(3, 3));
	}
	
	@Test
	void testIsMovementInsidePlateauFalse() {
		Assertions.assertFalse(plateauInTest.isMovementInsidePlateau(6, 0));
	}
	
	@Test
	void testIsGridBusyTrue() {
		try {
			Rover newRover = new Rover(1, "0", "0", "N");
			plateauInTest.addRover(newRover);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		Assertions.assertTrue(plateauInTest.isGridBusy(0, 0));
	}
	
	@Test
	void testIsGridBusyFalse() {
		Assertions.assertFalse(plateauInTest.isGridBusy(0, 0));
	}
}
