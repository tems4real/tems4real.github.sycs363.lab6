package howard.edu.sycs363.spring15.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIndexOf {

	@Test
	public void testIndexOfWithInvalidValue() {
		IntegerArrayList tester = new IntegerArrayList(20);
		tester.add(45);
		
		//Test IndexOf	
		assertEquals("value 50 not in list. Return -1",-1,tester.indexOf(50));
	}

	@Test
	public void testIndexOfWithValidValue() {
		IntegerArrayList tester = new IntegerArrayList(20);
		tester.add(45); //Index 0
		tester.add(50); //Index 1
		tester.add(94); //Index 2
		//Test IndexOf	
		assertEquals("Return -1",2,tester.indexOf(94));
	}
}
