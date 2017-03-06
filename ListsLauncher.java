/*
	ListsLauncher.java
	
	Made by Remco Blom
*/

import java.lang.Math;

/*
	Starts the program
*/
public class ListsLauncher {
	public static void main (String[] args) {
		TenIntegerArray tenIntArr = new TenIntegerArray();
		tenIntArr.fillAndPrint();
		tenIntArr.printHighest();
		tenIntArr.addingTwoLowest();
		tenIntArr.printEven();
	}
}

/*
	Makes an array of 10 places to fill with integers
*/
class TenIntegerArray {
	int[] numList = new int[10];
	int listLength = numList.length;
	
	// fill array with ten integers
	protected void fillAndPrint() {
		for (int i = 0; i < listLength; i++) {
			numList[i] = (int) (Math.random() * 101);
			System.out.print(numList[i]);
			if (i != listLength - 1) {
				System.out.print(", ");
			} else {
				System.out.println();
			}
		}
	}
	
	// print the highest integer of the array
	protected void printHighest() {
		int highestNum = 0;
		for (int num : numList) {
			if (num > highestNum) {
				highestNum = num;
			}
		}
		System.out.println("Highest number: " + highestNum);
	}
	
	// adding the lowest two integers of the array and print
	protected void addingTwoLowest() {
		int firstLowest = 100;
		int secondLowest = 100;
		
		for (int num : numList) {
			if (num < firstLowest) {
				secondLowest = firstLowest;
				firstLowest = num;
			} else if (num < secondLowest) {
				secondLowest = num;
			}
		}
		int totalLowest = firstLowest + secondLowest;
		System.out.println("Adding two lowest numbers: " + firstLowest 
			+ " + " + secondLowest + " = " + totalLowest);
	}
	
	// print all even numbers of array
	protected void printEven() {
		int evenNums = 0;
		
		for (int num : numList) {
			if (num % 2 == 0) {
				if (evenNums != 0) {
					System.out.print(", ");
				}
				evenNums++;
				System.out.print(num);
			}
		}
		System.out.println();
	}
}