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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchProductsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField MouseBox;
	private JTextField BrandBox;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SearchProductsFrame(final Customer cus) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(147, 11, 160, 25);
		contentPane.add(lblNewLabel);
		
		MouseBox = new JTextField();
		MouseBox.setBounds(168, 74, 96, 20);
		contentPane.add(MouseBox);
		MouseBox.setColumns(10);
		
		BrandBox = new JTextField();
		BrandBox.setColumns(10);
		BrandBox.setBounds(168, 120, 96, 20);
		contentPane.add(BrandBox);
		
		JLabel lblNewLabel_1 = new JLabel("Search button number -");
		lblNewLabel_1.setBounds(10, 77, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Search by brand -");
		lblNewLabel_1_1.setBounds(10, 123, 160, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton MouseButton = new JButton("Submit");
		MouseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      try{
		    	  	int ButtonNum = Integer.parseInt(MouseBox.getText());
		    	  	if (cus.SearchProduct(ButtonNum).equals("")) {			// if user enters nothing
		    	  		JOptionPane.showMessageDialog(null, "No results found");			
		    	  	} else {
					AvailableProductFrame apf = new AvailableProductFrame(cus,"search",cus.SearchProduct(ButtonNum));
					apf.setVisible(true);
					setVisible(false);
						}
	    	      }catch(NumberFormatException y){
	    	    	  JOptionPane.showMessageDialog(null, "Invalid number of buttons!");		// if not int
		    	       }
			}
		});
		MouseButton.setBounds(290, 73, 89, 23);
		contentPane.add(MouseButton);
		
		JButton BrandButton = new JButton("Submit");
		BrandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandBox.getText();
				if (cus.SearchProduct(brand).equals("")) {				// if user enters nothing
					JOptionPane.showMessageDialog(null, "No results found");
				} else {
				AvailableProductFrame apf = new AvailableProductFrame(cus,"search",cus.SearchProduct(brand));
				apf.setVisible(true);
				setVisible(false);
				} 
			}
		});
		BrandButton.setBounds(290, 119, 89, 23);
		contentPane.add(BrandButton);
		
		JButton BothButton = new JButton("Submit");
		BothButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandBox.getText();
				try{
				int ButtonNum = Integer.parseInt(MouseBox.getText());
				if (cus.SearchProduct(brand,ButtonNum).equals("")) {
					JOptionPane.showMessageDialog(null, "No results found");
				} else {
					AvailableProductFrame apf = new AvailableProductFrame(cus,"search",cus.SearchProduct(brand,ButtonNum));
					apf.setVisible(true);	
					setVisible(false);
				}
				}catch(NumberFormatException y){
	    	    	  JOptionPane.showMessageDialog(null, "Invalid number of buttons!");
				}
				
			}
		});
		BothButton.setBounds(168, 167, 96, 23);
		contentPane.add(BothButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Search by both -");
		lblNewLabel_1_1_1.setBounds(10, 171, 160, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
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
