package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Rock extends Scenery{
	public Rock(GameStateManager gsm){
		super("Rock", false,gsm);
		img = gsm.con.rock;
	}
}
