package howard.edu.sycs363.spring15.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestisEmpty {

	@Test
	public void testIsEmptyIsTrue() {
		IntegerArrayList tester = new IntegerArrayList();
		
		//Test isEmpty() is true
		assertTrue(tester.isEmpty());
	}

	@Test
	public void testIsEmptyIsFalse() {
		IntegerArrayList tester = new IntegerArrayList();
		tester.add(5);
		
		assertFalse(tester.isEmpty());
	}
}
