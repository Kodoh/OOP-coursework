package cw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBasketFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public ViewBasketFrame(final Customer cus) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Items in basket - ");
		lblNewLabel.setBounds(122, 11, 214, 25);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JTextArea BasketList = new JTextArea();
		BasketList.setText(cus.ViewBasket());
		BasketList.setBounds(26, 46, 400, 191);
		JScrollPane sp = new JScrollPane(BasketList);
		sp.setBounds(26, 47, 373, 190);
		contentPane.add(sp);
		
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
