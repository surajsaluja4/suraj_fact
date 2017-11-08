
package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class staff_area implements ActionListener

{
    JPanel p1,p2;
    JLabel l1,l2,l3,ln1,ln2,ln3,ln4,ln5,ln6,ln7;
	JButton bill,pro,sta,note,log;
     static JFrame frame=new JFrame();
        Font f=new Font("Modern No. 20",Font.BOLD, 25);
		Font f1=new Font("Brush Script Std",Font.BOLD, 60);
		Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
        Font f3=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
        Font f4=new Font("Baskerville Old Face",Font.CENTER_BASELINE,26);

        	Font fn1=new Font("Lucida Handwriting",Font.BOLD, 80);
            Font fn4=new Font("Imprint MT Shadow",Font.ITALIC,15);
            Font fn6=new Font("Lucida Calligraphy",Font.BOLD,17	);



    staff_area()
    {

        frame.setSize(900,800);
        frame.setLayout(null);
        frame.setResizable(false);
	



         p1=new JPanel();
         p2=new JPanel();
         log=new JButton("LogOut");

         p1.setBounds(0,0,900,220);
         p2.setBounds(0,180,900,530);


          p1.setBackground(Color.white);
          p2.setBackground(Color.white);

          p1.setLayout(null);
          p2.setLayout(null);

          frame.add(p1);

          frame.add(p2);

        l1=new JLabel(new ImageIcon("img/LOGO.png"));
        l2=new JLabel("Welcome:  ");
        l3=new JLabel("Mr. Bharat");                                                                             // to be edited later using value from database
        bill=new JButton(new ImageIcon("img/staff/bill.png"));
        pro=new JButton(new ImageIcon("img/staff/pro.jpg"));
        sta=new JButton(new ImageIcon("img/staff/about.png"));
        note=new JButton(new ImageIcon("img/staff/note.png"));

        ln1=new JLabel(new ImageIcon("img/main/LOGO_NEW.png"));
        ln3=new JLabel("BBM GROUPS");
        ln4=new JLabel("Symbol of trust and Quality");
        ln5=new JLabel("No.4 Dharamshala Road ");
        ln6=new JLabel("Jharia,Dhanbad");
        //ln7=new JLabel(new ImageIcon("img/staff/cur.gif"));


        ln3.setFont(fn1);
        ln3.setForeground(Color.decode("#00a69c"));
        ln4.setFont(fn6);
        ln5.setFont(fn4);
        ln6.setFont(fn4);

        l2.setFont(f3);
        l3.setFont(f3);

        l1.setBounds(120,0,634,206);
        l2.setBounds(570,5,140,100);
        l3.setBounds(690,5,140,100);
        log.setBounds(10,30,110,30);
        bill.setBounds(160,80,200,200);
        pro.setBounds(450,70,270,250);
        sta.setBounds(170,320,180,180);
        note.setBounds(480,310,200,200);

        ln1.setBounds(10,10,190,190);
   		ln3.setBounds(210, 30, 800, 150);
 		ln4.setBounds(580, 150, 300, 30);
 		ln5.setBounds(690, 10, 180, 20);
        ln6.setBounds(710, 30, 130, 20);
       // ln7.setBounds(10, 60, 150, 420);




        p1.add(ln1);
		p1.add(ln3);
		p1.add(ln4);
		p1.add(ln5);
        p1.add(ln6);
      //  p2.add(ln7);

        log.setForeground(Color.BLUE);
        log.setFont(f4);

        log.setBorder(null);
        log.setBackground(Color.white);
        bill.setBorder(null);
        bill.setBackground(Color.white);
        pro.setBorder(null);
        pro.setBackground(Color.white);
        sta.setBorder(null);
        sta.setBackground(Color.white);
        note.setBorder(null);
        note.setBackground(Color.white);


         p1.add(l1);
         p2.add(l2);
         p2.add(l3);
         p2.add(log);
         p2.add(bill);
         p2.add(pro);
         p2.add(sta);
         p2.add(note);
         log.addActionListener(this);
         bill.addActionListener(this);
         frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
	{
       // System.out.print(e);
		if(e.getSource()==log)
		{
        frame.setVisible(false);
        new Main();

        }
        if(e.getSource()==bill)
		{
        frame.setVisible(false);
        new billing_form();

        }
    }
 public static void main(String[] args) {
      new staff_area();
        
    }
}
