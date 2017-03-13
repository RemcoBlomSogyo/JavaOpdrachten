/*
	Lcd.java
	
	Made by Remco Blom
*/

import java.time.LocalTime;

public class Lcd {
	
	private int[]timeNums = new int[4];
	private int size = 1;
	private final boolean[] lineIsVert = {false, true, false, true, false};
	
	public void start(int newSize) {
		size = newSize;
		getCurTime();
		printLines();
	}
	
	private void getCurTime() {
		LocalTime time = LocalTime.now();
		timeNums[0] = time.getHour() / 10;
		timeNums[1] = time.getHour() % 10;
		timeNums[2] = time.getMinute() / 10;
		timeNums[3] = time.getMinute() % 10;
	}
	
	private void printLines() {
		
		// loop over the five line parts
		for (int i = 0; i < lineIsVert.length; i++) {
			
			int printedLines = 0;
			
			// if line is horizontal, print only one line
			if (!lineIsVert[i]) {
				printedLines = size - 1;
			}
			
			while (printedLines != size) {
				
				//loop over time digits
				for (int j = 0; j < timeNums.length; j++) {
					
					// vertical parts of digit
					if (lineIsVert[i]) {
						
						// upper vertical part of digit
						if (i == 1) {
							
							// left part of digit
							if (Numbers.getLine(timeNums[j], 1)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
							// middle part of digit
							printSpaces();
							
							// right part of digit
							if (Numbers.getLine(timeNums[j], 2)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
						// under vertical part of digit
						} else {
							
							// left part of digit
							if (Numbers.getLine(timeNums[j], 4)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
							// middle part of digit
							printSpaces();
							
							// right part of digit
							if (Numbers.getLine(timeNums[j], 5)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
						}	

						printSpaceNoNum(j);

						// print dots in the middle of time notation
						if (j == 1) {
							printDots();
							printSpaceNoNum(j);
						}
					
					// horizontal parts of digits				
					} else {
						
						// left part of digit
						System.out.print(" ");
						
						// middle part of digit
						for (int k = 0; k < size; k++) {
							if (i == 0) {
								if (Numbers.getLine(timeNums[j], 0)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							} else if (i == 2) {
								if (Numbers.getLine(timeNums[j], 3)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							} else {
								if (Numbers.getLine(timeNums[j], 6)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							}
						}
						
						// right part of digit
						System.out.print(" ");
						
						printSpaceNoNum(j);
						
						if (j == 1) {
							printSpaces();
							printSpaceNoNum(j);
						}
					}
				}
				
				System.out.println();
				printedLines++;
			}
		}
	}
	
	// printDots
	private void printDots() {
		for (int i = 0; i < size; i++) {
			System.out.print("-");
		}
	}
	
	private void printSpaces() {
		for (int i = 0; i < size; i++) {
			System.out.print(" ");
		}
	}
	
	// print space after digit, not if last digit is printed
	private void printSpaceNoNum(int index) {
		if (index != 3) {
			System.out.print(" ");
		}
	}
}
