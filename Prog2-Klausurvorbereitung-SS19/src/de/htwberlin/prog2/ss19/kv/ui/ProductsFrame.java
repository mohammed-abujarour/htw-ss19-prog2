package de.htwberlin.prog2.ss19.kv.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import de.htwberlin.prog2.ss19.kv.model.EmailExportStrategy;
import de.htwberlin.prog2.ss19.kv.model.ExportStrategy;
import de.htwberlin.prog2.ss19.kv.model.FaxExportStrategy;
import de.htwberlin.prog2.ss19.kv.model.FileExportStrategy;
import de.htwberlin.prog2.ss19.kv.model.Product;
import de.htwberlin.prog2.ss19.kv.util.PriceSorter;
import de.htwberlin.prog2.ss19.kv.utils.IOUtils;

public class ProductsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Color lightBlue = new Color(175, 211, 255);
	private static final Color yellow = new Color(240, 230, 140);
	private JPanel contentPane;
	private JTextField textFieldCategory;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private DefaultListModel<Product> products = new DefaultListModel<>();
	private ExportStrategy exportStrategy;
	private JComboBox<ExportStrategy> comboBox;

	/**
	 * Create the frame.
	 */
	public ProductsFrame() {
		super();
		basicFrameSettings();

		JPanel bluePanel = createTopPanel();
		contentPane.add(bluePanel, BorderLayout.NORTH);

		JPanel yellowPanel = createLeftPanel();
		contentPane.add(yellowPanel, BorderLayout.WEST);

		JList<Product> list = createList();
		contentPane.add(list, BorderLayout.CENTER);

	}

	/**
	 * This method creates the top panel and returns it as a JPanel
	 * 
	 * @return JPanel
	 * 
	 */
	private JPanel createTopPanel() {
		JPanel topPanel = new JPanel();
		topPanel.setBackground(lightBlue);

		JButton btnLoad = new JButton("Load from file *");
		btnLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Product> importedProducts = IOUtils.readProducts();

				if (importedProducts == null)
					return;

				products.removeAllElements();

				for (Product product : importedProducts)
					products.addElement(product);
			}
		});
		topPanel.add(btnLoad);

		JButton btnSort = new JButton("Sort by name");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Product> list = new ArrayList<Product>();
				Enumeration<Product> elements = products.elements();
				while (elements.hasMoreElements())
					list.add(elements.nextElement());

				Collections.sort(list);

				products.removeAllElements();
				for (Product product : list)
					products.addElement(product);
			}
		});
		topPanel.add(btnSort);

		JButton btnSortByPrice = new JButton("Sort by price");
		btnSortByPrice.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ArrayList<Product> list = new ArrayList<Product>();
				Enumeration<Product> elements = products.elements();
				while (elements.hasMoreElements())
					list.add(elements.nextElement());

				Collections.sort(list, new PriceSorter());

				products.removeAllElements();
				for (Product product : list)
					products.addElement(product);
			}
		});
		topPanel.add(btnSortByPrice);

		JButton btnExport = new JButton("Export to ...");
		btnExport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				exportStrategy = (ExportStrategy) comboBox.getSelectedItem();
				boolean result = exportStrategy.export();
				JOptionPane.showInternalMessageDialog(contentPane,
						"Die Export Aufgabe " + (result ? "war erfolgreich" : "war leider nicht erfolgreich"),
						"Export Result", JOptionPane.INFORMATION_MESSAGE);

			}
		});
		topPanel.add(btnExport);

		comboBox = new JComboBox<ExportStrategy>();
		comboBox.setModel(new DefaultComboBoxModel<ExportStrategy>(new ExportStrategy[] {
				new FileExportStrategy(products), new EmailExportStrategy(), new FaxExportStrategy() }));
		topPanel.add(comboBox);

		return topPanel;
	}

	/**
	 * This method creates the JList where products will be displayed
	 */
	private JList<Product> createList() {
		JList<Product> list = new JList<Product>();
		list.setModel(products);
		return list;
	}

	/**
	 * This method creates the left Panel and returns it as a JPanel
	 */
	private JPanel createLeftPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 2, 10, 2));
		panel.setBackground(yellow);
		panel.setLayout(new GridLayout(4, 2, 0, 40));

		JLabel label = new JLabel("Name");
		panel.add(label);

		textFieldName = new JTextField(10);
		panel.add(textFieldName);

		JLabel lblCategory = new JLabel("Category");
		panel.add(lblCategory);

		textFieldCategory = new JTextField(10);
		panel.add(textFieldCategory);

		JLabel lblPrice = new JLabel("Price");
		panel.add(lblPrice);

		textFieldPrice = new JTextField();
		panel.add(textFieldPrice);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createProduct();
			}
		});
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldCategory.setText("");
				textFieldPrice.setText("");

			}
		});
		panel.add(btnCancel);

		return panel;
	}

	/**
	 * This method performs the basic Frame settings, e.g., size, title, etc.
	 */
	private void basicFrameSettings() {
		setTitle("Products Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 800, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 5));
		this.setContentPane(contentPane);
	}

	/**
	 * This method reads users input from GUI elements and creates an product
	 * object, and adds it to the list of products
	 */
	private boolean createProduct() {

		String name = textFieldName.getText();
		String category = textFieldCategory.getText();
		double price = 0;
		try {
			price = Double.parseDouble(textFieldPrice.getText());
		} catch (Exception exc) {
			JOptionPane.showInternalMessageDialog(contentPane, exc.getMessage());
			return false;
		}
		try {
			Product product = new Product(name, category, price);
			products.addElement(product);

		} catch (Exception exc) {
			JOptionPane.showInternalMessageDialog(contentPane, exc.getMessage());
			return false;
		}
		return true;
	}
}
