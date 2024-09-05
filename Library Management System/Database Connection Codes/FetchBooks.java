package com.itep.library;

import java.sql.*;

public class FetchBooks {

	private int BookId;
	private int maxBookId;
	private int minBookId;
	private String BookName;
	private String BookAouthor;
	private int BlockId;
	private boolean isAvailable;
	private String BookLocation;
	private String[][] data = new String[20][5];
	static int i = 1, j = 1;
	static String path = "jdbc:mysql://localhost:3306/LMS";

	public FetchBooks() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select min(book_id) from book");
			if (rs.next()) {
				minBookId = rs.getInt(1);
			}
			System.out.println(minBookId);

			Statement st1 = con.createStatement();
			ResultSet rs1 = st.executeQuery("select max(book_id) from book");
			if (rs1.next()) {
				maxBookId = rs1.getInt(1);
			}
			System.out.println(maxBookId);
			
			PreparedStatement ps = con.prepareStatement(
					"Select book_id,book_name,book_aouthor,isAvailable,block_id from book where book_id=?");
			
			ps.setInt(1, minBookId);
			for (i = minBookId; i <= maxBookId; i++) {

				
				ResultSet rs2 = ps.executeQuery();
				while (rs2.next()) {
					for (j = 0; j < 5; j++) {
						data[i][j] = rs2.getString(j+1);
					}
					
				}
				minBookId++;
				ps.setInt(1, minBookId);
			}

			for(i=1001;i<=maxBookId;i++)
			{
				for(j=0;j<5;j++)
				{
					System.out.print(" "+data[i][j]);
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String[][] getData() {

		return data;
	}

	public int getBookId() {
		return BookId;
	}

	public void setBookId(int bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookAouthor() {
		return BookAouthor;
	}

	public void setBookAouthor(String bookAouthor) {
		BookAouthor = bookAouthor;
	}

	public int getBlockId() {
		return BlockId;
	}

	public void setBlockId(int blockId) {
		BlockId = blockId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getBookLocation() {
		return BookLocation;
	}

	public void setBookLocation(String bookLocation) {
		BookLocation = bookLocation;
	}

	public static void main(String[] args) {
		new FetchBooks();
	}

}
