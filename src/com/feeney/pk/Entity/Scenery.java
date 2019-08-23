package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Scenery extends GameObject {
	private boolean playerOn;

	Scenery(GameStateManager gsm){
		super(gsm);
	}

	Scenery(String name,GameStateManager gsm){
		super(name, gsm );
	}

	public Scenery(String name, Boolean pass,GameStateManager gsm){
		super(name, pass,gsm);
	}



}

