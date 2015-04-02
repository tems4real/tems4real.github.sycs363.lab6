package howard.edu.sycs363.spring15.lab3;
/**
 * @author Oreoluwa Onatemowo
 * ID: @02670375
 * 
 * Driver class to run/test values methods from IntegerArraylist class.
 */
public class Driver {

	public static void main(String[] args) {
		//IntegerArrayList 
		IntegerArrayList bList = new IntegerArrayList();
		IntegerArrayList aList = new IntegerArrayList(5);

		bList.add(20);
		bList.add(210);
		bList.add(120);
		bList.add(4,12);
		bList.allValues();
		int value = aList.get(0);
		System.out.println("Value of 0th element"+value);
		System.out.println("List empty is " + bList.isEmpty()); //Will return false because list is not empty
		aList.add(20);
		aList.add(1,10);
		aList.add(7,12);
		aList.add(130);
		aList.add(3,1780);
		aList.add(1);
		aList.add(90);
		
		System.out.println(bList.get(9)); // Will return -1 because index not populated
		bList.get(1); // Will return 210
		
		bList.remove(210); // Will return 210, and will delete from list
		bList.allValues(); // Will print out the array, after removal of 210
		bList.remove(9); // Will return -1, since 9 is not present 
		
	}
	
	

}
