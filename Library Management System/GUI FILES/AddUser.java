package com.itep.library;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	JButton btnAddData;
	JDateChooser dateChooser;
	JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_1_1, rdbtnNewRadioButton_1_2,
			rdbtnStudent;

	private String userName;
	private String userEmail;
	private String userPhone;
	private String userDob;
	private String userGender;
	private String userType;
	private String userPassword;
	private String userAddress;
	private JTextField textField_3;

	public AddUser() {
		getContentPane().setForeground(SystemColor.controlLtHighlight);
		getContentPane().setBackground(SystemColor.desktop);
		
		setVisible(true);
		setSize(800,600);
		setTitle("Add User");
		setLocation(150,100);
		getContentPane().setLayout(null);
		
		JLabel lblEnterUserName = new JLabel("Enter User Name:");
		lblEnterUserName.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblEnterUserName.setForeground(SystemColor.controlLtHighlight);
		lblEnterUserName.setBounds(218, 27, 153, 41);
		getContentPane().add(lblEnterUserName);
		
		textField = new JTextField();
		textField.setFont(new Font("C059", Font.BOLD, 14));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(SystemColor.desktop);
		textField.setBounds(389, 27, 236, 41);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterEmail = new JLabel("Enter Email");
		lblEnterEmail.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblEnterEmail.setForeground(SystemColor.controlLtHighlight);
		lblEnterEmail.setBounds(218, 80, 153, 41);
		getContentPane().add(lblEnterEmail);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("C059", Font.BOLD, 14));
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBackground(SystemColor.desktop);
		textField_1.setColumns(10);
		textField_1.setBounds(389, 80, 236, 41);
		getContentPane().add(textField_1);
		
		JLabel lblEnterPhone = new JLabel("Enter Phone");
		lblEnterPhone.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblEnterPhone.setForeground(SystemColor.controlLtHighlight);
		lblEnterPhone.setBounds(218, 133, 153, 41);
		getContentPane().add(lblEnterPhone);
		
		JLabel lblSelectGender = new JLabel("Select Gender :");
		lblSelectGender.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblSelectGender.setForeground(SystemColor.controlLtHighlight);
		lblSelectGender.setBounds(218, 239, 136, 41);
		getContentPane().add(lblSelectGender);
		
		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblCreatePassword.setForeground(SystemColor.controlLtHighlight);
		lblCreatePassword.setBounds(218, 391, 136, 41);
		getContentPane().add(lblCreatePassword);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("C059", Font.BOLD, 14));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(SystemColor.desktop);
		textField_4.setColumns(10);
		textField_4.setBounds(389, 391, 236, 41);
		getContentPane().add(textField_4);
		
		JLabel lblConfermPassword = new JLabel("Conferm Password");
		lblConfermPassword.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblConfermPassword.setForeground(SystemColor.controlLtHighlight);
		lblConfermPassword.setBounds(218, 444, 136, 41);
		getContentPane().add(lblConfermPassword);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("C059", Font.BOLD, 14));
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setBackground(SystemColor.desktop);
		textField_5.setColumns(10);
		textField_5.setBounds(389, 444, 236, 41);
		getContentPane().add(textField_5);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(SystemColor.controlLtHighlight);
		rdbtnNewRadioButton.setBackground(SystemColor.desktop);
		rdbtnNewRadioButton.setBounds(384, 239, 70, 41);
		getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setForeground(SystemColor.controlLtHighlight);
		rdbtnNewRadioButton_1.setBackground(SystemColor.desktop);
		rdbtnNewRadioButton_1.setBounds(458, 239, 81, 41);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1_1 = new JRadioButton("Other");
		rdbtnNewRadioButton_1_1.setForeground(SystemColor.controlLtHighlight);
		rdbtnNewRadioButton_1_1.setBackground(SystemColor.desktop);
		rdbtnNewRadioButton_1_1.setBounds(544, 239, 81, 41);
		getContentPane().add(rdbtnNewRadioButton_1_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_1_1);
		
		JLabel lblEnterUserName_4_1 = new JLabel("Select type");
		lblEnterUserName_4_1.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblEnterUserName_4_1.setForeground(SystemColor.controlLtHighlight);
		lblEnterUserName_4_1.setBounds(218, 279, 136, 41);
		getContentPane().add(lblEnterUserName_4_1);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setForeground(SystemColor.controlLtHighlight);
		rdbtnStudent.setBackground(SystemColor.desktop);
		rdbtnStudent.setBounds(384, 284, 100, 40);
		getContentPane().add(rdbtnStudent);
		
		rdbtnNewRadioButton_1_2 = new JRadioButton("Profesional");
		rdbtnNewRadioButton_1_2.setForeground(SystemColor.controlLtHighlight);
		rdbtnNewRadioButton_1_2.setBackground(SystemColor.desktop);
		rdbtnNewRadioButton_1_2.setBounds(488, 284, 127, 40);
		getContentPane().add(rdbtnNewRadioButton_1_2);
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(rdbtnStudent);
		bg1.add(rdbtnNewRadioButton_1_2);
		
		JLabel lblSelectDob = new JLabel("Select DOB");
		lblSelectDob.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblSelectDob.setForeground(SystemColor.controlLtHighlight);
		lblSelectDob.setBounds(218, 186, 136, 41);
		getContentPane().add(lblSelectDob);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(SystemColor.desktop);
		dateChooser.setBackground(new Color(255, 255, 255));
		dateChooser.setBounds(389, 186, 236, 41);
		getContentPane().add(dateChooser);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("C059", Font.BOLD, 14));
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBackground(SystemColor.desktop);
		textField_2.setColumns(10);
		textField_2.setBounds(389, 133, 236, 41);
		getContentPane().add(textField_2);
		
		btnAddData = new JButton("Add Data");
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
					
					userName=textField.getText();
					
					if(textField_1.getText().trim().contains("@gmail.com"))
					{
					userEmail=textField_1.getText();
					
					}else
					{
						userEmail=textField_1.getText().concat("@gmail.com");
					}
					
					userPhone=textField_2.getText();
					//System.out.println(userPhone.length());
					
					
					userAddress=textField_3.getText();
					
					
					
					
					
				
			if(ae.getSource()==btnAddData)
			{
				if(textField.getText().length()!=0)
				{
					if(textField_1.getText().length()!=0)
					{
						int length=textField_2.getText().trim().length();
						
						if(length==10)
						{
							if(rdbtnNewRadioButton.isSelected())
							{
								userGender="Male";
								
							}
							else if(rdbtnNewRadioButton_1.isSelected())
							{
								userGender="Female";
								
							}else if(rdbtnNewRadioButton_1_1.isSelected())
							{
								userGender="Other";
								
							}else
							{
								JOptionPane.showMessageDialog(null, "Please select Gender");
							}
							
							if(rdbtnStudent.isSelected())
							{
								userType="Student";
								
							}
							else if(rdbtnNewRadioButton_1_2.isSelected())
							{
								userType="Profesional";
								
							}else
							{
								JOptionPane.showMessageDialog(null, "Please select Type");
							}
							
							if(textField_3.getText().length()!=0) {
								
								if(textField_4.getText().equals(textField_5.getText()))
								{
									userPassword=textField_5.getText();
									SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
									userDob=dateFormat.format(dateChooser.getDate());
									
									User u=new User(userName, userEmail, userPhone, userDob, userGender, userType, userPassword, userAddress);
									UserDatabase ud=new UserDatabase(u);
								}else
								{
									JOptionPane.showMessageDialog(null, "Please check password ");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Please Enter Address");
							}
				
					
						}else
						{
							JOptionPane.showMessageDialog(null, "Please Enter valid phone");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter Email");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter name");
				}
				
				}
			
			
			}
			
		});
		btnAddData.setBackground(SystemColor.desktop);
		btnAddData.setForeground(SystemColor.controlLtHighlight);
		btnAddData.setBounds(285, 517, 117, 34);
		getContentPane().add(btnAddData);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				
			}
		});
		btnClear.setBackground(SystemColor.desktop);
		btnClear.setForeground(SystemColor.controlLtHighlight);
		btnClear.setBounds(422, 517, 117, 34);
		getContentPane().add(btnClear);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("C059", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.desktop);
		textField_3.setBounds(389, 338, 236, 41);
		getContentPane().add(textField_3);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(SystemColor.controlLtHighlight);
		lblAddress.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 14));
		lblAddress.setBounds(218, 338, 136, 41);
		getContentPane().add(lblAddress);
		
		
	}

	public static void main(String args[])
	{
		new AddUser();
	}
}
