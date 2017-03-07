/*
	NimLauncher.java
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.InputMismatchException;

/*
	Makes a nim game and launches it
*/
public class NimLauncher {
	public static void main (String[] args) {
		NimGame nimGame = new NimGame();
		nimGame.choosePlayers();
	}
}

class NimGame {
	private int matches = 11;
	private int turnPlayer = 1;
	private int players = 0;
	private int[] compTakesMatches = {1, 1, 2, 3, 4, 1, 1, 2, 3, 4, 1};
	
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
	
	public int getPlayers() {
		return players;
	}
	
	public void setPlayers(int plrs) {
		players = plrs;
	}
	
	public void changeTurnPlayer(int player){
		if (player == 1) {
			player++;
		} else {
			player--;
		}
		setTurnPlayer(player);
	}
	
	// user is able to choose a one or a two player game
	public void choosePlayers() {
		System.out.print("Choose the amount of players (1/2): ");
		
		Scanner scan = new Scanner(System.in);
		try {
			setPlayers(scan.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("That is not an integer.\n");
			choosePlayers();
		}
		
		if (getPlayers() != 1 && getPlayers() != 2) {
			System.out.println("Choose between 1 or 2.\n");
			choosePlayers();
		}
		
		playerTurn();
	}
	
	// checks if a player lost or that the game has to continue
	public void checkEndGame() {
		if (getMatches() == 0) {
			if (getPlayers() == 1 && getTurnPlayer() == 2) {
				System.out.println("The computer took the last match.");
				System.out.println("The computer lost.");
			} else {
				System.out.println("Player " + getTurnPlayer() + " took the last match.");
				System.out.println("Player " + getTurnPlayer() + " lost.");
			}
		} else {
			changeTurnPlayer(getTurnPlayer());
			if (getPlayers() == 1 && getTurnPlayer() == 2) {
				computerTurn();
			} else {
				playerTurn();
			}
		}
	}
	
	// handles the turn of a human being player
	public void playerTurn() {
		int inputNum = 0;
		
		if (getMatches() == 1) {
			System.out.println("There is " + getMatches() + " match.");
		} else {
			System.out.println("There are " + getMatches() + " matches.");
		}
		System.out.print("How many does player " + getTurnPlayer() + " want to take? ");

		Scanner scan = new Scanner(System.in);
		try {
			inputNum = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("That is not an integer.\n");
			playerTurn();
			return;
		}

		if (checkValidInt(inputNum)) {
			setMatches(getMatches() - inputNum);
			checkEndGame();
		} else {
			playerTurn();
		}
	}
	
	// handles the turn of the computer player
	public void computerTurn() {
		if (getMatches() == 1) {
			System.out.println("There is " + getMatches() + " match.");
		} else {
			System.out.println("There are " + getMatches() + " matches.");
		}
		System.out.print("How many does the computer want to take? ");
		System.out.println(compTakesMatches[getMatches() - 1] + "\n");
		
		setMatches(getMatches() - compTakesMatches[getMatches() - 1]);
		checkEndGame();
	}
	
	// checks if the input of the player for taking matches is correct
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