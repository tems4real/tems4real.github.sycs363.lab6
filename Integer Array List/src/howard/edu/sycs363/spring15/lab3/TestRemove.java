package howard.edu.sycs363.spring15.lab3;

import static org.junit.Assert.*;

//import java.util.Random;

import org.junit.Test;

public class TestRemove {

	@Test
	public void testRemovewithEmptyList() {
		IntegerArrayList tester1 = new IntegerArrayList();
		
		//Tests remove 
		assertEquals("Empty list return -1",-1, tester1.remove(51));	
	}
	
	@Test
	public void testRemovewithValidIndex() {
		IntegerArrayList tester2 = new IntegerArrayList();
		tester2.add(45); //Index 0
		tester2.add(67); //Index 1
		tester2.add(23); //Index 2
		
		//Tests remove 
		assertEquals("Should return 67",67, tester2.remove(1));
	}

	@Test
	public void testRemovewithIndexOutOfRange() {
		IntegerArrayList tester2 = new IntegerArrayList();
		tester2.add(45); //Index 0
		tester2.add(67); //Index 1
		tester2.add(23); //Index 2
		
		//Tests remove 
		assertEquals("Index out of range, return -1",-1, tester2.remove(5));
	}

}
