package com.itep.library;
import java.awt.*;
import javax.swing.*;
public class AdminHome extends JFrame{

	JLabel bgimg;
	JTextArea header;
	JMenu menu, submenu,abook,UpdateBooks,AddUser,UpdateUser;  
    JMenuItem i1, i2, i3, i4, i5;  
	public AdminHome() {
		
		setVisible(true);
		setSize(500,500);
		setLayout(null);
		
				
		JMenuBar mb=new JMenuBar();  
        menu=new JMenu("::"); 
        abook=new JMenu("Add Books");
        UpdateBooks=new JMenu("UpdateBook");
        AddUser=new JMenu("AddUser");
        UpdateUser=new JMenu("UpdateUser");
        submenu=new JMenu("Sub Menu");  
        i1=new JMenuItem("Item 1");  
        i2=new JMenuItem("Item 2");  
        i3=new JMenuItem("Item 3");  
        i4=new JMenuItem("Item 4");  
        i5=new JMenuItem("Item 5"); 
        
        menu.add(i1); 
        menu.add(i2); 
        menu.add(i3);  
        submenu.add(i4); 
        submenu.add(i5);  
        menu.add(submenu);
        mb.add(menu); 
        mb.add(abook);
        mb.add(UpdateBooks);
        mb.add(AddUser);
        mb.add(UpdateUser);  
        mb.setBounds(10,10,1260,40);
        //add(mb);
		
        
        header=new JTextArea();
		header.setBounds(0,0,1400,60);
		header.setBackground(Color.lightGray);
		header.setEditable(false);
		//add(header);
		
		
		ImageIcon i11=new ImageIcon("library.jpg");
		Image img=i11.getImage().getScaledInstance(1400,800,Image.SCALE_SMOOTH);
		i11=new ImageIcon(img);
		bgimg=new JLabel("",i11,JLabel.CENTER);
		bgimg.setBounds(0,0,1400,800);
		add(bgimg);
		
		bgimg.add(mb);
		bgimg.add(header);
		
		
	}

	public static void main(String[] args) {
		
		new AdminHome();
	}

}
