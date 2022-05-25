package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AvailableProductFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ProductBox;

	/**
	 * Launch the application.
	 */
	public AvailableProductFrame(final User cus,String mode,String content) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Products -");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(104, 11, 251, 25);
		contentPane.add(lblNewLabel);
		
		JTextArea ProductBox = new JTextArea();

		JScrollPane sp = new JScrollPane(ProductBox);
		if (mode.equals("all")) {
		ProductBox.setText(cus.getProducts());
		ProductBox.setBounds(10, 45, 745, 361);
	}
		else {
		ProductBox.setText(content);
		ProductBox.setBounds(10, 45, 745, 361);	
		}
		sp.setBounds(26, 47, 373, 190);
		contentPane.add(sp);
		
		JButton ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cus instanceof Customer) {
					CustomerFrame cf = new CustomerFrame((Customer)cus);
					cf.setVisible(true);
					setVisible(false);					// return to customer screen if User is customer
				}
				else {
					AdminFrame af = new AdminFrame((Admin)cus);
					af.setVisible(true);
					setVisible(false);						// return to admin menu if User is admin
				}
			}
		});
		ReturnButton.setBounds(5, 11, 89, 23);
		contentPane.add(ReturnButton);
}
}