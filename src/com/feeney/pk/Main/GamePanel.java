package com.feeney.pk.Main;


import com.feeney.pk.Manager.GameStateManager;
import com.feeney.pk.Manager.Keys;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.security.Key;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, MouseMotionListener,MouseListener,KeyListener {
	
	// dimensions
	// HEIGHT is the playing area size
	// HEIGHT2 includes the bottom window
	public static final int WIDTH = 17*50;
	public static final int HEIGHT = 17*50;
	public static final int HEIGHT2 = HEIGHT + 12;
	public static final int SCALE = 1;
	
	// game loop stuff
	private Thread thread;
	private boolean running;
	private final int FPS = 30;
	private final int TARGET_TIME = 1000 / FPS;
	
	// drawing stuff
	private BufferedImage image;
	private Graphics2D g;


	private GameStateManager gsm;
	

	
	// constructor
	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setFocusable(true);
		requestFocus();
	}
	
	// ready to display
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addKeyListener(this);
			addMouseListener(this);
			addMouseMotionListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}
	
	// run new thread
	public void run() {
		
		init();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = TARGET_TIME - elapsed / 1000000;
			if(wait < 0) {
				wait = TARGET_TIME;

			}
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	// initializes fields
	private void init() {
		running = true;
		image = new BufferedImage(WIDTH, HEIGHT2, 1);
		g = (Graphics2D) image.getGraphics();
		gsm = new GameStateManager();
	}
	
	// updates game
	private void update() {
		gsm.update();
		Keys.update();
	}
	
	// draws game
	private void draw() {
		gsm.draw(g);
	}
	
	// copy buffer to screen
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT2 * SCALE, null);
		g2.dispose();
	}
	
	// key event
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		
		Keys.keySet(key.getKeyCode(), true);
		
	}
	public void keyReleased(KeyEvent key) {
		Keys.keySet(key.getKeyCode(), false);
	}

	//mouse



	public void mouseClicked(MouseEvent e) {
		//Keys.mouseSet(e.getX(),e.getY(), true);

	}

	public void mouseExited(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
		Keys.mouseSet(e.getX(),e.getY(),false);
	}
	public void mousePressed(MouseEvent e) {
		Keys.mouseSet(e.getX(),e.getY(),true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Keys.mouseSet(e.getX(),e.getY(),true);
	}
	public void mouseMoved(MouseEvent e){};

}
