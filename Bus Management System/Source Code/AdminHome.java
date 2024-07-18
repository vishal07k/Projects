import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class AdminHome extends JFrame implements ActionListener
{
Connection cn;
Statement st;
ResultSet rs;
int status;
JLabel l1,img1,img2,img3,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
Cursor cr;
AdminHome()
{
cr=new Cursor(HAND_CURSOR);

l1=new JLabel(" Welcome to Admin System..!");
l1.setFont(new Font("Times New Roman",Font.BOLD,30));
l1.setBounds(15,20,500,20);
l1.setForeground(Color.red);
add(l1);

l2=new JLabel("Bus Details");
l2.setFont(new Font("Times New Roman",Font.BOLD,30));
l2.setBounds(40,45,200,30);
l2.setForeground(Color.blue);
add(l2);

l3=new JLabel("Bus ID:");
l3.setFont(new Font("Times New Roman",Font.BOLD,20));
l3.setBounds(40,80,100,20);
l3.setForeground(Color.black);
add(l3);

t1=new JTextField(20);
t1.setEditable(false);
t1.setBounds(150,80,200,30);
add(t1);

l4=new JLabel("Bus NO:");
l4.setFont(new Font("Times New Roman",Font.BOLD,20));
l4.setBounds(40,120,100,20);
l4.setForeground(Color.black);
add(l4);

t2=new JTextField(20);
t2.setBounds(150,120,200,30);
add(t2);

l5=new JLabel("Source:");
l5.setFont(new Font("Times New Roman",Font.BOLD,20));
l5.setBounds(40,160,100,20);
l5.setForeground(Color.black);
add(l5);

t3=new JTextField(20);
t3.setBounds(150,160,200,30);
add(t3);

l6=new JLabel("Destination:");
l6.setFont(new Font("Times New Roman",Font.BOLD,20));
l6.setBounds(40,200,150,20);
l6.setForeground(Color.black);
add(l6);

t4=new JTextField(20);
t4.setBounds(150,200,200,30);
add(t4);

l13=new JLabel("Con ID:");
l13.setFont(new Font("Times New Roman",Font.BOLD,20));
l13.setBounds(40,240,100,20);
l13.setForeground(Color.black);
add(l13);

t5=new JTextField(20);
t5.setBounds(150,240,200,30);
add(t5);

l14=new JLabel("Driver ID:");
l14.setFont(new Font("Times New Roman",Font.BOLD,20));
l14.setBounds(40,280,200,20);
l14.setForeground(Color.black);
add(l14);

t6=new JTextField(20);
t6.setBounds(150,280,200,30);
add(t6);

l15=new JLabel("DATE:");
l15.setFont(new Font("Times New Roman",Font.BOLD,20));
l15.setBounds(40,320,200,20);
l15.setForeground(Color.black);
add(l15);

t7=new JTextField(20);
t7.setBounds(150,320,200,30);
add(t7);

l16=new JLabel("TIME:");
l16.setFont(new Font("Times New Roman",Font.BOLD,20));
l16.setBounds(40,360,200,20);
l16.setForeground(Color.black);
add(l16);

t8=new JTextField(20);
t8.setBounds(150,360,200,30);
add(t8);

l7=new JLabel("Conductor & Driver Details");
l7.setFont(new Font("Times New Roman",Font.BOLD,30));
l7.setBounds(600,45,400,30);
l7.setForeground(Color.blue);
add(l7);

l8=new JLabel("Con ID:");
l8.setFont(new Font("Times New Roman",Font.BOLD,20));
l8.setBounds(600,80,100,20);
l8.setForeground(Color.black);
add(l8);

t9=new JTextField(20);
t9.setEditable(false);
t9.setBounds(750,80,200,30);
add(t9);

l9=new JLabel("Name :");
l9.setFont(new Font("Times New Roman",Font.BOLD,20));
l9.setBounds(600,120,200,20);
l9.setForeground(Color.black);
add(l9);

t10=new JTextField(20);
t10.setEditable(false);
t10.setBounds(750,120,200,30);
add(t10);

l10=new JLabel("Bus ID:");
l10.setFont(new Font("Times New Roman",Font.BOLD,20));
l10.setBounds(600,160,100,20);
l10.setForeground(Color.black);
add(l10);

t11=new JTextField(20);
t11.setBounds(750,160,200,30);
add(t11);

l11=new JLabel("Driver ID:");
l11.setFont(new Font("Times New Roman",Font.BOLD,20));
l11.setBounds(600,200,200,20);
l11.setForeground(Color.black);
add(l11);

t12=new JTextField(20);
t12.setEditable(false);
t12.setBounds(750,200,200,30);
add(t12);

l12=new JLabel("Driver Name :");
l12.setFont(new Font("Times New Roman",Font.BOLD,20));
l12.setBounds(600,240,200,20);
l12.setForeground(Color.black);
add(l12);

t13=new JTextField(20);
t13.setEditable(false);
t13.setBounds(750,240,200,30);
add(t13);

l13=new JLabel("Bus ID:");
l13.setFont(new Font("Times New Roman",Font.BOLD,20));
l13.setBounds(600,280,100,20);
l13.setForeground(Color.black);
add(l13);

t14=new JTextField(20);
t14.setBounds(750,280,200,30);
add(t14);

b1=new JButton("|<");
b1.addActionListener(this);
b1.setBounds(400,80,70,30);
b1.setCursor(cr);
add(b1);
b2=new JButton("<");
b2.addActionListener(this);
b2.setBounds(400,130,70,30);
b2.setCursor(cr);
add(b2);
b3=new JButton(">");
b3.addActionListener(this);
b3.setBounds(480,80,70,30);
b3.setCursor(cr);
add(b3);
b4=new JButton(">|");
b4.addActionListener(this);
b4.setBounds(480,130,70,30);
b4.setCursor(cr);
add(b4);
b5=new JButton("Add");
b5.addActionListener(this);
b5.setBounds(400,180,70,30);
b5.setCursor(cr);
add(b5);
b6=new JButton("Edit");
b6.addActionListener(this);
b6.setBounds(400,230,70,30);
b6.setCursor(cr);
add(b6);
b7=new JButton("Save");
b7.addActionListener(this);
b7.setBounds(480,180,70,30);
b7.setCursor(cr);
add(b7);
b8=new JButton("Exit");
b8.addActionListener(this);
b8.setBounds(480,230,70,30);
b8.setCursor(cr);
add(b8);

b10=new JButton("Search Conductor");
b10.addActionListener(this);
b10.setBounds(400,280,150,30);
b10.setCursor(cr);
add(b10);

b11=new JButton("Search Driver");
b11.addActionListener(this);
b11.setBounds(400,330,150,30);
b11.setCursor(cr);
add(b11);

b12=new JButton("ASSIGN BUS");
b12.addActionListener(this);
b12.setBounds(700,330,150,30);
b12.setCursor(cr);
add(b12);

l14=new JLabel("To See the Ticket Status :");
l14.setFont(new Font("Times New Roman",Font.BOLD,30));
l14.setBounds(50,420,580,30);
l14.setForeground(Color.black);
add(l14);

b9=new JButton("Click");
b9.addActionListener(this);
b9.setBounds(480,420,70,30);
b9.setCursor(cr);
add(b9);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/t1.jpg"));
img1=new JLabel(i1);
img1.setBounds(0,0,500,400);
add(img1);

ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/t2.jpg"));
img3=new JLabel(i3);
img3.setBounds(500,0,500,400);
add(img3);

ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/b1.jpg"));
img2=new JLabel(i2);
img2.setBounds(300,430,400,400);
add(img2);

getContentPane().setBackground(Color.white);
setLayout(null);
setVisible(true);
setSize(1000,1000);
setTitle("ADMIN HOME");
setResizable(false);
setLocation(250,0);
setDefaultCloseOperation(EXIT_ON_CLOSE);

try
{
Class.forName("org.postgresql.Driver");
cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bms","postgres","root");
System.out.println("Driver Load");
st=cn.createStatement();
System.out.println("Statement Created");
} 
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
}
}

