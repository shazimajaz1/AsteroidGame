package com.mycompany.a1;

public class SpaceStation extends FixedObject {
	/*
		Field variables and state
	 */
	private int blinkRate;
	private boolean isBlinking;

	/*
		Constructor 1: default
	 */
	public SpaceStation() {
		blinkRate = 6;
		isBlinking = true;
	}

	/*
		This method returns the blink rate of the station.
	 */
	public int getBlinkRate() {
		return this.blinkRate;
	}

	/*
		This method sets the blink rate of the station to a random number.
	 */
	public void toggleBlink() {
		blinkRate = super.getRandom(3,12);
	}
	

	/*
		This method returns a string representation of the state of Space Station object.
	 */
	public String toString() {
		return "Space Station: \n" + "Blink Rate: " + blinkRate +" | Blinking: "+ isBlinking; 
	}
}
