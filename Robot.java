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
	
	public static void main(String[] args) {
		Robot robin = new Robot(2, 4, "south");
		Robot blitzCrank = new Robot(1, 2, "west");
		System.out.println("Robin: (" + robin.getPosX() + "," 
			+ robin.getPosY() + "), " + robin.getFacing());
		System.out.println("Blitzcrank: (" + blitzCrank.getPosX() + "," 
			+ blitzCrank.getPosY() + "), " + blitzCrank.getFacing());
	}
}