package de.htwberlin.prog2.ss19.kv.model;

import javax.swing.JOptionPane;

public class EmailExportStrategy implements ExportStrategy {

	@Override
	public boolean export() {

		JOptionPane.showMessageDialog(null, "Die Liste der Produkte wird per Email gesendet", "Export",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

	@Override
	public String toString() {
		return "Email";
	}

}
