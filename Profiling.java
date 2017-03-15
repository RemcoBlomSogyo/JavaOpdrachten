/*
	Profiling.java
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Profiling {
	
	ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	public void inputFile() {
		File file = new File("profiling-data.txt");
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				List<String> lineParts = Arrays.asList(line.split(", "));
				profiles.add(new Profile());
				profiles.get(profiles.size() - 1).setName(lineParts.get(0));
				
				for (int i = 1; i < lineParts.size(); i++) {
					profiles.get(profiles.size() - 1).addBook(lineParts.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		for (Profile profile : profiles) {
			System.out.println(profile.getName());
		}
	}	
}