package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class HUD {
	private int pScore, bScore;
	
	public HUD() {
		start();
	}
	
	public void start() {
		pScore = 0;
		bScore = 0;
	}
	
	public void paint(Graphics g) {		
		g.drawString(Integer.toString(pScore), (int) (Game.fraction(6.5, 8) * Game.getSIZE()), (int) (Game.fraction(1, 8) * Game.getSIZE()));
		g.drawString(Integer.toString(bScore), (int) (Game.fraction(1, 8) * Game.getSIZE()), (int) (Game.fraction(1, 8) * Game.getSIZE()));
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, new float[]{9}, 0));
		g2d.drawLine(Game.getSIZE()/2, 0, Game.getSIZE()/2, Game.getSIZE());
	}
	
	public void playerScored() {
		if (pScore < 9) pScore++;
		else {
			pScore++;
			win();
		}
	}
	
	public void botScored() {
		if (bScore < 9) bScore++;
		else {
			bScore++;
			lose();
		}
	}
	
	private void win() {
		start();
	}
	
	private void lose() {
		start();
	}
	
}
