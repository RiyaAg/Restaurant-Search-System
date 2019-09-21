package dbs_project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class User_validation {
	
	
	public static boolean login(int id,String password) {
		
		boolean loggedin=false;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			PreparedStatement ps=con.prepareStatement("select * from login where u_id=? and passkey=?");
			ps.setInt(1, id);

	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	       loggedin=rs.next();
	      

	        ps.close();
	        con.close();
		}
		catch(Exception e) {
				System.out.println(e);
			}
		return loggedin;
	}
	
	public static int save1(int id, String fname, String lname, String dob) {
		
		int i=0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?, to_date(?,'dd-mm-yyyy'))");
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, dob);
			i=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}
	
	public static int save2(String local, String cty, String st, int pcode, int id) {
		
		int j=0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			PreparedStatement ps=con.prepareStatement("insert into user_region values(?,?,?,?,?)");
			ps.setInt(1, pcode);
			ps.setString(2, local);
			ps.setString(3, cty);
			ps.setString(4, st);
			ps.setInt(5, id);
			j=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return j;
	}
	
	public static int save3(int id, String pkey) {
		
		int k=0;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
			PreparedStatement ps=con.prepareStatement("insert into login values(?,?)");
			ps.setInt(1, id);
			ps.setString(2, pkey);
		
			k=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return k;
	}

}
