package com.marsRover.marsRoverProject.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Parser class that reads from file and return the content as string.
 * @author Maximo Librandi
 *
 */
public class Parser {
	private final static Logger LOGGER = LogManager.getLogger(Parser.class);
	
	/** Constructor **/
	public Parser() {
		
	}
	
	/** Method to read the file content using a Buffer reader and a String builder**/
	public String readFile(String filename) {
		BufferedReader bufferedReader = null;
		String fileContent = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filename));
		    StringBuilder stringBuilder = new StringBuilder();
		    String line = bufferedReader.readLine();
		    while (line != null) {
		    	stringBuilder.append(line);
		    	stringBuilder.append(System.lineSeparator());
		        line = bufferedReader.readLine();
		    }
		    fileContent = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			LOGGER.error(e);
		} catch (IOException e) {
			LOGGER.error(e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
		return fileContent;
	}
}
