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

public class AddItemsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField BarcodeBox;
	private JTextField BrandBox;
	private JTextField ConnectivityBox;
	private JTextField QuantityBox;
	private JTextField OriginalBox;
	private JTextField RetailBox;
	private JTextField KtypeBox;
	private JLabel lblEnterBrand;
	private JLabel lblEnterConnectivity;
	private JLabel lblEnterQuantity;
	private JLabel lblEnterOriginalCost;
	private JLabel lblEnterRetailCost;
	private JTextField LayoutBox;
	private JTextField MtypeBox;
	private JTextField ButtonsBox;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField ColourBox;
	private JLabel lblNewLabel_7;
	private JButton ReturnButton;

	/**
	 * Launch the application.
	 */
	public AddItemsFrame(final Admin ad) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Items");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(208, 11, 139, 31);
		contentPane.add(lblNewLabel);
		
		BarcodeBox = new JTextField();
		BarcodeBox.setBounds(161, 53, 96, 20);
		contentPane.add(BarcodeBox);
		BarcodeBox.setColumns(10);
		
		BrandBox = new JTextField();
		BrandBox.setColumns(10);
		BrandBox.setBounds(161, 80, 96, 20);
		contentPane.add(BrandBox);
		
		ConnectivityBox = new JTextField();
		ConnectivityBox.setColumns(10);
		ConnectivityBox.setBounds(161, 111, 96, 20);
		contentPane.add(ConnectivityBox);
		
		QuantityBox = new JTextField();
		QuantityBox.setColumns(10);
		QuantityBox.setBounds(161, 142, 96, 20);
		contentPane.add(QuantityBox);
		
		OriginalBox = new JTextField();
		OriginalBox.setColumns(10);
		OriginalBox.setBounds(161, 172, 96, 20);
		contentPane.add(OriginalBox);
		
		RetailBox = new JTextField();
		RetailBox.setColumns(10);
		RetailBox.setBounds(161, 202, 96, 20);
		contentPane.add(RetailBox);
		
		KtypeBox = new JTextField();
		KtypeBox.setColumns(10);
		KtypeBox.setBounds(384, 80, 96, 20);
		contentPane.add(KtypeBox);
		
		JLabel lblEnterBarcode = new JLabel("Enter barcode -");
		lblEnterBarcode.setBounds(20, 56, 131, 17);
		contentPane.add(lblEnterBarcode);
		
		lblEnterBrand = new JLabel("Enter brand -");
		lblEnterBrand.setBounds(20, 83, 131, 17);
		contentPane.add(lblEnterBrand);
		
		lblEnterConnectivity = new JLabel("Enter connectivity -");
		lblEnterConnectivity.setBounds(20, 114, 139, 20);
		contentPane.add(lblEnterConnectivity);
		
		lblEnterQuantity = new JLabel("Enter quantity -");
		lblEnterQuantity.setBounds(20, 145, 131, 19);
		contentPane.add(lblEnterQuantity);
		
		lblEnterOriginalCost = new JLabel("Enter original cost -");
		lblEnterOriginalCost.setBounds(20, 175, 131, 19);
		contentPane.add(lblEnterOriginalCost);
		
		lblEnterRetailCost = new JLabel("Enter retail cost -");
		lblEnterRetailCost.setBounds(20, 205, 131, 20);
		contentPane.add(lblEnterRetailCost);
		
		LayoutBox = new JTextField();
		LayoutBox.setColumns(10);
		LayoutBox.setBounds(384, 111, 96, 20);
		contentPane.add(LayoutBox);
		
		MtypeBox = new JTextField();
		MtypeBox.setColumns(10);
		MtypeBox.setBounds(384, 172, 96, 20);
		contentPane.add(MtypeBox);
		
		ButtonsBox = new JTextField();
		ButtonsBox.setColumns(10);
		ButtonsBox.setBounds(384, 202, 96, 20);
		contentPane.add(ButtonsBox);
		
		lblNewLabel_1 = new JLabel("For keyboard -");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(384, 55, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("For mouse -");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(384, 144, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Keyboard type -");
		lblNewLabel_3.setBounds(267, 83, 107, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Keyboard layout -");
		lblNewLabel_4.setBounds(267, 114, 107, 20);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Mouse type -");
		lblNewLabel_5.setBounds(267, 175, 107, 17);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Button No -");
		lblNewLabel_6.setBounds(267, 205, 107, 20);
		contentPane.add(lblNewLabel_6);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcode = BarcodeBox.getText();
				String brand = BrandBox.getText();
				String quantity = QuantityBox.getText();
				String colour = ColourBox.getText();
				String connectivity = ConnectivityBox.getText();
				String og = OriginalBox.getText();
				String rp = RetailBox.getText();
				String layout = LayoutBox.getText();
				String ktype = KtypeBox.getText();
				String mtype = MtypeBox.getText();
				String NoButt = ButtonsBox.getText();
				if (barcode.length() > 0 && brand.length() > 0 && quantity.length() >0 && colour.length() > 0 && connectivity.length() > 0 && og.length() > 0 && rp.length() > 0 && (ktype.length() > 0 && layout.length() > 0 || mtype.length() > 0 && NoButt.length() > 0)) {
					// ensure no spaces filled in blank
				if (mtype.length() > 0 && ButtonsBox.getText().length() > 0 && layout.length() == 0 && ktype.length() == 0) {
					if (ad.AddProduct(Integer.parseInt(barcode), "mouse",mtype, brand, colour, connectivity, Integer.parseInt(quantity), Double.parseDouble(og), Double.parseDouble(rp), Integer.parseInt(NoButt)) == false) {
					JOptionPane.showMessageDialog(null, "Added item to stock!");
				}
					// barcode already found in file
					else {
						JOptionPane.showMessageDialog(null, "Barcode already in use!");
					}
				}
				if (mtype.length() == 0 && ButtonsBox.getText().length() == 0 && layout.length() > 0 && ktype.length() > 0) {
					if (ad.AddProduct(Integer.parseInt(barcode), "keyboard",ktype, brand, colour, connectivity, Integer.parseInt(quantity), Double.parseDouble(og), Double.parseDouble(rp), layout) == false) {
					JOptionPane.showMessageDialog(null, "Added item to stock!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Barcode already in use!");
					}
				}
				} else { // if there is blank spaces 
					JOptionPane.showMessageDialog(null, "Not all required fields entered!");
				}
			}
		});
		Submit.setBounds(223, 263, 89, 23);
		contentPane.add(Submit);
		
		ColourBox = new JTextField();
		ColourBox.setBounds(161, 233, 96, 20);
		contentPane.add(ColourBox);
		ColourBox.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Enter colour -");
		lblNewLabel_7.setBounds(20, 236, 131, 20);
		contentPane.add(lblNewLabel_7);
		
		ReturnButton = new JButton("Return");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFrame af = new AdminFrame(ad);
				af.setVisible(true);
				setVisible(false);
			}
		});
		ReturnButton.setBounds(20, 19, 89, 23);
		contentPane.add(ReturnButton);
	}
}
