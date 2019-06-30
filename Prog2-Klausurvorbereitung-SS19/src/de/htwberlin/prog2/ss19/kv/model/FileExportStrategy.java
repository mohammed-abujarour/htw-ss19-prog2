/**
 * 
 */
package de.htwberlin.prog2.ss19.kv.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 * @author Mohammed
 *
 */
public class FileExportStrategy implements ExportStrategy {

	private DefaultListModel<Product> elements;

	public FileExportStrategy(DefaultListModel<Product> elements) {

		this.elements = elements;
	}

	@Override
	public boolean export() {

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			FileWriter fw = null;
			PrintWriter pw = null;
			try {
				fw = new FileWriter(file);
				pw = new PrintWriter(fw);

				for (Object element : elements.toArray()) {
					if (!(element instanceof Product))
						continue;
					Product product = (Product) element;
					pw.write(product.getName() + "," + product.getCategory() + "," + product.getPrice() + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} finally {
				if (pw != null)
					pw.close();
				if (fw != null)
					try {
						fw.close();
					} catch (IOException e) {
					}
			}

		}

		return true;
	}

	@Override
	public String toString() {
		return "File";
	}

}
