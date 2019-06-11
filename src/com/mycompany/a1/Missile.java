package com.mycompany.a1;

public class Missile extends MoveableObject {
    /*
     * Field variables
     */
    private int fuelLevel;
    private Ship owner;

    /*
     * Constructor 1: Default
     */
    public Missile(Ship owner) {
        super();
        this.fuelLevel = 10;
        this.owner = owner;

    }


    /*
     * 	Function methods
     */

    public Ship getOwner() {

        return this.owner;
    }

    /*
        This method returns description of the Missile Object
     */
    public String toString() {
        //TODO: return a string with object location, fuel leve, and owner
        return "Missile \n" + "Fuel Level: " + fuelLevel;
    }


}
