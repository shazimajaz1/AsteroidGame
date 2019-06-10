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

    private void asteroidHitNPS() {
        System.out.println("An asteroid has collided with an NPS. Both have been removed!");
        gw.removeAsteroid();
        gw.removeNPS();
    }

    private void asteroidHitAsteroid() {
        System.out.println("Two Asteroids have collided each other and have been removed!");
        gw.removeAsteroid();
        gw.removeAsteroid();
    }


    private void psHitNPS() {
        System.out.println("You crashed into another ship. Watch out next time!");
        gw.removeNPS();
        gw.destroyPS();
    }

    private void psCrashedIntoAnAsteroid() {
        //Remove the ship if there are lives left
        System.out.println("You crashed into an Asteroid. Watch out next time!");
        gw.destroyPS();
        gw.removeAsteroid();
    }

    private void addAsteroid() {
        gw.addAsteroid();
    }

    private void addNPS() {
        gw.addNPS();

    }

    private void addSpaceStation() {
        gw.addSpaceStation();
    }

    private void addPS() {
        gw.addPS();
    }

    private void psFireMissile() {
        gw.psFireMissile();
    }

    private void npsFireMissile() {
        gw.npsFireMissile();

    }

    private void printMap() {
        gw.printMap();
    }

    private void printStatus() {
        //Print the status of all the objects in the game world
        System.out.println("Status of all objects");
        System.out.println(gw.toString());
        System.out.println();

    }

    private void turnPSMLRight() {
        gw.turnPSMLRight();

    }

    private void turnPSMLLeft() {
        gw.turnPSMLLeft();

    }

    private void refillMissiles() {
        gw.resetMissileCount();
    }


    private void psMissileKilledAsteroid() {
        // PS missile killed and Asteroid
        gw.psFireMissile();
        gw.removeAsteroid();
        gw.incrementScore(10);

    }

    private void psMissileKilledNPS() {
        gw.psFireMissile();
        gw.removeNPS();
        gw.incrementScore(20);
    }

    private void npsMissileKilledPS() {
        gw.destroyPS();
        gw.destroyNPSMissile();
    }


    private void quit() {

    }
}
