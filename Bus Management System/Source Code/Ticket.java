import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
    
public class Ticket extends JFrame 
{    
Connection cn;
Statement st;
ResultSet rs;
int i,j;
String a[][]=new String[10][10];
Ticket()
{   
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
try
{
rs=st.executeQuery("select min(TicketNO) from Ticket");
rs.next();
int no=rs.getInt(1);
rs=st.executeQuery("select max(TicketNO) from Ticket");
rs.next();
int endno=rs.getInt(1);
System.out.println("Maximum Entries :"+endno);
    
for(i=0;i<endno;i++)
{
rs=st.executeQuery("select * from Ticket where TicketNo="+(i+1));
while(rs.next())
{
for(j=0;j<6;j++)
{
a[i][j]=rs.getString(j+1);
}
}
}
for(i=0;i<endno;i++)
{
for(j=0;j<6;j++)
{
System.out.print(a[i][j]+"\t");
}
System.out.println();
}  
    String column[]={"TicketNo","ConId","Source","Destination","PassangerCount","Price"};
    JTable jt=new JTable(a,column);
    jt.setBounds(100,100,200,300);          
    JScrollPane sp=new JScrollPane(jt);
    add(sp);          
    setSize(800,400);    
    setVisible(true);
    setLocation(330,430);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    rs.close();
    st.close();
    cn.close();   
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Error is"+e);
}
}     

public static void main(String[] args) {    
    new Ticket();    
}    
}  