package fact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class edit_delete implements fonts,ActionListener{
    
    JFrame frame;
    JPanel p1,panelBack;
    String tablename,username,dbname;
    Connection con;
    PreparedStatement ps,ps1,ps2,ps3;
    ResultSet rs,rs1,rs2;
    Vector v=new Vector();
    int fields,x,y,width,hieght;
    JTextField text[],status;
    JLabel labels[],info;
    JButton back,update;
    JScrollPane sp;
    int response,response1;


    public edit_delete(int response2,String username1,String tablename1,String Database) {
        tablename=tablename1;
        dbname=Database;
        response=response2;
        username=username1;
        width=screensize.width();
        hieght=screensize.hieght();
        x=width/2;
        y=100;
        

        frame =new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


        

        p1=new JPanel(null);
        getdetails();

        info=new JLabel("");
        info.setForeground(Color.red);
        info.setFont(f1);
        info.setBounds(x-300, y-50, x, 100);

        back=new JButton("Home");
        back.setBackground(Color.GREEN);
        back.setFont(f9);
        back.setBounds(x-300,y+100+(fields*100), 150, 50);
         update=new JButton();
        if(response==1)
        {
       update.setText("Update");
       info.setText("Update Information");
        }
        else if(response==2)
        {
        update.setText("Delete");
        info.setText("Delete Information");
        for(int i=1;i<=fields;i++)
        {
        text[i].setEditable(false);
        text[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        }
        update.setBackground(Color.GREEN);
        update.setFont(f9);
        update.setBounds(x,y+100+(fields*100), 200, 50);

        status=new JTextField();
        status.setBounds(x-300,y+200+(fields*100), x, 50);
        status.setBorder(null);
        status.setBackground(Color.white);
        status.setFont(f9);
        status.setEditable(false);
        status.setHighlighter(null);

        p1.setPreferredSize(new Dimension(width-20,y+(fields*100)+300));
        p1.setBackground(Color.white);

        p1.add(info);
        p1.add(back);
        p1.add(update);
        p1.add(status);

        p1.setVisible(true);
        sp=new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelBack=new JPanel(new BorderLayout());
        panelBack.add(sp,BorderLayout.CENTER);
        panelBack.setVisible(true);
        frame.add(panelBack);
        frame.setVisible(true);

        update.addActionListener(this);
        back.addActionListener(this);
    }

    public void getdetails()
    {
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,"root","");
    ps=con.prepareStatement("desc "+tablename);
        System.out.println(ps);
     rs=ps.executeQuery();
    while(rs.next())
    {
    v.addElement(rs.getString(1));
    }

    ps1=con.prepareStatement("select * from "+tablename+" where username ='"+username+"'");
    rs1=ps1.executeQuery();
        System.out.println(ps1);
    rs1.next();
   
    Enumeration en=v.elements();
    fields=v.size();
    labels=new JLabel[fields+1];
    text=new JTextField[fields+1];

    int i=1;
        while (en.hasMoreElements()) {

          labels[i]=new JLabel(en.nextElement().toString());
           labels[i].setFont(f10);
          labels[i].setBounds(x-300,y+(i*100),300,50);
          p1.add(labels[i]);
            
            
             text[i]=new JTextField(rs1.getString(i));
           text[i].setFont(f10);
           if(text[i].getText().toString().equals(username))
           {
           text[i].setEditable(false);
           text[i].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
           text[i].addMouseListener(new MouseListener() {
                        
                        public void mouseClicked(MouseEvent e) {
                            JOptionPane.showMessageDialog(frame, "Can Not Edit The Primary Key","Error",JOptionPane.WARNING_MESSAGE);
                        }

                        public void mousePressed(MouseEvent e) {
                         
                        }

                        public void mouseReleased(MouseEvent e) {
                         
                        }

                        public void mouseEntered(MouseEvent e) {
                           
                        }

                        public void mouseExited(MouseEvent e) {
                          
                        }
           });

           }
          text[i].setBounds(x,y+(i*100),200,50);
          text[i].setBackground(Color.white);
          
          text[i].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.pink));
          p1.add(text[i]);
            
          i++;

        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
    }

    public static void main(String[] args) {
        new edit_delete(1,"admin","login_credentials","Admins");
    }


    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==update)
    {
         System.out.println("response"+response);

     
     try
     {
         if(response==1)
        {
            
     rs2=ps1.executeQuery();
     rs2.next();
     for(int i=1;i<=fields;i++)
     {
    if(!(text[i].getText().toString().equals(rs2.getString(i))))

    {
        if(v.get(i-1).equals("Password"))
        {
         ps3=con.prepareStatement("UPDATE `"+tablename+"` SET `"+v.get(i-1)+"`=\""+text[i].getText().toString()+"\" where username = '"+username+"'");
        }else
        {
         ps3=con.prepareStatement("UPDATE `"+tablename+"` SET `"+v.get(i-1)+"`=\""+text[i].getText().toString().toUpperCase()+"\" where username = '"+username+"'");
        
        }
       ps3.executeUpdate();
        System.out.println(ps3);
       status.setText("           Updated Successfully");
    }
     }
         }
     
          else if(response==2)
       {

     rs2=ps1.executeQuery();
     rs2.next();
     for(int i=1;i<=fields;i++)
     {
    if(!(text[i].getText().toString().equals(rs2.getString(i))))

    {
        if(v.get(i-1).equals("Password"))
        {
         ps3=con.prepareStatement("UPDATE `"+tablename+"` SET  where username = '"+username+"'");
        }else
        {
         ps3=con.prepareStatement("UPDATE `"+tablename+"` SET `"+v.get(i-1)+"`=\""+text[i].getText().toString().toUpperCase()+"\" where username = '"+username+"'");

        }
       ps3.executeUpdate();
        System.out.println(ps3);
       status.setText("           Updated Successfully");
    }
     }
         }
        
        status.setForeground(Color.BLUE);

    
    }
     catch(Exception es)
     {
         status.setText(es.toString());
         status.setForeground(Color.RED);
     }
    }
    if(e.getSource()==back)
    {
    frame.dispose();
    frame.setVisible(false);
    }
    }

}
