/*
	Robot.java
	
	Made by Remco Blom
*/

import java.util.ArrayList;

public class Robot {
	private int posX = 0;
	private int posY = 0;
	private String facing = "north";
	private ArrayList<String> commands = new ArrayList<String>();
	
	Robot(int x, int y, String face) {
		posX = x;
		posY = y;
		facing = face;
	}
	
	// getters and setters
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int newPosX) {
		posX = newPosX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int newPosY) {
		posY = newPosY;
	}
	
	public String getFacing() {
		return facing;
	}
	
	public void setFacing(String newFacing) {
		facing = newFacing;
	}
	
	public ArrayList<String> getCommands() {
		return commands;
	}
	
	public void setCommands(ArrayList<String> newCommands) {
		commands = newCommands;
	}
	
	public void printState() {
		System.out.println("(" + getPosX() + "," 
			+ getPosY() + "), " + getFacing());
	}
	
	// methods to fill the command list
	public void goLeft() {
		getCommands().add("left");
	}
	
	public void goRight() {
		getCommands().add("right");
	}
	
	public void goForward(int speed) {
		getCommands().add("forward" + speed);
	}
	
	public void goBackward() {
		getCommands().add("backward");
	}
	
	public void execute() {
		ArrayList<String> robotCommands = getCommands();
		for (String command : robotCommands) {
			if (command.equals("left")) {
				turnLeft();
			} else if (command.equals("right")) {
				turnRight();
			} else if (command.substring(0,7).equals("forward")) {
				forward(Integer.parseInt(command.substring(7)));
			} else {
				backward();
			}
		}
	}
	
	// action methods that execute method calls
	private void turnLeft() {
		if (getFacing().equals("north")) {
			setFacing("west");
		} else if (getFacing().equals("east")) {
			setFacing("north");
		} else if (getFacing().equals("south")) {
			setFacing("east");
		} else {
			setFacing("south");
		}
	}
	
	private void turnRight() {
		if (getFacing().equals("north")) {
			setFacing("east");
		} else if (getFacing().equals("east")) {
			setFacing("south");
		} else if (getFacing().equals("south")) {
			setFacing("west");
		} else {
			setFacing("north");
		}
	}
	
	private void forward() {
		forward(1);
	}
	
	private void forward(int speed) {
		if (speed >= 1 && speed <= 3) {
			if (getFacing().equals("north")) {
				setPosY(getPosY() + speed);
			} else if (getFacing().equals("east")) {
				setPosX(getPosX() + speed);
			} else if (getFacing().equals("south")) {
				setPosY(getPosY() - speed);
			} else {
				setPosX(getPosX() - speed);
			}
		}
	}
	
	private void backward() {
		if (getFacing().equals("north")) {
			setPosY(getPosY() - 1);
		} else if (getFacing().equals("east")) {
			setPosX(getPosX() - 1);
		} else if (getFacing().equals("south")) {
			setPosY(getPosY() + 1);
		} else {
			setPosX(getPosX() + 1);
		}
	}
	
	// main method that calls actions from other methods
	public static void main(String[] args) {
		Robot robin = new Robot(2, 4, "south");
		Robot blitzCrank = new Robot(1, 2, "west");
		robin.goRight();
		robin.goForward(3);
		robin.execute();
		blitzCrank.goLeft();
		blitzCrank.goBackward();
		blitzCrank.execute();
		System.out.print("Robin: ");
		robin.printState();
		System.out.print("Blitzcrank: ");
		blitzCrank.printState();
	}
}