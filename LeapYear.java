/*
	This program asks for a year to the user.
	The program answers if the year is a leap year or not.
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class LeapYear {
	
	public static void main (String[] args) {
		
		// Ask user for input, check for input is number and is positive
		int getYear = -1;

		while (getYear < 0) {
			System.out.println("Give me a year to check if it is leap year!");
			Scanner scan = new Scanner(System.in);
			try {
				getYear = scan.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("That's not an integer!");
			}
		}

		// check for new century is dividible by 400
		if (getYear % 100 == 0) {
			if (getYear % 400 == 0) {
				System.out.println("That year is a leap year!");
			}
			else {
				System.out.println("That year is NOT a leap year!");
			}
			return;
		}

		// check if year is dividible by 4
		if (getYear % 4 == 0) {
			System.out.println("That year is a leap year!");
			return;
		}

		System.out.println("That year is NOT a leap year!");
	}
}