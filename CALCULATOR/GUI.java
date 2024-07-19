package com.itep.cal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener{

	JTextField t1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,Add,Sub,Mul,Div,Eql,Dot,Ac;
	public GUI() {
		
		setVisible(true);
		setSize(330,450);
		setTitle("Calculator");
		setLayout(null);
		setLocation(500,0);
		getContentPane().setBackground(Color.cyan);
		//setResizable(false);
		

		t1=new JTextField();
		t1.setBounds(20,30,290,100);
		//t1.setText("Welcome......");
		add(t1);
		
		b1=new JButton("1");
		b1.setBounds(20,150,50,50);
		add(b1);
		
		b2=new JButton("2");
		b2.setBounds(80,150,50,50);
		add(b2);
		
		b3=new JButton("3");
		b3.setBounds(140,150,50,50);
		add(b3);
		
		b4=new JButton("4");
		b4.setBounds(20,210,50,50);
		add(b4);
		
		b5=new JButton("5");
		b5.setBounds(80,210,50,50);
		add(b5);
		
		b6=new JButton("6");
		b6.setBounds(140,210,50,50);
		add(b6);
		
		b7=new JButton("7");
		b7.setBounds(20,270,50,50);
		add(b7);
		
		b8=new JButton("8");
		b8.setBounds(80,270,50,50);
		add(b8);
		
		b9=new JButton("9");
		b9.setBounds(140,270,50,50);
		add(b9);
		
		b0=new JButton("0");
		b0.setBounds(20,330,110,50);
		add(b0);
		
		Eql=new JButton("=");
		Eql.setBounds(140,330,50,50);
		add(Eql);
		
		Dot=new JButton(".");
		Dot.setBounds(200,150,50,50);
		add(Dot);
		
		Ac=new JButton("ac");
		Ac.setBounds(260,150,50,50);
		add(Ac);
		
		Add=new JButton("+");
		Add.setBounds(200,210,50,110);
		add(Add);
		
		Sub=new JButton("-");
		Sub.setBounds(260,210,50,110);
		add(Sub);
		
		Mul=new JButton("*");
		Mul.setBounds(200,330,50,50);
		add(Mul);
		
		Div=new JButton("/");
		Div.setBounds(260,330,50,50);
		add(Div);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b0.addActionListener(this);
		Add.addActionListener(this);
		Sub.addActionListener(this);
		Mul.addActionListener(this);
		Div.addActionListener(this);
		Eql.addActionListener(this);
		Dot.addActionListener(this);
		Ac.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str="";
		if(ae.getSource()==b1)
		{
			str=t1.getText();
			str=str+"1";
			t1.setText(str);
		}
		else if(ae.getSource()==b2)
		{
			str=t1.getText();
			str=str+"2";
			t1.setText(str);
		}
		else if(ae.getSource()==b3)
		{
			str=t1.getText();
			str=str+"3";
			t1.setText(str);
		}else if(ae.getSource()==b4)
		{
			str=t1.getText();
			str=str+"4";
			t1.setText(str);
		}else if(ae.getSource()==b5)
		{
			str=t1.getText();
			str=str+"5";
			t1.setText(str);
		}else if(ae.getSource()==b6)
		{
			str=t1.getText();
			str=str+"6";
			t1.setText(str);
		}else if(ae.getSource()==b7)
		{
			str=t1.getText();
			str=str+"7";
			t1.setText(str);
		}else if(ae.getSource()==b8)
		{
			str=t1.getText();
			str=str+"8";
			t1.setText(str);
		}else if(ae.getSource()==b9)
		{
			str=t1.getText();
			str=str+"9";
			t1.setText(str);
		}else if(ae.getSource()==b0)
		{
			str=t1.getText();
			str=str+"0";
			t1.setText(str);
		}else if(ae.getSource()==Dot)
		{
			str=t1.getText();
			str=str+".";
			t1.setText(str);
		}else if(ae.getSource()==Ac)
		{
			str=" ";
			t1.setText(str);
		}
		else if(ae.getSource()==Add)
		{
			str=t1.getText();
			str=str+"+";
			t1.setText(str);
		}
		else if(ae.getSource()==Sub)
		{
			str=t1.getText();
			str=str+"-";
			t1.setText(str);
		}
		else if(ae.getSource()==Mul)
		{
			str=t1.getText();
			str=str+"*";
			t1.setText(str);
		}
		else if(ae.getSource()==Div)
		{
			str=t1.getText();
			str=str+"/";
			t1.setText(str);
		}
		if(ae.getSource()==Eql)
		{
			str=t1.getText();
			Opr(str);
			
		}
	}
	
	void Opr(String str)
	{
		double no1,no2;
		int pos=0;
		String s1="",s2="";
		
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='+' || ch=='-' ||ch=='*' || ch=='/')
			{
				pos=i;
				break;
			}
				
		}
		for(int i=0;i<pos;i++)
		{
			s1=s1+str.charAt(i);
		}
		for(int i=pos+1;i<str.length();i++)
		{
			s2=s2+str.charAt(i);
		}
		no1=Double.parseDouble(s1);
		no2=Double.parseDouble(s2);
		if(str.charAt(pos)=='+')
		{
			t1.setText((no1+no2)+"");
		}else if(str.charAt(pos)=='-')
		{
			t1.setText((no1-no2)+"");
		}else if(str.charAt(pos)=='*')
		{
			t1.setText((no1*no2)+"");
		}else if(str.charAt(pos)=='/')
		{
			t1.setText((no1/no2)+"");
		}
		
	}
	

	public static void main(String[] args) {
		new GUI();

	}

}

