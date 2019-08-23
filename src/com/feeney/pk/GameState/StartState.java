package com.feeney.pk.GameState;

import com.feeney.pk.Entity.Player;
import com.feeney.pk.GameState.GameState;
import com.feeney.pk.Manager.EnemyEngine;
import com.feeney.pk.Manager.GameStateManager;
import com.feeney.pk.Rooms.Room;

import java.awt.Graphics2D;
import java.util.*;

public class StartState extends GameState {

	public StartState(GameStateManager gsm){
		super(gsm);
	}

	public void init(){

	}

	public void update(){
		if (gsm.frame%30 == 0){
			gsm.setState(gsm.PLAY);
		}
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