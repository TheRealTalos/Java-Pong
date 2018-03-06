package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	private double x = 0, y = 0;
	private double dAngle;
	private double rAngle;
	private double speed = 1;
	private double offset = 1.6;
	
	private Random random = new Random();
	
	private static final int SIZE = 20;
	private static final double TAU = Math.PI * 2;
	
	private Rectangle colBox;

	public Ball() {
		spawn();
		colBox = new Rectangle((int)x, (int)y, SIZE, SIZE);
	}
	
	public void spawn() {
		x = Game.getSIZE()/2;
		
		if (random.nextBoolean())
			y = Game.getSIZE()/2 + Math.random() * Game.getSIZE()/4;
		else 
			y = Game.getSIZE()/2 - Math.random() * Game.getSIZE()/4;
		
		if (random.nextBoolean())
			dAngle = Math.random() * 45;
		else 
			dAngle = 360 - Math.random() * 45;
	}
	
	public void update() {
		if (y < 0 || y > Game.getSIZE() - SIZE) {
			wallBounce();
		}
		
		if (x < 0) {
			Game.getPanel().getHud().playerScored();
			spawn();
		}else if (x > Game.getSIZE() - SIZE) {
			Game.getPanel().getHud().botScored();
			spawn();
		}
		
		Player player = Game.getPanel().getPlayer();
		Bot bot = Game.getPanel().getBot();
		if (colBox.intersects(player.getColBox())) {
			racketBounce(player);
		}else if (colBox.intersects(bot.getColBox())) {
			racketBounce(bot);
		}
		
		if (dAngle < 180) {
			speed = Math.abs(dAngle - 90)/80;
		}else {
			speed = Math.abs(dAngle - 270)/80;
		}

		rAngle = TAU/(360/dAngle);
		
		double deltaX = Math.cos(rAngle);
		double deltaY = Math.sin(-rAngle);
		
		x += deltaX/speed;
		y += deltaY/speed;
		
		colBox.setLocation((int)x, (int)y);
	}
	
	public void wallBounce() {
		dAngle = 180 - dAngle + 180;
	}
	
	public void racketBounce(Racket r) {
		double distFromCenter = r.y - y + 50 - SIZE/2;
		dAngle = r.bounceAngle(distFromCenter / offset);
		
	}
	
	public void paint(Graphics g) {
		g.fillRect((int)x, (int)y, SIZE, SIZE);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getSize() {
		return SIZE;
	}
	
	public Rectangle getColBox() {
		return colBox;
	}
}
