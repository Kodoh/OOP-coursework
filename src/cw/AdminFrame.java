package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AdminFrame(final Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(143, 11, 193, 31);
		contentPane.add(lblNewLabel);
		
		JRadioButton ViewProducts = new JRadioButton("View Products");
		ViewProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AvailableProductFrame apf = new AvailableProductFrame(ad,"all","");
				apf.setVisible(true);
				setVisible(false);
			}
		});
		ViewProducts.setBounds(151, 86, 111, 23);
		contentPane.add(ViewProducts);
		
		JRadioButton AddItems = new JRadioButton("Add Items");
		AddItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemsFrame aif = new AddItemsFrame(ad);
				aif.setVisible(true);
				setVisible(false);
			}
		});
		AddItems.setBounds(151, 126, 111, 23);
		contentPane.add(AddItems);
		
		JButton ReturnButton = new JButton("Logout");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuFrame mf = new MenuFrame();
					mf.setVisible(true);
					setVisible(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ReturnButton.setBounds(23, 19, 89, 23);
		contentPane.add(ReturnButton);
	}
}
