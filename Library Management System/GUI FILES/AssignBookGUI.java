package com.itep.library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AssignBookGUI extends JFrame{
	private JTextField txtEnterBookName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtEnterUserEmail;
	private JButton btnNewButton_1;
	private JTextField textField_5;
	private JLabel lblUserId;
	private JTextField textField_6;
	private JLabel lblUserName;
	private JTextField textField_7;
	private JLabel lblUserEmail;
	private JTextField textField_8;
	private JLabel lblBookId_1;
	private JButton btnAssignBook;
	private JButton btnClear;
	private boolean available;
	private JButton btnBack;

	public AssignBookGUI() {
		getContentPane().setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		getContentPane().setBackground(new Color(64, 224, 208));
		
		
		setVisible(true);
		setSize(800,400);
		setTitle("Assign Book");
		
		getContentPane().setLayout(null);
		
		txtEnterBookName = new JTextField();
		txtEnterBookName.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		txtEnterBookName.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtEnterBookName.setText("");
			}
		});
		txtEnterBookName.setForeground(new Color(255, 255, 255));
		txtEnterBookName.setBackground(new Color(128, 128, 128));
		txtEnterBookName.setText("  Enter Book Name");
		txtEnterBookName.setBounds(28, 41, 161, 29);
		getContentPane().add(txtEnterBookName);
		txtEnterBookName.setColumns(10);
		
		JButton btnNewButton = new JButton(" Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=txtEnterBookName.getText();
				AssignBookData a=new AssignBookData(name);
				if(a.getBookId()!=0) {
				textField.setText(""+a.getBookId());
				textField_1.setText(name);
				textField_2.setText(""+a.getBlock());
				available =a.isAvailable();
				if(available)
				{
					textField_3.setText("Available");
				}else if(!available)
				{
					textField_3.setText("Not Available");
				}
				}else {
					JOptionPane.showMessageDialog(null,"Please Enter valid Book Name");
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(211, 43, 117, 25);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField.setBounds(161, 102, 167, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(161, 147, 167, 33);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(161, 192, 167, 33);
		getContentPane().add(textField_2);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setForeground(new Color(0, 128, 128));
		lblBookId.setBounds(28, 106, 78, 24);
		getContentPane().add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setForeground(new Color(0, 128, 128));
		lblBookName.setBounds(29, 151, 101, 24);
		getContentPane().add(lblBookName);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(new Color(0, 128, 128));
		lblLocation.setBounds(28, 201, 78, 24);
		getContentPane().add(lblLocation);
		
		JLabel lblIsAvailable = new JLabel(" Is Available");
		lblIsAvailable.setForeground(new Color(0, 128, 128));
		lblIsAvailable.setBounds(28, 239, 102, 38);
		getContentPane().add(lblIsAvailable);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(161, 242, 167, 33);
		getContentPane().add(textField_3);
		
		txtEnterUserEmail = new JTextField();
		txtEnterUserEmail.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		txtEnterUserEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtEnterUserEmail.setText("");
			}
		});
		txtEnterUserEmail.setText("  Enter User Email");
		txtEnterUserEmail.setForeground(Color.WHITE);
		txtEnterUserEmail.setColumns(10);
		txtEnterUserEmail.setBackground(Color.GRAY);
		txtEnterUserEmail.setBounds(417, 41, 161, 29);
		getContentPane().add(txtEnterUserEmail);
		
		btnNewButton_1 = new JButton(" Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String emil=txtEnterUserEmail.getText();
				AssignBookData a=new AssignBookData();
				a.FetchUserData(emil);
				if(a.getUserId()!=0)
				{
				textField_5.setText(""+a.getUserId());
				textField_6.setText(""+a.getUserName());
				textField_7.setText(""+a.getUserType());
				textField_8.setText(textField.getText());
				}
				else {
					JOptionPane.showMessageDialog(null,"User not found !");
				}
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(600, 43, 117, 25);
		getContentPane().add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(550, 102, 167, 33);
		getContentPane().add(textField_5);
		
		lblUserId = new JLabel("User Id");
		lblUserId.setForeground(new Color(0, 128, 128));
		lblUserId.setBounds(417, 106, 78, 24);
		getContentPane().add(lblUserId);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(549, 147, 167, 33);
		getContentPane().add(textField_6);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(0, 128, 128));
		lblUserName.setBounds(417, 151, 101, 24);
		getContentPane().add(lblUserName);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(550, 192, 167, 33);
		getContentPane().add(textField_7);
		
		lblUserEmail = new JLabel("User Type");
		lblUserEmail.setForeground(new Color(0, 128, 128));
		lblUserEmail.setBounds(417, 201, 78, 24);
		getContentPane().add(lblUserEmail);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Abyssinica SIL", Font.BOLD, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(550, 242, 167, 33);
		getContentPane().add(textField_8);
		
		lblBookId_1 = new JLabel("Book ID");
		lblBookId_1.setForeground(new Color(0, 128, 128));
		lblBookId_1.setBounds(417, 239, 102, 38);
		getContentPane().add(lblBookId_1);
		
		btnAssignBook = new JButton("Assign Book");
		btnAssignBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("") || textField_8.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Fill all Fields");
				}
				else
				{
				AssignBookData a=new AssignBookData();
				a.setBookId(Integer.parseInt(textField_8.getText()));
				a.setUserId(Integer.parseInt(textField_5.getText()));
				a.AssignBook();
				}
			}
		});
		btnAssignBook.setBackground(new Color(128, 128, 128));
		btnAssignBook.setForeground(new Color(255, 255, 255));
		btnAssignBook.setBounds(262, 302, 144, 38);
		getContentPane().add(btnAssignBook);
		
		btnClear = new JButton(" Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
			}
		});
		btnClear.setBackground(new Color(128, 128, 128));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(434, 302, 144, 38);
		getContentPane().add(btnClear);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(28, 12, 117, 25);
		getContentPane().add(btnBack);
	}
	public static void main(String[] args) {
		
		new AssignBookGUI();

	}
}
