package howard.edu.sycs363.spring15.lab5;

/**
 * Array
 * @author Oreoluwa Onatemowo
 * ID: @0267075
 */
public class IntegerArrayList {

	private int arraySize,lastIndex = -1, temp, genValue, valueIndex;
	private int[] anArray, largerArray;

	/**
	 * Class constructor that takes size of array to be created
	 *@param size: Specifies size of array to be created
	 */
	public IntegerArrayList(int size){
		arraySize = size;
		anArray = new int[arraySize];	
	}
	/**
	 * Normal Class constructor
	 */
	public IntegerArrayList(){
		genValue = 50;
		anArray = new int[genValue];
	}
	/**
	 * Method adds value at the end of a list
	 * @param value: Specifies value to put into the array
	 */
	public void add(int value){
		
		if (lastIndex + 1 == genValue){
			resizeArray();
		}
		anArray[lastIndex + 1] = value;
		lastIndex++;
	}
	/**
	 *  Method adds value at the end of a list
	 * @param value: Specifies value to put into the array
	 * @param index: specifies index to which value should put into list
	 */
	public void add(int index, int value){
		if((index > lastIndex + 1)){
			System.out.println("-1");
		}
		else{
			if(lastIndex + 1 == anArray.length){ //current array is full, new array needed
				resizeArray();
			}
			if(index != (lastIndex + 1)){// If insertion index is not last insertable index
				for(int count = index; count<(lastIndex+1);count++){
					anArray[count + 1] = anArray[count];
				}
				anArray[index] = value;
			}
			else if(index == (lastIndex + 1)){
				anArray[lastIndex + 1] = value;
			}	
			lastIndex = lastIndex + 1;
		}
	}
	/**
	 *  Method gets value from list using the inputted index
	 * @param index: Specifies index from which an integer should be gotten
	 * @return integer from list
	 */
	public int get(int index){
		if(index > lastIndex){
			return -1;
		}
		else{
		return anArray[index];
		}
	}
	/**
	 *  Method gets index of first instance of a value by searching the list for said value
	 * @param value: Specifies value who's index to return
	 * @return integer (index)
	 */
	public int indexOf(int value){
		int counter;
		for (counter = 0; counter<anArray.length; counter++){
			if (anArray[counter] == value){			
				valueIndex = counter;
				break;
			}
		}
		if (counter == anArray.length){
			return -1;
		}
		return valueIndex;
	}
	/**
	 *  Method deletes a value from the list, then returns the respective value
	 * @param index: index from which to delete value
	 * @return integer from list
	 */
	public int remove(int index){
		if (index > anArray.length){
			return -1;
		}
		else{
			if (index > lastIndex){
				return -1;
			}
			else{
				temp = anArray[index];
				for (int count = index; ((anArray.length)-1)>count;count++){
					anArray[count] = anArray[count+1];	
				}	
			}
			lastIndex = lastIndex - 1;
		}
		return temp;
	}

	/** 
	 * Method resizes array, by doubling the size of current array when needed
	 */
	private void resizeArray(){
		largerArray = new int[anArray.length*2];
		for (int counter = 0; counter <arraySize;counter++){
			largerArray[counter] = anArray[counter];
		}
		anArray = largerArray;
		genValue = anArray.length;
	}
	/** 
	 * Method prints all integers in the array 
	 */
	public void allValues(){
		for(int i =0; i<lastIndex+1;i++){
			System.out.println(anArray[i]);
		}
	/** 
	 * Method resets array size
	 */
	}
	public void resetArray(){
		lastIndex = -1;
	}
	/** 
	 * Method returns state of array
	 * @return true if array is empty, false if array is not.
	 */
	boolean isEmpty(){
		if(lastIndex == -1){
			return true;
		}
		else{
			return false;
		}
	}
}
