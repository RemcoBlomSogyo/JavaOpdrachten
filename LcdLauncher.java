/*
	LcdLauncher.java
	
	Made by Remco Blom
*/

public class LcdLauncher {
	
	public static void main(String[] args) {

		Lcd lcd = new Lcd();
		if (args.length == 2) {
			if (args[0].equals("-s") && args[1] != null) {
				int size = Integer.parseInt(args[1]);
				if (size >= 1 && size <= 5) {
					lcd.start(size);
				} else {
					lcd.start(2);
				}
			} else {
				lcd.start(2);
			}
		} else {
			lcd.start(2);
		}
	}
}

