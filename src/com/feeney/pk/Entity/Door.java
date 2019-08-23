package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Door extends Scenery{
	public Door(String in, GameStateManager gsm){
		super(in, true,gsm);
		img = gsm.con.door;
	}

}
