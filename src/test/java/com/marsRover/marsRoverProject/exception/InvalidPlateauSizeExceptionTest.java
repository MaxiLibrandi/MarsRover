package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Plateau;

/**
* UnitTest for the InvalidPlateauSizeException class.
* Testing that the exception is thrown when creating a new Plateau with negative sizes (in X-axis or Y-axis).
* @author Maximo Librandi
*
*/
class InvalidPlateauSizeExceptionTest {
	
	@Test
	void testInvalidPlateauSizeExceptionIsThrownBecauseCoordX() {
		Assertions.assertThrows(InvalidPlateauSizeException.class, () -> {
			new Plateau("-5", "5");
		});	
	}
	
	@Test
	void testInvalidPlateauSizeExceptionIsThrownBecauseCoordY() {
		Assertions.assertThrows(InvalidPlateauSizeException.class, () -> {
			new Plateau("5", "-5");
		});	
	}
	
	@Test
	void testInvalidPlateauSizeExceptionIsThrownBecauseBothCoordinates() {
		Assertions.assertThrows(InvalidPlateauSizeException.class, () -> {
			new Plateau("-5", "-5");
		});	
	}
}
