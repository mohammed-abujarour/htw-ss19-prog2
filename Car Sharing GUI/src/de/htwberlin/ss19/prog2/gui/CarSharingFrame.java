/**
 * 
 */
package de.htwberlin.ss19.prog2.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import de.htwberlin.ss19.prog2.CarSharingApp;
import de.htwberlin.ss19.prog2.Gender;
import de.htwberlin.ss19.prog2.Passenger;
import de.htwberlin.ss19.prog2.User;

/**
 * @author abujaro
 *
 */
public class CarSharingFrame extends JFrame {

	private CarSharingApp app = new CarSharingApp();
	private JPanel userPanel = new JPanel();
	private JPanel panel;
	private DefaultListModel<User> model = new DefaultListModel<>();

	public CarSharingFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.getContentPane().setLayout(new CardLayout());
		panel = init();
		try {
			loadUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setJMenuBar(createMenuBar());
		this.getContentPane().add(panel);
		this.userPanel.setVisible(false);
		initUserPanel();
		this.getContentPane().add(userPanel);

	}

	private void loadUsers() throws Exception {
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());
		ArrayList<User> appUsers = app.getUsers();

		appUsers.add(new Passenger("Tim", Gender.Male, "0122", 0));
		appUsers.add(new Passenger("Janine", Gender.Female, "0122", 0));

		appUsers.add(new Passenger("Martin", Gender.Male, "0122", 0));

		appUsers.add(new Passenger("Julia", Gender.Female, "0122", 0));

		User[] users = new User[appUsers.size()];

		for (int i = 0; i < appUsers.size(); i++)
			users[i] = appUsers.get(i);

		JList<User> userList = new JList<>();
		for (int i = 0; i < appUsers.size(); i++)
			model.add(i, appUsers.get(i));
		
		userList.setModel(model);

		panel.add(userList, BorderLayout.CENTER);
		panel.add(new JLabel("Home"), BorderLayout.NORTH);

		JButton whatIsSelected = new JButton("Show selection");
		whatIsSelected.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(userList.getSelectedValue());
			}
		});

		panel.add(whatIsSelected, BorderLayout.SOUTH);

	}

	private void initUserPanel() {
//		userPanel.setLayout(new GridLayout(4, 2, 10, 10));

		userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
		JLabel lblName = new JLabel("Name");
		JTextField txtName = new JTextField(10);

		JLabel lblGender = new JLabel("Gender");
		JComboBox<String> gender = new JComboBox<>(new String[] { "Male", "Female" });

		JLabel lblMobile = new JLabel("Mobile");
		JTextField txtMobile = new JTextField(10);

		JButton btnAdd = new JButton("Add user ... ");

		JPanel txtPanel = new JPanel();

		txtPanel.add(lblName);
		txtPanel.add(txtName);
		userPanel.add(txtPanel);

		JPanel genderPanel = new JPanel();
		genderPanel.add(lblGender);
		genderPanel.add(gender);
		userPanel.add(genderPanel);

		JPanel mobilePanel = new JPanel();
		mobilePanel.add(lblMobile);
		mobilePanel.add(txtMobile);
		userPanel.add(mobilePanel);

		JPanel btnPanel = new JPanel();
		btnPanel.add(btnAdd);

		JDialog dialog = new JDialog(this, "", true);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String name = txtName.getText();
				String mobileNumber = txtMobile.getText();
				Gender userGender = Gender.Male;

				if (gender.getSelectedItem().toString().equalsIgnoreCase("Female"))
					userGender = Gender.Female;

				try {
					Passenger passenger = new Passenger(name, userGender, mobileNumber, 0);
					app.addUser(passenger);
					model.addElement(passenger);
					dialog.setSize(300, 150);
					dialog.add(new JLabel("User " + passenger + " addedd successfully"));
					dialog.setVisible(true);
					System.out.println(passenger + " added successfully");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		userPanel.add(btnPanel);
	}

	private JMenuBar createMenuBar() {

		JMenuBar bar = new JMenuBar();
		JMenu userMenu = new JMenu("User");
		JMenuItem addUser = new JMenuItem("Add user");
		addUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				userPanel.setVisible(true);
				System.out.println(e);
			}
		});
		userMenu.add(addUser);
		userMenu.addSeparator();
		JMenuItem deleteUser = new JMenuItem("Delete user");

		userMenu.add(deleteUser);
		bar.add(userMenu);

		JMenu goMenu = new JMenu("Go to");
		JMenuItem goHome = new JMenuItem("Go Home");
		goHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userPanel.setVisible(false);
				panel.setVisible(true);
			}
		});

		goMenu.add(goHome);
		bar.add(goMenu);

		return bar;
	}

	private JPanel init() {

		JPanel panel = new JPanel();
		return panel;
	}
}
