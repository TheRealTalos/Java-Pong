package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;

public class Menu {
	private int menustate;
	private static final int HOME = 0;
	private static final int GAMEMODE = 1;
	private static final int CONTROLS = 2;
	private static final int THEME = 3;

	public Menu() {
		
	}
	
	public void update() {
		if (menustate == HOME) {
			
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		if (menustate == HOME) {
			if (e.getY() < Game.getSIZE() - Panel.SMALLFONT.getSize()*2) {
				System.out.println(e.getY() + " " + (Game.getSIZE() - Panel.SMALLFONT.getSize()*2));
				Game.getPanel().switchGamestate(Panel.GAME);
			}else {
				menustate = GAMEMODE;
			}
		}else if (menustate == GAMEMODE) {
			System.out.println("gamemode");
			if (e.getY() >= Game.getSIZE()/3 && e.getY() < (Game.getSIZE()/3)*2) {
				//SINGLEPLAYER
				menustate = CONTROLS;
			}else if (e.getY() >= (Game.getSIZE()/3)*2 && e.getY() < Game.getSIZE()) {
				//MULTIPLAYER
				menustate = CONTROLS;
			}
		}else if (menustate == CONTROLS) {
			System.out.println("controls");
			if (e.getY() >= Game.getSIZE()/3 && e.getY() < (Game.getSIZE()/3)*2) {
				//MOUSE
				menustate = THEME;
			}else if (e.getY() >= (Game.getSIZE()/3)*2 && e.getY() < Game.getSIZE()) {
				//KEYBOARD
				menustate = THEME;
			}
		}else if (menustate == THEME) {
			System.out.println("theme");
			if (e.getY() >= Game.getSIZE()/3 && e.getY() < (Game.getSIZE()/3)*2) {
				//WHITE
				Game.getPanel().switchGamestate(Panel.GAME);
			}else if (e.getY() >= (Game.getSIZE()/3)*2 && e.getY() < Game.getSIZE()) {
				//RED
				Game.getPanel().switchGamestate(Panel.GAME);
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setFont(Panel.BIGFONT);
		g.drawString("JAVA-PONG", (int) (Game.fraction(1, 8) * Game.getSIZE()), (int) (Game.fraction(1, 8) * Game.getSIZE()));
		if (menustate == HOME) {
			g.setFont(Panel.SMALLFONT);
			g.drawString("CLICK HERE TO START", (int) (Game.fraction(1, 8) * Game.getSIZE()), (int) (Game.fraction(1, 2) * Game.getSIZE()));
			g.drawString("CLICK HERE FOR SETTINGS", (int) (Game.fraction(1, 16) * Game.getSIZE()), Game.getSIZE() - g.getFont().getSize()/2);
		}if (menustate == GAMEMODE) {
			drawList(g, new String[] {"SINGLEPLAYER", "MULTIPLAYER"}, (int) Game.fraction(1, 3) * Game.getSIZE(), (int) Game.fraction(1, 8) * Game.getSIZE());
		}else if (menustate == CONTROLS) {
			g.setFont(Panel.SMALLFONT);
			g.drawString("CLICK HERE TO START", (int) (Game.fraction(1, 8) * Game.getSIZE()), (int) (Game.fraction(1, 2) * Game.getSIZE()));
			g.drawString("CLICK HERE FOR SETTINGS", (int) (Game.fraction(1, 16) * Game.getSIZE()), Game.getSIZE() - g.getFont().getSize()/2);
		}else if (menustate == THEME) {
			g.setFont(Panel.SMALLFONT);
			g.drawString("CLICK HERE TO START", (int) (Game.fraction(1, 8) * Game.getSIZE()), (int) (Game.fraction(1, 2) * Game.getSIZE()));
			g.drawString("CLICK HERE FOR SETTINGS", (int) (Game.fraction(1, 16) * Game.getSIZE()), Game.getSIZE() - g.getFont().getSize()/2);
		}
		
	}
	
	private void drawList(Graphics g, String[] s, int y, int gap) {
		Graphics2D g2d = (Graphics2D) g;
		g.setFont(Panel.SMALLFONT);
		for (int i = 0; i < s.length; i++) {
			g.drawString(s[i], Game.getSIZE()/2 - (int) g.getFont().getStringBounds(s[i], 0, 0, g2d.getFontRenderContext()).getWidth()/2, 300);
		}
	}
	
}
