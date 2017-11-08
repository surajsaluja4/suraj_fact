package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class admin_area implements  ActionListener
{

    static JFrame frame=new JFrame();

    static JPanel p1,p2;
    JLabel l1,l2;
    static JButton macp,adcp,log;
    static admin_verification av;
   static admin_area_managercp aac;
   static admin_area_admincp aamc;

    admin_area()
    {
        frame.setSize(900,800);
        frame.setLayout(null);
        frame.setResizable(false);
	


       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         p1=new JPanel();
         p2=new JPanel();
         av=new admin_verification();
         aac=new admin_area_managercp();
         aamc=new admin_area_admincp();


         p1.setBounds(0,0,900,270);
         p2.setBounds(0,185,900,530);


          p1.setBackground(Color.white);
          p2.setBackground(Color.white);

          p1.setLayout(null);
          p2.setLayout(null);

          frame.add(p1);

          frame.add(p2);
          frame.add(aac);
          frame.add(aamc);


        l1=new JLabel(new ImageIcon("img/admin_area/adm1.jpg"));
        l2=new JLabel(new ImageIcon("img/admin_area/adm2.png"));
        adcp=new JButton(new ImageIcon("img/admin_area/adm_bt1.png"));
        macp=new JButton(new ImageIcon("img/admin_area/adm_bt2.png"));
        log=new JButton(new ImageIcon("img/admin_area/adm_bt3.png"));


        l1.setBounds(20,10,250,250);
   		l2.setBounds(325, 10 , 400, 360);
        adcp.setBounds(180,100,500,155);
        macp.setBounds(180,256,500,155);
        log.setBounds(180,410,500,155);
        //macp.setBounds(350,40,200,200);


        adcp.setBorder(null);
        adcp.setBackground(Color.white);
        macp.setBorder(null);
        macp.setBackground(Color.white);
        log.setBorder(null);
        log.setBackground(Color.white);

        p1.add(l1);
        p1.add(l2);
        p2.add(macp);
        p2.add(adcp);
        p2.add(log);

        log.addActionListener(this);
        macp.addActionListener(this);
        adcp.addActionListener(this);

        frame.setVisible(true);
    }

public void actionPerformed(ActionEvent e)
	{
       // System.out.print(e);
		if(e.getSource()==log)
		{
        frame.setVisible(false);
        av.setVisible(false);
        new Main();

        }
        if(e.getSource()==macp)
		{
        p2.setVisible(false);
        av.setVisible(false);
        aac.setVisible(true);

        }

        if(e.getSource()==adcp)
		{
        p2.setVisible(false);
        av.setVisible(false);
        aamc.setVisible(true);

        }
}
  public static void close()
  {

       p1.setVisible(false);
       p2.setVisible(false);
       aac.setVisible(false);
       av.setVisible(false);
       frame.setVisible(false);
  
  }
    public static void main(String[] args)
    {
        new admin_area();

    }
}
