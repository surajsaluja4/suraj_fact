package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory.*;

class edit_supplier extends JFrame implements ActionListener,key
{
   static  JFrame f1;
      JLabel or1,or2,edit;
	  JTextField t,s,g,p;
      JPanel p1;
      JButton ok,can;
      int key;
Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		final Font f10=new Font("Lucida Handwriting",Font.ITALIC, 20);
      final  Font f11=new Font("Lucida Handwriting",Font.BOLD, 20);
edit_supplier(int key)
{
   setResizable(false);
		this.key=key;


		setSize(900,800);

        p1=new JPanel();//for the scroll pane
        p1.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//to be checked


		p1.setLayout(null);
        p1.setBounds(0,0,900,800);
		p1.setBackground(Color.white);
        add(p1);

    or1=new JLabel("Or");
    or2=new JLabel("Or");
    if(key==1)
    edit=new JLabel("Edit Supplier's Data");
    else
    edit=new JLabel("Delete Supplier's Data");

    t=new JTextField(25);
    s=new JTextField(25);            //text field for id
   g=new JTextField(25);            //text field for gst
    p=new JTextField(25);            //text field for phn


    ok=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    ok.setBorder(null);
	can=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    can.setBorder(null);

    edit.setBounds(240,60,600,60);
	edit.setFont(f9);
	edit.setForeground(Color.RED);
    p1.add(edit);

     t.setBounds(0,0,0,0);
	p1.add(t);


    s.setBounds(210,220,480,30);
	s.setFont(f10);
	s.setForeground(Color.GRAY);
    p1.add(s);
    s.setText("              Enter Your Supplier Id");
    s.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        s.setText("");
        s.setForeground(Color.BLACK);
        s.setFont(f11);

      }

      public void focusLost(FocusEvent e) {
          if(s.getText().toString().equals(""))
          {s.setFont(f10);
            s.setForeground(Color.GRAY);

              s.setText("              Enter Your Supplier Id");
          }
      }
    });


    or1.setBounds(390,270,180,30);
	or1.setFont(f10);
	or1.setForeground(Color.BLACK);
    p1.add(or1);

    g.setBounds(210,320,480,30);
	g.setFont(f10);
	g.setForeground(Color.GRAY);
    p1.add(g);
    g.setText("          Enter Your Supplier's GST No.");
    g.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        g.setText("");
        g.setForeground(Color.BLACK);
        g.setFont(f11);

      }

      public void focusLost(FocusEvent e) {
          if(g.getText().toString().equals(""))
          {g.setFont(f10);
            g.setForeground(Color.GRAY);

              g.setText("          Enter Your Supplier's GST No.");
          }
      }
    });


    or2.setBounds(390,370,180,30);
	or2.setFont(f10);
	or2.setForeground(Color.BLACK);
    p1.add(or2);

    p.setBounds(210,420,480,30);
	p.setFont(f10);
	p.setForeground(Color.GRAY);
    p1.add(p);
    p.setText("          Enter Your Supplier's Phone No.");
    p.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        p.setText("");
        p.setForeground(Color.BLACK);
        p.setFont(f11);

      }

      public void focusLost(FocusEvent e) {
          if(p.getText().toString().equals(""))
          {p.setFont(f10);
            p.setForeground(Color.GRAY);

              p.setText("          Enter Your Supplier's Phone No.");
          }
      }
    });


     ok.setBounds(210,590,205,45);
     ok.setBackground(Color.white);


	can.setBounds(460,590,200,45);
	can.setBackground(Color.white);

    p1.add(ok);
    p1.add(can);



        ok.addActionListener(this);
        can.addActionListener(this);




   setVisible(true);


}

public void actionPerformed(ActionEvent e)
	{
       	if(e.getSource()==can)
		{

                 setVisible(false);
         if(f1==null)
            new manager_area().st_true(4);
            else
            f1.setVisible(true);
        }
		if(e.getSource()==ok)
		{
            String ss,sg,sp;
            ss=s.getText().toString();
            sg=g.getText().toString();
            sp=p.getText().toString();

            if(!ss.equals("              Enter Your Supplier Id"))
            {
                 if(ss.startsWith("SUP0"))
                { setVisible(false);
                new edit_supplier_form(ss,1,key);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"No Such Supplier Exits");
                    s.setFont(f10);
                    s.setForeground(Color.GRAY);

                     s.setText("              Enter Your Supplier Id");

                 }
                 }
            else if(!sg.equals("          Enter Your Supplier's GST No."))
            {
             new edit_supplier_form(sg,2,key);
            setVisible(false);
            //dispose();
            }
            else if(!sp.equals("          Enter Your Supplier's Phone No."))
            {
             new edit_supplier_form(sp,3,key);
            setVisible(false);
            }

            else
                JOptionPane.showMessageDialog(null,"Please Fill Any One Parameter");

        }
}
public static void getframe(JFrame fr){
    fr.getClass();
       f1=fr;
}

public static void main(String []args)
 {

    new edit_supplier(2);

}


}
