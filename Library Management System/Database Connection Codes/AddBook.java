package com.itep.library;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddBook extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t5;
	JButton b1, b2;
	JComboBox<Integer> t4;

	public AddBook() {
		setVisible(true);
		setSize(700, 400);
		setTitle("Add Books");
		// setResizable(false);

		ImageIcon i1 = new ImageIcon("books.jpg");
		Image img1 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH);
		i1 = new ImageIcon(img1);
		JLabel img = new JLabel("", i1, JLabel.CENTER);
		img.setBounds(0, 0, 1400, 800);
		add(img);

		l1 = new JLabel("Book Id      :");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setForeground(Color.white);
		l1.setBounds(50, 30, 250, 30);
		img.add(l1);

		t1 = new JTextField();
		t1.setBounds(330, 30, 270, 40);
		t1.setBackground(Color.GRAY);
		t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t1.setForeground(Color.WHITE);
		t1.setEditable(false);
		img.add(t1);

		l2 = new JLabel("Enter Book Name    :");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setForeground(Color.white);
		l2.setBounds(50, 90, 250, 30);
		img.add(l2);

		t2 = new JTextField();
		t2.setBounds(330, 90, 270, 40);
		t2.setBackground(Color.GRAY);
		t2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t2.setForeground(Color.WHITE);
		img.add(t2);

		l3 = new JLabel("Enter Book Aouthor :");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3.setForeground(Color.white);
		l3.setBounds(50, 150, 250, 30);
		img.add(l3);

		t3 = new JTextField();
		t3.setBounds(330, 150, 270, 40);
		t3.setBackground(Color.GRAY);
		t3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t3.setForeground(Color.WHITE);
		img.add(t3);

		l4 = new JLabel("Enter Book Location :");
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setForeground(Color.white);
		l4.setBounds(50, 210, 250, 30);
		img.add(l4);

		Integer bId[]= {101,102,103,104,105,106,107,108,109};
		
		t4 = new JComboBox<Integer>(bId);
		t4.setBounds(330, 210, 270, 40);
		t4.setBackground(Color.GRAY);
		t4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t4.setForeground(Color.WHITE);
		img.add(t4);

		b1 = new JButton("Add Book");
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setForeground(Color.WHITE);
		b1.setBounds(330, 280, 150, 30);
		b1.addActionListener(this);
		img.add(b1);

		b2 = new JButton("Clear");
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setForeground(Color.WHITE);
		b2.setBounds(500, 280, 80, 30);
		b2.addActionListener(this);
		img.add(b2);

	}

	public static void main(String[] args) {

		new AddBook();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			//t4.setText("");
		}

		if (ae.getSource() == b1) {
			BookAdd b1 = new BookAdd();
			b1.setBookId(b1.getId());
			t1.setText("" + b1.getBookId());
			b1.setBookName(t2.getText());
			b1.setBookAouthor(t3.getText());
			int blockId=t4.getItemAt(t4.getSelectedIndex());
			b1.setBookLocation(blockId);

			int status = b1.insertData();
			if (status == 1) {
				JOptionPane.showMessageDialog(null, "Record Inserted Successfully!");
//				t1.setText("");
//				t2.setText("");
//				t3.setText("");
//				t4.setText("");
			} else if (status == 5) {
				JOptionPane.showMessageDialog(null, "Location full please add book into another location !");
			} else {
				JOptionPane.showMessageDialog(null, "Something went wrong!");
			}
		}

	}

}
