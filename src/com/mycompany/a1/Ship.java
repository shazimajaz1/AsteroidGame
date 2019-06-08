package com.mycompany.a1;

public abstract class Ship extends MoveableObject{
	/*
	 * 	Field variables
	 */
	private int missileCount;
	
	/*
	 * Constructor 1: Default
	 */
	public Ship() {
		this.missileCount = 10;
	}
	
	/*
	 * 	Getter and Setter Methods
	 */
	public int getMissileCount() {
		return this.missileCount;
	}
	
	public void setMissileCount(int newMissileCount) {
		this.missileCount = newMissileCount;
	}
	
	/*
	 * 	Functional Methods
	 */
	public void decMissiles() {
		this.missileCount--;
	}
	
	/*
	 * 	This method resets the missile count
	 */
	public void resetMissileCount() {
		this.missileCount = 10;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a1.MoveableObject#toString()
	 */
	public String toString() {
		//Get parent toString
		String parentDesc = super.toString();
		String myDesc = " | Missile Count: " + this.missileCount;
		
		return parentDesc + myDesc;
	}
	/*
	 * This method fires the missile when called
	 */
		public void fireMissile() {
			//Create a new Missile
			
			//Fire the Missile
			
			//Reduce the missile count
			this.decMissiles();
			System.out.println(toString());
			
		}

}
