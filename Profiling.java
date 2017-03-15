/*
	Profiling.java
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Profiling {
	
	ArrayList<String> profileStrs = new ArrayList<String>();
	
	public void inputFile() {
		File file = new File("profiling-data.txt");
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				profileStrs.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		for (String str : profileStrs) {
			System.out.println(str);
		}
	}	
}