package dbs_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class User_login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public User_login() {
		setBackground(new Color(255, 255, 224));
		setSize(650,500);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblLogin.setBounds(233, 34, 126, 62);
		add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblUsername.setBounds(46, 155, 146, 49);
		add(lblUsername);
		
		JLabel lblPasskey = new JLabel("Passkey: ");
		lblPasskey.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblPasskey.setBounds(46, 237, 124, 49);
		add(lblPasskey);
		
		textField = new JTextField();
		textField.setBounds(225, 167, 174, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int id=Integer.parseInt(textField.getText());
				String password= String.valueOf(passwordField.getPassword());
				 
				if(User_validation.login(id,password)) {
					Rest_Main.main(new String[] {});
					new Mainframe().cls();
				}
				else {
					JOptionPane.showMessageDialog(User_login.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);

                    textField.setText("");

                    passwordField.setText("");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		btnNewButton.setBounds(136, 362, 107, 35);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainframe.main(new String[] {});
				new Mainframe().cls();
			}
		});
		btnNewButton_1.setBounds(309, 362, 107, 35);
		add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 254, 174, 26);
		add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(460, 51, 141, 153);
		add(lblNewLabel);
		Image img=new ImageIcon(this.getClass().getResource("/rsz_menu.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(460, 231, 141, 153);
		add(lblNewLabel_1);
		Image img1=new ImageIcon(this.getClass().getResource("/rsz_french-fries.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		

	}
}
