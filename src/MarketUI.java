import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MarketUI {

	private JFrame marketFrame;
	private JPanel contentPane;
	private JTextField textField;

	public JFrame getMarketFrame() {
		return marketFrame;
	}

	public void setMarketFrame(JFrame marketFrame) {
		this.marketFrame = marketFrame;
	}

	public MarketUI(JFrame menuFrame, Market market) {
		
		marketFrame = new JFrame();
		marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marketFrame.setBounds(100, 100, 869, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		marketFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(681, 15, 164, 31);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"User Reviews", "Highest Price", "Lowest Price", "Top Selling"}));
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Sort By");
		
		lblNewLabel.setBounds(624, 22, 81, 16);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(27, 17, 345, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(382, 18, 97, 25);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(27, 84, 798, 477);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		scrollPane_1.setEnabled(true);
		panel.setAutoscrolls(true);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marketFrame.setVisible(false);
				menuFrame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(27, 601, 104, 31);
		contentPane.add(btnNewButton);
		
		int count = 0;
		for(Game game:market.getGames()) {
			JPanel mrgpanel = new JPanel();
			mrgpanel.setLayout(new BoxLayout(mrgpanel, BoxLayout.X_AXIS));
			mrgpanel.setPreferredSize(new Dimension(788,100));
			
			JPanel npanel = new JPanel();
			npanel.setPreferredSize(new Dimension(100,90));
			
			JPanel txt1panel = new JPanel();
			txt1panel.setPreferredSize(new Dimension(200,90));
			txt1panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 JOptionPane.showMessageDialog(contentPane, game.getName());
				}
			});
			
			JPanel txt2panel = new JPanel();
			txt2panel.setPreferredSize(new Dimension(200,90));
			
			JPanel txt3panel = new JPanel();
			txt3panel.setPreferredSize(new Dimension(100,90));
			
			JButton game_button = new JButton(":D");
			JLabel txt1 = new JLabel(game.getName());
			JLabel txt2 = new JLabel(game.getGenre());
			JLabel txt3 = new JLabel(String.valueOf(game.getPrice()));
			txt1panel.add(txt1);
			txt2panel.add(txt2);
			txt3panel.add(txt3);
			npanel.add(game_button);
			mrgpanel.add(npanel);
			mrgpanel.add(txt1panel);
			mrgpanel.add(txt2panel);
			mrgpanel.add(txt3panel);
			count++;
			panel.add(mrgpanel);
		}
	}
}