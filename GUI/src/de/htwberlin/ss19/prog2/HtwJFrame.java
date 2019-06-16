package de.htwberlin.ss19.prog2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		final JLabel label = new JLabel();

		JTextArea textArea = new JTextArea(10, 40);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				
				Object sourceObject =  e.getSource();
				if(sourceObject instanceof JTextArea) {
					JTextArea sourceTextArea = (JTextArea) sourceObject;
					label.setText(sourceTextArea.getText().length() + " chars");
				}
			}
		});
		panel.add(textArea);
		
		
		panel.add(label);
		
		final JTextField userInput = new JTextField(20);		
		panel.add(userInput);
		
		JButton addUserInput = new JButton("Add to options");
		panel.add(addUserInput);
		
		final JComboBox <String> userOptions = new JComboBox<>();		
		panel.add(userOptions);
		
		addUserInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userOptions.addItem(userInput.getText());
			}
		});
		return panel;
	}
}
