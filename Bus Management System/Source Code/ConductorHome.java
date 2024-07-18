import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ConductorHome extends JFrame implements ActionListener
{
JLabel l1,img1,img2,img3,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
Cursor cr;
static int pcount,kidcount,passcount,halfcount,fullcount,oneby4count,s5count;
static String name;
static String BusNo;
String date,source,destination;
int price,ConId;
Connection cn;
Statement st;
ResultSet rs;
ConductorHome(String name,String BusNo)
{
this.name=name;
this.BusNo=BusNo;

l1=new JLabel("Name");
l1.setFont(new Font("Times New Roman",Font.BOLD,25));
l1.setForeground(Color.red);
l1.setBounds(30,30,100,30);
add(l1);

t1=new JTextField(30);
t1.setBounds(150,30,300,30);
t1.setEditable(false);
t1.setText(name);
add(t1);

b1=new JButton("LogOut");
b1.setBackground(Color.red);
b1.setForeground(Color.white);
b1.setBounds(460,30,80,30);
b1.addActionListener(this);
add(b1);

l2=new JLabel("BUS ID");
l2.setFont(new Font("Times New Roman",Font.BOLD,20));
l2.setForeground(Color.red);
l2.setBounds(30,90,80,30);
add(l2);

t2=new JTextField(30);
t2.setBounds(150,90,140,30);
t2.setEditable(false);
t2.setText(BusNo);
add(t2);

l3=new JLabel("DATE");
l3.setFont(new Font("Times New Roman",Font.BOLD,20));
l3.setForeground(Color.red);
l3.setBounds(320,90,80,30);
add(l3);

t3=new JTextField(30);
t3.setBounds(400,90,140,30);
t3.setEditable(false);
add(t3);

l4=new JLabel("SOURCE");
l4.setFont(new Font("Times New Roman",Font.BOLD,20));
l4.setForeground(Color.red);
l4.setBounds(30,150,150,30);
add(l4);

t4=new JTextField(30);
t4.setBounds(180,150,200,30);
t4.requestFocus();
add(t4);


l5=new JLabel("DESTINATION");
l5.setFont(new Font("Times New Roman",Font.BOLD,20));
l5.setForeground(Color.red);
l5.setBounds(30,210,150,30);
add(l5);

t5=new JTextField(30);
t5.setBounds(180,210,200,30);
add(t5);

l6=new JLabel("PCOUNT");
l6.setFont(new Font("Times New Roman",Font.BOLD,20));
l6.setForeground(Color.red);
l6.setBounds(30,270,150,30);
add(l6);

t6=new JTextField(30);
t6.setBounds(180,270,100,30);
add(t6);

b2=new JButton("+");
b2.setBackground(Color.red);
b2.setForeground(Color.white);
b2.setBounds(300,270,50,30);
b2.addActionListener(this);
add(b2);

b3=new JButton("-");
b3.setBackground(Color.red);
b3.setForeground(Color.white);
b3.setBounds(360,270,50,30);
b3.addActionListener(this);
add(b3);

l7=new JLabel("PRICE");
l7.setFont(new Font("Times New Roman",Font.BOLD,20));
l7.setForeground(Color.red);
l7.setBounds(30,330,150,30);
add(l7);

t7=new JTextField(30);
t7.setBounds(180,330,100,30);
add(t7);

/*b4=new JButton("MALE");
b4.setBackground(Color.red);
b4.setForeground(Color.white);
b4.setBounds(150,330,80,30);
b4.addActionListener(this);
add(b4);

b5=new JButton("FEMALE");
b5.setBackground(Color.red);
b5.setForeground(Color.white);
b5.setBounds(280,330,80,30);
b5.addActionListener(this);
add(b5);

b6=new JButton("OTHER");
b6.setBackground(Color.red);
b6.setForeground(Color.white);
b6.setBounds(410,330,80,30);
b6.addActionListener(this);
add(b6);

l8=new JLabel("TYPE");
l8.setFont(new Font("Times New Roman",Font.BOLD,20));
l8.setForeground(Color.red);
l8.setBounds(30,390,150,30);
add(l8);*/

b7=new JButton("KID");
b7.setBackground(Color.red);
b7.setForeground(Color.white);
b7.setBounds(150,390,80,30);
b7.addActionListener(this);
add(b7);

b8=new JButton("HALF");
b8.setBackground(Color.red);
b8.setForeground(Color.white);
b8.setBounds(280,390,80,30);
b8.addActionListener(this);
add(b8);

b9=new JButton("1/4");
b9.setBackground(Color.red);
b9.setForeground(Color.white);
b9.setBounds(410,450,80,30);
b9.addActionListener(this);
add(b9);

b10=new JButton("75+");
b10.setBackground(Color.red);
b10.setForeground(Color.white);
b10.setBounds(150,450,80,30);
b10.addActionListener(this);
add(b10);

b11=new JButton("FULL");
b11.setBackground(Color.red);
b11.setForeground(Color.white);
b11.setBounds(280,450,80,30);
b11.addActionListener(this);
add(b11);

b12=new JButton("PASS");
b12.setBackground(Color.red);
b12.setForeground(Color.white);
b12.setBounds(410,390,80,30);
b12.addActionListener(this);
add(b12);

b13=new JButton("BOOK");
b13.setBackground(Color.red);
b13.setForeground(Color.white);
b13.setBounds(210,550,80,30);
b13.addActionListener(this);
add(b13);

b14=new JButton("CLEAR");
b14.setBackground(Color.red);
b14.setForeground(Color.white);
b14.setBounds(310,550,80,30);
b14.addActionListener(this);
add(b14);

/*ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/b1.jpg"));
img2=new JLabel(i2);
img2.setBounds(100,180,400,400);
add(img2);*/

getContentPane().setBackground(Color.white);
setLayout(null);
setVisible(true);
setSize(600,800);
setTitle("CONDUCTOR HOME");
setResizable(false);
setLocation(400,0);
setDefaultCloseOperation(EXIT_ON_CLOSE);
try
{
Class.forName("org.postgresql.Driver");
System.out.println("Driver load");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bms","postgres","root");
System.out.println("Connection successfull");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
}
}
void newTicket()
{
System.out.println("Passanger count:"+pcount);
System.out.println("75+ count:"+s5count);
System.out.println("Half count:"+halfcount);
System.out.println("Full count:"+fullcount);
System.out.println("Pass count:"+passcount);
System.out.println("1/4 count:"+oneby4count);
System.out.println("Kid count:"+kidcount);
System.out.println("Date :"+date);
System.out.println("Price:"+price);
source=t4.getText();
destination=t5.getText();
System.out.println("Source :"+source+"\tDestination :"+destination);
try{
rs=st.executeQuery("select ConId from Bus where BusId="+BusNo);
rs.next();
ConId=rs.getInt(1);
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
}
System.out.println("Con Id:"+ConId);
new TicketBook(pcount,kidcount,passcount,halfcount,fullcount,oneby4count,s5count,price,date,source,destination,ConId);
}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==b1)
{
dispose();
new ConductorLogin();
}
int status=0;

