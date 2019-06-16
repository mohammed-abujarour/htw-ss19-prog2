package de.htwberlin.ss19.prog2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class MenuHandler implements ActionListener {

	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		System.out.println(source);
		JMenuItem menuItem = (JMenuItem) source;
		if (menuItem.getName().contains("Open")) {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				System.out.println("Opening file: " + chooser.getSelectedFile().getPath());
			}

		}

	}

}
