package dbs_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Rater extends JPanel {

	/**
	 * Create the panel.
	 */
	private ButtonGroup rd;
	private String rev="";
	private JTextArea textArea;
	public Rater() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(null);
		setSize(550,400);
		JLabel lblRatingSystem = new JLabel("Rating System");
		lblRatingSystem.setBounds(21, 30, 261, 38);
		lblRatingSystem.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 25));
		add(lblRatingSystem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 60, 322, 2);
		add(separator);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		comboBox.setBounds(21, 112, 273, 20);
		add(comboBox);
		
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
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBounds(21, 160, 109, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBounds(21, 186, 109, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setBounds(21, 212, 109, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setBounds(21, 238, 109, 23);
		add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setBounds(21, 264, 109, 23);
		add(radioButton_4);
		
		JButton btnRate = new JButton("Rate");
		btnRate.setBounds(72, 311, 109, 28);
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=0;
				rev=textArea.getText().trim();
				if(radioButton.isSelected()&&!rev.equals(""))
				{
					x=1;
					String st=comboBox.getSelectedItem().toString();
					new RestControl().addRate(st.trim(),x,rev);
					new Rest_Main().main(new String[] {});
					Rest_Main.Cls();
				}
				if(radioButton_1.isSelected()&&!rev.equals(""))
				{
					x=2;
					String st=comboBox.getSelectedItem().toString();
					new RestControl().addRate(st,x,rev);
					new Rest_Main().main(new String[] {});
					Rest_Main.Cls();
				}
				if(radioButton_2.isSelected()&&!rev.equals(""))
				{
					x=3;
					String st=comboBox.getSelectedItem().toString();
					new RestControl().addRate(st,x,rev);
					new Rest_Main().main(new String[] {});
					Rest_Main.Cls();
				}
				if(radioButton_3.isSelected()&&!rev.equals(""))
				{
					x=4;
					String st=comboBox.getSelectedItem().toString();
					new RestControl().addRate(st,x,rev);
					new Rest_Main().main(new String[] {});
					Rest_Main.Cls();
				}
				if(radioButton_4.isSelected()&&!rev.equals(""))
				{
					x=5;
					String st=comboBox.getSelectedItem().toString();
					new RestControl().addRate(st,x,rev);
					new Rest_Main().main(new String[] {});
					Rest_Main.Cls();
				}
				if((!radioButton.isSelected()&&!radioButton_1.isSelected()&&!radioButton_2.isSelected()
						&&!radioButton_3.isSelected()&&!radioButton_4.isSelected())||rev.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please select a rating/enter a review");
				}
			}
		});
		btnRate.setFont(new Font("Sitka Small", Font.ITALIC, 14));
		add(btnRate);
		
		JButton btnBck = new JButton("Back");
		btnBck.setBounds(359, 311, 109, 28);
		btnBck.setForeground(Color.RED);
		btnBck.setFont(new Font("Sitka Small", Font.BOLD, 13));
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Rest_Main().main(new String[] {});
				Rest_Main.Cls();
			}
		});
		add(btnBck);
		
		JLabel lblPleaseSelectA = new JLabel("Please select a restaurant and rate,review it:");
		lblPleaseSelectA.setBounds(15, 73, 391, 28);
		lblPleaseSelectA.setFont(new Font("Sitka Small", Font.ITALIC, 17));
		add(lblPleaseSelectA);
		
		JLabel label = new JLabel("");
		label.setBounds(371, 162, 141, 112);
		add(label);
		Image img=new ImageIcon(this.getClass().getResource("/rsz_r.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		rd = new ButtonGroup();
		rd.add(radioButton);
		rd.add(radioButton_1);
		rd.add(radioButton_2);
		rd.add(radioButton_3);
		rd.add(radioButton_4);
		
		textArea = new JTextArea();
		textArea.setBounds(136, 198, 189, 50);
		add(textArea);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your review:");
		lblPleaseEnterYour.setFont(new Font("Sitka Small", Font.ITALIC, 17));
		lblPleaseEnterYour.setBounds(136, 162, 225, 25);
		add(lblPleaseEnterYour);

	}
}
