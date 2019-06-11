package com.mycompany.a1;

import java.util.Random;

public abstract class FixedObject extends GameObject {
	private int id;
	private static int idHelper;
	private Random random = new Random();
	
	/*
	 * 	Constructor1 : Default
	 */
	public FixedObject() {
		
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
		This method helps in creating a new ID of the FixedObject
	 */
	public static int getNewID() {
		//TODO: return a new ID from the previous id
		return 0;
	}
	
}
