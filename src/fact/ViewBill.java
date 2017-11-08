/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;



import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.DriverManager;
import javax.swing.BorderFactory.*;
import java.util.Vector;
import javax.swing.border.TitledBorder;


class ViewBill  implements ActionListener,key
{
    static JFrame frame=new JFrame();

      JLabel or[]=new JLabel[10];
      JLabel edit;
	  JTextField t,s,g,p;
      JPanel p1,p2;
      JButton ok,can,view;
     static JComboBox pro_list,item_list;
       Vector list,list2;
       final String opt1="              Enter Your Bill Number";
       final String opt2="          Enter Customer Number";
       final String opt3="          Enter Customer Name";
        Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		Font f8=new Font("Modern No. 20",Font.PLAIN, 20);

        final Font f10=new Font("Lucida Handwriting",Font.ITALIC, 20);
      final  Font f11=new Font("Lucida Handwriting",Font.BOLD, 20);
ViewBill()
{
   frame.setResizable(false);
   frame.setBackground(Color.WHITE);

		frame.setSize(900,800);

p2=new JPanel();
p2.setLayout(null);
p2.setBackground(Color.white);
p2.setBounds(0, 0, 900, 800);

        p1=new JPanel();//for the scroll pane
        frame.setLayout(null);
        p1.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

p2.add(p1);
frame.add(p2);
		//to be checked


		p1.setLayout(null);
        p1.setBounds(70,100,750,600);
		p1.setBackground(Color.white);


    or[0]=new JLabel("Or");
    or[1]=new JLabel("Or");
    or[2]=new JLabel("Or");
    or[3]=new JLabel("Or");
    or[4]=new JLabel("Or");

pro_list=new JComboBox();

    edit=new JLabel("View Bills");

    t=new JTextField(25);
    s=new JTextField(25);            //text field for id
   g=new JTextField(25);            //text field for gst
    p=new JTextField(25);            //text field for phn


    ok=new JButton("Submit");
    can=new JButton("Cancel");
    view=new JButton("View All");
    edit.setBounds(240,60,600,60);
	edit.setFont(f9);
	edit.setForeground(Color.RED);
    //p1.add(edit);

     t.setBounds(0,0,0,0);
	p1.add(t);

   view.setBounds(140,70,480,30);
   view.setFont(f10);
   view.setForeground(Color.GRAY);
   view.setBackground(Color.WHITE);


    or[4].setBounds(365,120,480,30);
    or[4].setFont(f10);
	or[4].setForeground(Color.BLACK);
    p1.add(or[4]);

    s.setBounds(140,170,480,30);
	s.setFont(f10);
	s.setForeground(Color.GRAY);
    p1.add(s);
    s.setText(opt1);
    s.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        s.setText("");
        s.setForeground(Color.BLACK);
        s.setFont(f8);

      }

