package com.itep.library;

import java.sql.*;
import java.util.Date;

import javax.swing.JOptionPane;

public class AssignBookData {

	private String name;
	private int bookId;
	private boolean isAvailable;
	private int location_id;
	private String block;

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	static String path = "jdbc:mysql://localhost:3306/LMS";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getLocation() {
		return location_id;
	}

	public void setLocation(int location) {
		this.location_id = location;
	}

	public AssignBookData(String name) {

		this.name = name;
		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select book_id,isavailable,block_id from book where book_name ='" + name + "'");
			if (rs.next()) {
				bookId = rs.getInt(1);
				isAvailable = rs.getBoolean(2);
				location_id = rs.getInt(3);
			}

			ResultSet rs1 = st
					.executeQuery("select block_name from location_block where block_id ='" + location_id + "'");
			if (rs1.next()) {
				block = rs1.getString(1);
			}

			// System.out.println(bookId);
			// System.out.println(isAvailable);
			// System.out.println(location_id);
			// System.out.println(block);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private String email1 = "";
	private String userName = "";
	private int userId = 0;
	private String userType = "";
	private int userbookId = 0;

	public void FetchUserData(String email) {
		this.email1 = email;

		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select u_id,u_name,u_type from user where email ='" + email1 + "'");
			if (rs.next()) {
				userId = rs.getInt(1);
				userName = rs.getString(2);
				userType = rs.getString(3);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserbookId() {
		return userbookId;
	}

	public void setUserbookId(int userbookId) {
		this.userbookId = userbookId;
	}

	public AssignBookData() {

	}

	private int blockId;
	private int blockContaint;

	public int getBlockContaint() {
		return blockContaint;
	}

	public void setBlockContaint(int blockContaint) {
		this.blockContaint = blockContaint;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	void AssignBook() {
		try {
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			PreparedStatement st = con
					.prepareStatement("update user set book_id=? ,book_getdate=(select current_date()) where u_id=?");
			PreparedStatement st1 = con.prepareStatement("update book set isavailable=? where book_id=?");
			PreparedStatement st3 = con.prepareStatement("update location_block set block_containt=? where block_id=?");
			PreparedStatement st4 = con.prepareStatement("select block_id from book where book_id=?");
			PreparedStatement st5 = con.prepareStatement("select block_containt from location_block where block_id=?");

			st.setInt(1, bookId);
			Date d = new Date();
			st.setInt(2, userId);

			PreparedStatement st2 = con.prepareStatement("select book_id from user where u_id=?");
			st2.setInt(1, userId);
			ResultSet r = st2.executeQuery();
			int bId = 0;
			if (r.next()) {
				bId = r.getInt(1);
			}

			if (bId == 0) {
				int i = st.executeUpdate();
				System.out.println(i);

				st1.setBoolean(1, false);
				st1.setInt(2, bookId);
				int j = st1.executeUpdate();
				System.out.println(j);

				st4.setInt(1, bookId);
				ResultSet rs = st4.executeQuery();
				if (rs.next()) {
					blockId = rs.getInt(1);
					System.out.println(blockId);
				}
				st5.setInt(1, blockId);
				ResultSet rs1 = st5.executeQuery();
				if (rs1.next()) {
					blockContaint = rs1.getInt(1);
					System.out.println(blockContaint);
				}
				rs.close();
				rs1.close();

				st3.setInt(1, (blockContaint - 1));
				st3.setInt(2, blockId);
				int k = st3.executeUpdate();
				JOptionPane.showMessageDialog(null,
						"Book: " + bookId + " Assigned to UserID: " + userId + " successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "User had already one book");
			}

			st.close();
			st1.close();
			st5.close();
			st3.close();
			st4.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {

		// new AssignBookData("Java");
		AssignBookData a = new AssignBookData();
		a.setBookId(1001);
		a.setUserId(1200);
		a.AssignBook();
	}

}
