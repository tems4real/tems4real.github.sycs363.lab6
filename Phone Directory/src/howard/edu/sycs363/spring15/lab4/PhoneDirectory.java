package howard.edu.sycs363.spring15.lab4;
import java.io.*;
import java.util.*;

public class PhoneDirectory {
	private String again,storeFile = "storage.txt";
	private Map<String, String> directoryMap = new HashMap<String, String>();
	/**
	 * Generic class constructor 
	 */
	public PhoneDirectory(){
		
		do{
			try {		
				FileReader fromFile = new FileReader("storage.txt");
				BufferedReader bufFromFile = new BufferedReader(fromFile);
				String line;
				while((line = bufFromFile.readLine())!= null){
					String [] directory = line.split(",");
					directoryMap.put(directory[0].trim(), directory[1].trim());
				}
				bufFromFile.close();
				again = "false";
			} catch (Exception e) {
				try {
					FileWriter newFile = new FileWriter("storage.txt");
					PrintWriter newPW = new PrintWriter(newFile);	
					newPW.close();
					again = "true";
				} catch (Exception e2) {
					System.out.println("Error creating storage file.");
					System.exit(0);
				}
			}
		}while(again == "true");
	}
	
	private void PhoneDirectoryCreator(String phoneDirectoryFile){
		try {		
			FileReader fromFile = new FileReader(phoneDirectoryFile);
			BufferedReader bufFromFile = new BufferedReader(fromFile);
			bufFromFile.close();
		} catch (Exception e) {
			System.out.println(phoneDirectoryFile + " is not currently in the file input location.");
			System.out.println("Please confirm file name was inputted correctly, and is in correct entry location.");
			System.out.println("To confirm "+phoneDirectoryFile+" is now in phoneDirectory click 1, then Enter");
			System.out.println("To create the " +phoneDirectoryFile +" for storage, click 2, then Enter.");
			System.out.println("To exit program now, click 3, then Enter.");
			Scanner inputText = new Scanner(System.in);
			String choice = "do not";
			do{			
				String inputString = inputText.nextLine();
				Integer inputInt = Integer.parseInt(inputString);
				inputText.close();
				switch(inputInt){
					case 1:
						PhoneDirectoryCreator(phoneDirectoryFile);
						break;
					case 2:
						try {
							FileWriter newFile = new FileWriter(phoneDirectoryFile);
							PrintWriter newPW = new PrintWriter(newFile);	
							newPW.close();
						} catch (Exception e2) {
							System.out.println("Error creating storage file.");
							System.exit(0);
						}
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid input, please re-enter.");
						choice = "redo";
				}
			}while(choice == "redo");
		}
	}
	/**
	 * Class constructor that takes file with data
	 *@param phoneDirectoryFile: Specifies the input file from which data will be read
	 */
	public PhoneDirectory(String phoneDirectoryFile){	
			storeFile = phoneDirectoryFile;
			PhoneDirectoryCreator(phoneDirectoryFile);
	}
	
	/**
	 * Method looks up a phone number based on the input key (name)
	 *@param personName: key used to search for phone number
	 *@return phoneNumber: Returns phone number based on input key (name)
	 */
	public String lookup(String personName) {
		
		if (directoryMap.get(personName) == null){
			return personName + "'s number not currently in the directory.";
		}
		return directoryMap.get(personName);
	}
	
	/**
	 * Method searches for key (name).
	 * If found, replaces phone number details
	 * else, creates new entry
	 *@param name: key searched for
	 *@param phoneNumber: phone number that can be added or changed based on if key is found
	 */
	public void addorChangeEntry(String name, String phoneNumber){
			directoryMap.put(name, phoneNumber);
			System.out.println("Change made.");
	}
	
	/**
	 * Method searches for key, then deletes key if found
	 * @param name: key which if found, is deleted from stored information
	 */
	public void deleteEntry(String name){
		if(directoryMap.containsKey(name)){
		directoryMap.remove(name);
		}
		else{
			System.out.println(name + " is not in directory.");
		}
	}
	
	/**
	 * Method writes contents of in memory phone directory to a file
	 */
	public void write(){

		try {
			FileWriter newFile = new FileWriter(storeFile);
			PrintWriter newPW = new PrintWriter(newFile);
			Set<String> setOfKeys = directoryMap.keySet();
			Iterator<String> iterator = setOfKeys.iterator();
			while(iterator.hasNext()){
				String key = (String)iterator.next();
				String value = (String) directoryMap.get(key);
				newPW.println(key+", "+value);
			}
			newPW.close();
			again = "true";
		} catch (Exception e) {
			System.out.println("Error creating storage file.");
			System.exit(0);
		}
	}
}
