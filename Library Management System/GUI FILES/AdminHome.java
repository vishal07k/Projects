package com.itep.library;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AdminHome extends JFrame implements ActionListener{

	JLabel bgimg;
	JTextArea header;
	JMenuItem abook,assignBooks,AddUser,retriveBook,view,edit,logOut,showBooks,deleteUser;
	JMenu menu, submenu;  
    
	public AdminHome() {
		
		setVisible(true);
		setSize(500,500);
		getContentPane().setLayout(null);
		
		
		
				
		JMenuBar mb=new JMenuBar();  
		
        menu=new JMenu("MENU"); 
        abook=new JMenuItem("Add Books");
        abook.setBackground(Color.white);
        abook.addActionListener(this);
        assignBooks=new JMenuItem("assignBook");
        assignBooks.setBackground(Color.white);
        assignBooks.addActionListener(this);
        AddUser=new JMenuItem("AddUser");
        AddUser.setBackground(Color.white);
        AddUser.addActionListener(this);
        retriveBook=new JMenuItem("retriveBook");
        retriveBook.setBackground(Color.white);
        retriveBook.addActionListener(this);
        showBooks=new JMenuItem("showBooks");
        showBooks.setBackground(Color.white);
        showBooks.addActionListener(this);
        deleteUser=new JMenuItem("Delete User");
        deleteUser.setBackground(Color.white);
        deleteUser.addActionListener(this);
        
//        view=new JMenuItem("View    ");
//        view.setBackground(Color.white);
//        view.addActionListener(this);
//        edit=new JMenuItem("Edit    ");
//        edit.setBackground(Color.white);
//        edit.addActionListener(this);
        logOut=new JMenuItem("LogOut");
        logOut.setBackground(Color.white);
        logOut.addActionListener(this);
        
        submenu=new JMenu("Profile");  
//        submenu.add(view); 
//        submenu.add(edit); 
        submenu.add(logOut);
          
        menu.add(submenu);
        mb.add(menu); 
        mb.add(abook);
        mb.add(assignBooks);
        mb.add(AddUser);
        mb.add(retriveBook);
        mb.add(showBooks); 
        mb.add(deleteUser);
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
		getContentPane().add(bgimg);
		
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
		if(ae.getSource()==assignBooks)
		{
			
			AssignBookGUI a=new AssignBookGUI();
			a.setLocation(100,150);
		
		}
		if(ae.getSource()==showBooks)
		{
			
			new ShowBooks();
					
		}
		if(ae.getSource()==AddUser)
		{
			
			new AddUser();
			
					
		}
		if(ae.getSource()==retriveBook)
		{
			
			new RetriveBook();
			
					
		}
		if(ae.getSource()==deleteUser)
		{
			
			new deleteUser();
			
					
		}
		if(ae.getSource()==logOut)
		{
			setVisible(false);
			new Home();
		}
	}
	
	public static void main(String[] args) {
		
		new AdminHome();
	}
}
