package com.feeney.pk.Manager;

import com.feeney.pk.Entity.Enemy;
import com.feeney.pk.Manager.GameStateManager;

import java.awt.Graphics2D;
import java.util.*;

public class EnemyEngine{

	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private GameStateManager gsm;

	public EnemyEngine(GameStateManager gsm){
		this.gsm = gsm;
	}

	public void update(){
		pelletCheck();
		if (gsm.frame%60 == 0){
			enemies.add(new Enemy(gsm, 0));
			enemies.add(new Enemy(gsm, 1));
			enemies.add(new Enemy(gsm, 2));
			enemies.add(new Enemy(gsm, 3));
		}
		for (int i = 0; i < enemies.size(); i++){
			if (enemies.get(i).getAlive()){
				enemies.get(i).update();
			}
		}
	}

	public void draw(Graphics2D g){
		for (int i = 0; i < enemies.size(); i++){
			if (enemies.get(i).getAlive()){
				enemies.get(i).draw(g);
			}
		}
	}

	public Enemy getEnemy(int i){
		return enemies.get(i);
	}
	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}

	public void pelletCheck(){
		for (int i = 0; i <  gsm.getState().getPlayer().pellets.size(); i++){
			if ( gsm.getState().getPlayer().pellets.get(i) == null) continue;
			int xP = gsm.getState().getPlayer().pellets.get(i).getX();
			int yP = gsm.getState().getPlayer().pellets.get(i).getY();
			for (int j = 0; j < enemies.size(); j++ ){
				if (!enemies.get(j).getAlive()) continue;
				int xE = enemies.get(j).getX()-25;
				int yE = enemies.get(j).getY()-25;
				if ((xE+20 > xP && xE-20 < xP)   &&  (yE+20 > yP && yE-20 < yP))
				{

					gsm.getState().getPlayer().pellets.set(i,null);

					enemies.get(j).setAlive(false);
				}
			}
		}
	}
}