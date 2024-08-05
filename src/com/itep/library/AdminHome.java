package com.itep.library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AdminHome extends JFrame implements ActionListener{

	JLabel bgimg;
	JTextArea header;
	JButton abook,UpdateBooks,AddUser,UpdateUser,view,edit,logOut;
	JMenu menu, submenu;  
    
	public AdminHome() {
		
		setVisible(true);
		setSize(500,500);
		setLayout(null);
		
				
		JMenuBar mb=new JMenuBar();  
        menu=new JMenu("MENU"); 
        abook=new JButton("Add Books");
        abook.setBackground(Color.white);
        abook.addActionListener(this);
        UpdateBooks=new JButton("UpdateBook");
        UpdateBooks.setBackground(Color.white);
        UpdateBooks.addActionListener(this);
        AddUser=new JButton("AddUser");
        AddUser.setBackground(Color.white);
        AddUser.addActionListener(this);
        UpdateUser=new JButton("UpdateUser");
        UpdateUser.setBackground(Color.white);
        UpdateUser.addActionListener(this);
        view=new JButton("View    ");
        view.setBackground(Color.white);
        view.addActionListener(this);
        edit=new JButton("Edit    ");
        edit.setBackground(Color.white);
        edit.addActionListener(this);
        logOut=new JButton("LogOut");
        logOut.setBackground(Color.white);
        logOut.addActionListener(this);
        
        submenu=new JMenu("Profile");  
        submenu.add(view); 
        submenu.add(edit); 
        submenu.add(logOut);
          
        menu.add(submenu);
        mb.add(menu); 
        mb.add(abook);
        mb.add(UpdateBooks);
        mb.add(AddUser);
        mb.add(UpdateUser);  
        mb.setBounds(10,10,1260,40);
       
		
        
        header=new JTextArea();
		header.setBounds(0,0,1400,60);
		header.setBackground(Color.lightGray);
		header.setEditable(false);
		
		
		
		ImageIcon i11=new ImageIcon("library.jpg");
		Image img=i11.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i11=new ImageIcon(img);
		bgimg=new JLabel("",i11,JLabel.CENTER);
		bgimg.setBounds(0,0,1400,800);
		add(bgimg);
		
		bgimg.add(mb);
		bgimg.add(header);
		
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==abook)
		{
			
			AddBook a=new AddBook();
			a.setLocation(100,150);
		
		}
	}
	
	public static void main(String[] args) {
		
		new AdminHome();
	}

}
