package main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Player extends Racket {
	private static final int X = 770 - WIDTH;
	
	public Player() {
		x = X;
		colBox = new Rectangle((int)x, (int)y, WIDTH, HEIGHT);
	}
	
	public double bounceAngle(double d) {
		return 180 - d;
	}
	
	public void update(MouseEvent e) {
		y = e.getY();
		if (y > Game.getSIZE() - HEIGHT) {
			y = Game.getSIZE() - HEIGHT;
		}
		colBox.setLocation((int)x, (int)y);
	}
	
	public Rectangle getColBox() {
		return colBox;
	}
}