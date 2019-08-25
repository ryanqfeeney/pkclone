package com.feeney.pk.GameState;

import com.feeney.pk.Manager.EnemyEngine;
import com.feeney.pk.Entity.Player;
import com.feeney.pk.Manager.GameStateManager;
import com.feeney.pk.Rooms.Room;

import java.awt.Graphics2D;


public abstract class GameState {
	
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void handleInput();
	public abstract Player getPlayer();
	public abstract Room getRoom();
	public abstract EnemyEngine getEE();

	public static class StartState extends GameState {

		StartState(GameStateManager gsm){
			super(gsm);
		}

		public void init(){

		}

		public void update(){

		}

		public void draw(Graphics2D g){


		}

		public void handleInput(){

		}

		public Player getPlayer(){
			return new Player(gsm);
		}

		public Room getRoom(){
			return new Room(gsm);
		}
		public EnemyEngine getEE(){
			return new EnemyEngine(gsm);
		}


	}
}