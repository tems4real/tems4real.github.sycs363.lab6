package howard.edu.sycs363.spring15.lab6;

import static org.junit.Assert.*;
import howard.edu.sycs363.spring15.lab4.PhoneDirectory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WriteTest {
	private Map<String, String> defaultTestMap = new HashMap<String, String>();
	private Map<String, String> customTestMap = new HashMap<String, String>();

	@Test
	public void testWriteDefaultFile() {
		PhoneDirectory newDirectory = new PhoneDirectory();
		newDirectory.addorChangeEntry("Ore", "2029107997");
		
		//Writes to file
		newDirectory.write();
		try {		
			FileReader fromFile = new FileReader("storage.txt");
			BufferedReader bufFromFile = new BufferedReader(fromFile);
			String line;
			while((line = bufFromFile.readLine())!= null){
				String [] directory = line.split(",");
				defaultTestMap.put(directory[0].trim(), directory[1].trim());
			}
			bufFromFile.close();
			
		}catch (Exception e) {
			System.out.println("Failed to read file.");
		}
		
		//Tests that file was correctly written into
		assertEquals("Should return 2029107997","2029107997",defaultTestMap.get("Ore"));
	}

	@Test
	public void testWriteCustomFile() {
	//Tests Constructor with custom save file
	PhoneDirectory newDirectory = new PhoneDirectory("testFile.txt");
	newDirectory.addorChangeEntry("Ore", "2029107997");
	
	newDirectory.write();
	
	//Reads file 
	try {		
		FileReader fromFile = new FileReader("testFile.txt");
		BufferedReader bufFromFile = new BufferedReader(fromFile);
		String line;
		while((line = bufFromFile.readLine())!= null){
			String [] directory = line.split(",");
			customTestMap.put(directory[0].trim(), directory[1].trim());
		}
		bufFromFile.close();
		
	}catch (Exception e) {
		System.out.println("Failed to read file.");
	}
	
	//Tests that file was correctly read from
	assertEquals("Should return 2029107997","2029107997",customTestMap.get("Ore"));
	}
	
}
