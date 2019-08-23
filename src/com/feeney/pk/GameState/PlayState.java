package com.feeney.pk.GameState;


// The main playing GameState.
// Contains everything you need for gameplay:
// Player, TileMap, Diamonds, etc.
// Updates and draws all game objects.

import com.feeney.pk.Entity.Enemy;
import com.feeney.pk.Manager.EnemyEngine;
import com.feeney.pk.Entity.Player;
import com.feeney.pk.Manager.GameStateManager;
import com.feeney.pk.Manager.Keys;
import com.feeney.pk.Rooms.Room;

import java.awt.Graphics2D;
import java.util.*;

public class PlayState extends GameState {
	protected Room room;
	protected Player player;
	protected EnemyEngine eEng;
	protected LinkedList<Enemy> enemies = new LinkedList<Enemy>();

	
	public PlayState(GameStateManager gsm) {
		super(gsm);	
	}
	
	public void init() {

		room = new Room(gsm);
		room.loadLevel("src/com/feeney/pk/res/levels/pking.txt");

		player = new Player(gsm);
		player.setPosition(room.getSizeX()/2, room.getSizeY()/2);

		eEng = new EnemyEngine(gsm);

	}

	public void update() {

		handleInput();
		room.update();
		player.update();
		eEng.update();
		
	}
	
	public void draw(Graphics2D g) {	
		room.draw(g);
		player.draw(g);
		eEng.draw(g);
		
	}




	
	public void handleInput() {
		if (Keys.isDown(Keys.W) && Keys.isDown(Keys.D)){
			movePlayerUp(player.getSpeed()/Math.sqrt(2));
			movePlayerRight(player.getSpeed()/Math.sqrt(2));
		}
		else if (Keys.isDown(Keys.W) && Keys.isDown(Keys.A)){
			movePlayerUp(player.getSpeed()/Math.sqrt(2));
			movePlayerLeft(player.getSpeed()/Math.sqrt(2));
		}
		else if (Keys.isDown(Keys.S) && Keys.isDown(Keys.D)){
			movePlayerDown(player.getSpeed()/Math.sqrt(2));
			movePlayerRight(player.getSpeed()/Math.sqrt(2));
		}
		else if (Keys.isDown(Keys.S) && Keys.isDown(Keys.A)){
			movePlayerDown(player.getSpeed()/Math.sqrt(2));
			movePlayerLeft(player.getSpeed()/Math.sqrt(2));
		}

		else if(Keys.isDown(Keys.A)){
			movePlayerLeft(player.getSpeed());
		} 


		else if(Keys.isDown(Keys.D)){
			movePlayerRight(player.getSpeed());
		} 

	
		else if(Keys.isDown(Keys.W)){
			movePlayerUp(player.getSpeed());
			
		} 

		else if(Keys.isDown(Keys.S)){
			movePlayerDown(player.getSpeed());
		}

		if (Keys.isPressed(Keys.UP) && Keys.isPressed(Keys.RIGHT)){
			player.shootUpRight();
		}
		else if (Keys.isPressed(Keys.UP) && Keys.isPressed(Keys.LEFT)){
			player.shootUpLeft();
		}
		else if (Keys.isPressed(Keys.DOWN) && Keys.isPressed(Keys.RIGHT)){
			player.shootDownRight();
		}
		else if (Keys.isPressed(Keys.DOWN) && Keys.isPressed(Keys.LEFT)){
			player.shootDownLeft();
		}

		else if (Keys.isPressed(Keys.UP)){
			player.shootUp();
		} 	

		else if (Keys.isPressed(Keys.DOWN)){
			player.shootDown();
		} 
		else if (Keys.isPressed(Keys.LEFT)){
			player.shootLeft();
		} 
		else if (Keys.isPressed(Keys.RIGHT)){
			player.shootRight();
		} 


	}
	public Player getPlayer(){
		return player;
	}
	public Room getRoom(){
		return room;
	}
	public EnemyEngine getEE(){
		return eEng;
	}


	

	public void movePlayerLeft(double speed){
		player.setView(0);
		int x = player.getX();
		int y = player.getY();
		if (x > player.getSpeed()-1 && room.pass[x-(int)(player.getSpeed()+.5)][y]){
			player.setPosition(x-speed, y);
		}
		
	}
	public void movePlayerRight(double speed){
		player.setView(1);
		int x = player.getX();
		int y = player.getY();
		if (x < room.getSizeX()-player.getSpeed() && room.pass[x+(int)(player.getSpeed()+.5)][y]){
			player.setPosition(x+speed, y);
		}
		
	}
	public void movePlayerDown(double speed){
		player.setView(2);
		int y = player.getY();
		int x = player.getX();
		if (y < room.getSizeY()-15 && room.pass[x][y+(int)(player.getSpeed()+.5)]){
			player.setPosition(x, y+speed);
		}
		
	}
	public void movePlayerUp(double speed){
		player.setView(3);
		int y = player.getY();
		int x = player.getX();
		if (y > player.getSpeed()-1 && room.pass[x][y-(int)(player.getSpeed()+.5)]){
			player.setPosition(x, y-speed);
		}
		
	}


}
