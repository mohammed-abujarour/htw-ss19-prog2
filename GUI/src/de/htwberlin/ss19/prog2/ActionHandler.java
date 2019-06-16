/**
 * 
 */
package de.htwberlin.ss19.prog2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author Mohammed
 *
 */
public class ActionHandler implements ActionListener{

	public void actionPerformed(ActionEvent e) {
				
		Object source = e.getSource();
		System.out.println(source);
		
		if(! (source instanceof JButton))
			return;
		JButton sourceButton = (JButton) source;
		if(! HtwJFrame.CLICK_ME_BUTTON.equalsIgnoreCase(sourceButton.getName()))
			return;
		
		System.out.println(sourceButton.getName() + " pressed!");
		
			
	}

}
