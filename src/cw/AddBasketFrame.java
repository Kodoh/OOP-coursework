package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBasketFrame extends JFrame {

	private JPanel contentPane;
	private JTextField barcode;

	/**
	 * Launch the application.
	 */
	public AddBasketFrame(final Customer cus) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();										
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter barcode of Item to be added to basket - ");
		lblNewLabel.setBounds(107, 76, 304, 14);
		contentPane.add(lblNewLabel);
		
		barcode = new JTextField();
		barcode.setBounds(167, 101, 96, 20);			// text box to add barcode
		contentPane.add(barcode);
		barcode.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Add to basket");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(135, 11, 197, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton SubmitBut = new JButton("Submit");
		SubmitBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			      try{
			    	  //error detection
			    	  int bcode = Integer.parseInt(barcode.getText());
						if (cus.AddToBasket(bcode) == true) {				
							JOptionPane.showMessageDialog(null, "item added!");			// barcode in stock	
						}
						else {
							JOptionPane.showMessageDialog(null, "item not found!");		// barcode not found in stock
						}															
	    	      }catch(NumberFormatException y){
	    	    	  JOptionPane.showMessageDialog(null, "Invalid Barcode!");			// not a barcode
		    	       }
			}
		});
		SubmitBut.setBounds(167, 146, 96, 23);
		contentPane.add(SubmitBut);
		
		JButton Back = new JButton("Return");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		// return to main scren
				CustomerFrame cf = new CustomerFrame(cus);
				cf.setVisible(true);
				setVisible(false);
			}
		});
		Back.setBounds(10, 11, 89, 25);
		contentPane.add(Back);
	}
}
