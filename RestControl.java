package dbs_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class RestControl {

	public String retCuisine()
	{
		String res=new String();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","evolve");
		  PreparedStatement ps1=con.prepareStatement("select unique cuisine from restaurant");
		  ResultSet rs1=ps1.executeQuery();
		  while(rs1.next())
		  {
			  String str=rs1.getString(1);
		   PreparedStatement ps=con.prepareStatement("select name from restaurant where cuisine=?");
           ps.setString(1,str);
           ResultSet rs=ps.executeQuery();
           res=res+str+"\n-----------------\n";
          while(rs.next())
          {
        	  res=res+rs.getString(1)+"\n";
          }
          res=res+"\n\n";
		  }
		  con.close();
         
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Error has occured");
		}
		return res;
	}
	public String retRegion()
	{
		String res=new String();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","evolve");
			PreparedStatement ps=con.prepareStatement("select unique city from region");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String str=rs.getString(1);
				String q="select name from restaurant,region where res_id=rest_id and city=?";
				PreparedStatement ps1=con.prepareStatement(q);
				ps1.setString(1,str);
				ResultSet rs1=ps1.executeQuery();
				res=res+str+"\n-----------------\n";
				while(rs1.next())
				{
					res=res+rs1.getString(1)+"\n";
				}
				res=res+"\n\n";
			}
			con.close();
		}
		catch (Exception e) {

			JOptionPane.showMessageDialog(null,"Error has occured");
		}
		return res;
	}
	public void addRate(String res,int r,String rev)
	{
		int id=0;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","evolve");
		String q="select rest_id from restaurant where name=?";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1,res);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		id=rs.getInt(1);
		}
		q="insert into ratings values (?,?,?)";
		ps=con.prepareStatement(q);
		ps.setInt(1,id);
		ps.setInt(2,r);
		ps.setString(3,rev);
		ps.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"An error has occured");
		}
	}
}
