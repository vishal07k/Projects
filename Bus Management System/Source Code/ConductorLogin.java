import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ConductorLogin extends JFrame implements ActionListener
{
JLabel img,l1,l2,h1;
JTextField t1;
JPasswordField t2;
JButton b1,b2;
int flag;
Connection cn;
Statement st;
ResultSet rs;
ConductorLogin()
{
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/t1.jpg"));
img=new JLabel(i1);
img.setBounds(320,0,200,400);
add(img);

h1=new JLabel("CONDUCTOR LOGIN");
h1.setFont(new Font("Colonna MT",Font.BOLD,30));
h1.setForeground(Color.orange);
h1.setBounds(10,30,300,20);
add(h1);

h1=new JLabel("PORTAL...!");
h1.setFont(new Font("Colonna MT",Font.BOLD,30));
h1.setForeground(Color.orange);
h1.setBounds(40,70,300,20);
add(h1);

l1=new JLabel("USERNAME");
l1.setFont(new Font("Colonna MT",Font.BOLD,20));
l1.setForeground(Color.white);
l1.setBounds(40,130,120,20);
add(l1);

t1=new JTextField(30);
t1.setBounds(40,160,180,30);
add(t1);

l2=new JLabel("PASSWORD");
l2.setFont(new Font("Colonna MT",Font.BOLD,20));
l2.setForeground(Color.white);
l2.setBounds(40,230,120,20);
add(l2);

t2=new JPasswordField(30);
t2.setBounds(40,260,180,30);
add(t2);

b1=new JButton("LOGIN");
b1.setBackground(Color.white);
b1.setForeground(Color.blue);
b1.setBounds(20,320,100,20);
b1.setFont(new Font("Times New Roman",Font.BOLD,15));
b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
b1.addActionListener(this);
add(b1);

b2=new JButton("BACK");
b2.setBackground(Color.white);
b2.setForeground(Color.blue);
b2.setBounds(150,320,100,20);
b2.setFont(new Font("Times New Roman",Font.BOLD,15));
b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
b2.addActionListener(this);
add(b2);

getContentPane().setBackground(new Color(35,35,35));
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(500,400);
setTitle("Conductor LOGIN");
setResizable(false);
setLocation(300,200);
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
setVisible(false);
new Home1();
}
if(ae.getSource()==b1)
{
try{
 if(t1.getText().trim().length()>0)
 {
  if(t2.getText().trim().length()>0)
  {
   rs=st.executeQuery("select PASSWORD from Conductor where USERNAME='"+t1.getText()+"'");
   if(rs.next())
   {
    if(rs.getString(1).equals(t2.getText()))
    {
     rs=st.executeQuery("select name,BusId from Conductor where USERNAME='"+t1.getText()+"'");
     rs.next();
     String name=rs.getString(1);
     String BusNo=rs.getString(2);
     System.out.println(""+name+"\t"+BusNo);
     setVisible(false);
     new ConductorHome(name,BusNo);
    }
   else
   {
    JOptionPane.showMessageDialog(null,"Invalid Password");
   }
  }
 else
 {
  JOptionPane.showMessageDialog(null,"Invalid Username");
 }
}
else
{
JOptionPane.showMessageDialog(null,"Plz Enter Password");
}
}
else
{
JOptionPane.showMessageDialog(null,"Plz Enter UserName");
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is"+e);
}
}
}
public static void main(String args[])
{
new ConductorLogin();
}
}