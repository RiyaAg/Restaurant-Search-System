package dbs_project;

import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Sort_Budget extends JPanel {
	private ResultSet rs;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Sort_Budget() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setSize(550,400);
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Restaurants are:");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		lblNewLabel.setBounds(32, 26, 274, 29);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 53, 328, 2);
		add(separator);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","evolve");
			String q="select name,avg_for2 from budget,restaurant where r_id=rest_id order by avg_for2";
			PreparedStatement ps=con.prepareStatement(q);
			rs=ps.executeQuery();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Error has occured");
			}
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rest_Main.main(new String[] {});
				Rest_Main.Cls();
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton.setBounds(118, 300, 105, 29);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 77, 306, 158);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JLabel label = new JLabel("");
		label.setBounds(366, 73, 153, 122);
		add(label);
		Image img=new ImageIcon(this.getClass().getResource("/wallet.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(376, 206, 134, 122);
		add(label_1);
		Image img2=new ImageIcon(this.getClass().getResource("/Basket-icon.png")).getImage();
		label_1.setIcon(new ImageIcon(img2));
		

	}
}
