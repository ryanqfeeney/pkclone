package com.feeney.pk.Entity;

import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
public class Content{
	public static BufferedImage[][] font = load("src/com/feeney/pk/HUD/font.gif", 8, 8);
	// player
	public BufferedImage playerDown;
	public BufferedImage playerLeft;
	public BufferedImage playerRight;
	public BufferedImage playerUp;
	public BufferedImage playerDeath;


	//Scenery
	public BufferedImage tree;
	public BufferedImage rock;
	public BufferedImage floor;
	public BufferedImage door;
	public BufferedImage wall;



	//Undead
	public BufferedImage undead;
	public BufferedImage undeadAttack0;
	public BufferedImage undeadAttack1;
	public BufferedImage undeadAttack2;
	public BufferedImage undeadAttack3;
	public BufferedImage undeadAttack4;
	public BufferedImage undeadAttack5;
	public BufferedImage undeadAttack6;
	public BufferedImage undeadAttack7;


	public BufferedImage gargoyle;
	public BufferedImage garAttack;

	public BufferedImage gDragon;
	public BufferedImage acid;

	public BufferedImage blankImage;

	public BufferedImage youDied;

	public BufferedImage fireBall;


	public Content(){


		try{
			blankImage = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Blank.png"));
		}
		catch(IOException e){
    		System.out.println("Failed to load blank image(s)");
    	}
    	try{
			fireBall = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/fireball.png"));
		}
		catch(IOException e){
    		System.out.println("Failed to load blank image(s)");
    		e.printStackTrace();
    	}
		try{
    		playerDown = ImageIO.read(new File("src/com/feeney/pk/res/Player/PlayerDown.png"));
    		playerUp = ImageIO.read(new File("src/com/feeney/pk/res/Player/PlayerUp.png"));
    		playerLeft = ImageIO.read(new File("src/com/feeney/pk/res/Player/PlayerLeft.png"));
    		playerRight = ImageIO.read(new File("src/com/feeney/pk/res/Player/PlayerRight.png"));
    		playerDeath = ImageIO.read(new File("src/com/feeney/pk/res/Player/PlayerDeath.png"));
    	}
    	catch(IOException e){
    		System.out.println("Failed to load player image(s)");
    	}
    	//////////////////////////

		try{
    		tree = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Tree.png"));
    		rock = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Rock.png"));
    		door = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Door.png"));
    		floor = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Floor.png"));
    		wall = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/Wall.png"));


    	}
    	catch(IOException e){
    		System.out.println("Failed to load Scenery image(s)");
    	}
    	///////////////////////
    	try{
    		undead = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Undead.png"));

    		undeadAttack0 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack0.png"));
    		/*undeadAttack1 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack1.png"));
    		undeadAttack2 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack2.png"));
    		undeadAttack3 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack3.png"));

    		undeadAttack4 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack4.png"));
    		undeadAttack5 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack5.png"));
    		undeadAttack6 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack6.png"));
    		undeadAttack7 = ImageIO.read(new File("src/com/feeney/pk/res/Undead/Attack7.png"));*/

    	}
    	catch(IOException e){
    		System.out.println("Failed to load undead image(s)");
    	}
    	/////////////////////////

    	try{
    		gargoyle = ImageIO.read(new File("src/com/feeney/pk/res/Gargoyle/Gargoyle.png"));


    	}
    	catch(IOException e){
    		System.out.println("Failed to load gargoyle image(s)");
    	}
    	try{
    		gDragon = ImageIO.read(new File("src/com/feeney/pk/res/GapingDragon/GD.png"));
    		acid = ImageIO.read(new File("src/com/feeney/pk/res/GapingDragon/Acid.png"));


    	}
    	catch(IOException e){
    		System.out.println("Failed to load gaping dragon image(s)");
    	}

    	try{
    		youDied = ImageIO.read(new File("src/com/feeney/pk/res/Scenery/YouDied.jpg"));


    	}
    	catch(IOException e){
    		System.out.println("Failed to load you died image(s)");
    	}
	}
	public static BufferedImage[][] load(String s, int w, int h) {
		BufferedImage[][] ret;
		try {
			BufferedImage spritesheet = ImageIO.read(new File(s));
			int width = spritesheet.getWidth() / w;
			int height = spritesheet.getHeight() / h;
			ret = new BufferedImage[height][width];
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					ret[i][j] = resize(spritesheet.getSubimage(j * w, i * h, w, h), 32, 32);

				}
			}
			return ret;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error loading graphics.");
			System.exit(0);
		}
		return null;
	}
	public static void drawString(Graphics2D g, String s, int x, int y, int scale) {
		s = s.toUpperCase();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == 47) c = 36; // slash
			if(c == 58) c = 37; // colon
			if(c == 32) c = 38; // space
			if(c >= 65 && c <= 90) c -= 65; // letters
			if(c >= 48 && c <= 57) c -= 22; // numbers
			int row = c / font[0].length;
			int col = c % font[0].length;
			g.drawImage(resize(font[row][col],8*scale,8*scale), x + 8 * i * scale, y, null);
		}
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}


}


