package com.mycompany.a1;

import java.util.Random;
/*
 * This class creates the fields for the MoveAbleObject
 * Creates check on the speed and the direction.
 * Throws an IllegalArgumentException
 * 
 * @Editors: Shazim Ajaz, Tatiana Grama
 */
public abstract class MoveableObject extends GameObject implements Moveable {
	private int speed;
	private int direction;
	private Random random = new Random();
	
	/*
	 * 	Constructor 1: Default
	 */
	public MoveableObject() {
		this.speed = random.nextInt(20); //Max speed is 20
		this.direction = random.nextInt(359); //0 to 359
	}
	
	/*
	 * Constructor 2: user chooses x and y, and the direction of the Moveable Object
	 */
	public MoveableObject(int direction, double x, double y) {
		this.direction = direction;
		super.setX(x);
		super.setY(y);
		
	}
	
	/*
	 * 
	 */
	
	/*
	 * 	Move method must be implemented by all the child: required
	 */
	public abstract void move();
	public int getSpeed() {
		return this.speed;
		
	}
	
	/*
	 * This method checks that the speed is between 0 and 20
	 */
	public void setSpeed(int speed) {
		if(speed >= 0 && speed <= 20) {
			this.speed = speed;
		} else {
			throw new IllegalArgumentException("The speed should be between 0 - 20");
		}
	}
	
	/*
	 * Returns the direction of the MoveableObject
	 */
	public int getDirection() {
		return this.direction;
	}
	
	/*
	 * Checks that the direction is between 0 and 359
	 * @Exception: Throws IllegalArgument Exception when the direction is <= 0 and >= 359
	 */
	public void setDirection(int direction) {
		if(direction >= 0 && direction <= 359) {
			this.direction = direction;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	/*
	 * Returns a random number in a the given range x and y
	 */
	public int getRandom(int x, int y) {
		//Generate a random number between x and y
		if(y > x) {
		int number = x + random.nextInt(y);
		//Return the generated number
		return number;
		} else {
			throw new IllegalArgumentException("Illeger lower and upper range");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a1.GameWorld#toString()
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDescription = "Speed: " + this.speed + " "	+ "Direction : " + this.direction;
		return parentDesc + " " + myDescription;
	}
}
