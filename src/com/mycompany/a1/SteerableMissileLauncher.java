package com.mycompany.a1;

public class SteerableMissileLauncher extends MissileLauncher implements Steerable {

	/*
		Field variables and class constants
	 */
	private static final int TURN_FACTOR = 5; //Update this to change the turn factor with which the missile turns.

	/*
		Constructor 1: Initializes the speed and direction of the missile.
	 */
	public SteerableMissileLauncher() {
		this.setDirection(90);
		this.setSpeed(0);
	}
	/*
		This method overrides the default toString and returns the description.
	 */
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " Direction of the missile Launcher:  " +  this.getDirection() + " Turn Factor: " + TURN_FACTOR;

		return "Player Ship Missile Launcher: \n " + myDesc;
	}
	/*
		This turns the missile launcher left
	 */
	@Override
	public void turnLeft() {
		if(!(this.getDirection() + TURN_FACTOR > 180 )){
			this.setDirection(this.getDirection() + TURN_FACTOR);
		}
		
	}

	/*
		This method turns the missile launcher right.
	 */
	@Override
	public void turnRight() {
		if(!(this.getDirection() + TURN_FACTOR < 0 )){
			this.setDirection(this.getDirection() - TURN_FACTOR);
		}
		
	}
}
