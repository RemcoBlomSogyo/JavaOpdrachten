/*
	This program asks for a number to the user.
	The program answers with the corresponding fibonacci number.
	
	Made by Remco Blom
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class FibonacciTestDrive {
		
	public static void main (String[] args) {
		
		Userinput input = new Userinput();
		int inputNum = input.getPosInt();
		
		Fibonacci fib = new Fibonacci();
		fib.numCheck(inputNum);
	}
}


/*
	Asks user for integer
*/

class Userinput {
	
	public static int getPosInt() {
		
		int userNum = 0;

		while (userNum <= 0) {
			System.out.println("Give me an integer to check what the corresponding fibonacci number is");
			Scanner scan = new Scanner(System.in);
			try {
				userNum = scan.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("An integer above 0 please!");
			}
		}
		
		return userNum;
	}
}


/*
	Finds corresponding fibonacci number and print
*/

class Fibonacci {
	
	public static void numCheck(int userInput) {

		int firstNum = 0;
		int secondNum = 1;
		int thirdNum = 1;
		int fibNum = 3;
		
		while (fibNum != userInput) {
			firstNum = secondNum;
			secondNum = thirdNum;
			thirdNum = firstNum + secondNum;
			fibNum += 1;
		}
		
		System.out.println("Fibonacci number " + userInput + " is " + thirdNum);
	}
}
