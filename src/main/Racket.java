package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
	protected static final int WIDTH = 20;
	protected static final int HEIGHT = 100;
	
	protected Rectangle colBox;
	
	protected double x;
	protected double y;
	
	public Racket(){
		
	}
	
	protected void paint(Graphics g) {
		g.fillRect((int)x, (int)y, WIDTH, HEIGHT);
	}

	protected double bounceAngle(double d) {
		return 0;
	}
}
