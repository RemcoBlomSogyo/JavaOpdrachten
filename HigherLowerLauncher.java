/*
	This is a game where computer chooses a number.
	The user has to guess which number the computer has chosen.
	
	Made by Remco Blom
*/

import java.lang.Math;
import java.util.Scanner;
import java.util.InputMismatchException;

public class HigherLowerLauncher {
	
	public static void main (String[] args) {
		HigherLower higherLower = new HigherLower();
		higherLower.startGame();
	}
}

class HigherLower {
	
	private static int guessNum;
	private static int guessesLeft = 10;
	
	// chooses number and start the game
	protected void startGame() {
		guessNum = (int) (Math.random() * 50 + 1);
		askUser();
	}
	
	// decreases amount of guesses if answer is wrong
	private void decreaseGuesses() {
		guessesLeft--;
		if (guessesLeft != 0) {
			System.out.println("Guesses left: " + guessesLeft);
			askUser();
		}
		else {
			System.out.println("Game over!");
		}
	}
	
	// compares input with number and communicate with user
	private void compareNums(int chosenNum) {
		if (guessNum < chosenNum) {
			System.out.println("Lower");
			decreaseGuesses();
		}
		else if (guessNum > chosenNum) {
			System.out.println("Higher");
			decreaseGuesses();
		}
		else {
			System.out.println("Correct");
		}
	}
	
	// asks input from user
	private void askUser() {
		
		int inputNum = 0;
		while (inputNum < 1 || inputNum > 50) {
			System.out.print("Enter a number: ");
			Scanner scan = new Scanner(System.in);
			
			try {
				inputNum = scan.nextInt();
				if (inputNum < 1 || inputNum > 50) {
					System.out.println("The number has to be 1 till 50");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("That's not a number");
			}
		}
		
		compareNums(inputNum);
	}
}