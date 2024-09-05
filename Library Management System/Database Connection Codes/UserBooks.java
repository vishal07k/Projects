package com.itep.library;
import javax.swing.*;
import java.sql.*;
public class UserBooks extends JFrame{
	static String path = "jdbc:mysql://localhost:3306/LMS";

	private int bookId;
	private String bookName;
	private String bookAouthor;
	private String bookGetDate;
	
	private String email;
	public UserBooks(String email) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			
			Statement st=con.createStatement();
			
			ResultSet rs1=st.executeQuery("select book_getdate,book_id from user where email='"+email+"'");
			if(rs1.next())
			{
				bookGetDate=rs1.getString(1);
				bookId=rs1.getInt(2);
				
			}
			
			if(bookId!=0)
			{
			ResultSet rs=st.executeQuery("select book_name,book_aouthor from book where book_id="+bookId);
			if(rs.next())
			{
				bookName=rs.getString(1);
				bookAouthor=rs.getString(2);
				
				
			}
				System.out.println(email+" "+bookName+" "+bookAouthor+" "+bookGetDate+" "+bookId);		
			}
			else
			{
				System.out.println("User had no book granted!");
			}
			
			}catch(Exception e)
		{
			System.out.println(e);
		}
		
		String data[][]= {{""+bookId,bookName,bookAouthor,bookGetDate,"10 days"}};
		String column[] = { "Book Id", "Book Name", "Book Aouthor","Book Assign Date","Book Submit days"};
		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		setSize(800, 400);
		setLocation(150,150);
		setVisible(true);
		setTitle("All Books");
	}

	public static void main(String[] args) {
		
		new UserBooks("kartikkarle@gmail.com");
	}

}
