package com.itep.library;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShowBooks extends JFrame {

	public ShowBooks() {
		FetchBooks f=new FetchBooks();
		String data[][] =f.getData();
		String column[] = { "Book Id", "Book Name", "Book Aouthor","Is Book Available" ,"Book Location"};
		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		setSize(800, 400);
		setLocation(150,150);
		setVisible(true);
		setTitle("All Books");
	}

	public static void main(String []args)
	{
		new ShowBooks();
		
	}
}
