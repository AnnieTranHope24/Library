/**
 * 
 */
package project6;

import java.io.FileNotFoundException;

/**
 * @author Demetria Johansen, Ngoc Tran
 * Interface for UserInterface class.
 */
public interface IUserInterface {
	/**
	 *  Method that reads the contents of an input file and puts them into a collection.
	 * @throws FileNotFoundException throw file not found exception
	 */
	public void readContents() throws FileNotFoundException;
	/**
	 * Method to run the program.
	 * @throws FileNotFoundException throw file not found exception
	 */
	public void runProgram() throws FileNotFoundException;
	/**
	 * Method that creates a visual menu for the user and calls another method to take in user input.
	 */
	public void showMenu();
	/**
	 * Method that displays the collection of items.
	 */
	public void displayCollection();
	/**
	 * Method to check out materials.
	 */
	public void checkOutMaterials();
	/**
	 * Method to quit the program.
	 */
	public void quit();

}
