package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;


public class Pellet extends GameObject {
	double destX, destY;
	double startX, startY;
	double bulletSpeed;
	int bulletLife;

	public Pellet(double destX, double destY, double x, double y, GameStateManager gsm){
		super("Pellet", true, gsm);
		//this.direction = direction;
		this.destX = destX;
		this.destY = destY;
		this.startX = x;
		this.startY = y;
		bulletSpeed = 10;
		bulletLife = 15*2;
		setPosition(x-25,y-25);
		img = gsm.con.fireBall;

	}

	public void update(){

		bulletLife--;
		//setPosition(x+(Math.cos(destX-x)*bulletSpeed), y+(Math.sin(destY-y)*bulletSpeed));
		//setPosition(x,y+bulletSpeed);
		double angle;
		if(destX > startX) {
			angle = Math.atan((startY - destY) / (destX - startX));
			setPosition(x+bulletSpeed*Math.cos(angle),y-bulletSpeed*Math.sin(angle));

		}
		else {
			angle = Math.atan(((startY - destY) / (destX - startX)));
			setPosition(x-bulletSpeed*Math.cos(angle),y+bulletSpeed*Math.sin(angle));

		}

//		switch(direction){
//			case 0:
//				setPosition(x,y-bulletSpeed);
//				break;
//			case 1:
//				setPosition(x+bulletSpeed,y-bulletSpeed);
//				break;
//			case 2:
//				setPosition(x+bulletSpeed,y);
//				break;
//			case 3:
//				setPosition(x+bulletSpeed,y+bulletSpeed);
//				break;
//			case 4:
//				setPosition(x,y+bulletSpeed);
//				break;
//			case 5:
//				setPosition(x-bulletSpeed,y+bulletSpeed);
//				break;
//			case 6:
//				setPosition(x-bulletSpeed,y);
//				break;
//			case 7:
//				setPosition(x-bulletSpeed,y-bulletSpeed);
//				break;
//		}

	}
	
}
