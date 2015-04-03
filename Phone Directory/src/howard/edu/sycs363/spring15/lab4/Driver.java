package howard.edu.sycs363.spring15.lab4;
import howard.edu.sycs363.spring15.lab6.PhoneDirectory;

import java.util.Scanner;

public class Driver {
	/**
	 * @author: Oreoluwa Onatemowo
	 * @id: @02670375
	 */
	
	private static void Action(PhoneDirectory newDirectory){
		Scanner input = new Scanner(System.in);
			
		String choice;
		
		do{
			String inputChoice = input.nextLine();
			try {
				int inputInt = Integer.parseInt(inputChoice);
				choice = "do not redo";
				switch(inputInt){
				case 1: 
						System.out.println("Please enter name for whose number to search for, then press Enter.");
						String nameInput = input.nextLine();
						System.out.println("Name: "+nameInput+"\n"+
								"Number: "+newDirectory.lookup(nameInput));
						break;
				case 2: 
						System.out.println("Please enter name then press Enter.");
						String name = input.nextLine();
						System.out.println("Please enter phone number then press Enter");
						String phoneNumber = input.nextLine();
						newDirectory.addorChangeEntry(name, phoneNumber);
						break;
				case 3: 
						System.out.println("Please enter name to delete.");
						String deleteName = input.nextLine();
						newDirectory.deleteEntry(deleteName);
						break;
				case 4: 
						System.out.println("Please enter name then press Enter.");
						String changeName = input.nextLine();
						System.out.println("Please enter then press Enter");
						String changeNumber = input.nextLine();
						newDirectory.addorChangeEntry(changeName, changeNumber);
						break;
						
				default: System.out.println("Invalid Input \nPlease re-enter value.");
						choice = "redo";
				}
				
			} catch (Exception e) {
				System.out.println("Invalid Input \nPlease re-enter value.");
				choice ="redo";
			}
		}while(choice == "redo");
		
		System.out.println("Would you like to make a choice from the menu? \nClick y then Enter for yes, or n to quit program.");
		String inputString = input.nextLine();
		if ((inputString.equalsIgnoreCase("y"))){
			System.out.println("Scroll above to see menu \nInput corresponding number for choice, then click Enter.");
			Action(newDirectory);
		}
		input.close();
		newDirectory.write();
	}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("*************************************************");
		System.out.println("*Quick instruction:                             *");
		System.out.println("*Click y, then Enter to use default directory.  *");
		System.out.println("*To use custom directory                        *");
		System.out.println("*Enter Directory file name then press Enter.    *");
		System.out.println("*************************************************");

	
		String redo;
		do{
			String newInput = input.nextLine();
			redo = "n";
			
			if ((newInput.equalsIgnoreCase("y"))){
				PhoneDirectory newDirectory = new PhoneDirectory();
				Action(newDirectory);
			}
			else{
				if(newInput.contains(".txt") == true){		
					PhoneDirectory newDirectory = new PhoneDirectory(newInput);
					Action(newDirectory);
				}
				else{
					
					System.out.println("Invalid file. Please re-enter file name.");
					redo = "y";
				}
			
			}
		}while(redo.equals("y"));
		
		System.out.println("*************************************************");
		System.out.println("**********************MENU***********************");
		System.out.println("*1. Look up a phone number.                     *");
		System.out.println("*2. Add an entry to the directory.              *");
		System.out.println("*3. Delete an entry from the directory.         *");
		System.out.println("*4. Change someone's phone number.              *");
		System.out.println("*************************************************");
		System.out.println("*************************************************");
		System.out.println("To make a choice,\nType in a corresponding number and click Enter.");
		
		
	input.close();
	}	
}