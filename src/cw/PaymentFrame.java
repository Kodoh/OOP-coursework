package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField EmailBox;
	private JTextField CardNumBox;
	private JTextField SortBox;

	/**
	 * Launch the application.
	 */
	public PaymentFrame(final Customer cus) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pay for basket");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 11, 184, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pay via payal -");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(150, 47, 174, 20);
		contentPane.add(lblNewLabel_1);
		
		EmailBox = new JTextField();
		EmailBox.setBounds(160, 78, 96, 20);
		contentPane.add(EmailBox);
		EmailBox.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email -");
		lblNewLabel_2.setBounds(101, 81, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton EmailSub = new JButton("Submit");
		EmailSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = EmailBox.getText();
				if (email.contains("@") && email.contains(".com")) {
					JOptionPane.showMessageDialog(null, cus.Payment("Paypal"));			// display payment message (confirmation or error)
				} else {
					JOptionPane.showMessageDialog(null,"Invalid Email");		// email must have @ and .com
				}
			}
		});
		EmailSub.setBounds(290, 77, 89, 23);
		contentPane.add(EmailSub);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pay by credit card -");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(123, 141, 201, 20);
		contentPane.add(lblNewLabel_1_1);
		
		CardNumBox = new JTextField();
		CardNumBox.setBounds(160, 172, 96, 20);
		contentPane.add(CardNumBox);
		CardNumBox.setColumns(10);
		
		SortBox = new JTextField();
		SortBox.setBounds(160, 203, 96, 20);
		contentPane.add(SortBox);
		SortBox.setColumns(10);
		
		JButton CardSubmit = new JButton("Submit");
		CardSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sort = SortBox.getText();
				String cardNum = CardNumBox.getText();
				if ((cardNum.length() == 6) && (sort.length() == 3)) {			// ensure card number is 6 digits and sort code is length 3
					try {
						int cardNumInt = Integer.parseInt(cardNum);
						int sortInt = Integer.parseInt(sort);
						JOptionPane.showMessageDialog(null, cus.Payment("Credit Card"));
					} catch (NumberFormatException y){
						JOptionPane.showMessageDialog(null, "Invalid card details");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid card details");
				}
			}
		});
		CardSubmit.setBounds(160, 240, 96, 23);
		contentPane.add(CardSubmit);
		
		JLabel lblNewLabel_3 = new JLabel("Card Number -");
		lblNewLabel_3.setBounds(47, 175, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Security code -");
		lblNewLabel_4.setBounds(47, 206, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerFrame cf = new CustomerFrame(cus);
				cf.setVisible(true);
				setVisible(false);
			}
		});
		ReturnButton.setBounds(10, 16, 89, 23);
		contentPane.add(ReturnButton);
	}
}
