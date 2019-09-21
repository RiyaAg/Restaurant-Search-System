package dbs_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	private static Mainframe frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Mainframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainframe() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane = new JPanel();contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME!");
		lblNewLabel.setIcon(null);
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 40));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(196, 40, 263, 60);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		Image img=new ImageIcon(this.getClass().getResource("/rsz_cutlery.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  User_login ul=new User_login();
			  
			 frame.setContentPane(ul);
			 frame.repaint();
			 frame.revalidate();
			  
			  
			  
			}
		});
		btnNewButton.setBounds(191, 159, 247, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New User");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		Image img2=new ImageIcon(this.getClass().getResource("/rsz_restaurant.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New_user nw=new New_user();
				
				frame.setContentPane(nw);
				 frame.repaint();
				 frame.revalidate();
			}
		});
		btnNewButton_1.setBounds(191, 272, 247, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(27, 159, 149, 177);
		contentPane.add(lblNewLabel_1);
		Image img3=new ImageIcon(this.getClass().getResource("/rsz_pizza.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img3));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(472, 159, 149, 177);
		contentPane.add(lblNewLabel_2);

		Image img4=new ImageIcon(this.getClass().getResource("/rsz_1dish.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img4));
	}
	public void cls()
	{
		frame.dispose();
	}
}
