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
				profiles.get(profiles.size() - 1).setName(lineParts.get(0).replace("  ", " "));
				
				for (int i = 1; i < lineParts.size(); i++) {
					profiles.get(profiles.size() - 1).addBook(lineParts.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		/*for (Profile profile : profiles) {
			System.out.println(profile.getName());
		}*/
		askName();
	}

	public void askName() {
		System.out.print("Name of customer: ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		for (Profile profile : profiles) {
			if (profile.getName().equals(userInput)) {
				ArrayList<String> bookTitles = profile.getBookTitles();
				for (int i = 0; i < bookTitles.size(); i++) {
					System.out.print(bookTitles.get(i));
					if (i != bookTitles.size() - 1) {
						System.out.print(", ");
					}
				}
				return;
			}
		}
		System.out.println("Customer doesn't exist");
	}
}