import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Home1 extends JFrame implements ActionListener
{
JLabel img,H1,l1,l2,l3,l4,l5,l6;
JButton a1,e1,u1,s1;
Home1()
{
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bus.jpg"));
img=new JLabel(i1);
img.setBounds(0,0,300,400);
add(img);

H1=new JLabel("Welcome To BMS Portal!");
H1.setBounds(5,30,350,30);
H1.setFont(new Font("Trebuchet MS",Font.BOLD,25));
H1.setForeground(Color.white);
add(H1);

l1=new JLabel("NOTE : Please Login First to Proceed ");
l1.setBounds(370,30,400,30);
l1.setFont(new Font("Bahnschrift",Font.BOLD,15));
l1.setForeground(Color.blue);
add(l1);

l2=new JLabel("ADMIN:");
l2.setBounds(370,80,100,30);
l2.setFont(new Font("Bahnschrift",Font.BOLD,15));
l2.setForeground(Color.white);
add(l2);

a1=new JButton("LOGIN");
a1.setBounds(490,80,100,30);
a1.setForeground(Color.blue);
a1.setBackground(new Color(198,198,198));
a1.addActionListener(this);
a1.setCursor(new Cursor(Cursor.HAND_CURSOR));
add(a1);

l3=new JLabel("CONDUCTOR:");
l3.setBounds(370,130,100,30);
l3.setFont(new Font("Bahnschrift",Font.BOLD,15));
l3.setForeground(Color.white);
add(l3);

e1=new JButton("LOGIN");
e1.setBounds(490,130,100,30);
e1.setForeground(Color.blue);
e1.setBackground(new Color(198,198,198));
e1.addActionListener(this);
e1.setCursor(new Cursor(Cursor.HAND_CURSOR));
add(e1);



getContentPane().setBackground(new Color(215,102,0));
setLayout(null);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(700,350);
setTitle("Home Sceen");
setResizable(false);
setLocation(300,200);
}
public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==a1)
{
setVisible(false);
new AdminLogin();
}
else if(ae.getSource()==e1)
{
setVisible(false);
new ConductorLogin();
}

}
public static void main(String args[])
{
new Home1();
}
}