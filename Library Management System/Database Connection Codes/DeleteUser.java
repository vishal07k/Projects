package com.itep.library;

import java.sql.*;

import javax.swing.JOptionPane;
public class DeleteUser {

	private String email;
	private String name;
	private int userId;
	static String path = "jdbc:mysql://localhost:3306/LMS";
	public DeleteUser(String email) {
		this.email=email;
		
		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			
			ResultSet rs=st.executeQuery("select u_id,u_name from user where email='"+email+"'");
			if(rs.next())
			{
				userId=rs.getInt(1);
				name=rs.getString(2);
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception :"+e);
		}
		
	}
	
	void deleteData()
	{try {
		Connection con = DriverManager.getConnection(path, "root", "Root@123");
		Statement st = con.createStatement();
		
		int a=st.executeUpdate("delete from user where u_id="+userId);
		if(a==1)
		{
			JOptionPane.showMessageDialog(null,"Record deleted successfully !");
		}
	}catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Exception :"+e);
	}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
