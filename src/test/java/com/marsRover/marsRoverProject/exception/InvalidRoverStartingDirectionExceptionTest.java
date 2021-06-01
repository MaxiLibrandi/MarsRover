package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.Rover;

/**
 * UnitTest for the InvalidRoverStartingDirectionException class.
 * Testing the exception is thrown when creating a new rover with a letter that doesn't belong to {N, W, S, E}.
 * The exception also is thrown when creating with a lower case letter.
 * @author Maximo Librandi
 *
 */
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
