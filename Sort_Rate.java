package dbs_project;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextArea;

import net.proteanit.sql.DbUtils;

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
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Sort_Rate extends JPanel {
	private JTable table;
    private ResultSet rs;
	/**
	 * Create the panel.
	 */
	public Sort_Rate() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setSize(550,400);
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		JLabel lblTheRestaurentsAre = new JLabel("The Restaurants are:");
		lblTheRestaurentsAre.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		lblTheRestaurentsAre.setBounds(39, 41, 286, 32);
		add(lblTheRestaurentsAre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(39, 72, 286, 2);
		add(separator);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rest_Main.main(new String [] {} );
				Rest_Main.Cls();
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Sitka Small", Font.PLAIN, 17));
		btnBack.setBounds(98, 311, 105, 29);
		add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 100, 266, 166);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			String s="select name,round(avg(rating),2) as avg_ratings from restaurant,ratings where rest_id=re_id group by name order by avg(rating) desc";
		    PreparedStatement ps=con.prepareStatement(s);
            rs=ps.executeQuery();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error has occured");
		}
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		JLabel label = new JLabel("");
		label.setBounds(351, 83, 152, 201);
		add(label);
		Image img=new ImageIcon(this.getClass().getResource("/rsz_feedback.png")).getImage();
		label.setIcon(new ImageIcon(img));

	}
}
