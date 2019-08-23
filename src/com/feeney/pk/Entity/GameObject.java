package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class GameObject{
	
	protected String name;
	protected Boolean passable;
	protected BufferedImage img;
	protected double x;
	protected double y;
	protected int pWidth = 50;
	protected int pHeight = 50;
	protected boolean isVisible;
	protected GameStateManager gsm;



	public GameObject(GameStateManager gsm){

		this.name = "";
		passable = true;
		isVisible = true;
		this.gsm = gsm;

	}

	GameObject(String name, GameStateManager gsm){
		this.name = name;
		passable = true;
		isVisible = true;
		this.gsm = gsm;
	}

	GameObject(String name, Boolean pass, GameStateManager gsm){
		this.name = name;
		passable = pass;
		isVisible = true;
		this.gsm = gsm;
	}





	public void setName(String nameIn){
		this.name = nameIn;
	}

	public String getName(){
		return name;
	}

	public void setPosition(double x, double y){
		this.x = (int)(x+.5);
		this.y = (int)(y+.5);
	}

	public int getX(){
		return (int)(x+.5);
	}

	public int getY(){
		return (int)(y+.5);
	}



	public void setPass(Boolean pass){
		this.passable = pass;
	}

	public Boolean getVisibility(){
		return isVisible;
	}


	public void setVisibility(Boolean in){
		this.isVisible = in;
	}

	public Boolean getPass(){
		return passable;
	}


	public BufferedImage getBufferedImage(){
		return img;
	}
	public void draw(Graphics2D g) {
		g.drawImage(
			img,
				(int)(x+.5)-25,
				(int)(y+.5)-25,
			null
		);
	}


}






