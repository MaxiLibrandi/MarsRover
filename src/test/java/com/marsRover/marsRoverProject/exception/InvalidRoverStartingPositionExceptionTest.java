package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Rover;

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
