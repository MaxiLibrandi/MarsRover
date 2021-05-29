package com.marsRover.marsRoverProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.marsRover.marsRoverProject.command.CommandProducer;
import com.marsRover.marsRoverProject.parser.Parser;

public class Runner {
private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {
		/*
		String inputFilePath = "src/main/resources/input.txt";
		Parser inputParser = new Parser(inputFilePath);
		inputParser.readFile();
		
		BufferedReader bufferedReader = new BufferedReader(new StringReader(inputParser.getFileContent()));
		String line = null;
		try {
			line = bufferedReader.readLine();
			LOGGER.info("Plateau size is " + line);
			while ((line = bufferedReader.readLine()) != null)
				LOGGER.info(line);
		} catch (IOException e) {
			LOGGER.error(e);
		}
		*/
		
		Rover rover = new Rover(1,3,3,'E');
		String command = "MMRMMRMRRM";
		rover.addCommands(CommandProducer.produceCommands(command));
		LOGGER.info(rover.getStringPosition());
		rover.move();
		LOGGER.info(rover.getStringPosition());
	}

}
