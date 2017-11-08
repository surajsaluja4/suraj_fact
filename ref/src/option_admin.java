import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

 class option_admin extends JFrame implements ActionListener

 {


	JButton b1,b2,b3,b4;
    JPanel p;
    option_admin()
    {
     setVisible(true);
     setLocation(100,100);
     setSize(500,80);
            p=new JPanel();
	add(p);
            
    p.setVisible(true);
	p.setSize(500,500);
    p.setBackground(Color.BLUE);
        b1=new JButton("BILLING ");
	b3=new JButton("PRODUCT ENTRY");
    b2=new JButton("STAFF REGISTRATION");
    b4=new JButton("CANCEL");
    
    b1.setBounds(320,470,100,50);
	b2.setBounds(150,500,125,50);
   b3.setBounds(150,325,125,50);
    b4.setBounds(150,425,125,50);
    
	p.add(b1);
    p.add(b2);
   p.add(b3);
p.add(b4);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);


    }

public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==b1)
		{
            new Form();
            setVisible(false);
        }
        if(e.getSource()==b2)
		{
            new register_staff();

            setVisible(false);
        }
        if(e.getSource()==b3)
		{
            new pro_entry();

            setVisible(false);
        }
        if(e.getSource()==b4)
		{
            setVisible(false);
            new bbm1();
        }

}
   
 }

