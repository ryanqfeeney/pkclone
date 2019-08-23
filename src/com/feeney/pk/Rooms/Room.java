package com.feeney.pk.Rooms;



import com.feeney.pk.Entity.*;
import com.feeney.pk.Manager.GameStateManager;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.*;


public class Room extends JPanel{


	private int x;
	private int y;

	private int pixelHeight;
	private int pixelWidth;

	private GameObject[][] room;
	public Boolean[][] pass; 
	private GameStateManager gsm;




	public Room(GameStateManager gsm){


		pixelHeight = 50;
		pixelWidth = 50;
		this.gsm = gsm;

	}

	public void update(){

	}

	public void draw(Graphics g) {
 
    	for (int i =0; i < getSizeX(); i+=pixelWidth){
    		for (int j = 0; j < getSizeY(); j+=pixelHeight){
    			g.drawImage(room[i][j].getBufferedImage(), i,j, null);
    		}
    	}
    }




    public void loadLevel(String in){

		try{
			File file = new File(in);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st; 
	 		x = Integer.parseInt(br.readLine())*pixelWidth;
	 		y = Integer.parseInt(br.readLine())*pixelHeight;


	 		room = new GameObject[x][y];
	 		pass = new Boolean[x][y];
	 		for (int i = 0; i < y; i+=pixelHeight){
	 			st = br.readLine();
	 			
	 			int letterInx = 0;
	 			for (int j = 0; j < x; j+=pixelWidth){

	 				if (st.substring(letterInx,letterInx+1).equals("."))
	 				{
	 					room[j][i] = new Floor(gsm);
	 					room[j][i].setPosition(j,i);

	 					for (int ii = i; ii < i + pixelWidth; ii++){
	 						for(int jj = j; jj < j + pixelHeight; jj++){
	 							pass[jj][ii] = true;
	 						}
	 					}

	 				}
	  				else if (st.substring(letterInx,letterInx+1).equals("1"))
	 				{
	 					room[j][i] = new Tree(gsm);
	 					room[j][i].setPosition(j,i);
	 					for (int ii = i; ii < i + pixelWidth; ii++){
	 						for(int jj = j; jj < j + pixelHeight; jj++){
	 							pass[jj][ii] = false;
	 						}
	 					}
	 				}
	 				else if (st.substring(letterInx,letterInx+1).equals("0"))
	 				{
	 					room[j][i] = new Rock(gsm);
	 					room[j][i].setPosition(j,i);
	 					for (int ii = i; ii < i + pixelWidth; ii++){
	 						for(int jj = j; jj < j + pixelHeight; jj++){
	 							pass[jj][ii] = false;	 						}
	 					}

	 				}
	 				else
	 				{
	 					room[j][i] = new Door("ERROR",gsm);
	 					room[j][i].setPosition(j,i);
	 				}
	 				letterInx++;
	 			}
	 		}





		}
		catch (FileNotFoundException ex){
			System.out.println("Failed to load level 404");
		}
		catch (IOException ex){
			System.out.println("Failed to load level");
		}

		



	} 

	public GameObject getSpot(int x,int y){
		return room[x][y];
	}

	public void setSpot(int x, int y, GameObject toSet){
		room[x][y] = toSet;
	}

	public int getSizeX(){
		return x;
	}

	public int getSizeY(){
		return y;
	}




	public int getPixelWidth(){
		return pixelWidth;
	}

	public int getPixelHeight(){
		return pixelHeight;
	}


}