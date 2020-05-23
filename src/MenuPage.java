import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPage{
	
	private JFrame menuFrame;
	private JPanel contentPane;
	

		

	public JFrame getMenuFrame() {
		return menuFrame;
	}

	public void setMenuFrame(JFrame menuFrame) {
		this.menuFrame = menuFrame;
	}




	public MenuPage(Management mng, JFrame loginFrame) {
		
		menuFrame = new JFrame();
		menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuFrame.setBounds(100, 100, 525, 351);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Market");
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarketUI marketUI = new MarketUI();
				marketUI.getMarketFrame().setLocationRelativeTo(null);
				marketUI.getMarketFrame().setVisible(true);
				menuFrame.setVisible(false);
			}
		});
		btnNewButton.setBounds(108, 71, 310, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Social");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(108, 109, 310, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Library");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(108, 147, 310, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(108, 185, 310, 25);
		contentPane.add(btnNewButton_3);
		
		JButton exit_button = new JButton("Logout");
		exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(true);
				menuFrame.setVisible(false);
			}
		});
		exit_button.setBounds(12, 266, 97, 25);
		contentPane.add(exit_button);
	}
}
