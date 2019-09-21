package dbs_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class New_user extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public New_user() {
		setBackground(new Color(255, 255, 224));
		setSize(650,500);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		lblNewLabel.setBounds(226, 23, 173, 39);
		add(lblNewLabel);
		
		JLabel lblUserid = new JLabel("User_id:");
		lblUserid.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblUserid.setBounds(35, 145, 75, 25);
		add(lblUserid);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblFirstName.setBounds(35, 73, 111, 25);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblLastName.setBounds(35, 109, 111, 25);
		add(lblLastName);
		
		JLabel lblDob = new JLabel("DOB(dd-mm-yyyy):");
		lblDob.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblDob.setBounds(35, 219, 159, 25);
		add(lblDob);
		
		JLabel lblLocality = new JLabel("Locality:");
		lblLocality.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblLocality.setBounds(35, 255, 95, 25);
		add(lblLocality);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblCity.setBounds(35, 291, 75, 25);
		add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblState.setBounds(35, 327, 75, 25);
		add(lblState);
		
		JLabel lblPincode = new JLabel("Pincode:");
		lblPincode.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblPincode.setBounds(35, 363, 95, 25);
		add(lblPincode);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String fname=textField.getText().trim();
				String lname=textField_1.getText().trim();
				int uid=Integer.parseInt(textField_2.getText().trim());
				String pkey=String.valueOf(passwordField.getPassword());
				String db=textField_4.getText().trim();
				String local=textField_5.getText().trim();
				String cty=textField.getText().trim();
				String state=textField_7.getText().trim();
				int pcode=Integer.parseInt(textField_8.getText());
				
				int i=User_validation.save1(uid, fname, lname, db);
				if(i>0) {
					int j=User_validation.save2(local, cty, state, pcode, uid);
					int k=User_validation.save3(uid, pkey);
					if((j>0)&(k>0)) {
						JOptionPane.showMessageDialog(New_user.this, "User added successfully!");

	                    Rest_Main.main(new String[]{});
	                    new Mainframe().cls();
					}
					else {
						JOptionPane.showMessageDialog(New_user.this, "Sorry, unable to save!");
					}
				}
				else {
					JOptionPane.showMessageDialog(New_user.this, "Sorry, unable to save!");
				}
			}
		});
		
		btnRegister.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnRegister.setBounds(216, 417, 116, 39);
		add(btnRegister);
		
		textField = new JTextField();
		textField.setBounds(216, 78, 140, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 114, 140, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 150, 140, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 223, 140, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(216, 260, 140, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(216, 296, 140, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(216, 332, 140, 20);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(216, 368, 140, 20);
		add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mainframe.main(new String[] {});
				new Mainframe().cls();
			}
		});
		btnBack.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnBack.setBounds(377, 417, 101, 39);
		add(btnBack);
		
		JLabel lblPasskey = new JLabel("Passkey");
		lblPasskey.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblPasskey.setBounds(35, 181, 95, 27);
		add(lblPasskey);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 187, 140, 20);
		add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(412, 122, 201, 214);
		add(label);

		Image img=new ImageIcon(this.getClass().getResource("/rsz_11taco.png")).getImage();
		label.setIcon(new ImageIcon(img));

	}
}
