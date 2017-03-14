/*
	Lcd.java
	
	Made by Remco Blom
*/

import java.time.LocalTime;
import java.util.ArrayList;

public class Lcd {
	
	private ArrayList<Integer> timeNums = new ArrayList<Integer>();
	private int size = 1;
	private boolean amPm = false;
	private final boolean[] lineIsVert = {false, true, false, true, false};
	
	public void start(int newSize, boolean newAmPm) {
		size = newSize;
		amPm = newAmPm;
		getCurTime();
		printLines();
	}
	
	private void getCurTime() {
		LocalTime time = LocalTime.now();
		if (amPm) {
			if (time.getHour() < 12) {
				timeNums.add(-2);
			} else {
				timeNums.add(-1);
			}
		}
		timeNums.add(time.getHour() / 10);
		timeNums.add(time.getHour() % 10);
		timeNums.add(time.getMinute() / 10);
		timeNums.add(time.getMinute() % 10);
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
				for (int j = 0; j < timeNums.size(); j++) {
					
					// vertical parts of digit
					if (lineIsVert[i]) {
						
						// upper vertical part of digit
						if (i == 1) {
							
							// left part of digit
							if (Numbers.getLine(timeNums.get(j), 1)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
							// middle part of digit
							printSpaces();
							
							// right part of digit
							if (Numbers.getLine(timeNums.get(j), 2)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
						// under vertical part of digit
						} else {
							
							// left part of digit
							if (Numbers.getLine(timeNums.get(j), 4)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
							
							// middle part of digit
							printSpaces();
							
							// right part of digit
							if (Numbers.getLine(timeNums.get(j), 5)) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
						}	

						printSpaceNoNum(j);

						// print dots in the middle of time notation
						if ((!amPm && j == 1) || (amPm && j == 2)) {
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
								if (Numbers.getLine(timeNums.get(j), 0)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							} else if (i == 2) {
								if (Numbers.getLine(timeNums.get(j), 3)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							} else {
								if (Numbers.getLine(timeNums.get(j), 6)) {
									System.out.print("-");
								} else {
									System.out.print(" ");
								}
							}
						}
						
						// right part of digit
						System.out.print(" ");
						
						printSpaceNoNum(j);
						
						if ((!amPm && j == 1) || (amPm && j == 2)) {
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
	
	// print dots between the second and third digit
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
