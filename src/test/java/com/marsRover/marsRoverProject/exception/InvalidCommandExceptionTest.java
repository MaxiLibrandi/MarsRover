package com.marsRover.marsRoverProject.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.marsRover.marsRoverProject.command.CommandProducer;

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
