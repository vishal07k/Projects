package com.itep.library;

import java.sql.*;

import javax.swing.JOptionPane;

public class ForgotPassword {

	public ForgotPassword() {

	}

	static String path = "jdbc:mysql://localhost:3306/LMS";
	private String dob = null;
	private String dob1 = null;
	private String email = null;
	private String password = null;
	private String phone = null;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ForgotPassword(String dob, String email, String phone) {
		super();
		this.dob = dob;
		this.email = email;
		this.phone = phone;
	}

	public void getPass() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();

			
					ResultSet rs = st.executeQuery("select dob from admin where email ='" + email + "' and phone='" + phone + "'");
					if (rs.next()) {
						dob1 = rs.getString(1);
						System.out.println(dob);
						rs.close();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid email or phone !");
					}
					if (dob.equals(dob1)) {
						ResultSet rs1 = st.executeQuery("select password from admin where dob ='" + dob + "'");
						if (rs1.next()) {
							password = rs1.getString(1);
							JOptionPane.showMessageDialog(null, "Your Password :" + password);
							rs1.close();
						} else {
							JOptionPane.showMessageDialog(null, "Please Check Date Of Birth !");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please Check Date !");
					}
				

			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void getPassUser()
	{
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(path, "root", "Root@123");
			Statement st = con.createStatement();

			
					ResultSet rs = st.executeQuery("select u_dob from user where email ='" + email + "' and u_phone='" + phone + "'");
					if (rs.next()) {
						dob1 = rs.getString(1);
						//System.out.println(dob);
						rs.close();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid email or phone !");
					}
					if (dob.equals(dob1)) {
						ResultSet rs1 = st.executeQuery("select u_password from user where u_dob ='" + dob + "'");
						if (rs1.next()) {
							password = rs1.getString(1);
							JOptionPane.showMessageDialog(null, "Your Password :" + password);
							rs1.close();
						} else {
							JOptionPane.showMessageDialog(null, "Please Check Date Of Birth !");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please Check Date !");
					}
				

			st.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	public static void main(String[] args) {
		ForgotPassword f = new ForgotPassword();
		f.setEmail("khamkarvishal6@gmail.com");
		f.setPhone("9373971472");
		f.getPass();
	}

}
