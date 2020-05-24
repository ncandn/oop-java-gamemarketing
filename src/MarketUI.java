import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class MarketUI {

	private JFrame marketFrame;
	private JPanel contentPane, listJPanel;
	private JTextField textField;
	
	public JFrame getMarketFrame() {
		return marketFrame;
	}

	public void setMarketFrame(JFrame marketFrame) {
		this.marketFrame = marketFrame;
	}

	public MarketUI() {
		
		marketFrame = new JFrame();
		marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marketFrame.setBounds(100, 100, 685, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		marketFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(491, 13, 164, 31);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User Reviews", "Highest Price", "Lowest Price", "Top Saling"}));
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Sort By");
		lblNewLabel.setBounds(440, 20, 81, 16);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(27, 17, 245, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(282, 19, 97, 25);
		contentPane.add(btnSearch);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(27, 335, 630, 170);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(44, 71, 97, 25);
		listJPanel.add(btnNewButton);
		listJPanel.validate();
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(44, 109, 97, 25);
		listJPanel.add(btnNewButton_1);
		listJPanel.validate();
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(44, 147, 97, 25);
		listJPanel.add(btnNewButton_2);
		listJPanel.validate();
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(54, 185, 97, 25);
		listJPanel.add(btnNewButton_3);
		listJPanel.validate();
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(44, 233, 97, 25);
		listJPanel.add(btnNewButton_4);
		listJPanel.validate();
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(54, 271, 97, 25);
		listJPanel.add(btnNewButton_5);
		listJPanel.validate();
		scrollPane.add(listJPanel);
	}
	
}
