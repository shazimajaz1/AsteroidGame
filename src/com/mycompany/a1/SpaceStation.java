package com.mycompany.a1;

public class SpaceStation extends FixedObject {
	private int blinkRate;
	private boolean isBlinking;
	
	public SpaceStation() {
		blinkRate = 6;
		isBlinking = true;
	}
	
	public int getBlinkRate() {
		return this.blinkRate;
	}
	
	public void toggleBlink() {
		blinkRate = super.getRandom(3,12);
	}
	
	
	public String toString() {
		return "Space Station: \n" + "Blink Rate: " + blinkRate +" | Blinking: "+ isBlinking; 
	}
}
