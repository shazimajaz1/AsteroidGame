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
				switch(command.charAt(0)) {
					case 'a': //Add a new Asteroid
						gw.addAsteroid();
						break;
					case 'y': //Add a new NPS
						gw.addNPS();
						break;
					case 'b': //Add a new blinking space station to the world
						gw.addSpaceStation();
						break;
					case 's': //Add a new PS to the world
						gw.addPS();
						break;
					case 'f' : //Fire a missile out of the PS
						gw.psFireMissile();
						break;
					case 'L' : //Fire a missile from NPS
						gw.npsFireMissile();
						break;
					case 'm' : //Print a map/toString of the Game World
						gw.printMap();
						break;
					case 'p': //Print the status of all the objects in the game world
						System.out.println("Status of all objects");
						System.out.println(gw.toString());
						System.out.println();
						break;
					case '>': //Turn the missile launcher clockwise
						gw.turnPSMLRight();
						break;
					case '<': //Turn the missile launcher counter clockwise
						gw.turnPSMLLeft();
						break;
				}
				
			}
			
		});
		
	}
	
	
	private void quit() {
		
	}
}
