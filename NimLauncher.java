/*
	NimLauncher.java
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class NimLauncher {
	public static void main (String[] args) {
		NimGame nimGame = new NimGame();
		nimGame.playTurn();
	}
}

class NimGame {
	private int matches = 11;
	private int turnPlayer = 1;
	
	public int getMatches() {
		return matches;
	}
	
	public void setMatches(int mchs) {
		matches = mchs;
	}
	
	public int getTurnPlayer() {
		return turnPlayer;
	}
	
	public void setTurnPlayer(int turnPlr) {
		turnPlayer = turnPlr;
	}
	
	public void changeTurnPlayer(int player){
		if (player == 1) {
			player++;
		} else {
			player--;
		}
		setTurnPlayer(player);
	}
	
	public void checkEndGame() {
		if (getMatches() == 0) {
			System.out.println("Player " + getTurnPlayer() + " took the last match.");
			System.out.println("Player " + getTurnPlayer() + " lost.");
		} else {
			changeTurnPlayer(getTurnPlayer());
			playTurn();
		}
	}
	
	public void playTurn() {
		int inputNum = 0;
		boolean isInt = false;
		
		while (!isInt) {
			if (getMatches() == 1) {
				System.out.println("There is " + getMatches() + " match.");
			} else {
				System.out.println("There are " + getMatches() + " matches.");
			}
			System.out.print("How many does player " + getTurnPlayer() + " want to take? ");

			Scanner scan = new Scanner(System.in);
			try {
				inputNum = scan.nextInt();
				isInt = true;
			} catch (InputMismatchException e) {
				System.out.println("That is not an integer.\n");
			}
		}
		
		if (checkValidInt(inputNum)) {
			setMatches(getMatches() - inputNum);
			checkEndGame();
		} else {
			playTurn();
		}
	}
	
	public boolean checkValidInt(int input) {
		if (input < 1 || input > 4) {
			System.out.println("Give an integer between 1 and 4.\n");
			return false;
		} else if (getMatches() - input < 0) {
			System.out.println("There are not that much matches left.\n");
			return false;
		} else {
			System.out.println();
			return true;
		}
	}
}