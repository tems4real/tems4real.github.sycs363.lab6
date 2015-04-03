package howard.edu.sycs363.spring15.lab6;

import static org.junit.Assert.*;
import howard.edu.sycs363.spring15.lab4.PhoneDirectory;

import org.junit.Test;

public class TestDelete {

	@Test
	public void testDeleteEntryPresent() {
		PhoneDirectory newDirectory = new PhoneDirectory();
		newDirectory.addorChangeEntry("Ore", "2029107997");
		newDirectory.deleteEntry("Ore");
		
		//Test that delete worked
		//Look up should fail since deleted
		assertEquals("Should return Ore's number not currently in the directory.","Ore's number not currently in the directory.",newDirectory.lookup("Ore"));
	}
	
	@Test
	public void testDeleteEntryAbsent() {
		PhoneDirectory newDirectory = new PhoneDirectory();	
		newDirectory.deleteEntry("Ore");
		
		//Test that delete worked
		//Look up should fail since deleted
		assertEquals("Should return Ore's number not currently in directory","Ore's number not currently in the directory.",newDirectory.lookup("Ore"));
	}

}
