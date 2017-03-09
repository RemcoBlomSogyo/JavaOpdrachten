/*
	Robot.java
	
	Made by Remco Blom
*/

public class Robot {
	private int posX = 0;
	private int posY = 0;
	private String facing = "north";
	
	Robot(int x, int y, String face) {
		posX = x;
		posY = y;
		facing = face;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int x) {
		posX = x;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int y) {
		posY = y;
	}
	
	public String getFacing() {
		return facing;
	}
	
	public void setFacing(String face) {
		facing = face;
	}
	
	public void printState() {
		System.out.println("(" + getPosX() + "," 
			+ getPosY() + "), " + getFacing());
	}
	
	public void turnLeft() {
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
	
	public void turnRight() {
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
	
	public static void main(String[] args) {
		Robot robin = new Robot(2, 4, "south");
		Robot blitzCrank = new Robot(1, 2, "west");
		robin.turnRight();
		blitzCrank.turnLeft();
		System.out.print("Robin: ");
		robin.printState();
		System.out.print("Blitzcrank: ");
		blitzCrank.printState();
	}
}