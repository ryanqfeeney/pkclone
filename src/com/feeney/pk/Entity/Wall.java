package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Wall extends Scenery{
	public Wall(GameStateManager gsm){
		super("Wall", false,gsm);
		img = gsm.con.wall;
	}
}
