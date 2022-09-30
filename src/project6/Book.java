package project6;

import java.util.GregorianCalendar;

/**
 * Class for books that extends the Item class
 * @author Demetria Johansen, Ngoc Tran
 *
 */
public class Book extends Item {
	private String author;
	private final static int CHECKED_OUT_DAYS = 21;

	/**
	 * Constructor for Book class.
	 * @param callNumber the call number
	 * @param title the title
	 * @param author the author
	 * @param genre the genre
	 */
	public Book(String callNumber, String title, String author, String genre) {
		super(callNumber, title, genre);
		setAuthor(author);

	}
	/**
	 * Method to set the check out and due date of items
	 */
	public void setdateCheckedOutAndDueDate() {
		super.setdateCheckedOutAndDueDate(CHECKED_OUT_DAYS);
	}

	/**
	 * Method to print book titles, authors, genres, call numbers, 
	 * and if something is checked out.
	 */
	@Override
	public void printInfor() {
		// TODO Auto-generated method stub
		System.out.println("Book Title: " + getTitle());
		System.out.println("Author: " + author);
		System.out.println("Genre: " + getType());
		System.out.println("Call Number: " + getCallNumber());

		if (isCheckedOut()) {
			System.out.println("Checked Out: YES");
			System.out.println(dateCheckedOutToString());
			System.out.println(dateDueToString());
		} else {
			System.out.println("Checked Out: NO");
		}
		System.out.println();

	}

	/**
	 * Method to get the author of an item
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Method to set the author of an item
	 * @param author the author of the book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
