package howard.edu.sycs363.spring15.lab6;

import static org.junit.Assert.*;
import howard.edu.sycs363.spring15.lab4.PhoneDirectory;

import org.junit.Test;

public class TestLookup {

	@Test
	public void testLookupPass() {
		PhoneDirectory newDirectory = new PhoneDirectory();
		//Tests add
		newDirectory.addorChangeEntry("Ore", "1234567890");
		
		//Test lookup Method
		assertEquals("Should return 1234567890","1234567890",newDirectory.lookup("Ore"));
	}

	@Test
	public void testLookupFail() {
		PhoneDirectory newDirectory = new PhoneDirectory();
		
		//Test lookup Method
		assertEquals("Should return :Bre's number not currently in the directory.","Bre's number not currently in the directory.",newDirectory.lookup("Bre"));
	}
	
	@Test
	public void testChangeEntry() {
		PhoneDirectory newDirectory = new PhoneDirectory();
		//Tests add
		newDirectory.addorChangeEntry("Ore", "1234567890");
		newDirectory.addorChangeEntry("Ore", "4354993094");
		
		//Test lookup Method
		assertEquals("Should return 4354993094","4354993094",newDirectory.lookup("Ore"));
	}
}
