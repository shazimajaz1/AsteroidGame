package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public abstract class GameObject{
	private double x;
	private double y;
	private int color;
	private Random random = new Random();
	
	/*
	 * Constructor #1. Default.
	 */
	public GameObject() {
		this.color = ColorUtil.LTGRAY;
		setupLocation();
		
	}
	/*
	 *  Constructor #2. Allows other colors to be chosen.
	 */
	public GameObject(int color) {
		this.color = color;
		setupLocation();
	}
	
	private void setupLocation() {
		this.x = random.nextInt(1023);
		this.y = random.nextInt(767);
	}
	
	/*
	 * Getter methods.
	 */
	public double getX() {
		return x;
		
	}
	public double getY() {
		return y;
		
	}
	public String getColor() {
		return String.valueOf(color);
	}
	
	
	
	
	/*
	 * Setter methods.
	 */
	public void setX(double x) {
		this.x = x;
		
	}
	public void setY(double y) {
		this.y = y;
		
	}
	public void setColor(int color) {
		this.color = color; 
	}
	/*
	 * Sets location of the object. 
	 */
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "Location: (" + x + ", " + y + ") " + "Color: " + this.color;
	}
}
