package com.itep.library;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserHome extends JFrame implements ActionListener{

	private static String userEmail;
	JMenuItem myBooks,showBooks;
	
	public UserHome(String email) {
		this.userEmail=email;
		getContentPane().setBackground(new Color(255, 192, 203));
		
		setVisible(true);
		setSize(800,600);
		setTitle("User Home");
		getContentPane().setLayout(null);
		
		myBooks=new JMenuItem("My Books");
		myBooks.setBackground(Color.white);
		myBooks.addActionListener(this);
		
		showBooks=new JMenuItem("Show All Books");
		showBooks.setBackground(Color.white);
		showBooks.addActionListener(this);
		
		
		JMenuBar mb=new JMenuBar(); 
		mb.add(myBooks);
		mb.add(showBooks);
		mb.setBounds(10,10,260,40);
		add(mb);
		
		ImageIcon i11=new ImageIcon("library.jpg");
		Image img=i11.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i11=new ImageIcon(img);
		JLabel bgimg=new JLabel("",i11,JLabel.CENTER);
		bgimg.setBounds(0,0,1400,800);
		getContentPane().add(bgimg);
		
	}

	public static void main(String[] args) {
		new UserHome("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==myBooks)
		{
			new UserBooks(userEmail);
		}
		
		
		if(ae.getSource()==showBooks)
		{
			new ShowBooks();
		}
		
	}
}
