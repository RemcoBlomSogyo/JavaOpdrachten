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
	
	public void forward() {
		forward(1);
	}
	
	public void forward(int speed) {
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
	
	public void backward() {
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
	
	public static void main(String[] args) {
		Robot robin = new Robot(2, 4, "south");
		Robot blitzCrank = new Robot(1, 2, "west");
		robin.turnRight();
		robin.forward(3);
		blitzCrank.turnLeft();
		blitzCrank.backward();
		System.out.print("Robin: ");
		robin.printState();
		System.out.print("Blitzcrank: ");
		blitzCrank.printState();
	}
}