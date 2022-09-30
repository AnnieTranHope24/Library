package project6;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Superclass for Book and Periodical classes.
 * @author Demetria Johansen, Ngoc Tran
 */
public abstract class Item {
	private String callNumber;
	private boolean isCheckedOut;
	private GregorianCalendar dateCheckedOut;
	private GregorianCalendar dateDue;
	private String title;
	private String type;

	/**
	 * Constructor for Item class.
	 * @param callNumber the call number of the item
	 * @param title the title of the item
	 * @param type the type of the item
	 */
	public Item(String callNumber, String title, String type) {
		this.callNumber = callNumber;
		this.title = title;
		this.type = type;
		isCheckedOut = false;
	}
	
	/**
	 * Method to get the call number of an item.
	 * @return callNumber
	 */
	public String getCallNumber() {
		return callNumber;

	}
	
	/**
	 * Method to check out items.
	 * @return isCheckedOut
	 */
	public boolean isCheckedOut() {
		GregorianCalendar today = new GregorianCalendar();
		//if today is after dateDue then the item is returned and not checked out
		if(today.after(dateDue)) {
			isCheckedOut = false;
		}
		return isCheckedOut;

	}
	
	/**
	 * Uses the Gregorian Calendar to retrieve the date that a text was checked out
	 * @return dateCheckedOut
	 */
	public GregorianCalendar getDateCheckedOut() {
		return dateCheckedOut;
	}

	/**
	 * Method to retrieve the date that an item is due.
	 * @return dateDue
	 */
	public GregorianCalendar getDateDue() {
		return dateDue;
	}
	
	/**
	 * Method that sets the due date of an item.
	 * @param date the due date 
	 */
	public void setdateDue(GregorianCalendar date) {
		dateDue = date;
	}

	/**
	 * Method to change the check out date of an item to a string value.
	 * @return dateOut
	 */
	public String dateCheckedOutToString() {
		String dateOut = String.format("Date Out: %tD", dateCheckedOut);
		return dateOut;

	}

	/**
	 * Method to change the due date of an item to a string value.
	 * @return dateDueString;
	 */
	public String dateDueToString() {
		String dateDueString = String.format("Date Due: %tD", dateDue);
		return dateDueString;

	}

	/**
	 * Method to retrieve the title of an item.
	 * @return title
	 */
	public String getTitle() {
		return title;

	}

	/**
	 * Method to retrieve the type of an item (e.g. book or periodical).
	 * @return type
	 */
	public String getType() {
		return type;

	}

	/**
	 * Method to set the date for a checked out item and the due date.
	 * @param addedDays the number of days after the date checked out
	 */
	public void setdateCheckedOutAndDueDate(int addedDays) {
		setIsCheckedOut(true);
		dateCheckedOut = new GregorianCalendar();
		dateDue = (GregorianCalendar) dateCheckedOut.clone();
		dateDue.add(Calendar.DAY_OF_YEAR, addedDays);

	}

	/**
	 * Method to set the callNumber of an item.
	 * @param callNumber the call number of the item
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * Method to set an item to checked out if the boolean value for isChecked out is true.
	 * @param isCheckedOut whether or not the item is checked out
	 */
	public void setIsCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}

	/**
	 * Method that sets the title of an item.
	 * @param title the title of the item
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method to set the type of an item.
	 * @param type the subject or genre of the item
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Abstract method for setting the date checked out and due date of an item.
	 */
	public abstract void setdateCheckedOutAndDueDate();

	/**
	 * Abstract method to print the information of an item.
	 */
	public abstract void printInfor();

}
