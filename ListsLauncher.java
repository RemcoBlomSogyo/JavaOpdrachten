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
		tenIntArr.fourLists();
		tenIntArr.bubbleSort();
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
		
		System.out.print("Even numbers: ");
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
	
	// make four lists based on the divisibility of the numbers
	protected void fourLists() {
		int[] divTwoNums = new int[10];
		int[] divThreeNums = new int[10];
		int[] divFiveNums = new int[10];
		int[] remainNums = new int[10];
		int divTwoCounter = 0;
		int divThreeCounter = 0;
		int divFiveCounter = 0;
		int remainCounter = 0;
		
		for (int num : numList) {
			boolean isDividable = false;
			if (num % 2 == 0) {
				divTwoNums[divTwoCounter] = num;
				divTwoCounter++;
				isDividable = true;
			}
			if (num % 3 == 0) {
				divThreeNums[divThreeCounter] = num;
				divThreeCounter++;
				isDividable = true;
			}
			if (num % 5 == 0) {
				divFiveNums[divFiveCounter] = num;
				divFiveCounter++;
				isDividable = true;
			}
			if (!isDividable) {
				remainNums[remainCounter] = num;
				remainCounter++;
			}
		}
		
		printList(divTwoCounter, divTwoNums, 2);
		printList(divThreeCounter, divThreeNums, 3);
		printList(divFiveCounter, divFiveNums, 5);
		printList(remainCounter, remainNums, 0);
	}
	
	// printing method for fourLists
	private void printList (int counter, int[] nums, int divBy) {
		if (divBy != 0) {
			System.out.print("Numbers dividable by " + divBy + ": ");
		} else {
			System.out.print("Remaining numbers: ");
		}
		
		commaPrint(counter, nums);
		
		if (counter == 0) {
			System.out.println();
		}
	}
	
	// sorting the list of numbers with bubble sort
	protected void bubbleSort () {
		int[] sortList = numList;
		int sorts = 1;
		
		while (sorts != 0) {
			sorts = 0;
			for (int i = 0; i < listLength; i++) {
				if (i == listLength - 1) {
					break;
				}
				if (sortList[i] > sortList[i + 1]) {
					int temp = sortList[i];
					sortList[i] = sortList[i + 1];
					sortList[i + 1] = temp;
					sorts++;
				}
			}
		}
		
		System.out.print("Bubble sort: ");
		commaPrint(listLength, sortList);
	}
	
	// printing numbers seperated by commas, for printList and bubbleSort
	private void commaPrint (int arrLength, int[] numArray) {
		for (int i = 0; i < arrLength; i++) {
			if (i != arrLength - 1) {
				System.out.print(numArray[i] + ", ");
			} else {
				System.out.println(numArray[i]);
			}
		}
	}
}