package de.htwberlin.ss19.prog2;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HtwJFrame extends JFrame{
	private String title = "JFrame Magic";
	private int width = 600;
	private int height = 400;

	public HtwJFrame() {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel htwPanel = init(); //preparePanel();
		this.add(htwPanel);
	}

	private JPanel init() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		return panel;
	}
}
