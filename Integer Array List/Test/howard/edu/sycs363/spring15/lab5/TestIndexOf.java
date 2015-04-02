package howard.edu.sycs363.spring15.lab5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIndexOf {

	@Test
	public void testIndexOfWithEmptyList() {
		IntegerArrayList tester = new IntegerArrayList(20);
		
		//Test indexOf() with empty IntegerArrayList
		assertEquals("List is empty. Return -1",-1,tester.indexOf(50));
	}
	
	@Test
	public void testIndexOfWithInvalidValue() {
		IntegerArrayList tester = new IntegerArrayList(20);
		tester.add(45);
		
		//Test indexOf() with value not in list
		assertEquals("Value 50 not in list. Return -1",-1,tester.indexOf(50));
	}

	@Test
	public void testIndexOfWithValidValue() {
		IntegerArrayList tester = new IntegerArrayList(20);
		tester.add(45); //Index 0
		tester.add(50); //Index 1
		tester.add(94); //Index 2
		
		//Test indexOf() with value in list
		assertEquals("Return 2, index of value 94.",2,tester.indexOf(94));
	}
}
