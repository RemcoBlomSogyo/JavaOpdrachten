/*
	Numbers.java
	
	Made by Remco Blom
*/

public class Numbers {
	
	public static boolean getLine(int num, int index) {
		
		/*
			Index0 = Upper Horizontal Line 
			Index1 = Upper Left Vertical Line
			Index2 = Upper Right Vertical Line
			Index3 = Middle Horizontal Line 
			Index4 = Under Left Vertical Line
			Index5 = Under Right Vertical Line
			Index6 = Under Horizontal Line 
		*/
		switch (num) {
			
			// this represents the A in AM
			case -2:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return true;
			} else {
				return false;
			} 	
			
			// this represents the P in PM
			case -1:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return false;
			} else {
				return false;
			} 	
			
			case 0: 
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return false;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 	
			
			case 1:
			
			if (index == 0) {
				return false;
			} else if (index == 1) {
				return false;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return false;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return false;
			} 	
			
			case 2:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return false;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return false;
			} else {
				return true;
			} 	
			
			case 3:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return false;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 	
			
			case 4:
			
			if (index == 0) {
				return false;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return false;
			} 	
			
			case 5:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return false;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 
			
			case 6:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return false;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 	
			
			case 7:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return false;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return false;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return false;
			} 	
			
			case 8:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 
			
			case 9:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return true;
			} else if (index == 4) {
				return false;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 	
			
			default:
			
			if (index == 0) {
				return true;
			} else if (index == 1) {
				return true;
			} else if (index == 2) {
				return true;
			} else if (index == 3) {
				return false;
			} else if (index == 4) {
				return true;
			} else if (index == 5) {
				return true;
			} else {
				return true;
			} 
		}
	}
}