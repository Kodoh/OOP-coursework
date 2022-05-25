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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public CustomerFrame(final Customer cus) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Screen");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(133, 11, 185, 31);
		contentPane.add(lblNewLabel);
		
		JRadioButton AddItems = new JRadioButton("Add items to basket");
		AddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBasketFrame abf = new AddBasketFrame(cus);
				abf.setVisible(true);
				setVisible(false);
			}
		});
		AddItems.setBounds(162, 68, 143, 23);
		contentPane.add(AddItems);
		
		JRadioButton ViewItems = new JRadioButton("View items in basket");
		ViewItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cus.ViewBasket().length() > 0) {
					ViewBasketFrame vbf = new ViewBasketFrame(cus);				// if there is at least one product in the basket we can see the basket
					vbf.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Basket is empty!");
				}
			}
		});
		ViewItems.setBounds(162, 94, 185, 23);
		contentPane.add(ViewItems);
		
		JRadioButton ViewAvailable = new JRadioButton("View available products");
		ViewAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvailableProductFrame apf =  new AvailableProductFrame(cus,"all","");
				apf.setVisible(true);
				setVisible(false);
			}
		});
		ViewAvailable.setBounds(162, 120, 195, 23);
		contentPane.add(ViewAvailable);
		
		JRadioButton EmptyBasket = new JRadioButton("Empty basket");
		EmptyBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cus.EmptyBasket();
				JOptionPane.showMessageDialog(null, "Basket cleared");
			}
		});
		EmptyBasket.setBounds(162, 147, 169, 23);
		contentPane.add(EmptyBasket);
		
		JRadioButton Search = new JRadioButton("Search for products");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchProductsFrame spf = new SearchProductsFrame(cus);
				spf.setVisible(true);
				setVisible(false);
			}
		});
		Search.setBounds(162, 173, 185, 23);
		contentPane.add(Search);
		
		JRadioButton Pay = new JRadioButton("Pay for basket");
		Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cus.ViewBasket().length() > 0) {
					PaymentFrame pf = new PaymentFrame(cus);
					pf.setVisible(true);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Basket is empty!");			// we need at least one item in the basket to pay
				}
			}
		});
		Pay.setBounds(162, 202, 195, 23);
		contentPane.add(Pay);
		
		JButton BackButton = new JButton("Logout");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuFrame mf = new MenuFrame();
					mf.setVisible(true);					// return to login
					setVisible(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		BackButton.setBounds(10, 11, 89, 23);
		contentPane.add(BackButton);
	}
}
