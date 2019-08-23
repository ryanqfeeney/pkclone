package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;


public class Pellet extends GameObject {
	int direction; //0 up 1 top right ... clockwise 7 is top left//
	int bulletSpeed;
	int bulletLife;

	public Pellet(int direction, int x, int y, GameStateManager gsm){
		super("Pellet", true, gsm);
		this.direction = direction;
		bulletSpeed = 10;
		bulletLife = 15*2;
		setPosition(x-25,y-25);
		img = gsm.con.fireBall;

	}

	public void update(){

		bulletLife--;
		switch(direction){
			case 0:
				setPosition(x,y-bulletSpeed);
				break;
			case 1: 
				setPosition(x+bulletSpeed,y-bulletSpeed);
				break;
			case 2: 
				setPosition(x+bulletSpeed,y);
				break;
			case 3: 
				setPosition(x+bulletSpeed,y+bulletSpeed);
				break;
			case 4: 
				setPosition(x,y+bulletSpeed);
				break;
			case 5: 
				setPosition(x-bulletSpeed,y+bulletSpeed);
				break;
			case 6: 
				setPosition(x-bulletSpeed,y);
				break;
			case 7: 
				setPosition(x-bulletSpeed,y-bulletSpeed);
				break;
		}

	}
	
}
