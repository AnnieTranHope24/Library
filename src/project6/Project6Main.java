package project6;

import java.io.FileNotFoundException;

/**
 * Class that runs the program by creating a UserInterface and calling the runProgram method.
 * @author Demetria Johansen
 *
 */
public class Project6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserInterface userInterface = new UserInterface();
		try{
		userInterface.runProgram();
		}
		catch (FileNotFoundException e) {
		System.out.println("File not found!");
		}
		
	}

}
