/*
	Profiling.java
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Profiling {
	
	ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	// reads txt file and converts into profiles
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
		//askBook();
	}

	// asks name as input to user
	private void askName() {
		System.out.print("Name of customer: ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		if (userInput.contains(" ")) {
			checkFullName(userInput);
		} else {
			checkPartial(userInput);
		}
	}
	
	// asks book title as input to user
	private void askBook() {
		System.out.print("Name of book: ");
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		
		searchForNames(userInput);
	}
	
	// checks if the full name is in the list of profiles
	private void checkFullName(String input) {
		for (Profile profile : profiles) {
			if (profile.getName().equals(input)) {
				//printBooks(profile);
				recommendBook(profile);
				return;
			}
		}
		System.out.println("Customer doesn't exist");
	}
	
	// checks if the input is in the name of a customer
	private void checkPartial(String input) {
		for (Profile profile : profiles) {
			if (profile.getName().toLowerCase().contains(input.toLowerCase())) {
				System.out.print(profile.getName() + ": ");
				//printBooks(profile);
				recommendBook(profile);
				return;
			}
		}
		System.out.println("No customer found");
	}
	
	// prints all sold book titles of a customer
	private void printBooks(Profile profile) {
		ArrayList<String> bookTitles = profile.getBookTitles();
		for (int i = 0; i < bookTitles.size(); i++) {
			System.out.print(bookTitles.get(i));
			if (i != bookTitles.size() - 1) {
				System.out.print(", ");
			}
		}
	}
	
	// prints all names of customers that bought a specific book
	private void searchForNames(String input) {
		for (Profile profile : profiles) {
			if (profile.getBookTitles().contains(input)) {
				System.out.println(profile.getName());
				return;
			}
		}
		System.out.println("This book hasn't been sold");
	}
	
	// gives a recommendation to a customer based on similarities with an other customer
	private void recommendBook(Profile inputProf) {
		ArrayList<String> inputTitles = inputProf.getBookTitles();
		for (Profile compareProf : profiles) {
			ArrayList<String> compareTitles = compareProf.getBookTitles();
			ArrayList<String> matchTitles = new ArrayList<String>();
			for (String inputTitle : inputTitles) {
				if (compareTitles.contains(inputTitle)) {
					matchTitles.add(inputTitle);
				}
			}
			if (matchTitles.size() >= 3 && matchTitles.size() != compareTitles.size()) {
				for (String compareTitle : compareTitles) {
					if (!matchTitles.contains(compareTitle)) {
						System.out.println(compareTitle);
						return;
					}
				}
			}
		}
		System.out.println("No recommendations");
	}
}