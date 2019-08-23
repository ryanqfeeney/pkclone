package com.feeney.pk.Manager;


import com.feeney.pk.Entity.Content;
import com.feeney.pk.Entity.Player;
import com.feeney.pk.GameState.GameState;
import com.feeney.pk.GameState.StartState;
import com.feeney.pk.GameState.PlayState;

import java.awt.Graphics2D;



public class GameStateManager {
	
	private GameState[] gameStates;
	private Player playerSave;
	private int currentState;
	public int frame;

	
	public static final int NUM_STATES = 5;
	public static final int YOUDIED = 0;
	public static final int START = 1;
	public static final int PLAY = 2;
	public static final int PAUSE = 3;
	public static final int END = 4;



	public Content con;


	
	public GameStateManager() {

		con = new Content();
		gameStates = new GameState[NUM_STATES];
		setState(START);
		frame = 0;
		
	}
	
	public void setState (int i) {


		
		currentState = i;

		if(gameStates[currentState]!=null){
		}


		if(i == START) {
			if(gameStates[i]==null){
				gameStates[i] = new StartState(this);
			}

		}/*
		if(i == YOUDIED) {
			if(gameStates[i]==null){
				gameStates[i] = new YOUDIED(this);
			}
		}
		
		if(i == PAUSE) {
			if(gameStates[i]==null){
				gameStates[i] = new PauseState(this);
			}
		}*/

		
		if(i == PLAY) {
			if(gameStates[i]==null){
				gameStates[i] = new PlayState(this);
				gameStates[i].init();
			}
		}/*
		if(i == END) {
			if(gameStates[i]==null){
				gameStates[i] = new EndState(this);
			}
		}*/
	}

	public void unloadState(int i){
		gameStates[i] = null;
	}

	public void update() {

		frame++;
		if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
		

	}

	public GameState getState(){
		return gameStates[currentState];
	}

	public int getFrame(){
		return frame;
	}
	
	public void draw(Graphics2D g) {
		if (gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}

	public Player getPlayerSave(){
		return playerSave;
	}

	
}
