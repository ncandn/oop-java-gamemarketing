import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class LoginUI {
   
	private JFrame login_frame;
    private JPanel contentPane;
    private JTextField in_username;
    private JPasswordField in_password;
    Management mng ;
   
    public JFrame getLoginFrame() {
		return login_frame;
	}

	public void setLoginFrame(JFrame login_frame) {
		this.login_frame = login_frame;
	}

	public LoginUI() throws CloneNotSupportedException, IOException{
		
		login_frame = new JFrame();
    	this.mng = new Management();

    	
    	login_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	login_frame.setBounds(100, 100, 593, 350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        login_frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Name");
        lblNewLabel.setBounds(12, 13, 73, 28);
        contentPane.add(lblNewLabel);

        in_username = new JTextField();
        in_username.setBounds(81, 16, 116, 22);
        contentPane.add(in_username);
        in_username.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password");
        lblNewLabel_1.setBounds(12, 54, 73, 16);
        contentPane.add(lblNewLabel_1);

        in_password = new JPasswordField();
        in_password.setBounds(81, 51, 116, 22);
        contentPane.add(in_password);

        JButton btnNewButton = new JButton("Login");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            	User user = mng.getSocial().getUserMap().get(in_username.getText());
                if(user != null)
            	{
            		if(user.getPassword().equals(String.copyValueOf(in_password.getPassword())))
            		{   
            			
            			MenuUI menu = new MenuUI(mng, login_frame);
            			menu.getMenuFrame().setLocationRelativeTo(null);
            			menu.getMenuFrame().setVisible(true);
            			login_frame.setVisible(false);
            			in_username.setText("");
            			in_password.setText("");
            		}
            		else
            		{
            			JOptionPane.showMessageDialog(contentPane, "Your password is incorrect!");

            		}
            	}
                else {
                	
                	JOptionPane.showMessageDialog(contentPane, in_username.getText() + " does not exist!");

                }

            }
        });
        btnNewButton.setBackground(Color.DARK_GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBounds(231, 15, 97, 25);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Register");
        btnNewButton_1.setBackground(Color.DARK_GRAY);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNewButton_1.setBounds(231, 50, 97, 25);
        contentPane.add(btnNewButton_1);
    }

	

}
