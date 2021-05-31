package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Plateau;

class InvalidPlateauSizeExceptionTest {
	
	@Test
	void testInvalidPlateauSizeExceptionIsThrown() {
		Assertions.assertThrows(InvalidPlateauSizeException.class, () -> {
			new Plateau("5", "-5");
		});	
	}
}
