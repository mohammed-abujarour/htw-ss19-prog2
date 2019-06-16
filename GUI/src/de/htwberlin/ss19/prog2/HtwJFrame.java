package de.htwberlin.ss19.prog2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HtwJFrame extends JFrame implements ActionListener{
	private static final String CLICK_ME_BUTTON = "ClickMe";
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
		
		JButton clickMeButton = new JButton("Click me!");
		clickMeButton.addActionListener(this);
		clickMeButton.setName(CLICK_ME_BUTTON);
		panel.add(clickMeButton);
		
		JButton doNotClickButton = new JButton("Do NOT click me!");
		doNotClickButton.addActionListener(this);
		panel.add(doNotClickButton);

		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(! (source instanceof JButton))
			return;
		JButton sourceButton = (JButton) source;
		if(! CLICK_ME_BUTTON.equalsIgnoreCase(sourceButton.getName()))
			return;
		
		System.out.println(sourceButton.getName() + " pressed!");
		
	}
}
