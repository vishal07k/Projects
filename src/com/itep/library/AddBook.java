package com.itep.library;

import java.awt.Image;

import javax.swing.*;
public class AddBook extends JFrame{
	
	public AddBook()
	{
		setVisible(true);
		setSize(400,400);
		
		
		
		ImageIcon i1=new ImageIcon("books.jpg");
		Image img1=i1.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i1=new ImageIcon(img1);
		JLabel img=new JLabel("",i1,JLabel.CENTER);
		img.setBounds(0,0,1400,800);
		add(img);
		
	}

	public static void main(String[] args) {
		
		new AddBook();
	}

}
