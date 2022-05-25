package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameBox;
	private JLabel InvalidUN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws FileNotFoundException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuFrame() throws FileNotFoundException{
		final List<User> listUser = new ArrayList<User>();			// initialise lists from stock.txt / UserAccounts
		List<product> listStock = new ArrayList<product>();
		File AccountsFile = new File("UserAccounts.txt");
		File StockFile = new File("Stock.txt");
		Scanner AccountScanner = new Scanner(AccountsFile);
		Scanner StockScanner = new Scanner(StockFile);
		Mouse mo = null;
		Keyboard key = null;
		Customer cu = null;
		Admin ad = null;
		while (StockScanner.hasNextLine()) {
			String[] details = StockScanner.nextLine().split(",") ;			// if keyboard create keyboard object and add to product list
			if (details[1].trim().equals("keyboard")) {
				key = new Keyboard(Integer.parseInt(details[0].trim()), details[3].trim(), details[4].trim(), details[5].trim(),Integer.parseInt(details[6].trim()),Double.parseDouble(details[7].trim()),Double.parseDouble(details[8].trim()),details[9].trim(),details[2].trim());
				listStock.add(key);
			}	// if mouse create mouse object and add to product list
			else {
				mo = new Mouse(Integer.parseInt(details[0].trim()), details[3].trim(), details[4].trim(), details[5].trim(),Integer.parseInt(details[6].trim()),Double.parseDouble(details[7].trim()),Double.parseDouble(details[8].trim()),details[2].trim(),Integer.parseInt(details[9].trim()));
				listStock.add(mo);
		}
		}
		while (AccountScanner.hasNextLine()) {
			String[] details = AccountScanner.nextLine().split(",") ;
			if (details[6].trim().equals("customer")) {								//create a Customer object for each new Customer within UserAccounts and add to user array
				cu = new Customer(Integer.parseInt(details[0].trim()), details[1].trim(), details[2].trim(), new
				Address(Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim()),(ArrayList<product>)listStock,(ArrayList<User>)listUser);
				listUser.add(cu);
			}
			else {		//create an Admin object for each new Admin within UserAccounts
				ad = new Admin(Integer.parseInt(details[0].trim()), details[1].trim(), details[2].trim(), new
				Address(Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim()),(ArrayList<product>)listStock,(ArrayList<User>)listUser);
				listUser.add(ad);
		}
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Screen");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(164, 11, 132, 43);
		contentPane.add(lblNewLabel);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = UsernameBox.getText();
				Customer cus = null;
				Admin add = null;
				boolean found = false;
				for(int i = 0; i<listUser.size(); i++) {
					if (listUser.get(i).getUsername().equals(Username)) {
						if (listUser.get(i) instanceof Admin) {
							found = true;								//check if admin on login
							add = (Admin) listUser.get(i);
							break;
						}
						else {
							found = true;								// check if Customer on login
							cus = (Customer) listUser.get(i); 
							break;
						}
					}
				}
			if (found == false) {
				JOptionPane.showMessageDialog(null, "Username not found!");
			}
			else {
				if (cus != null) {
					CustomerFrame cf = new CustomerFrame(cus);
					cf.setVisible(true);
					setVisible(false);						// take to Customer frame if user is a customer
				}
				else {
					AdminFrame af = new AdminFrame(add);
					af.setVisible(true);
					setVisible(false);							// take to Admin frame if user is an admin
				}
			}
			}
		});
		SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SubmitButton.setBounds(178, 181, 96, 23);
		contentPane.add(SubmitButton);
		
		UsernameBox = new JTextField();
		UsernameBox.setBounds(178, 114, 96, 20);
		contentPane.add(UsernameBox);
		UsernameBox.setColumns(10);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setBounds(108, 117, 60, 14);
		contentPane.add(UsernameLabel);
		
	}
}
