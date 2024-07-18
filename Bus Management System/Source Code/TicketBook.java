import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class TicketBook extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
JButton b1,b2;
static int pcount,kidcount,passcount,halfcount,fullcount,oneby4count,s5count;
static String name;
String date,source,destination;
int price,ConId,rate;
Connection cn;
Statement st;
ResultSet rs;

TicketBook(int pcount,int kidcount,int passcount,int halfcount,int fullcount,int oneby4count,int s5count,int price,String date,String source,String destination,int ConId)
{
this.pcount=pcount;
this.kidcount=kidcount;
this.passcount=passcount;
this.halfcount=halfcount;
this.fullcount=fullcount;
this.oneby4count=oneby4count;
this.s5count=s5count;
this.price=price;
this.date=date;
this.source=source;
this.destination=destination;
this.ConId=ConId;

l1=new JLabel("Maharashtra Parivahan");
l1.setFont(new Font("Times New Roman",Font.BOLD,20));
l1.setForeground(Color.black);
l1.setBounds(30,10,400,20);
add(l1);

l6=new JLabel("Date:"+date);
l6.setFont(new Font("Times New Roman",Font.BOLD,20));
l6.setForeground(Color.black);
l6.setBounds(180,30,400,20);
add(l6);

l7=new JLabel("CONID:"+ConId);
l7.setFont(new Font("Times New Roman",Font.BOLD,20));
l7.setForeground(Color.black);
l7.setBounds(30,30,400,20);
add(l7);

l2=new JLabel("Ticket From :"+source);
l2.setFont(new Font("Times New Roman",Font.BOLD,20));
l2.setForeground(Color.black);
l2.setBounds(30,50,400,20);
add(l2);

l3=new JLabel("To :"+destination);
l3.setFont(new Font("Times New Roman",Font.BOLD,20));
l3.setForeground(Color.black);
l3.setBounds(180,70,400,20);
add(l3);

l4=new JLabel("Total Passanger :"+pcount);
l4.setFont(new Font("Times New Roman",Font.BOLD,20));
l4.setForeground(Color.black);
l4.setBounds(30,90,400,20);
add(l4);

l5=new JLabel("full:"+fullcount+" Half:"+halfcount+" 1/4:"+oneby4count+" 75+:"+s5count+" Kid:"+kidcount+" pass:"+passcount);
l5.setFont(new Font("Times New Roman",Font.BOLD,20));
l5.setForeground(Color.black);
l5.setBounds(30,110,400,20);
add(l5);

l8=new JLabel("Total Price:"+price);
l8.setFont(new Font("Times New Roman",Font.BOLD,20));
l8.setForeground(Color.black);
l8.setBounds(30,130,400,20);
add(l8);

b1=new JButton("PRINT");
b1.setBounds(30,170,100,20);
b1.setForeground(Color.black);
b1.addActionListener(this);
add(b1);

b2=new JButton("CANCLE");
b2.setBounds(200,170,100,20);
b2.setForeground(Color.black);
b2.addActionListener(this);
add(b2);

getContentPane().setBackground(Color.white);
setLayout(null);
setVisible(true);
setSize(400,250);
setTitle("Ticket");
setResizable(false);
setLocation(450,380);
//setDefaultCloseOperation(EXIT_ON_CLOSE);
try
{
Class.forName("org.postgresql.Driver");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bms","postgres","root");
st=cn.createStatement();
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is"+e);
}
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
dispose();
}
try
{

if(ae.getSource()==b1)
{
rs=st.executeQuery("select max(ticketNo)from ticket");
rs.next();
int no=rs.getInt(1);
no++;
st.executeUpdate("insert into Ticket values("+no+","+ConId+",'"+source+"','"+destination+"',"+pcount+","+price+")");
JOptionPane.showMessageDialog(null,"Ticket Booked");
setVisible(false);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is"+e);
}
}
public static void main(String args[])
{ 
new TicketBook(0,0,0,0,0,0,0,0,"10/12/20","abc","xyz",1200);
}
}
//new Ticket(pcount,kidcount,passcount,halfcount,fullcount,oneby4count,s5count,price,date,source,destination,ConId);