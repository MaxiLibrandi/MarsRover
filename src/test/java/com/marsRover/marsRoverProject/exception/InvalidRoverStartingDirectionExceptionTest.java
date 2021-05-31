package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Rover;


class InvalidRoverStartingDirectionExceptionTest {

	@Test
	void testInvalidRoverStartingDirectionExceptionIsThrown() {
		Assertions.assertThrows(InvalidRoverStartingDirectionException.class, () -> {
			new Rover(1, "0", "0", "R");
		});	
	}
	
	@Test
	void testInvalidRoverStartingDirectionExceptionIsThrownLowerCase() {
		Assertions.assertThrows(InvalidRoverStartingDirectionException.class, () -> {
			new Rover(1, "0", "0", "n");
		});	
	}

}
