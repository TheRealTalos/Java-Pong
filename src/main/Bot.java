package main;

import java.awt.Rectangle;

public class Bot extends Racket {
	private static final double X = 20;

	private double speed;
	private static final double EXPERT = 0.8;
	private static final double INTERMEDIATE = 0.6;
	private static final double BEGINNER = 0.4;

	public Bot() {
		x = X;
		colBox = new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
		speed = BEGINNER;
	}
	
	public void update() {
		Ball ball = Game.getPanel().getBall();
		if (ball.getY() + ball.getSize()/2 < y + HEIGHT/2) {
			moveUp();
		}else if (ball.getY() + ball.getSize()/2> y + HEIGHT/2){
			moveDown();
		}
		colBox.setLocation((int)x, (int)y);
	}
	
	public double bounceAngle(double d) {
		return d + 360;
	}
	
	protected void moveUp(){
		if (y > 0) y-=speed;
	}
	
	protected void moveDown(){
		if (y < Game.getSIZE() - HEIGHT) y+=speed;
	}
	
	public Rectangle getColBox() {
		return colBox;
	}
	
}
