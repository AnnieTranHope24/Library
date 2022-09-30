package project6;

import java.util.GregorianCalendar;

/**
 * Class for periodicals that extends the Item class.
 * @author Demetria Johansen, Ngoc Tran
 *
 */
public class Periodical extends Item {
	private String volume;
	private String issue;
	private final static int CHECKED_OUT_DAYS = 7;

	/**
	 * Constructor for periodicals.
	 * @param callNumber the call number of the periodical
	 * @param title the title of the periodical
	 * @param volume the volume of the periodical
	 * @param issue the issue of the periodical
	 * @param subject the subject of the periodical
	 */
	public Periodical(String callNumber, String title, String volume, String issue, String subject) {
		super(callNumber, title, subject);
		setVolume(volume);
		setIssue(issue);

	}

	/**
	 * Print method for periodical information (e.g. title, volume etc).
	 */
	@Override
	public void printInfor() {
		// TODO Auto-generated method stub
		System.out.println("Periodical Title: " + getTitle());
		System.out.println("Volume: " + volume);
		System.out.println("Issue: " + issue);
		System.out.println("Subject: " + getType());
		System.out.println("Call Number: " + getCallNumber());
		if(isCheckedOut()) {
			System.out.println("Checked Out: YES");
			System.out.println(dateCheckedOutToString());
			System.out.println(dateDueToString());
		}
		else {
			System.out.println("Checked Out: NO");
		}
		System.out.println();
	}

	/**
	 * Method that sets the check out and due date of periodicals.
	 */
	public void setdateCheckedOutAndDueDate() {
		super.setdateCheckedOutAndDueDate(CHECKED_OUT_DAYS);
	}

	/**
	 * Method to retrieve the volume of a periodical.
	 * @return volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * Method that sets the volume of a periodical.
	 * @param volume the volume of the periodical
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * Method to retrieve the issue of a periodical.
	 * @return the issue
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * Method to set the issue of the periodical. 
	 * @param issue the issue of the periodical
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

}