try
{
if(t1.getText().trim().length()>0)
{
rs=st.executeQuery("select current_date");
rs.next();
date=rs.getString(1);
t3.setText(date);
}
if(ae.getSource()==b2)
{
pcount++;
t6.setText(""+pcount);
}
if(ae.getSource()==b7)
{
kidcount++;
}
if(ae.getSource()==b8)
{
halfcount++;
}
if(ae.getSource()==b9)
{
oneby4count++;
}
if(ae.getSource()==b10)
{
s5count++;
}
if(ae.getSource()==b11)
{
fullcount++;
}
if(ae.getSource()==b12)
{
passcount++;
}
if(ae.getSource()==b3)
{
pcount--;
t6.setText(""+pcount);
}
if(t4.getText().trim().length()>0 && t5.getText().trim().length()>0)
{
rs=st.executeQuery("select price from price where source='"+t4.getText()+"' and destination='"+t5.getText()+"'");
rs.next();
price=rs.getInt(1);

if(pcount>0)
{
int tcount=kidcount+passcount+halfcount+fullcount+oneby4count+s5count;
if(tcount==pcount)
{
price=((price*0)*kidcount)+((price*0)*passcount)+((price*1/2)*halfcount)+(price*fullcount)+((price*1/4)*oneby4count)+((price*0)*s5count);
t7.setText(""+price);
status=1;
}
}
}
if(ae.getSource()==b14)
{
pcount=0;
kidcount=0;
passcount=0;
halfcount=0;
fullcount=0;
oneby4count=0;
s5count=0;
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
}
if(ae.getSource()==b13 && status==1)
{
newTicket();
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
}
}
public static void main(String args[])
{ 
new ConductorHome("Vishal","1700");
}
}