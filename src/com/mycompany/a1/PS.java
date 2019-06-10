package com.mycompany.a1;

public class PS extends Ship implements Steerable{

	/*
		Member variables and class constants
	 */
	private SteerableMissileLauncher missileLauncher;
	private static PS currentShip;

	/*
	 * Constructor 1: Default
	 */
	private PS() {
		super.setX(512);
		super.setY(384);
		super.resetMissileCount();
		super.setSpeed(0);
		super.setDirection(90);
		missileLauncher = new SteerableMissileLauncher();
	}

	/*
		This method returns the current ship
	 */
	public static PS getPS(){
		if(currentShip != null){
			return currentShip;
		} else {
			currentShip = new PS();
			return currentShip;
		}

	}
	/*
	 *Constructor 2 
	 */
	public PS(double x, double y, int speed, int direction, int missileCount) {
		super.setX(x);
		super.setY(y);
		super.resetMissileCount();
		super.setSpeed(speed);
		super.setDirection(direction);
		missileLauncher = new SteerableMissileLauncher();
		
	}
	
	public void turnLeft() {
		int direction = super.getDirection();
		direction--;
		super.setDirection(direction);
	} 
	public void turnRight() {
		int direction = super.getDirection();
		direction++;
		super.setDirection(direction);
	}
	public String toString() {
		String parentDesc = super.toString();
		return "Player Ship \n" + parentDesc;
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
	}

	public void turnMLLeft(){
		missileLauncher.turnLeft();
	}

	public void turnMLRight(){
		missileLauncher.turnRight();
	}

	public SteerableMissileLauncher getLauncher() {
		return this.missileLauncher;
	}
	
	
	}

