package com.itep.library;

import java.sql.*;

public class BookAdd {

	private int bookId, bookLocation;
	private String bookName, bookAouthor;
	int id = 0;

	public BookAdd() {
		bookId = 0;
		bookName = null;
		bookAouthor = null;
		bookLocation = 0;
	}

	public BookAdd(int id, String name, String aouthor, int location) {
		bookId = id;
		bookName = name;
		bookAouthor = aouthor;
		bookLocation = location;
	}

	public int insertData() {

		int size = 0, max = 0;
		try {
			String path = "jdbc:mysql://localhost:3306/LMS";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select block_containt from location_block where block_id="+bookLocation);
			if (rs.next()) {
				size = rs.getInt(1);
				size += 1;
			}
			rs.close();
			
			ResultSet rs1 = st.executeQuery("select block_size from location_block where block_id="+bookLocation);
			if (rs1.next()) {
				max = rs1.getInt(1);
			}
			rs1.close();
			
			if (size<max) {
				st.executeUpdate("insert into book values(" + bookId + ",'" + bookName + "','" + bookAouthor+ "',(select current_date),1,'" + bookLocation + "')");
			} else {
				rs.close();
				st.close();
				con.close();
				return 5;
			}

			st.executeUpdate("update location_block set block_containt=" + size + " where block_id=" + bookLocation);
			rs.close();
			st.close();
			con.close();
			return 1;

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	int getId() {
		
		try {
			String path = "jdbc:mysql://localhost:3306/LMS";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(book_id) from book");
			if (rs.next()) {
				id = Integer.parseInt(rs.getString(1));
			}
			
			rs.close();
			st.close();
			con.close();
			return (id+1);		
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return -1;
	}

	public static void main(String[] args) {
		BookAdd b1 = new BookAdd();

		int id = b1.getId();
		System.out.println(id);

		BookAdd b2 = new BookAdd(id, "by", "ram", 101);
		int re = b2.insertData();
		if (re == 1) {
			System.out.println("Inserted");
		} else {
			System.out.println("error");
		}
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation(int bookLocation) {
		this.bookLocation = bookLocation;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAouthor() {
		return bookAouthor;
	}

	public void setBookAouthor(String bookAouthor) {
		this.bookAouthor = bookAouthor;
	}

}
