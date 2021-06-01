package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Rover;

/**
* UnitTest for the InvalidRoverStartingPositionException class.
* Testing that the exception is thrown when creating a new Rover with negative position (in X-axis or Y-axis).
* When a Rover is created with a position bigger than the Plateau's size, the exception will be handled by RoverOutOfPlateauException.
* @author Maximo Librandi
*
*/
class InvalidRoverStartingPositionExceptionTest {

	@Test
	void testInvalidRoverStartingPositionExceptionIsThrownCoordX() {
		Assertions.assertThrows(InvalidRoverStartingPositionException.class, () -> {
			new Rover(1, "-1", "0", "N");
		});	
	}
	
	@Test
	void testInvalidRoverStartingPositionExceptionIsThrownCoordY() {
		Assertions.assertThrows(InvalidRoverStartingPositionException.class, () -> {
			new Rover(1, "0", "-1", "N");
		});	
	}
	
	@Test
	void testInvalidRoverStartingPositionExceptionIsThrownBothCoords() {
		Assertions.assertThrows(InvalidRoverStartingPositionException.class, () -> {
			new Rover(1, "-1", "-1", "N");
		});	
	}
}
