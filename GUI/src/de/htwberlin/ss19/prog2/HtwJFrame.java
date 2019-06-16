package de.htwberlin.ss19.prog2;

import javax.swing.JFrame;

public class HtwJFrame extends JFrame{
	private String title = "JFrame Magic";
	private int width = 600;
	private int height = 400;

	public HtwJFrame() {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
