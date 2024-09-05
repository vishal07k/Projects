package com.itep.library;

import javax.swing.*;
import java.awt.Font;

public class LoadingGUI extends JFrame implements Runnable{

	Thread t;
	JLabel lblLoading;
	public LoadingGUI() {
		setVisible(true);
		setSize(1500,800);
		setTitle("Splash");
		setLocation(200,200);
		getContentPane().setLayout(null);
		
		lblLoading = new JLabel("");
		lblLoading.setFont(new Font("Dialog", Font.BOLD, 30));
		lblLoading.setBounds(618, 159, 219, 110);
		getContentPane().add(lblLoading);
		
		t=new Thread(this);
		t.start();
		
		
		
	}
	

	
		public void run() {
			
			try {
				String Str="Loading...";
				String s="";
				for(int i=0;i<Str.length();i++)
				{
					Thread.sleep(500);
					s=s+Str.charAt(i);
					lblLoading.setText(""+s);
				}
				
				setVisible(false);
				new Home();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	
	public static void main(String[] args) {
		
			new LoadingGUI();
	}
}
