/**
 * 
 */
package de.htwberlin.prog2.ss19.kv.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import de.htwberlin.prog2.ss19.kv.model.Product;

/**
 * @author Mohammed
 *
 */
public class IOUtils {

	public static List<Product> readProducts() {

		ArrayList<Product> products = new ArrayList<>();

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			Reader fr = null;
			BufferedReader buf = null;
			try {
				fr = new FileReader(file);
				buf = new BufferedReader(fr);
				while (buf.ready()) {
					String line = buf.readLine();
					if (line.isEmpty())
						continue;
					String parts[] = line.split(",");
					if (parts.length != 3)
						continue;
					Product product = new Product(parts[0], parts[1], Double.parseDouble(parts[2]));
					products.add(product);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (buf != null)
					try {
						buf.close();
					} catch (IOException e) {
					}
				if (fr != null)
					try {
						fr.close();
					} catch (IOException e) {
					}
			}

			return products;
		}

		return null;
	}

}
