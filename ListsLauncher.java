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
		tenIntArr.print();
	}
}

/*
	Makes an array of 10 places to fill with integers
*/
class TenIntegerArray {
	int[] numList = new int[10];
	int listLength = numList.length;
	
	protected void fill() {
		for (int i = 0; i < listLength; i++) {
			numList[i] = (int) (Math.random() * 101);
		}
	}
	
	protected void print() {
		for (int i = 0; i < listLength; i++) {
			System.out.print(numList[i]);
			if (i != listLength - 1) {
				System.out.print(", ");
			} else {
				System.out.println();
			}
		}
	}
}