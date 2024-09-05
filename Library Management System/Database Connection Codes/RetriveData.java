package com.itep.library;

import java.sql.*;

import javax.swing.JOptionPane;

public class RetriveData {

	static String path = "jdbc:mysql://localhost:3306/LMS";
	private String userEmail;
	private String userName;
	private String userPhone;
	private String userBookDate;
	private int userBookId;
	
	private String bookName;
	private int blockId;
	
	
	public RetriveData(String userEmail, String userName, String userPhone, String userBookDate, int userBookId,
			String bookName, int blockId) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userBookDate = userBookDate;
		this.userBookId = userBookId;
		this.bookName = bookName;
		this.blockId = blockId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserBookDate() {
		return userBookDate;
	}

	public void setUserBookDate(String userBookDate) {
		this.userBookDate = userBookDate;
	}

	public int getUserBookId() {
		return userBookId;
	}

	public void setUserBookId(int userBookId) {
		this.userBookId = userBookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public RetriveData() {
		
	}

	public void retriveData()
	{
		
		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery("select u_name,u_phone,book_id,book_getdate from user where email='"+userEmail+"'");
			if(rs.next())
			{
				userName=rs.getString(1);
				userPhone=rs.getString(2);
				
				userBookId=rs.getInt(3);
				userBookDate=rs.getString(4);
			}
			System.out.println(userName+" "+userPhone+" "+userBookDate+" "+userBookId);
			
			ResultSet rs1=st.executeQuery("select book_name from book where book_id="+userBookId);
		
			if(rs1.next())
			{
			bookName=rs1.getString(1);
			
			}
			System.out.println(bookName+" ");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void updateData() {
		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			
			if(userBookId!=0)
			{
			
			int r=st.executeUpdate("update user set book_id=null, book_getdate=null,book_submitdate=(select current_date()) where u_phone='"+userPhone+"'");
			if(r==1)
			{
				System.out.println("Data updated");
			}
			System.out.println(blockId+" "+userBookId);
			int k=st.executeUpdate("update book set isavailable=true, block_id="+blockId+" where book_id="+userBookId);
			if(k==1)
			{
				System.out.println("update book");
			}
			ResultSet rs=st.executeQuery("select block_containt from location_block where block_id="+blockId);
			int size=0;
			if(rs.next())
			{
				size=rs.getInt(1);
			}
			System.out.println(size);
			int l=st.executeUpdate("update location_block set block_containt="+(size+1)+" where block_id="+blockId+"");
			if(l==1 && k==1 && r==1)
			{
				JOptionPane.showMessageDialog(null,"Data retrived successfully !");
			}
			}else
			{
				JOptionPane.showMessageDialog(null,"User Not have any book !");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
	}
	public static void main(String[] args) {
		
		RetriveData r=new RetriveData();
//		r.setUserEmail("roshniwaghmare@gmail.com");
//		r.retriveData();
//		r.setBlockId(101);
//		r.setUserBookId(1);
//		r.updateData();
		

	}

}
