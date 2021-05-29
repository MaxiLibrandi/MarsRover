package com.marsRover.marsRoverProject.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
	private final static Logger LOGGER = LogManager.getLogger(Parser.class);
	private String filename;
	private String fileContent;
	
	public Parser(String filename) {
		this.filename = filename;
	}
	
	public void readFile() {
		BufferedReader bufferedReader = null;
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
	}
	
	public String getFileContent() {
		return fileContent;
	}
}
