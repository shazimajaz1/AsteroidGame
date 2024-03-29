package com.mycompany.a1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
	/*
	 * 	Field variables
	 */
	private ArrayList<GameObject> store;
	private int livesLeft;
	private int missilesLeft;
	private int score;
	private int windowHeight = 768;
	private final int windowWidth = 1024;
	private Random random = new Random();
	private boolean hasPlayerShip;

	/*
	 * 	Constructor 1: default
	 */
	public GameWorld() {
		store = new ArrayList<GameObject>();
		missilesLeft = 10;
		livesLeft = 5; //Initial Lives
	}

	/*
	 * Helper Methods
	 */
	public void init() {

	}

	/*
	 * This method returns the number of objects in the game world.
	 */
	public int getNumberOfObjects() {
		return this.store.size();
	}

	/*
	 * Returns the current score of the player
	 */
	public ArrayList<GameObject> getStore() {
		return this.store;
	}

	/*
	 * Add a new Game object to the game world.
	 */
	public void store(GameObject go) {
		store.add(go);
	}

	/*
	 * 	Returns the current score of the playership
	 */
	public int getScore() {
		return this.score;
	}

	/*
	 * 	Resets the score value to 0
	 */
	public void resetScore() {
		this.score = 0;
	}

	/*
	 * Increments the score by the given factor
	 */
	public void incrementScore(int incFactor) {

		this.score += incFactor;
		System.out.println("The Player Ship score: " + this.score);
	}

	/*
	 * Decrements the score by the given factor
	 */
	public void decrementScore(int decFactor) {
		this.score -= decFactor;
	}

	/*
	 * Returns the height of the current GameWorld window
	 */
	public int getWindowHeight() {
		return this.windowHeight;
	}

	/*
	 * Returns the width of the current GameWorld window
	 */
	public int getWindowWidth() {
		return this.windowWidth;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		//Generate a new String and return the value
		return "Lives Left: " + this.livesLeft + " | Missiles Left: " + this.missilesLeft +
				" | Score: " + this.score + " | Has Player Ship: " + this.hasPlayerShip;
	}

	/*
	 *  This method adds a player ship and only adds the player ship if there is no playership already
	 */
	public void addPS() {
		boolean found = false;
		int index = 0;
		while(index < store.size()){
			GameObject go = store.get(index);
			index++;

			if(go instanceof PS){
				found = true;
			}
		}
		if(!found) {
			//Add a new PS here
			PS ps = PS.getPS();
			store.add(ps);
			System.out.println(ps.toString());
			this.hasPlayerShip = true;
		} else {
			System.out.println("There is already a player ship in the game");
		}
	}

	/*
	 * This method adds a new non player ship
	 */
	public void addNPS() {
		//Add NPS Here
		NPS nps = new NPS();
		store.add(nps);
		System.out.println(nps.toString());
	}

	/*
	 * Adds a new asteroid to the GameWorld
	 */
	public void addAsteroid() {
		//Add Asteroid here
		Asteroid asteroid = new Asteroid();
		store.add(asteroid);
		System.out.println(asteroid.toString());
	}

	/*
	 * Makes the player ship turn left.
	 */
	public void psLT() {
		//Get the player ship object from the list

		//Turn the ship left
	}

	/*
	 * Makes the player ship turn right
	 */
	public void psRT() {
		//Get the player ship object from the list

		//Make the ship turn right.
	}

	public void destroyPS() {
		//Find the player ship
		if(livesLeft > 0){
			livesLeft--;
			System.out.println("Your ship lost one live. Number of lives left: " + this.livesLeft);

		} else {
			//Find the PS
			//Destroy NPS missile here
			int index = 0;
			while (index < store.size()) {
				GameObject gameObject = store.get(index);
				if (gameObject instanceof PS) {
					store.remove(index);
					System.out.println("The PS was destroyed!");
					printMap();
					break;
				}
				index++;
			}
		}



	}

	public void addPSMissileLauncher() {
		//Add missile launcher for PS
	}

	public void addNPSMissileLauncher() {
		//Add missile launcher for NPS here

	}


	/*
	 * This method fires the PS Missile when called
	 */
	public void psFireMissile() {
		if(missilesLeft > 0) {
			//Fire PS Missile here
			int index = 0;
			while (index < store.size()) {
				GameObject gameObject = store.get(index);
				if (gameObject instanceof PS) {
					PS ps = (PS) gameObject;
					ps.fireMissile();
					missilesLeft--;
					Missile missile = new Missile(ps);
					store.add(missile);
					System.out.println("A missile from Player Ship has been fired!");
				}
				index++;

			}
		} else {
			System.out.println();
			System.out.print("You are out of missiles! Go to the space station to refill!");
		}

	}

	public void destoryPSMissile() {
		//Destroy PS missile here

	}

	/*
	 * This method fires the NPS Missile when called
	 */
	public void npsFireMissile() {
		//File NPS Missile Here
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof NPS) {
				((NPS) gameObject).fireMissile();
				store.add(new Missile((NPS) gameObject));

			}
			index++;
		}

	}

	public void destroyNPSMissile() {
		//Destroy NPS missile here
		npsFireMissile();
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof Missile) {
				if((((Missile) gameObject).getOwner()) instanceof  NPS) {
					store.remove(index);
					System.out.println("The NPS Missile was destroyed!");
					printMap();
					break;
				}
			}
			index++;
		}

	}

	/*
	 * 	Add the space station
	 */
	public void addSpaceStation() {
		//Add space station here
		SpaceStation spaceStation = new SpaceStation();
		store.add(spaceStation);
		System.out.println(spaceStation.toString());
	}

	/*
	 * This method prints the map of the objects inside the GameWorld
	 */
	public void printMap() {
		System.out.println("***************************************Game World***********************************");
		if (store.size() > 0) {
			int index = 0;
			while (index < store.size()) {
				System.out.println(store.get(index).toString());
				System.out.println();
				index++;
			}
		}
		System.out.println("************************************************************************************");
	}

	/*
		This method turns the PS Missile Launcher Left when called
	 */
	public void turnPSMLLeft() {
		//Find the PSML here
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof PS) {
				PS launcher = (PS) gameObject;
				launcher.turnMLLeft();
				System.out.println(launcher.getLauncher().toString());
			}
			index++;
		}
	}

	/*
		This method turns the PS Missile Launcher Right when called
	 */
	public void turnPSMLRight() {
		//Find the PSML here
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof PS) {
				PS launcher = (PS) gameObject;
				launcher.turnMLRight();
				System.out.println(launcher.getLauncher().toString());
			}
			index++;
		}


	}

	/*
		Resets Missile Count on the PS Missile Launcher
	 */
	public void resetMissileCount() {
		//Find the PSML here
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof PS) {
				PS launcher = (PS) gameObject;
				launcher.resetMissileCount();
				System.out.println(launcher.toString());
			}
			index++;
		}

	}

	/*
		Find and remove asteroid
	 */
	public void removeAsteroid() {
		//Find the asteroid location
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof Asteroid) {
				store.remove(index);
				System.out.println("The Asteroid was destroyed!");
				printMap();
				break;
			}
			index++;
		}
	}

	/*
		Find and remove NPS
	 */
	public void removeNPS() {
		int index = 0;
		while (index < store.size()) {
			GameObject gameObject = store.get(index);
			if (gameObject instanceof NPS) {
				store.remove(index);
				System.out.println("The NPS was destroyed!");
				printMap();
				break;
			}
			index++;
		}
	}


}
