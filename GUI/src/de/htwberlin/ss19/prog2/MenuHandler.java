package de.htwberlin.ss19.prog2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		System.out.println(source);

	}

}