void getData()
{
try
{
t1.setText(rs.getString(1));
t2.setText(rs.getString(2));
t3.setText(rs.getString(3));
t4.setText(rs.getString(4));
t5.setText(rs.getString(5));
t6.setText(rs.getString(6));
t7.setText(rs.getString(7));
t8.setText(rs.getString(8));
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
}
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==b1)
{
rs=st.executeQuery("select * from Bus where BusId=(select min(BusId) from Bus)");
rs.next();
getData();
}
if(ae.getSource()==b2)
{
int k=Integer.parseInt(t1.getText());
k--;
rs=st.executeQuery("select * from Bus where BusId="+k);
if(rs.next())
getData();
else
JOptionPane.showMessageDialog(null,"This is first Record");
}

if(ae.getSource()==b3)
{
int k=Integer.parseInt(t1.getText());
k++;
rs=st.executeQuery("select * from Bus where BusId="+k);
if(rs.next())
getData();
else
JOptionPane.showMessageDialog(null,"This is Last Record");
}
if(ae.getSource()==b4)
{
rs=st.executeQuery("select * from Bus where BusId=(select max(BusId) from Bus)");
rs.next();
getData();
}
if(ae.getSource()==b5)
{
status=1;
rs=st.executeQuery("select max(BusId)+1 from Bus");
rs.next();
t1.setText(rs.getString(1));
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
t8.setText("");
t2.requestFocus();
}
if(ae.getSource()==b6)
{
status=2;
}
if(ae.getSource()==b7)
{
if(t2.getText().trim().length()>0 && t3.getText().trim().length()>0 && t4.getText().trim().length()>0 && t5.getText().trim().length()>0 && t6.getText().trim().length()>0)
{
if(status==1)
{
st.executeUpdate("Insert into Bus values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"',"+t5.getText()+","+t6.getText()+",(select current_date),(select current_time))");
JOptionPane.showMessageDialog(null,"Record Inserted");
}
else
if(status==2)
{
st.executeUpdate("Update Bus set BusNo='"+t2.getText()+"',Source='"+t3.getText()+"',Destination='"+t4.getText()+"',ConId="+t5.getText()+",DriverId="+t6.getText()+",Date='"+t7.getText()+"',Time='"+t8.getText()+"' where BusId="+t1.getText());
JOptionPane.showMessageDialog(null,"Record Updated");
}
if(status==3)
{
st.executeUpdate("Update Conductor set BusId="+t11.getText()+"where ConId="+t9.getText());
st.executeUpdate("Update Driver set BusId="+t14.getText()+"where DriverId="+t12.getText());
JOptionPane.showMessageDialog(null,"Record Updated");
}
status=0;
}
else
JOptionPane.showMessageDialog(null,"Incorrect Information");
}
if(ae.getSource()==b10)
{
rs=st.executeQuery("select * from Conductor where ConId="+t5.getText());
if(rs.next())
{
t9.setText(rs.getString(1));
t10.setText(rs.getString(2));
t11.setText(rs.getString(3));
}
else
{
JOptionPane.showMessageDialog(null,"Incorrect ConId");
}
}
if(ae.getSource()==b11)
{
rs=st.executeQuery("select * from Driver where DriverId="+t6.getText());
if(rs.next())
{
t12.setText(rs.getString(1));
t13.setText(rs.getString(2));
t14.setText(rs.getString(3));
}
else
{
JOptionPane.showMessageDialog(null,"Incorrect DriverId");
}
}
if(ae.getSource()==b12)
{
t11.setText("");
t14.setText("");
status=3;
}
if(ae.getSource()==b8)
{
 rs.close();
 st.close();
 cn.close();
 dispose();
 new AdminLogin();
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error :"+e);
System.out.println(""+e);
}
if(ae.getSource()==b9)
{
new Ticket();
}
}
public static void main(String args[])
{
new AdminHome();
}
}