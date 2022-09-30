package project6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that interacts with the user.
 * @author Demetria Johansen, Ngoc Tran
 *
 */
public class UserInterface implements IUserInterface {
	private HashMap<String, Item> items;
	private boolean isQuit;

	public UserInterface() {
		items = new HashMap<>();
	}

	/**
	 * Method that reads the contents of an input file and puts them into a HashMap
	 */
	@Override
	public void readContents() throws FileNotFoundException {
		// TODO Auto-generated method stub

		File ourFile = new File("input.txt");
		Scanner reader = new Scanner(ourFile);
		String val;

		while (reader.hasNextLine()) {
			val = reader.nextLine();
			String[] elements = val.trim().split(",");

			// put items to the HashMap
			try {
				if (elements[0].toUpperCase().equals("B")) {
					Book book = new Book(elements[1], elements[2], elements[3], elements[4]);
					items.put(book.getCallNumber(), book);
				} else if (elements[0].toUpperCase().equals("P")) {
					Periodical p = new Periodical(elements[1], elements[2], elements[3], elements[4], elements[5]);
					items.put(p.getCallNumber(), p);
				} else {
					throw new InvalidInputException();
				}
			} catch (InvalidInputException e) {

			}
		}
		reader.close();
	}

	/**
	 * Method to retrieve the size of the Library.
	 * @return items.size()
	 */
	public int getLibrarySize() {
		return items.size();
	}

	/**
	 * Method to run the program.
	 */
	@Override
	public void runProgram() throws FileNotFoundException {
		// TODO Auto-generated method stub
		readContents();
		while (!isQuit) {
			showMenu();
		}
	}

	/**
	 * Method that creates a visual menu for the user and calls another method to take in user input.
	 */
	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("-------------Menu-------------");
		System.out.println(" 1) Display collection");
		System.out.println(" 2) Check out materials");
		System.out.println(" 3) Quit");
		System.out.println("------------------------------");
		menuOptions();
	}

	/**
	 * Method that uses options presented byt the showMenu method and takes action based on user input.
	 * @return val
	 */
	public int menuOptions() {
		System.out.println("Please choose an option: " );
		Scanner scan = new Scanner(System.in);
		
		try {
			int val = scan.nextInt();
			if (val == 1) {
				displayCollection();
			} else if (val == 2) {
				checkOutMaterials();
			} else if(val == 3){
				quit();
			}
			else {
				throw new InvalidInputException();
			}
			return val;
			
		}catch(InputMismatchException e) {
			System.out.println("Invalid input. Please enter 1, 2, or 3");
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid input. Please enter 1, 2, or 3");
		}
		return 0;


	}

	/**
	 * Method that displays the collection of items.
	 */
	@Override
	public void displayCollection() {
		// TODO Auto-generated method stub

		for (String key : items.keySet()) {
			Item item = items.get(key);
			item.printInfor();
		}

	}

	/**
	 * Method to check out materials 
	 */
	@Override
	public void checkOutMaterials() {
		// TODO Auto-generated method stub
		System.out.println("Enter the call number: ");
		while (true) {
			try {
				Scanner check = new Scanner(System.in);
				String material = check.nextLine();
				if (material == "") {
					throw new InvalidInputException();
				} else {
					getMaterial(material);
					break;
				}
			} catch (InvalidInputException e) {
				System.out.println("Empty entry.");
			}
		}

	}
	
	/**
	 * Method that retrieves an item based on the key entered.
	 * @param key the key
	 * @return items.get(key)
	 */
	public Item getItem(String key) {
	
		return items.get(key);
	}

	/**
	 * Method to retrieve materials based on the callNumber.
	 * @param callNumber the call number of the periodical
	 * @return item the item
	 */
	public Item getMaterial(String callNumber) {
//		if the HashMap items contains the call number provided by the user
		if (items.get(callNumber) != null) {
			Item item = items.get(callNumber);
			// if the item is available
			if (!item.isCheckedOut()) {
				item.setdateCheckedOutAndDueDate();
				item.printInfor();				
				return item;
			}
			// if the item has been checked out
			else {
				System.out.println("Item is not available.");
				return null;
			}
		}
//		if the HashMap items does not contain the call number provided by the user
		else {
			System.out.println("Item is not available.");
			return null;
		}

	}

	/**
	 * Method to quit the program.
	 */
	@Override
	public void quit() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				System.out.println("Do you want to quit?");
				System.out.println("Enter '1' for yes or '2' for no");

				Scanner quit = new Scanner(System.in);
				// Temporary value for storing user input.
				int answer = quit.nextInt();
				if (answer == 1) {
					isQuit = true;
					// Terminate program
					System.exit(0);
				} else if (answer == 2) {
					break;
				}
				else {
					throw new InvalidInputException(); 
				}

			} catch (InputMismatchException e) {
				System.out.println("Invalid entry! Must be '1' for yes or '2' for no.");
			}
			catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid entry! Must be '1' for yes or '2' for no.");
				
			}
		}

	}

}
