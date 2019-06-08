package com.mycompany.a1;

public class NPS extends Ship {
	/*
	 * Field variables for NPS
	 */
	private MissileLauncher missileLauncher;
	private int size; 
	
	/*
	 * Constructor 1: Default Constructor
	 */
	public NPS() {
		missileLauncher = new MissileLauncher(super.getDirection(), super.getX(), super.getY(), super.getMissileCount());
		size = super.getRandom(15, 25);
	}
	
	/*
	 * Constructor 2: Default Constructor
	 */
	public int getSize() {
		return size;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a1.MoveableObject#toString()
	 */
	public String toString() {
		String parentDesc = super.toString();
		String thisDes = " |" + " Size: " + size;
		return "Non Player Ship \n" + parentDesc + thisDes;
	}
	
	/*
	 * Returns the direction of the NPS
	 */
	public double getDirecton() {
		return this.getDirecton(); 
	}
	
	/*
	 * This method returns the speed of the NPS
	 */
	public int getSpeed() {
		return this.getSpeed();
	}
	
	/*
	 * This method allows us to change the direction of the NPS
	 */
	public void setDirection(int direction) {
		if(direction >= 0 && direction <= 359) {
			this.setDirection(direction);
		} else {
			throw new IllegalArgumentException("The direction must be betweenn 0 and 359");
		}
		
	}
	
	/*
	 * This method allows us to change the speed of the NPS
	 */
	public void setSpeed(int newSpeed) {
		if(newSpeed <= 20 && newSpeed >= 0) {
			this.setSpeed(newSpeed);
		} else {
			throw new IllegalArgumentException("The speed must be between 0 and 20");
		}
	}

	/*
	 * This method adds move functionality to the NPS
	 */
	@Override
	public void move() {
		// Implement move functionality
		double deltaX = Math.cos(super.getDirection()) * super.getSpeed();
		double deltaY = Math.sin(super.getDirection()) * super.getSpeed();
		
		//Move the Non player ship by the given change factor
		super.setX(super.getX() + deltaX);
		super.setY(super.getY() + deltaY);
	}
	
	
}