      public void focusLost(FocusEvent e) {
          if(s.getText().toString().equals(""))
          {s.setFont(f10);
            s.setForeground(Color.GRAY);

              s.setText(opt1);
          }
      }
    });


    or[0].setBounds(365,220,180,30);
	or[0].setFont(f10);
	or[0].setForeground(Color.BLACK);
    p1.add(or[0]);

    g.setBounds(140,270,480,30);
	g.setFont(f10);
	g.setForeground(Color.GRAY);
    p1.add(g);
    g.setText(opt2);
    g.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        g.setText("");
        g.setForeground(Color.BLACK);
        g.setFont(f8);

      }

      public void focusLost(FocusEvent e) {
          if(g.getText().toString().equals(""))
          {g.setFont(f10);
            g.setForeground(Color.GRAY);

              g.setText(opt2);
          }
      }
    });


    or[1].setBounds(365,320,180,30);
	or[1].setFont(f10);
	or[1].setForeground(Color.BLACK);
    p1.add(or[1]);

    p.setBounds(140,370,480,30);
	p.setFont(f10);

    p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2), "View Bills", TitledBorder.LEFT, TitledBorder.TOP,f9));
	p.setForeground(Color.GRAY);
    p1.add(p);
    p.setText(opt3);
    p.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        p.setText("");
        p.setForeground(Color.BLACK);
        p.setFont(f8);

      }

      public void focusLost(FocusEvent e) {
          if(p.getText().toString().equals(""))
          {p.setFont(f10);
            p.setForeground(Color.GRAY);

              p.setText(opt3);
          }
      }
    });

         list=new Vector(100);
         list2=new Vector(100);
         list2.add(0,"Product Items");
             try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                         Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=1;

                        if(con!=null)
                            {
                         PreparedStatement  ps=con.prepareStatement("select prod_id from product_item ");
                       ResultSet rs=ps.executeQuery();
                        i=1;
                        while(rs.next())
                            {
                                list2.add(i,(String)rs.getString("prod_id"));


                                } //end of while loop

                        }  // end of if
                             }

                                   catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block


         item_list=new JComboBox(list2);

    or[2].setBounds(365,450,180,30);
	or[2].setFont(f10);
	or[2].setForeground(Color.BLACK);
    p1.add(or[2]);

    pro_list.setBounds(140,450,200,30);
	pro_list.setFont(f10);
	pro_list.setForeground(Color.GRAY);
    pro_list.setBackground(Color.WHITE);
    //pro_list.setSelectedIndex(-1);
    p1.add(pro_list);

    item_list.setBounds(420,450,200,30);
	item_list.setFont(f10);
	item_list.setForeground(Color.GRAY);
    item_list.setBackground(Color.WHITE);
    //item_list.setSelectedIndex(-1);
   	 p1.add(item_list);



       item_list.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if(item_list.getSelectedIndex()!=0)
                {
                item_list.setForeground(Color.BLACK);
                item_list.getEditor().getEditorComponent().setForeground(Color.black);
                item_list.setFont(f8);
                }
                else
                {
                    item_list.setForeground(Color.GRAY);
                item_list.setFont(f10);
                    item_list.getEditor().getEditorComponent().setForeground(Color.gray);

                }
                }
        });
              pro_list.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if(pro_list.getSelectedIndex()!=0)
                {
                pro_list.setForeground(Color.BLACK);
                pro_list.getEditor().getEditorComponent().setForeground(Color.black);

                pro_list.setFont(f8);
                }
                else
                {
                    pro_list.setForeground(Color.black);
                    pro_list.getEditor().getEditorComponent().setForeground(Color.gray);

                pro_list.setFont(f10);
                }
                }
        });
pro_list.setEditable(true);

search sbm = new search(pro_list,Connection1.dbmanager,"product_group","name","Products");
pro_list.setModel(sbm);

pro_list.addItemListener(sbm);
pro_list.addMouseListener(sbm);
pro_list.addFocusListener(sbm);
pro_list.getEditor().setItem("Products");
pro_list.getEditor().getEditorComponent().setForeground(Color.gray);

item_list.setEditable(true);

search sbm1 = new search(item_list,Connection1.dbmanager,"product_item","prod_id","Product Items");

item_list.setModel(sbm1);

item_list.addItemListener(sbm1);
item_list.addMouseListener(sbm1);
item_list.addFocusListener(sbm1);
item_list.getEditor().setItem("Product Items");
item_list.getEditor().getEditorComponent().setForeground(Color.gray);


     ok.setBounds(160,520,180,30);
     can.setBounds(410,520,180,30);

    p1.add(ok);
    p1.add(can);
    p1.add(view);


        ok.addActionListener(this);
        can.addActionListener(this);
        view.addActionListener(this);



   frame.setVisible(true);


}

public void actionPerformed(ActionEvent e)
	{
       	if(e.getSource()==can)
		{

                frame.setVisible(false);
                 new manager_area().st_true(4);
        }
        if(e.getSource()==view)
		{

                frame.setVisible(false);
                 new view_frame(1);
        }
		if(e.getSource()==ok)
		{
            String ss,sg,sp;
            ss=s.getText().toString();
            
            sg=g.getText().toString();
            
            sp=p.getText().toString();
           

            if(!ss.equals(opt1))
            {
                 if(ss.startsWith("SUP0"))
                { frame.setVisible(false);
                new edit_supplier_form(ss,1,3);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"No Such Bill Number Exits");
                    s.setFont(f10);
                    s.setForeground(Color.GRAY);

                     s.setText(opt1);

                 }
                 }
            else if(!sg.equals(opt2))
            {
             new edit_supplier_form(sg,2,3);
            frame.setVisible(false);
            //dispose();
            }
            else if(!sp.equals(opt3))
            {
             new edit_supplier_form(sp,3,3);
            frame.setVisible(false);
            }

            else
                JOptionPane.showMessageDialog(null,"Please Fill Any One Parameter");

        }
}
public static void main(String []args)
 {

    new ViewBill();

}


}

