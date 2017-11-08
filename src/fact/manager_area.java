package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class manager_area implements  ActionListener{
    static JFrame frame=new JFrame();
   // JPanel p1,p2;
          JLabel l1,l2,l3,l4;
      static    JPanel p1=new JPanel();
       static   JPanel p2=new JPanel();
       static    manager_area_supplier mas;
       static    manager_area_products map;
       static    manager_area_employee mae;
       static    manager_area_transaction_area mata;
       static    add_product ap;
           
           JButton cost,staff,product,log,supp,bill,note;
		Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
        Font f1=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
    manager_area()
    {
        frame.setSize(900,800);
        frame.setLayout(null);
        frame.setResizable(false);
	

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



          mas=new manager_area_supplier();
          map=new manager_area_products();
          mae=new manager_area_employee();
          mata=new manager_area_transaction_area();
          ap=new add_product();


          p1.setBounds(0,0,900,240);
          p2.setBounds(0,240,900,530);


          p1.setBackground(Color.white);
          p2.setBackground(Color.white);

          p1.setLayout(null);
          p2.setLayout(null);

          frame.add(p1);

          frame.add(p2);

          frame.add(mas);
          frame.add(map);
          frame.add(mae);
          frame.add(mata);
          frame.add(ap);





        l1=new JLabel(new ImageIcon("img/manager_area/man.png"));
        l2=new JLabel(new ImageIcon("img/manager_area/man2.png"));
        l3=new JLabel("Welcome:  ");
        l4=new JLabel(Main.welcomename.toUpperCase());                                                                             // to be edited later using value from database
        l3.setFont(f1);
        l4.setFont(f1);

        log=new JButton("LogOut");
        cost=new JButton(new ImageIcon("img/manager_area/money.png"));
        supp=new JButton(new ImageIcon("img/manager_area/supp.png"));
        staff=new JButton(new ImageIcon("img/manager_area/staff.png"));
        product=new JButton(new ImageIcon("img/manager_area/product.png"));
        bill=new JButton(new ImageIcon("img/manager_area/bill.png"));
        note=new JButton(new ImageIcon("img/manager_area/notepad.png"));

        log=new JButton("LogOut");

        log.setForeground(Color.BLUE);
        log.setFont(f);


        l1.setBounds(-10,0,250,250);
   		l2.setBounds(320, -30 ,400,300);
        l3.setBounds(570,180,140,100);
        l4.setBounds(690,180,140,100);

        log.setBounds(740,10,120,50);

        supp.setBounds(20,0,220,220);
        cost.setBounds(320,0,220,220);
        staff.setBounds(620,0,220,220);
        product.setBounds(20,200,220,220);
        bill.setBounds(320,200,220,220);
        note.setBounds(620,210,220,220);


        log.setBorder(null);
        log.setBackground(Color.white);


        supp.setBorder(null);
        supp.setBackground(Color.white);
        cost.setBorder(null);
        cost.setBackground(Color.white);
        staff.setBorder(null);
        staff.setBackground(Color.white);
        product.setBorder(null);
        product.setBackground(Color.white);
        bill.setBorder(null);
        bill.setBackground(Color.white);
        note.setBorder(null);
        note.setBackground(Color.white);

        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(l4);
        p1.add(log);


        p2.add(supp);
        p2.add(cost);
        p2.add(staff);
        p2.add(product);
        p2.add(bill);
        p2.add(note);



        supp.addActionListener(this);
        log.addActionListener(this);
        product.addActionListener(this);
        staff.addActionListener(this);
        note.addActionListener(this);
        cost.addActionListener(this);
        bill.addActionListener(this);


        frame.setVisible(true);
        p1.setVisible(true);
        p2.setVisible(true);






    }


public static void close()
  {

       p1.setVisible(false);
       p2.setVisible(false);
       mas.setVisible(false);
       map.setVisible(false);
       mae.setVisible(false);
       mata.setVisible(false);
       ap.setVisible(false);
       frame.setVisible(false);

  }

public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==supp)
		{

        p2.setVisible(false);
        mas.setVisible(true);
        }

        if(e.getSource()==log)
		{

        frame.setVisible(false);
        new Main();
        }

		if(e.getSource()==product)
		{

        p2.setVisible(false);
        map.setVisible(true);
        }
        if(e.getSource()==staff)
		{

        p2.setVisible(false);
        mae.setVisible(true);
        }

        if(e.getSource()==cost)
		{

        p2.setVisible(false);
       // ap.setVisible(true);
        mata.setVisible(true);
        }
        if(e.getSource()==bill)
        {
            frame.dispose();
            new billing_form();
        }


        if(e.getSource()==note)
        {
             Runtime rs = Runtime.getRuntime();

    try {
      rs.exec("notepad");
    }
    catch (Exception ex) {
      System.out.println(ex);
    }
        }
    }


public void st_true(int i)
{
    if(i==1)
    {
    p1.setVisible(true);
    p2.setVisible(false);
    map.setVisible(true);
    }
    if(i==4)
    {
    p1.setVisible(true);
    p2.setVisible(false);
    mas.setVisible(true);
    }
     if(i==2)
    {

    p2.setVisible(false);
    ap.setVisible(true);

    }
    if(i==3)
    {
    p1.setVisible(true);
    p2.setVisible(false);
    mae.setVisible(true);
    }
    if(i==5)
    {
        frame.dispose();
        frame.setVisible(true);
      
    }


}



    public static void main(String[] args) {
        new manager_area();

    }
}
