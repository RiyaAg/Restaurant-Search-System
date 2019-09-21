package dbs_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Rest_display extends JFrame {

	private JPanel contentPane;
	static Rest_display frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String str=new String();
				try {
					frame = new Rest_display(str);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void cl()
	{
		frame.dispose();
	}
	/**
	 * Create the frame.
	 */
	int rid;
	

	
	public Rest_display(String res) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestaurantName = new JLabel("Restaurant Name");
		lblRestaurantName.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblRestaurantName.setBounds(39, 25, 323, 71);
		getContentPane().add(lblRestaurantName);
		
		JLabel lblCuisine = new JLabel("Cuisine");
		lblCuisine.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblCuisine.setBounds(60, 114, 96, 27);
		getContentPane().add(lblCuisine);
		
		JLabel lblCuisinetype = new JLabel("Value");
		lblCuisinetype.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblCuisinetype.setBounds(222, 114, 157, 27);
		getContentPane().add(lblCuisinetype);
		
		JLabel lblBudget = new JLabel("Avg for 1");
		lblBudget.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblBudget.setBounds(60, 148, 96, 30);
		getContentPane().add(lblBudget);
		
		JLabel lblApprox = new JLabel("Value");
		lblApprox.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblApprox.setBounds(222, 148, 157, 28);
		getContentPane().add(lblApprox);
		
		JLabel lblTimings = new JLabel("Avg for 2");
		lblTimings.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblTimings.setBounds(60, 189, 96, 30);
		getContentPane().add(lblTimings);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblValue.setBounds(222, 189, 157, 30);
		getContentPane().add(lblValue);
		
		JLabel lblTimings_1 = new JLabel("Timings");
		lblTimings_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblTimings_1.setBounds(60, 230, 96, 30);
		getContentPane().add(lblTimings_1);
		
		JLabel lblValue_1 = new JLabel("Value");
		lblValue_1.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblValue_1.setBounds(222, 232, 198, 27);
		getContentPane().add(lblValue_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblAddress.setBounds(60, 271, 96, 30);
		getContentPane().add(lblAddress);
		
		JLabel lblValue_2 = new JLabel("Value");
		lblValue_2.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblValue_2.setBounds(222, 271, 323, 30);
		getContentPane().add(lblValue_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Rest_Main.main(new String[] {});
				setVisible(false);;
			}
		});
		btnBack.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		btnBack.setBounds(463, 456, 96, 30);
		getContentPane().add(btnBack);
		
		JLabel lblValue_3 = new JLabel("Value");
		lblValue_3.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
		lblValue_3.setBounds(222, 305, 350, 30);
		getContentPane().add(lblValue_3);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblRating.setBounds(60, 337, 96, 27);
		getContentPane().add(lblRating);
		
		JLabel lblValue_4 = new JLabel("Value");
		lblValue_4.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblValue_4.setBounds(222, 344, 86, 20);
		getContentPane().add(lblValue_4);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblReview.setBounds(60, 384, 96, 20);
		getContentPane().add(lblReview);
		
		JLabel lblRv = new JLabel("rv1");
		lblRv.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblRv.setBounds(222, 384, 481, 27);
		getContentPane().add(lblRv);
		
		JLabel lblRv_1 = new JLabel("rv2");
		lblRv_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblRv_1.setBounds(222, 415, 493, 30);
		getContentPane().add(lblRv_1);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(419, 43, 240, 202);
		getContentPane().add(label);
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			PreparedStatement ps=con.prepareStatement("select rest_id,cuisine,timings,avg_rat from restaurant where name=?");
			ps.setString(1,res);
			ResultSet rs = ps.executeQuery();
			String imgdisp="/"+res+".jpg";
			
			if(rs.next())
			{
				lblRestaurantName.setText(res);
				lblCuisinetype.setText(rs.getString("cuisine"));
				lblValue_1.setText(rs.getString("timings"));
				lblValue_4.setText(String.valueOf(rs.getFloat("avg_rat")));
				rid=rs.getInt("rest_id");
				Image img=new ImageIcon(this.getClass().getResource(imgdisp)).getImage();
				label.setIcon(new ImageIcon(img));
				
				
			}
			
			PreparedStatement ps1=con.prepareStatement("select avg_for1,avg_for2 from budget where r_id=?");
			ps1.setInt(1,rid);
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next())
			{
				String av1="Rs. "+String.valueOf(rs1.getInt("avg_for1"));
				String av2="Rs. "+String.valueOf(rs1.getInt("avg_for2"));
				lblApprox.setText(av1);
				lblValue.setText(av2);
			}
			
			PreparedStatement ps2=con.prepareStatement("select locality,city,state,pincode from region where res_id=?");
			ps2.setInt(1,rid);
			ResultSet rs2 = ps2.executeQuery();
			
			if(rs2.next())
			{
				String addr=rs2.getString("locality")+", "+rs2.getString("city");
				String addr1=rs2.getString("state")+", "+String.valueOf(rs2.getInt("pincode"));
				lblValue_2.setText(addr);
				lblValue_3.setText(addr1);
			}
			
			PreparedStatement ps3=con.prepareStatement("select review from ratings where re_id=?");
			ps3.setInt(1,rid);
			ResultSet rs3 = ps3.executeQuery();
			
			if(rs3.next())
			{
				lblRv.setText(rs3.getString("review"));
			}
			
			if(rs3.next())
			{
				lblRv_1.setText(rs3.getString("review"));
			}
			
			
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
