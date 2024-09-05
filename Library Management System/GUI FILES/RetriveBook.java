package com.itep.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetriveBook extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox<Integer> comboBox;
	private String userEmail;
	private String userName;
	private String userPhone;
	private String userBookDate;
	private String bookName;
	private int blockId;
	private RetriveData r;
	public RetriveBook() {
		getContentPane().setBackground(new Color(51, 102, 153));
		setVisible(true);
		setSize(800,400);
		setTitle("Retrive Book");
		setLocation(150,150);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter User Email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblNewLabel.setBounds(186, 34, 133, 31);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(51, 102, 153));
		textField.setBounds(322, 31, 210, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userEmail=textField.getText();
				r=new RetriveData();
				r.setUserEmail(userEmail);
				r.retriveData();
				textField_1.setText(r.getUserName());
				textField_2.setText(r.getBookName());
				textField_3.setText(r.getUserBookDate());
				textField_4.setText(r.getUserPhone());
				
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 102, 153));
		btnNewButton.setBounds(549, 34, 117, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblUserName.setBounds(91, 94, 133, 31);
		getContentPane().add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(51, 102, 153));
		textField_1.setBounds(257, 91, 210, 31);
		getContentPane().add(textField_1);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setForeground(Color.WHITE);
		lblBookName.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblBookName.setBounds(91, 133, 133, 31);
		getContentPane().add(lblBookName);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(51, 102, 153));
		textField_2.setBounds(257, 130, 210, 31);
		getContentPane().add(textField_2);
		
		JLabel lblDateOfBook = new JLabel("Date of Book Assign");
		lblDateOfBook.setForeground(Color.WHITE);
		lblDateOfBook.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblDateOfBook.setBounds(91, 170, 148, 31);
		getContentPane().add(lblDateOfBook);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(51, 102, 153));
		textField_3.setBounds(257, 167, 210, 31);
		getContentPane().add(textField_3);
		
		JLabel lblUserPhone = new JLabel("User Phone");
		lblUserPhone.setForeground(Color.WHITE);
		lblUserPhone.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblUserPhone.setBounds(91, 209, 133, 31);
		getContentPane().add(lblUserPhone);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Bitstream Charter", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBackground(new Color(51, 102, 153));
		textField_4.setBounds(257, 206, 210, 31);
		getContentPane().add(textField_4);
		
		Integer bId[]= {101,102,103,104,105,106,107,108,109};
		comboBox = new JComboBox(bId);
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(51, 102, 153));
		comboBox.setBounds(257, 249, 210, 31);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4_1 = new JLabel("New Location");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("AnjaliOldLipi", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(91, 249, 133, 31);
		getContentPane().add(lblNewLabel_4_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(51, 102, 153));
		btnExit.setBounds(510, 209, 117, 25);
		getContentPane().add(btnExit);
		
		JButton btnRetrive = new JButton("Retrive");
		btnRetrive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				blockId=comboBox.getItemAt(comboBox.getSelectedIndex());
				r.setBlockId(blockId);
				r.updateData();
			}
		});
		btnRetrive.setForeground(Color.WHITE);
		btnRetrive.setBackground(new Color(51, 102, 153));
		btnRetrive.setBounds(510, 133, 117, 25);
		getContentPane().add(btnRetrive);
		
		JButton btnShowAllBooks = new JButton("Show All Books");
		btnShowAllBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ShowBooks();
			
			}
			
		});
		btnShowAllBooks.setForeground(Color.WHITE);
		btnShowAllBooks.setBackground(new Color(51, 102, 153));
		btnShowAllBooks.setBounds(495, 170, 148, 25);
		getContentPane().add(btnShowAllBooks);
	}

	public static void main(String[] args) {
	new RetriveBook();
	}
}
