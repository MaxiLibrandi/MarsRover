package com.marsRover.marsRoverProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.marsRover.marsRoverProject.command.CommandProducer;
import com.marsRover.marsRoverProject.exception.GridBusyByOtherRoverException;
import com.marsRover.marsRoverProject.exception.InvalidCommandException;
import com.marsRover.marsRoverProject.exception.InvalidPlateauSizeException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingDirectionException;
import com.marsRover.marsRoverProject.exception.InvalidRoverStartingPositionException;
import com.marsRover.marsRoverProject.exception.RoverOutOfPlateauException;
import com.marsRover.marsRoverProject.parser.Parser;

public class Runner {
private final static Logger LOGGER = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {
		
		LOGGER.info("Houston, execution starting...");
		
		String inputFilePath = "src/main/resources/input.txt";
		Parser inputParser = new Parser(inputFilePath);
		BufferedReader bufferedReader = new BufferedReader(new StringReader(inputParser.readFile()));
		try {
			String line = bufferedReader.readLine();
			LOGGER.info("Plateau size is " + line);
			Plateau mars = new Plateau(line.split(" ")[0], line.split(" ")[1]);
			int roverId = 1;
			while ((line = bufferedReader.readLine()) != null) {
				Rover rover = new Rover(roverId++,line.split(" ")[0], line.split(" ")[1], line.split(" ")[2]);
				line = bufferedReader.readLine();
				rover.addCommands(CommandProducer.produceCommands(line));
				mars.addRover(rover);
				LOGGER.info(rover.toString());
				LOGGER.info("Commands: " + line);
				rover.move(mars);
				LOGGER.info(rover.getStringPosition());
			}
		} catch (IOException e) {
			LOGGER.error(e);
		} catch (InvalidPlateauSizeException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingPositionException e) {
			LOGGER.error(e);
		} catch (InvalidRoverStartingDirectionException e) {
			LOGGER.error(e);
		} catch (InvalidCommandException e) {
			LOGGER.error(e);
		} catch (RoverOutOfPlateauException e) {
			LOGGER.error(e);
		} catch (GridBusyByOtherRoverException e) {
			LOGGER.error(e);
		}
		
		
	}

}
