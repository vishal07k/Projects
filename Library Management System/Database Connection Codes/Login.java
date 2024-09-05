package com.itep.library;
import java.sql.*;
public class Login {

	static private String name;
	static private String password;
	static String path="jdbc:mysql://localhost:3306/LMS";
	public static void main(String[] args) {
		
		Login l1=new Login();
		int result=l1.login("vishalk","Vishal@123");
		if(result==1)
		{
			new AdminHome();
		}
		else if(result==-1)
		{
			System.out.println("Wrong userName");
		}
		else if(result==2)
		{
			System.out.println("Wrong Password");
		}

	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public int insertData()
	{
		
		return 1;
	}

	int login(String name,String password)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(path,"root","Root@123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select password from admin where email ='"+name+"'");
			if(rs.next())
			{
				if(rs.getString("password").equals(password))
				{
					return 1;
					
				}
				else
				{
					
					return 2;
				}
			}else
			{
			
			return -1;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	int loginUser(String name,String password)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(path,"root","Root@123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select u_password from user where email ='"+name+"'");
			
			if(rs.next())
			{
				if(rs.getString("u_password").equals(password))
				{
					return 1;
					
				}
				else
				{
					
					return 2;
				}
			}else
			{
			
			return -1;
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
}
