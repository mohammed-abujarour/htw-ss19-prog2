package de.htwberlin.prog2.ss19.kv.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import de.htwberlin.prog2.ss19.kv.model.Product;

public class ProductsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Color lightBlue = new Color(175, 211, 255);
	private static final Color yellow = new Color(240, 230, 140);
	private JPanel contentPane;
	private JTextField textFieldCategory;
	private JTextField textFieldName;
	private JTextField textFieldPrice;

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
		topPanel.add(btnLoad);

		JButton btnSort = new JButton("Sort by name");
		topPanel.add(btnSort);

		JButton btnSortByPrice = new JButton("Sort by price");
		topPanel.add(btnSortByPrice);

		JButton btnExport = new JButton("Export to ...");
		topPanel.add(btnExport);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "File", "Email", "Fax" }));
		topPanel.add(comboBox);

		return topPanel;
	}

	/**
	 * This method creates the JList where products will be displayed
	 */
	private JList<Product> createList() {
		JList<Product> list = new JList<Product>();
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
		panel.add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
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

}
