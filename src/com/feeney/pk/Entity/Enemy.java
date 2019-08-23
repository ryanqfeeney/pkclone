package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Enemy extends GameObject {
	protected int speed;
	protected Boolean alive;
	public Enemy(GameStateManager gsm, int i){
		super("Enemy",true, gsm);
		speed = 1;
		img = gsm.con.undead;
		alive = true;

		if (i==0){
			setPosition(400,0);
		}
		if (i==1){
			setPosition(850,425);
		}
		if (i==2){
			setPosition(425,850);
		}
		if (i==3){
			setPosition(0,425);
		}
	}

	public void update(){
		moveTowardPlayer();
	}

	public int getSpeed(){
		return speed;
	}
	public Boolean getAlive(){
		return alive;
	}

	public void setAlive(Boolean bool){
		alive = bool;
	}
	public void moveTowardPlayer(){
		for (int i = 0; i < getSpeed(); i++){
			int x = (int)(this.x+.5);
			int y = (int)(this.y+.5);

			int pX = gsm.getState().getPlayer().getX();
			int pY = gsm.getState().getPlayer().getY();

			

			if (pX < x && pY < y){
				//topLeft
				setPosition(x-1,y-1);
				
			}

			else if (pX==x&pY<y){
				//topCenter
				setPosition(x,y-1);
				

			}

			else if (pX>x&&pY<y){
				//topRight
				setPosition(x+1,y-1);
			}

			else if (pX<x&&pY==y){
				//midleft
				setPosition(x-1,y);
			}

			else if (pX>x&&pY==y){
				//midright
				setPosition(x+1,y);
			}

			else if (pX < x && pY > y){
				//bottem left
				setPosition(x-1,y+1);

			}

			else if (pX==x&pY>y){
				//center bottom
				setPosition(x,y+1);

			}

			else if (pX>x&&pY>y){
				//right bottom
				setPosition(x+1,y+1);
			}

		}
	}
}