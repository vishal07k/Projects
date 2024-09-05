package com.itep.library;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgotGUI extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    private String dob="";
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
	public ForgotGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setVisible(true);
		//setSize(500,500);
		getContentPane().setBackground(new Color(176, 224, 230));
		setBackground(new Color(224, 255, 255));
		
		setVisible(true);
		setSize(400,400);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(192, 39, 144, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Email");
		lblNewLabel.setBounds(50, 39, 109, 30);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 79, 144, 32);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Mobile");
		lblNewLabel_1.setBounds(50, 83, 109, 23);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter DOB");
		lblNewLabel_2.setBounds(50, 158, 109, 28);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(192, 157, 144, 32);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Admin");
		rdbtnNewRadioButton.setBounds(50, 126, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("User");
		rdbtnNewRadioButton_1.setBounds(192, 126, 144, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JButton btnGivePassword = new JButton("Give Password");
		btnGivePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter Email");
				}
				else {
					if(textField_1.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Enter Phone number");
					}
					else {
				if(rdbtnNewRadioButton.isSelected())
				{
					ForgotPassword f=new ForgotPassword();
					f.setEmail(textField.getText());
					f.setPhone(textField_1.getText());
					f.setDob(textField_2.getText());
					
						
					f.getPass();
						}
				else if(rdbtnNewRadioButton_1.isSelected())
				{
					ForgotPassword f1=new ForgotPassword();
					f1.setEmail(textField.getText());
					f1.setPhone(textField_1.getText());
					f1.setDob(textField_2.getText());
					
						
					f1.getPassUser();
				}
				else {
					JOptionPane.showMessageDialog(null, "Plese select Admin Or User");
				}
					}
					
				}
				
			}
		});
		btnGivePassword.setFont(new Font("Dialog", Font.BOLD, 10));
		btnGivePassword.setBounds(200, 214, 117, 25);
		getContentPane().add(btnGivePassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(73, 212, 83, 26);
		getContentPane().add(btnBack);
	}
		public static void main(String []args) {
			
			new ForgotGUI();
			
		}
}
