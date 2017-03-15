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
		
		askName();
	}

	public void askName() {
		System.out.print("Name of customer: ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		if (userInput.contains(" ")) {
			checkFullName(userInput);
		} else {
			checkPartial(userInput);
		}
	}
	
	public void checkFullName(String input) {
		
		for (Profile profile : profiles) {
			if (profile.getName().equals(input)) {
				printBooks(profile);
				return;
			}
		}
		System.out.println("Customer doesn't exist");
	}
	
	public void checkPartial(String input) {
	
		for (Profile profile : profiles) {
			if (profile.getName().toLowerCase().contains(input.toLowerCase())) {
				System.out.print(profile.getName() + ": ");
				printBooks(profile);
				return;
			}
		}
		System.out.println("No customer found");
	}
	
	private void printBooks(Profile profile) {
		ArrayList<String> bookTitles = profile.getBookTitles();
		for (int i = 0; i < bookTitles.size(); i++) {
			System.out.print(bookTitles.get(i));
			if (i != bookTitles.size() - 1) {
				System.out.print(", ");
			}
		}
	}
}