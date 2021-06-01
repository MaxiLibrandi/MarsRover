# Repository
This repository contains the implementation of the Mars Rovers problem in __Java__, using __Maven__.

# Mars Rovers Problem
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.

A rover’s position and location is represented by a combination of x and y coordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.

In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading. Assume that the square directly North from (x, y) is (x, y+1).

### Input 
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau. The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the rover’s orientation.

Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.

### Output
The output for each rover should be its final coordinates and heading.

# Example
### Test Input: 
5 5

1 2 N

LMLMLMLMM

3 3 E 

MMRMMRMRRM
### Expected Output:
1 3 N

5 1 E

# Instructions to run locally
### Requirements
For running it, you will need:
  - Java
  - Maven

You can install **Java** following the steps in https://www.java.com/en/download/help/index_installing.html

You can install **Maven** following the steps in https://maven.apache.org/install.html

### Clone the repo
First, you need to clone this GitHub repo into your local system in order to run it locally.

### Install Maven in the repo
After cloning the repo, you need to install maven in the project. Inside the CLI, move to the project's directory and run the following command:

> mvn install

When you execute this command, the Maven lifecycle will execute. This consists of 7 steps: **validate, compile, test, package, verify, install** and **deploy**.

As the test is one of the steps of the lifecycle, the tests in this project will be run. If you don't want to run the tests, use the **-d** flag.

### Execute 
After installing Maven in the project, you can run the main method of it. Again, using the CLI, move to the project's directory and run the following command:

> mvn exec:java -Dexec.mainClass="com.marsRover.marsRoverProject.Runner" -Dexec.args="<FILEPATH_TO_INPUT>"

Note that the main method is waiting the file path of your input file. Replace the **<FILEPATH_TO_INPUT>** with the path of your input file.

You can find an example of an input file under 'src/main/resources/input.txt'. You can also use it for running the main method of the project. The command will be:

> mvn exec:java -Dexec.mainClass="com.marsRover.marsRoverProject.Runner" -Dexec.args="src/main/resources/input.txt"

### Run tests

If you only want to run the unit tests for the project, you can do it after having installed Maven. Open the CLI, move to the project directory and run the following command:

> mvn test 

# Additional considerations
- The casting from the input is done inside the Constructors, and not when the input data is read.
- If a Rover is created with a position bigger than the Plateau size (in any X-axis or Y-axis), it will throw an exception when the rover is added to the Plateau, not when the Rover is created. 
- The logic I used for this problem is: I create a new rover (with input from file), then I add it to the Plateau and then I execute the commands. If there is a second rover, I will add it to the Plateau __after__ the commands of the first rover was executed.
