package dbs_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JSlider;

public class Rest_Main extends JFrame {

	private JPanel contentPane;
    private static Rest_Main frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Rest_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void Cls()
	{
		frame.dispose();
	}

	/**
	 * Create the frame.
	 */
	public Rest_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,550,400);
		contentPane = new JPanel();contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTheAvailableRestaurents = new JLabel("The available restaurants are: ");
		lblTheAvailableRestaurents.setFont(new Font("Sitka Small", Font.ITALIC, 23));
		lblTheAvailableRestaurents.setBounds(23, 28, 389, 43);
		contentPane.add(lblTheAvailableRestaurents);
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		comboBox.setBounds(23, 89, 274, 37);
		contentPane.add(comboBox);
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
            PreparedStatement stmt = con.prepareStatement("select name from restaurant");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
            	comboBox.addItem(rs.getString(1));
            }
            
            con.close();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"An error has occured");
		}
		
		JButton btnShow = new JButton("Show");
		btnShow.setBackground(new Color(211, 211, 211));
		btnShow.setFont(new Font("Sitka Small", Font.PLAIN, 21));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String res_name = comboBox.getSelectedItem().toString();
				new Rest_display(res_name).setVisible(true);;
				frame.dispose();
				
			}
		});
		btnShow.setBounds(76,219, 125, 37);
		contentPane.add(btnShow);
		
		
		
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(20, 65, 442, 2);
		contentPane.add(separator1);
		
		
		JButton btnSortByRatings = new JButton("Show by ratings");
		btnSortByRatings.setBackground(new Color(211, 211, 211));
		btnSortByRatings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sort_Rate sr=new Sort_Rate();
				frame.setContentPane(sr);
				frame.repaint();
				frame.revalidate();
			}
		});
		btnSortByRatings.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnSortByRatings.setBounds(340, 96, 131, 30);
		contentPane.add(btnSortByRatings);
		
		JButton btnNewButton = new JButton("Show by region");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sort_Region sc=new Sort_Region();
				frame.setContentPane(sc);
				frame.repaint();
				frame.revalidate();
			}
		});
		btnNewButton.setBounds(340, 137, 131, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show by cuisine");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sort_Cuisine sc=new Sort_Cuisine();
				frame.setContentPane(sc);
				frame.repaint();
				frame.revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Small", Font.PLAIN, 11));
		btnNewButton_1.setBounds(340, 178, 131, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show by budget");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		btnNewButton_2.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sort_Budget sb=new Sort_Budget();
				frame.setContentPane(sb);
				frame.repaint();
				frame.revalidate();
				
			}
		});
		btnNewButton_2.setBounds(340, 225, 131, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Rate\r\n\r\n");
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rater ra=new Rater();
				frame.setContentPane(ra);
				frame.repaint();
				frame.revalidate();
			}
		});
		btnNewButton_3.setFont(new Font("Sitka Small", Font.PLAIN, 21));
		btnNewButton_3.setBounds(76, 284, 125, 37);
		contentPane.add(btnNewButton_3);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(211, 211, 211));
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mainframe.main(new String[] {});
				frame.dispose();
			}
		});
		btnLogout.setBounds(340, 290, 131, 30);
		contentPane.add(btnLogout);
	}
}
