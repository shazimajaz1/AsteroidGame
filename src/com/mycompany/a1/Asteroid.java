package com.mycompany.a1;

public class Asteroid extends MoveableObject {
	/*
	 * 	Field Variables
	 */
	private int size;
	
	/*
	 * Constructor 1: Default
	 */
	public Asteroid() {
		super();
		//Randomize the size
		this.size = this.getRandom(6, 30);
	}
	
	/*
	 * 	Getter 1: Returns the size
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * Setter 1: Set the size of the Asteroid
	 */
	public  void setSize(int size) {
		if(size >= 6 && size <= 30) {
			this.size = size;
		} else {
			throw new IllegalArgumentException("Size should be between 6 and 30");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a1.GameWorld#toString()
	 */
	public String toString() {
		//Get parent description
		String descParent = super.toString();
		
		//Get current description
		String myDesc = "Size: " + size;
		
		//Return both
		return "Asteroid: " +  descParent + " " + myDesc;
	}

	/*
	 * This method checks that the value of x is inside the window
	 */
	public void setX(int x) {
		if(x < 1024 && x >= 0) {
			this.setX(x); 
		}
		else {
			throw new IllegalArgumentException("The object should not be outside the GameWorld.");
		}
		
	}
	/*
	 * This method checks if the value of y is inside the window
	 */
	public void setY(int y) {
		if(y < 768 && y >= 0) {
			this.setY(y); 
		}
		else {
			throw new IllegalArgumentException("The object should not be outside the GameWorld.");
		}
		
	}

	/*
	 * This method when called, moves the asteroid.
	 */
	@Override
	public void move() {
		//Determine the moving factor
		double deltaX = Math.cos(super.getDirection());
		double deltaY = Math.sin(super.getDirection());
		
		//Set the new Direction
		int newX =(int) super.getX();
		int newY =(int) super.getY();
		super.setX(newX); super.setY(newY);
		
	}
}
