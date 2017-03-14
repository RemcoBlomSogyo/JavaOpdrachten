/*
	LcdLauncher.java
	
	Made by Remco Blom
*/

public class LcdLauncher {
	
	private Lcd lcd = new Lcd();
	private int size = 2;
	private int timeNotation = -24;
	private String[] copyArgs;
	
	public static void main(String[] args) {
		LcdLauncher launcher = new LcdLauncher();
		launcher.copyArgs = args;
		launcher.checkArgs();
	}
	
	private void checkArgs() {
		if (copyArgs.length == 1) {
			try {
				setTimeNot(Integer.parseInt(copyArgs[0]));
			} catch (NumberFormatException e) {}
			
		} else if (copyArgs.length == 2 && copyArgs[0].equals("-s")) {
			try {
				setSize(Integer.parseInt(copyArgs[1]));
			} catch (NumberFormatException e) {}

		} else if (copyArgs.length == 3) {
			if (copyArgs[0].equals("-s")) {
				try {
					setSize(Integer.parseInt(copyArgs[1]));
				} catch (NumberFormatException e) {}
				
				try {
					setTimeNot(Integer.parseInt(copyArgs[2]));
				} catch (NumberFormatException e) {}
				
			} else if (copyArgs[1].equals("-s")) {
				try {
					setSize(Integer.parseInt(copyArgs[2]));
				} catch (NumberFormatException e) {}
				
				try {
					setTimeNot(Integer.parseInt(copyArgs[0]));
				} catch (NumberFormatException e) {}
			}
		}
				
		if (timeNotation == -12) {
			lcd.start(size, true);
		} else {
			lcd.start(size, false);
		}
	}
	
	private void setSize(int newSize) {
		if (newSize >= 1 && newSize <= 5) {
			size = newSize;
		}
	}
	
	private void setTimeNot(int newTimeNot) {
		if (newTimeNot == -12) {
			timeNotation = newTimeNot;
		}
	}
}

