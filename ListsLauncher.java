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
		tenIntArr.fill();
		tenIntArr.printArray();
		tenIntArr.printHighest();
	}
}

/*
	Makes an array of 10 places to fill with integers
*/
class TenIntegerArray {
	int[] numList = new int[10];
	int listLength = numList.length;
	
	// fill array with ten integers
	protected void fill() {
		for (int i = 0; i < listLength; i++) {
			numList[i] = (int) (Math.random() * 101);
		}
	}
	
	// print the array of ten integers
	protected void printArray() {
		for (int i = 0; i < listLength; i++) {
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
}