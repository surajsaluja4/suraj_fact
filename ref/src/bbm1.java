import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class bbm1 implements ActionListener {
	
	JPanel p1,p2,p3,p4,p5,p6;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	JLabel l18,l19,l20;
    login l;
    static JFrame frame=new JFrame();

    
     bbm1()
	
    
    {

        Font f=new Font("Modern No. 20",Font.BOLD, 25);
		Font f1=new Font("Lucida Handwriting",Font.BOLD, 60);
		Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
		Font f3=new Font("Baskerville Old Face",Font.BOLD, 17);
		Font f4=new Font("Imprint MT Shadow",Font.PLAIN, 30);
		Font f5=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
		Font f6=new Font("Lucida Calligraphy",Font.BOLD,17	);
		Font f7=new Font("Lucida Handwriting",Font.BOLD,50);
		Font f8=new Font("Aerial",Font.PLAIN,25);

      
      frame.setSize(900,800);
      frame.setLayout(null);
     
         p1=new JPanel();
         p2=new JPanel();
         p3=new JPanel();
         p4=new JPanel();
         p5=new JPanel();
         l=new login();


         p1.setBounds(0,0,900,170);
         p2.setBounds(0,170,900,30);
         p3.setBounds(0,200,900,100);
         p4.setBounds(0,300,200,500);
         p5.setBounds(200,300,700,500);

         p1.setBackground(Color.white);
         p2.setBackground(Color.white);
         p3.setBackground(Color.white);
         p4.setBackground(Color.white); 

         p1.setLayout(null);
         p2.setLayout(null);
         p3.setLayout(null);
         p4.setLayout(null); 
         p5.setLayout(null);

      frame.add(p1);
      frame.add(p2);
     frame.add(p3);
     frame.add(p4);
     frame.add(p5);
     frame.add(l);
         
        l1=new JLabel(new ImageIcon("img/logo.gif"));
        l2=new JLabel("BBM GROUPS");
        l3=new JLabel("Symbol of trust and Quality");
        l4=new JLabel("No.4 Dharamshala Road ");
        l5=new JLabel("Jharia,Dhanbad");
        l6=new JLabel(new ImageIcon("img/panelpic.gif"));
        l7=new JLabel("Product ");
        l8=new JLabel("Categories");
        l9=new JLabel("HOME");
        l10=new JLabel("Welcome to THE BBM GROUPS,");
        l11=new JLabel( "Explore a fine range of handloom items like Bedsheets,Bedcovers,"); 
        l12=new JLabel("Cushions, Quilts,  and more.");
        l13=new JLabel("Being a premiere manufacturer, exporter, trader & supplier  ");
        l14=new JLabel("having a proven track record in the industry, we offer a wide  "); 
        l15=new JLabel("range of quality-assured handcrafted products to our customers");
        l16=new JLabel(new ImageIcon("img/curt2.gif"));
        l17=new JLabel(new ImageIcon("img/bed2.gif"));
        l18=new JLabel(new ImageIcon("img/bed1.gif"));	

    l2.setFont(f1);
	l3.setFont(f2);
	l4.setFont(f3);
	l5.setFont(f3);
	l7.setFont(f4);
	l8.setFont(f4); 
                 l9.setFont(f7);
                 l10.setFont(f6);
	l11.setFont(f6);         
	l12.setFont(f6);
	l13.setFont(f6);
	l14.setFont(f6);
	l15.setFont(f6);

l2.setForeground(Color.gray);
l9.setForeground(Color.red);		
                            
 		l1.setBounds(0, 40,160, 80);
         		l2.setBounds(180, 50 , 500, 60);
 	                 l3.setBounds(500, 90, 300, 60);
 		l4.setBounds(670, 10, 350, 20);
 		l5.setBounds(670, 30, 350, 20);
 		l6.setBounds(0,0,900,100);
		l7.setBounds(5,0,180,60);
        l8.setBounds(13,30,180,65);
		l9.setBounds(250,10,250,50);
		l10.setBounds(100,70,600,20);
		l11.setBounds(20,100,680,20);
		l12.setBounds(20,130,600,20);
		l13.setBounds(20,180,680,20);
		l14.setBounds(20,210,680,20);
		l15.setBounds(20,240,680,20);
		l16.setBounds(180,280,150,150);
		l17.setBounds(10,280,150,150);	
		l18.setBounds(50,280,600,150);
		

	
	b1=new JButton("Home");
	b2=new JButton("Login");
	b3=new JButton("Registration");
	b4=new JButton("About");
	b5=new JButton("Contact us");
	b6=new JButton("Bedsheets");
	b7=new JButton("Curtains");
	b8=new JButton("Blankets");
	b9=new JButton("Covers");
	b10=new JButton("Furnish");
	

	b1.setBounds(170,3,80,20);
 	b2.setBounds(260,3,80,20);
	b3.setBounds(350,3,130,20);
 	b4.setBounds(480,3,80,20);
 	b5.setBounds(570,3,110,20);
	b6.setBounds(30,125,120,20);
 	b7.setBounds(30,175,120,20);
	b8.setBounds(30,225,120,20);
 	b9.setBounds(30,275,120,20);
 	b10.setBounds(30,325,120,20);


	                 b1.setBackground(Color.white);
		b2.setBackground(Color.white);
		b3.setBackground(Color.white);
		b4.setBackground(Color.white);
		b5.setBackground(Color.white);
		b6.setBackground(Color.white);
		b7.setBackground(Color.white);
		b8.setBackground(Color.white);
		b9.setBackground(Color.white);
		b10.setBackground(Color.white);
		
		b1.setForeground(Color.green);
		b2.setForeground(Color.green);
		b3.setForeground(Color.green);
		b4.setForeground(Color.green);
		b5.setForeground(Color.green);
		b6.setForeground(Color.blue);
		b7.setForeground(Color.blue);
		b8.setForeground(Color.blue);
		b9.setForeground(Color.blue);
		b10.setForeground(Color.blue);


		b1.setFont(f6);
		b2.setFont(f6);
		b3.setFont(f6);
		b4.setFont(f6);
		b5.setFont(f6);
		b6.setFont(f5);
		b7.setFont(f5);
		b8.setFont(f5);
		b9.setFont(f5);
		b10.setFont(f5);
		
	b1.setBorder(null);
 	b2.setBorder(null);
	b3.setBorder(null);
	b4.setBorder(null);
 	b5.setBorder(null); 
	b6.setBorder(null);
	b7.setBorder(null);
	b8.setBorder(null);
	b9.setBorder(null);
 	b10.setBorder(null);


    
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    
	
		p1.add(l1);	
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);

		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);

		p3.add(l6);

		p4.add(l7);
		p4.add(l8);
		p4.add(b6);
		p4.add(b7);
		p4.add(b8);
		p4.add(b9);
		p4.add(b10);

		p5.add(l9);
		p5.add(l10);
		p5.add(l11);
		p5.add(l12);
        p5.add(l13);
		p5.add(l14);
		p5.add(l15);
		//p5.add(l16);
		//p5.add(l17);
		p5.add(l18);



frame.setVisible(true);

}                                      //end of constructor

public void actionPerformed(ActionEvent e)
	{


        		if(e.getSource()==b1)
        		{
                    p5.setVisible(true);
                }
                 if(e.getSource()==b2)
                {
                    p5.setVisible(false);
                    l.setVisible(true);

               }
                 if(e.getSource()==b3)
                {
                    new register();

               }
             if(e.getSource()==b4)
                {
                    p5.setVisible(true);
               }

             if(e.getSource()==b5)
                {
 JOptionPane.showMessageDialog(null," Ph:+91-01802631383" +"\n"+ "Website:https://www.bbmgroups.com"+"\nEmail:bbmtextiles@bbmgroups.com");
             }


}
public static void main(String args[])
{
 new bbm1();
}	

 public static void close()
{

     frame.setVisible(false);
   

}
}                                      //end of class
