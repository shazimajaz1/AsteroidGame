package com.mycompany.a1;

public class MissileLauncher extends MoveableObject {
	/*
	 * 	Field variables and class constants
	 */
	private int missileCount;
	
	/*
	 * 	Constructor 1: Default constructor
	 */
	public MissileLauncher(int direction, double x, double y, int missileCount) {
		super(direction, x, y);
		this.missileCount = missileCount;
		
	}
	
	public MissileLauncher() {
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
