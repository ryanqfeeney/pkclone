package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Player extends GameObject {

	public ArrayList<Pellet> pellets = new ArrayList<Pellet>();

	protected int view;
	protected double speed;
	
	

	public Player(GameStateManager gsm){
		super("Player", gsm);
		img = gsm.con.playerDown;
		speed = 6;
	}




	public void setView(int i){
		view = i;
		if (i == 0){
			img = gsm.con.playerLeft;
		}
		else if (i == 1){
			img = gsm.con.playerRight;

		}
		else if (i == 2){
			img = gsm.con.playerDown;

		}
		else if (i == 3){
			img = gsm.con.playerUp;

		}
	}

	public void update(){

		pelletUpdate();
		checkHit();
	}

	public void checkHit(){
		ArrayList<Enemy> enemies = gsm.getState().getEE().getEnemies();
		int xP = gsm.getState().getPlayer().getX();
		int yP = gsm.getState().getPlayer().getY();
		for (int i = 0; i < enemies.size(); i++){
			if ( !enemies.get(i).getAlive()) continue;
			int xE = enemies.get(i).getX()-25;
			int yE = enemies.get(i).getY()-25;
			if ((xE+45 > xP && xE-5 < xP)   &&  (yE+45 > yP && yE-5 < yP)) //This is off but I don't want to figure it out rn
			{
				//change state here
			}
		}
	}

	public void pelletUpdate(){
		for (int i = 0; i < pellets.size(); i++){
			if (pellets.get(i) == null){
				continue;
			}
			else if (pellets.get(i).bulletLife == 0){
				pellets.set(i, null);
			}
			else{
				pellets.get(i).update();
			}
		}
	}

	public double getSpeed(){
		return speed;
	}


	@Override
	public void draw(Graphics2D g){

		g.drawImage(
			img,
				(int)(x+.5)-25,
				(int)(y+.5)-25,
			null
		);


		for (int i = 0; i < pellets.size(); i++){
			if (pellets.get(i) == null){
				continue;
			}

			else{
				g.drawImage(pellets.get(i).getBufferedImage(),
							pellets.get(i).getX(),
							pellets.get(i).getY(),
							null);
			}
		}		

	}

	public void shootUp(){
		Pellet pel = new Pellet(0,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}

	}
	public void shootRight(){
		Pellet pel = new Pellet(2,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}
	public void shootDown(){
		Pellet pel = new Pellet(4,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}
	public void shootLeft(){
		Pellet pel = new Pellet(6,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}

	public void shootUpRight(){
		Pellet pel = new Pellet(1,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}

	}
	public void shootDownRight(){
		Pellet pel = new Pellet(3,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}
	public void shootDownLeft(){
		Pellet pel = new Pellet(5,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}
	public void shootUpLeft(){
		Pellet pel = new Pellet(7,(int)(x+.5),(int)(y+.5),gsm);

		int i;
		for (i = 0; i < pellets.size(); i++){
			if(pellets.get(i) == null){
				pellets.set(i,pel);
				break;
			}
		}

		if (i == pellets.size()){
			pellets.add(pel);
		}
	}




}



	

