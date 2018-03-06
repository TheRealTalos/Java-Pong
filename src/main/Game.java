package main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	private static Panel panel;
	private static final int TITLEBAR = 30;
	private static final int SIZE = 800;
	private static final int REALSIZE = SIZE - TITLEBAR;

	/*
	 * TODO : Resizable
	 * TODO : Menu
	 * TODO : Difficulty bar
	 * TODO : Single Multi Player
	 * TODO : Change colour theme
	 * TODO : Win lose
	 * TODO : Ball gets stuck on top
	 * 
	 */

	public Game() {
		init();
	}
	
	private void init() {
		setSize(SIZE,SIZE);
		setTitle("JAVA-PONG");
		setBackground(Color.BLACK);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new Panel();
		add(panel);
	}
	
	public static double fraction(double a, double b) {
		return a/b;
	}
	
	public static Panel getPanel() {
		return panel;
	}
	
	public static int getSIZE() {
		return REALSIZE;
	}
	
	public static void main(String[] args) {
		new Game();
	}
	
}
