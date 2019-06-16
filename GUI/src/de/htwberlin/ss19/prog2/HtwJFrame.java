package de.htwberlin.ss19.prog2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HtwJFrame extends JFrame{
	public static final String CLICK_ME_BUTTON = "ClickMe";
	private String title = "JFrame Magic";
	private int width = 600;
	private int height = 400;
	private ActionHandler actionHandler;

	public HtwJFrame() {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		actionHandler = new ActionHandler();
		
		JPanel htwPanel = init(); //preparePanel();
		this.add(htwPanel);
	}

	private JPanel init() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		JButton clickMeButton = new JButton("Click me!");
		clickMeButton.addActionListener(actionHandler);
		clickMeButton.setName(CLICK_ME_BUTTON);
		panel.add(clickMeButton);
		
		JButton doNotClickButton = new JButton("Do NOT click me!");
		doNotClickButton.addActionListener(actionHandler);
		panel.add(doNotClickButton);

		return panel;
	}
}
