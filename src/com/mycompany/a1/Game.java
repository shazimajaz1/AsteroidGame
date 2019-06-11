package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;


public class Game extends Form {
    private GameWorld gw;

    public Game() {
        gw = new GameWorld();
        gw.init();
        play();

    }

    private void play() {
        //Create a new Text Bar
        Form main = new Form("Asteroid Game Controller", BoxLayout.y());
        final TextField textField = new TextField();
        main.add(textField);
        main.show();

        //Create Action Listeners
        textField.addActionListener(new ActionListener() {
            //
            @Override
            public void actionPerformed(ActionEvent evt) {
                String command = textField.getText().toString();
                textField.clear();
                if (command.length() != 0) {
                    switch (command.charAt(0)) {
                        case 'a':
                            addAsteroid();
                            break; //Add asteroid
                        case 'y':
                            addNPS();
                            break; //Add NPS
                        case 'b':
                            addSpaceStation();
                            break; //Add a new space station
                        case 's':
                            addPS();
                            break; //Add a new PS
                        case 'f':
                            psFireMissile();
                            break;
                        case 'L':
                            npsFireMissile();
                            break;
                        case 'm':
                            printMap();
                            break;
                        case 'p':
                            printStatus();
                            break;
                        case '>':
                            turnPSMLRight();
                            break;
                        case '<':
                            turnPSMLLeft();
                            break;
                        case 'n':
                            refillMissiles();
                            break;
                        case 'k':
                            psMissileKilledAsteroid();
                            break;
                        case 'e':
                            psMissileKilledNPS();
                            break;
                        case 'E':
                            npsMissileKilledPS();
                            break;
                        case 'c':
                            psCrashedIntoAnAsteroid();
                            break;
                        case 'h':
                            psHitNPS();
                            break;
                        case 'x':
                            asteroidHitAsteroid();
                            break;
                        case 'I':
                            asteroidHitNPS();
                            break;
                    }

                }
            }

        });

    }

    /*
        This method is invoked when asteroid hits a non player ship
     */
    private void asteroidHitNPS() {
        System.out.println("An asteroid has collided with an NPS. Both have been removed!");
        gw.removeAsteroid();
        gw.removeNPS();
    }

    /*
        This method is invoked when the asteroid hits another asteroid
     */
    private void asteroidHitAsteroid() {
        System.out.println("Two Asteroids have collided each other and have been removed!");
        gw.removeAsteroid();
        gw.removeAsteroid();
    }


    /*
        This method is invoked when the Player ship hits a non Player ship
     */
    private void psHitNPS() {
        System.out.println("You crashed into another ship. Watch out next time!");
        gw.removeNPS();
        gw.destroyPS();
    }

    /*
        This method is invoked when the Player Ship crashes into an astroid.
     */
    private void psCrashedIntoAnAsteroid() {
        //Remove the ship if there are lives left
        System.out.println("You crashed into an Asteroid. Watch out next time!");
        gw.destroyPS();
        gw.removeAsteroid();
    }

    /*
        This method adds a new asteroid int the gameworld
     */
    private void addAsteroid() {
        gw.addAsteroid();
    }

    /*
        This method adds a new non player ship
     */
    private void addNPS() {
        gw.addNPS();

    }

    /*
        This method adds a new space station to the gameworld.
     */
    private void addSpaceStation() {
        gw.addSpaceStation();
    }

    /*
        This method adds a player ship to the Game World.
     */
    private void addPS() {
        gw.addPS();
    }

    /*
        This method fire missiles out of the player ship
     */
    private void psFireMissile() {
        gw.psFireMissile();
    }

    /*
        This method fires missiles out of the non player ship
     */
    private void npsFireMissile() {
        gw.npsFireMissile();

    }

    /*
        This methid prints the map of the game world objects
     */
    private void printMap() {
        gw.printMap();
    }

    /*
        This method prints the status of the objects in the game world
     */
    private void printStatus() {
        //Print the status of all the objects in the game world
        System.out.println("Status of all objects");
        System.out.println(gw.toString());
        System.out.println();

    }

    /*
        This method turns player ship missile launcher to the right
     */
    private void turnPSMLRight() {
        gw.turnPSMLRight();

    }

    /*
       This method turns player ship missile launcher to the left
    */
    private void turnPSMLLeft() {
        gw.turnPSMLLeft();

    }

    /*
        This method refills missiles for player ship
     */
    private void refillMissiles() {
        gw.resetMissileCount();
    }

    /*
        This method is involed when PS Missile kills an Asteroid. Asteroid is removed.
    */
    private void psMissileKilledAsteroid() {
        // PS missile killed and Asteroid
        gw.psFireMissile();
        gw.removeAsteroid();
        gw.incrementScore(10);

    }

    /*
        This method is involved when PS Missile kills a NPS.
     */
    private void psMissileKilledNPS() {
        gw.psFireMissile();
        gw.removeNPS();
        gw.incrementScore(20);
    }

    /*
        This method is involved when NPS Missile kills PS
     */
    private void npsMissileKilledPS() {
        gw.destroyPS();
        gw.destroyNPSMissile();
    }

    /*
        This method closes the game.
     */
    private void quit() {

    }
}
