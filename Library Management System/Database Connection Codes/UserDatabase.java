package com.itep.library;

import java.sql.*;

import javax.swing.JOptionPane;


public class UserDatabase {
	static String path="jdbc:mysql://localhost:3306/LMS";
	User u;
	public UserDatabase(User u) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(path,"root","Root@123");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into user values("+u.getUserId()+",'"+u.getUserName()+"','"+u.getUserEmail()+"','"+u.getUserPhone()+"','"+u.getUserPassword()+"','"+u.getUserDob()+"','"+u.getUserAddress()+"','"+u.getUserType()+"','"+u.getUserGender()+"',null,null,null)");
			if(i!=0)
			{
				JOptionPane.showMessageDialog(null, "User Added successfully !");
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Exception :"+e);
		}
	}

	public static void main(String[] args) {
		

	}

}
