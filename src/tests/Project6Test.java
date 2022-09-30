package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import project6.Book;
import project6.Item;
import project6.Periodical;
import project6.UserInterface;

/**
 * Test class for Project6
 * @author Ngoc Tran
 *
 */
public class Project6Test {
	
	/**
	 * Method to read the contents of a test file
	 */
	@Test
	public void testReadContents() {
		UserInterface uiTest = new UserInterface();
		try {
			uiTest.readContents();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(4, uiTest.getLibrarySize());
	}

	/**
	 * Method to get the materials for a test
	 */
	@Test
	public void testGetMaterial() {
		UserInterface uiTest = new UserInterface();
		try {
			uiTest.readContents();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GregorianCalendar dateCheckedOut = new GregorianCalendar();
		String dateOutString = String.format("Date Out: %tD", dateCheckedOut);
		GregorianCalendar dateDueBook = (GregorianCalendar) dateCheckedOut.clone();
		dateDueBook.add(Calendar.DAY_OF_YEAR, 21);
		String dateDueBookString = String.format("Date Due: %tD", dateDueBook);
		GregorianCalendar dateDuePeriodical = (GregorianCalendar) dateCheckedOut.clone();
		dateDuePeriodical.add(Calendar.DAY_OF_YEAR, 7);
		String dateDuePeriodicalString = String.format("Date Due: %tD", dateDuePeriodical);
		// Case1: provide the callNumber of an available item (the item included in the
		// library and
		// has not been checked out)
		Book item = (Book) uiTest.getMaterial("F380.M1");
		assertEquals("F380.M1", item.getCallNumber());
		assertEquals("George R. R. Martin", item.getAuthor());
		assertEquals("A Game of Thrones", item.getTitle());
		assertEquals("Fantasy Literature", item.getType());
		assertEquals(dateOutString, item.dateCheckedOutToString());
		assertEquals(dateDueBookString, item.dateDueToString());

		Periodical p = (Periodical) uiTest.getMaterial("QJ072.C23.37.4");
		assertEquals("QJ072.C23.37.4", p.getCallNumber());
		assertEquals(dateOutString, p.dateCheckedOutToString());
		assertEquals(dateDuePeriodicalString, p.dateDueToString());
		assertEquals("4", p.getIssue());
		assertEquals("Computational Linguistics", p.getTitle());
		assertEquals("Computational Linguistics", p.getType());
		assertEquals("37", p.getVolume());

		// Case 2: the callNumber provided is not included in the library (the HashMap
		// items)
		Item item1 = uiTest.getMaterial("ABC");
		assertEquals(null, item1);
		// Case3: the item with the callNumber provided is in the HashMap items but has
		// been
		// checked out
		Item item2 = uiTest.getMaterial("F380.M1");
		assertEquals(null, item2);
		System.out.println();
		// Case4: if today is after the due date then the item has been returned and it
		// is
		// available
		uiTest.getItem("F380.M1").setdateDue(new GregorianCalendar(2021, 2, 23));
		Book item3 = (Book) uiTest.getMaterial("F380.M1");
		assertEquals("F380.M1", item3.getCallNumber());
		assertEquals("George R. R. Martin", item3.getAuthor());
		assertEquals("A Game of Thrones", item3.getTitle());
		assertEquals("Fantasy Literature", item3.getType());
		assertEquals(dateOutString, item3.dateCheckedOutToString());
		assertEquals(dateDueBookString, item3.dateDueToString());
	}

}