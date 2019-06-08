package com.mycompany.a1;

public class Missile extends MoveableObject {
	/*
	 * Field variables
	 */
	private int fuelLevel;
	private Ship owner;
	
	/*
	 * Constructor 1: Default
	 */
	public Missile(Ship owner) {
		this.owner = owner;
		
	}
	
	/*
	 * 	Getter and Setter Methods
	 */
	public void setDirection(double direction) {
		 //TODO
	}
	
	public void setSpeed(int speed) {
		
	}
	
	public int getFuel() {
		return this.fuelLevel;
	}
	
	/*
	 * 	Function methods
	 */
	public void decrementFuel() {
		this.fuelLevel--;
	}
	
	public Ship getOwner() {
		return this.owner;
	}
	
	public String toString() {
		//TODO: return a string with object location, fuel leve, and owner
		return null;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
