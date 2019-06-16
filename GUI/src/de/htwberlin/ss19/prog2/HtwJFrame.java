package de.htwberlin.ss19.prog2;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HtwJFrame extends JFrame {
	public static final String CLICK_ME_BUTTON = "ClickMe";
	private String title = "JFrame Magic";
	private int width = 600;
	private int height = 400;
	private ActionHandler actionHandler;
	private ActionListener menuActionListener;

	public HtwJFrame() {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		actionHandler = new ActionHandler();
		this.setJMenuBar(initMenuBar());
		JPanel htwPanel = init(); // preparePanel();
		this.add(htwPanel);
	}

	private JMenuBar initMenuBar() {
		menuActionListener = new MenuHandler();
		JMenuBar bar = new JMenuBar();
		String topLevelMenu[] = { "File", "Edit", "View", "Help" };
		String menuItems[][] = { { "Open ...", "Save", "Exit" }, { "Select" }, { "Zoom" }, { "Support" } };
		for (int i = 0; i < topLevelMenu.length; i++) {
			JMenu menu = new JMenu(topLevelMenu[i]);
			for (int j = 0; j < menuItems[i].length; j++) {
				JMenuItem menuItem = new JMenuItem(menuItems[i][j]);
				menuItem.setName(menuItem.getText());
				menuItem.addActionListener(menuActionListener);
				menu.add(menuItem);
			}
			bar.add(menu);
		}

		return bar;
	}

	private JPanel init() {
		final JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setLayout(new GridLayout(3, 1));
		
		JButton clickMeButton = new JButton("Click me!");
		clickMeButton.addActionListener(actionHandler);
		clickMeButton.setName(CLICK_ME_BUTTON);
//		panel.add(clickMeButton);

		JButton doNotClickButton = new JButton("Do NOT click me!");
		doNotClickButton.addActionListener(actionHandler);
		//panel.add(doNotClickButton);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(clickMeButton);
		buttonsPanel.add(doNotClickButton);
		
		panel.add(buttonsPanel);
		
		final JLabel label = new JLabel();

		JTextArea textArea = new JTextArea(10, 40);
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);

				Object sourceObject = e.getSource();
				if (sourceObject instanceof JTextArea) {
					JTextArea sourceTextArea = (JTextArea) sourceObject;
					label.setText(sourceTextArea.getText().length() + " chars");
				}
			}
		});
		
		JPanel textAreaPanel = new JPanel();
		textAreaPanel.setLayout(new GridLayout(2, 1));
		textAreaPanel.add(textArea);
		textAreaPanel.add(label);
		panel.add(textAreaPanel);

		final JTextField userInput = new JTextField(20);

		JButton addUserInput = new JButton("Add to options");

		final JComboBox<String> userOptions = new JComboBox<>();

		JPanel optionsPanel = new JPanel();
		optionsPanel.add(userInput);
		optionsPanel.add(addUserInput);
		optionsPanel.add(userOptions);

		panel.add(optionsPanel);
		
		addUserInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String newOption = userInput.getText();
				ArrayList<String> existingOptions = readAllExistingOptions();
				boolean optionExists = existingOptions.contains(newOption);
				if (optionExists) {
					int answer = JOptionPane.showConfirmDialog(panel,
							"Option already exists?\nDo you want to add it anyways?");
					String message = "";

					if (answer == JOptionPane.YES_OPTION) {
						userOptions.addItem(newOption);
						message = new String("Duplicated item added to option list");
						JOptionPane.showMessageDialog(panel, message);
					} else if (answer == JOptionPane.NO_OPTION) {
						message = new String("Duplicated item discarded from option list");
						JOptionPane.showMessageDialog(panel, message);
					} else if (answer == JOptionPane.CANCEL_OPTION) {
						message = new String("Action cancelled");
						JOptionPane.showMessageDialog(panel, message);
					}

				} else
					userOptions.addItem(newOption);
			}

			private ArrayList<String> readAllExistingOptions() {
				int size = userOptions.getItemCount();
				ArrayList<String> items = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					String item = userOptions.getItemAt(i);
					items.add(item);
				}
				return items;
			}
		});
		return panel;
	}
}
