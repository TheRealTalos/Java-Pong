package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
	private int gamestate;
	public final static int MENU = 0;
	public final static int GAME = 1;
	
	public static final Font BIGFONT = new Font("BigFont", Font.BOLD, (int) (Game.fraction(1, 8) * Game.getSIZE()));
	public static final Font SMALLFONT = new Font("SmallFont", Font.BOLD, (int) (Game.fraction(1, 16) * Game.getSIZE()));
	
	private Menu menu;
	private HUD hud;
	private Ball ball;
	private Player player;
	private Bot bot;
	private MouseEvent me;
	
	public Panel() {
		setBackground(Color.BLACK);
		
		menu = new Menu();
		hud = new HUD();
		ball = new Ball();
		player = new Player();
		bot = new Bot();
		
		gamestate = MENU;
		
		Timer timer = new Timer(1, this);
		timer.start();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(BIGFONT);
		if (gamestate == MENU) {
			menu.paint(g);
		}else if (gamestate == GAME) {
			hud.paint(g);
			ball.paint(g);
			player.paint(g);
			bot.paint(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (gamestate == MENU) {
			menu.update();
		}else if (gamestate == GAME) {
			ball.update();
			if (me != null) player.update(me);
			bot.update();
		}
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		me = e;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("ass");
		menu.mouseClicked(e);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void switchGamestate(int g) {
		gamestate = g;
	}
	
	public HUD getHud() {
		return hud;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Bot getBot() {
		return bot;
	}
	
}
