package com.itep.library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{

	JLabel bgimg,title,l1,l2,l3,l4,l5,l6;
	JTextField t1,t3;
	JPasswordField t2,t4;
	JButton b1,b2,b3,b4;
	private static String userEmail;
	public Home()
	{
		setVisible(true);
		setSize(1500,800);
		getContentPane().setLayout(null);
		
		b2=new JButton("Forgot?");
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.WHITE);
		b2.setBounds(460,280,100,30);
		b2.addActionListener(this);
		getContentPane().add(b2);
		
		l3=new JLabel("OR");
		l3.setFont(new Font("Times New Roman",Font.ITALIC,20));
		l3.setForeground(Color.WHITE);
		l3.setBounds(400,530,30,30);
		getContentPane().add(l3);
		
		t1=new JTextField(50);
		t1.setBounds(300,150,270,40);
		t1.setBackground(Color.GRAY);
		t1.setFont(new Font("Times New Roman",Font.BOLD,20));
		t1.setForeground(Color.WHITE);
		getContentPane().add(t1);
		
		l3=new JLabel("OR");
		l3.setFont(new Font("Times New Roman",Font.ITALIC,20));
		l3.setForeground(Color.WHITE);
		l3.setBounds(400,280,30,30);
		getContentPane().add(l3);
		
		l1=new JLabel("User :");
		l1.setFont(new Font("Times New Roman",Font.BOLD,20));
		l1.setForeground(Color.white);
		l1.setBounds(150,150,200,40);
		getContentPane().add(l1);
		
		b1=new JButton("Log In");
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.WHITE);
		b1.setBounds(300,280,80,30);
		b1.addActionListener(this);
		getContentPane().add(b1);
		
		b3=new JButton("Log In");
		b3.setBackground(Color.GRAY);
		b3.setForeground(Color.WHITE);
		b3.setBounds(300,530,80,30);
		b3.addActionListener(this);
		getContentPane().add(b3);
		
		//setLocation(400,200);
		

		title =new JLabel("Library Management System");
		title.setFont(new Font("Bahnschrift",Font.BOLD,50));
		title.setForeground(Color.WHITE);
		title.setBounds(50,20,1000,80);
		getContentPane().add(title);
		
		l2=new JLabel("Password :");
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setForeground(Color.white);
		l2.setBounds(150,210,200,40);
		getContentPane().add(l2);
		
		t2=new JPasswordField(50);
		t2.setBounds(300,210,270,40);
		t2.setBackground(Color.GRAY);
		t2.setFont(new Font("Times New Roman",Font.BOLD,20));
		t2.setForeground(Color.WHITE);
		getContentPane().add(t2);
		
		l4=new JLabel("Admin :");
		l4.setFont(new Font("Times New Roman",Font.BOLD,20));
		l4.setForeground(Color.white);
		l4.setBounds(150,400,200,40);
		getContentPane().add(l4);
		
		t3=new JTextField(50);
		t3.setBounds(300,400,270,40);
		t3.setBackground(Color.GRAY);
		t3.setFont(new Font("Times New Roman",Font.BOLD,20));
		t3.setForeground(Color.WHITE);
		getContentPane().add(t3);
		
		l5=new JLabel("Password :");
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setForeground(Color.white);
		l5.setBounds(150,460,200,40);
		getContentPane().add(l5);
		
		t4=new JPasswordField(50);
		t4.setBounds(300,460,270,40);
		t4.setBackground(Color.GRAY);
		t4.setFont(new Font("Times New Roman",Font.BOLD,20));
		t4.setForeground(Color.WHITE);
		getContentPane().add(t4);
		
		b4=new JButton("Forgot?");
		b4.setBackground(Color.GRAY);
		b4.setForeground(Color.WHITE);
		b4.setBounds(460,530,100,30);
		b4.addActionListener(this);
		getContentPane().add(b4);
		
		
		
		
		ImageIcon i1=new ImageIcon("Home.jpg");
		Image img=i1.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i1=new ImageIcon(img);
		bgimg=new JLabel("",i1,JLabel.CENTER);
		bgimg.setBounds(0,0,1400,800);
		getContentPane().add(bgimg);
		
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b3)
		{
			
			String name=t3.getText();
			String password=t4.getText();
			Login l=new Login();
			int result=l.login(name, password);
			if(result==1)
			{
				new AdminHome();
				setVisible(false);
			}
			else if(result==-1)
			{
				JOptionPane.showMessageDialog(null,"Wrong user Name");
			}
			else if(result==2)
			{
				JOptionPane.showMessageDialog(null,"Wrong Password");
			}
		}
		if(ae.getSource()==b1)
		{
			
			String name=t1.getText();
			userEmail=name;
			String password=t2.getText();
			Login l=new Login();
			int result=l.loginUser(name, password);
			if(result==1)
			{
				new UserHome(userEmail);
				setVisible(false);
			}
			else if(result==-1)
			{
				JOptionPane.showMessageDialog(null,"Wrong user Name");
			}
			else if(result==2)
			{
				JOptionPane.showMessageDialog(null,"Wrong Password");
			}
		}
		if(ae.getSource()==b2)
		{
			new ForgotGUI();
		}
		if(ae.getSource()==b4)
		{
			new ForgotGUI();
		}
		
	}
	
	public static void main(String[] args) {
		new Home();

	}
	
}
