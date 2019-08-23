package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Floor extends Scenery{
	public Floor(GameStateManager gsm){
		super("Floor", true,gsm);
		img = gsm.con.floor;
	}
}
