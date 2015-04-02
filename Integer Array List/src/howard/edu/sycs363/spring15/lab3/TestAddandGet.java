package howard.edu.sycs363.spring15.lab3;

import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;

public class TestAddandGet {

	@Test
	public void testAdd() {
		//Tests default IntegerArrayList
		IntegerArrayList tester = new IntegerArrayList();
		tester.add(10);
		
		//Tests add and get
		assertEquals("Should return 10",10, tester.get(0));
	}
	
	@Test
	public void testAddAtIndexFail(){
		//Tests 
		IntegerArrayList tester = new IntegerArrayList(20);
		tester.add(4, 6);
		
		//Test add at Index
		assertEquals("Should return -1", -1, tester.get(4));
	}
	
	
	@Test
	public void testAddAtIndexPass(){
		//Tests 
		IntegerArrayList tester = new IntegerArrayList(20);
		Random randomGen = new Random();
		//Populating array with values, to test that array is dynamic
		for(int i = 0; i < 21; i++){
			int randomInt = randomGen.nextInt(100);
			tester.add(randomInt);
		}
		//Adds value to specific index
		tester.add(4, 6);
		
		//Test add at Index
		assertEquals("Should return 4", 6, tester.get(4));
		
	}
	

}
