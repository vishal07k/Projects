package com.itep.library;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class deleteUser extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private String email;
	private String name;
	private DeleteUser u;

	public deleteUser() {
		getContentPane().setBackground(new Color(100, 149, 237));
		
		setVisible(true);
		setSize(600,200);
		setTitle("Delete User");
		setLocation(150,150);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField.setBackground(new Color(100, 149, 237));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBounds(228, 9, 185, 27);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(127, 12, 115, 21);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				email=textField.getText();
				u=new DeleteUser(email);
				textField_1.setText(""+u.getName());
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setBounds(427, 10, 117, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(41, 80, 115, 21);
		getContentPane().add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(100, 149, 237));
		textField_1.setBounds(137, 73, 235, 27);
		getContentPane().add(textField_1);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				u.deleteData();
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setBounds(397, 74, 117, 25);
		getContentPane().add(btnDelete);
		
	}

	public static void main(String[] args) {
		new deleteUser();
	}

}
