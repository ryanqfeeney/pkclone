package com.feeney.pk.Entity;

import com.feeney.pk.Manager.GameStateManager;

public class Tree extends Scenery{
	public Tree(GameStateManager gsm){
		super("Floor", false,gsm);
		img = gsm.con.tree;
	}
}
