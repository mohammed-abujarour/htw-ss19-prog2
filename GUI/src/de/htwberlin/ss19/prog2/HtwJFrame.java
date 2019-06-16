package de.htwberlin.ss19.prog2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HtwJFrame extends JFrame implements ActionListener{
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
		
		JButton button = new JButton("Click me!");
		button.addActionListener(this);
		
		panel.add(button);
		
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getSource());
		
	}
}
