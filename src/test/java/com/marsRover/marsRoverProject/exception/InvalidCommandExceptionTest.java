package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.command.CommandProducer;

/**
* UnitTest for the InvalidCommandException class.
* Testing possible ways of doing the exception be thrown when the CommandProducer produces new commands to be set.
* @author Maximo Librandi
*
*/
class InvalidCommandExceptionTest {

	@Test
	void testInvalidCommandExceptionIsThrownFirstCommand() {
		Assertions.assertThrows(InvalidCommandException.class, () -> {
			CommandProducer.produceCommands("BMRMLM");
		});	
	}
	
	@Test
	void testInvalidCommandExceptionIsThrownLastCommand() {
		Assertions.assertThrows(InvalidCommandException.class, () -> {
			CommandProducer.produceCommands("MRMLMB");
		});	
	}
	
	@Test
	void testInvalidCommandExceptionIsThrownMiddleCommand() {
		Assertions.assertThrows(InvalidCommandException.class, () -> {
			CommandProducer.produceCommands("MRMBLM");
		});	
	}
}
