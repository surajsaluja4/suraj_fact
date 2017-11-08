//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JComboBox;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
class billing_form  implements ActionListener
{
    static JFrame frame=new JFrame();
    static String name,grp_supp,size;
    int sp,sold_quant;
    double gst,disi,total;
    JLabel bill,bn,date,up,prod,quantity,disc,fol,pe1,sgst,csnm,cno,cgst,cusphn,time,totquant;
    JTextField b,d,u,cus,quant,c,sg,cn,ctx,g,dis,ph,t;
    JComboBox pro_list;
    JButton ok,cancel,add,clear;
    JScrollPane scrpn;
       Vector list,check;
        Font f9=new Font("Modern No. 20",Font.BOLD, 40);
        Font f10=new Font("Modern No. 20",Font.PLAIN, 13);
		Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 25);
        JPanel p1,p;
       static JTable tb;
        static DefaultTableModel model;
    static String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());
        int ct=0;
       static int ret=0,rt=0;
static String ps="",qs="",ds="",ts="";
    private FocusListener l;
billing_form()
{
  	
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    System.out.println(timeStamp);

    check=new Vector();
                   
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);   // for maxamizing the frame


        p1=new JPanel();
        p=new JPanel();
        p.setLayout(null);
		p.setBackground(Color.white);



       int width=Toolkit.getDefaultToolkit().getScreenSize().width;
       int hieght=Toolkit.getDefaultToolkit().getScreenSize().height;
       p1.setSize(width,hieght);
      // p1.setBounds(200,200,1080,580);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		frame.add(p1);

        bill=new JLabel("Billing Portal");
        bn=new JLabel("Bill no.:");
        time=new JLabel("Time :");
        date=new JLabel("Date :");
        prod=new JLabel("Products List :");
        up=new JLabel("Unit Price :");
        quantity=new JLabel("Quantity:");
        disc=new JLabel("Discount % :");
        sgst=new JLabel("SGST % :");
        csnm=new JLabel("Cust. No. :");
        cno=new JLabel("Cust. Name :");
        cgst=new JLabel(" CGST % :");
        cusphn=new JLabel("Cust Phn. :");

        ok=new JButton("Ok");
        cancel=new JButton("Cancel");
        add=new JButton("Add");

        clear=new JButton("Clear The Selected Row");


        quant=new JTextField(25);
        dis=new JTextField(25);
        c=new JTextField(25);
        t=new JTextField(25);
        b=new JTextField(1);
        d=new JTextField(1);
        u=new JTextField(3);
        sg=new JTextField(25);
        g=new JTextField(25);
        cn=new JTextField(25);
        ctx=new JTextField(25);
        ph=new JTextField(25);
         try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select id from billing ");
                        ResultSet rs=ps.executeQuery();

                        while(rs.next())
                            {
                                    ret=Integer.parseInt((String)rs.getString("id"));


                            } //end of while loop
                        ps=con.prepareStatement("select id from customer ");
                        rs=ps.executeQuery();

                        while(rs.next())
                            {
                                    rt=Integer.parseInt((String)rs.getString("id"));


                            } //end of while loop

                        }
                       }
  catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block
b.setText(Integer.toString(ret++));
b.setEditable(false);
cn.setText(Integer.toString(rt++));
cn.setEditable(false);
d.setText(timeStamp.substring(0,10));
t.setText(timeStamp.substring(11));
d.setEditable(false);
t.setEditable(false);



        bill.setBounds(520,20,450,40);
        bill.setFont(f9);
        bill.setForeground(Color.red);
        bill.setBackground(Color.white);
        p1.add(bill);

    ok=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    ok.setBorder(null);
	cancel=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    cancel.setBorder(null);


    bn.setBounds(130,80,180,30);
	bn.setFont(f);
	bn.setForeground(Color.black);
	p1.add(bn);

    b.setBounds(295,80,80,28);
	b.setFont(f);
	b.setForeground(Color.black);
	p1.add(b);

    time.setBounds(600,80,180,30);
	time.setFont(f);
	time.setForeground(Color.black);
	p1.add(time);

    t.setBounds(760,80,100,28);
	t.setFont(f);
	t.setForeground(Color.black);
	p1.add(t);

    date.setBounds(1010,80,180,40);
    date.setFont(f);
	date.setForeground(Color.black);
	p1.add(date);

    d.setBounds(1140,80,130,28);
	d.setFont(f);
	d.setForeground(Color.black);
	p1.add(d);




    prod.setBounds(130,120,360,30);
	prod.setFont(f);
	prod.setForeground(Color.black);
	p1.add(prod);

    list=new Vector(100);

         try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=0;

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select prod_id from product_item ");
                        ResultSet rs=ps.executeQuery();

                        while(rs.next())
                            {
                                list.add(i,(String)rs.getString("prod_id"));
                                i++;
                            } //end of while loop
                        }  // end of if
                             }

                                   catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

         pro_list=new JComboBox(list);

    pro_list.setBounds(295,120,180,30);   //30,120
	pro_list.setFont(f);
	pro_list.setForeground(Color.black);
    pro_list.setBackground(Color.white);
    pro_list.setSelectedIndex(-1);
   	p1.add(pro_list);
    pro_list.addActionListener(this);

    up.setBounds(600,120,180,30);   //30,120
	up.setFont(f);
	up.setForeground(Color.black);
    up.setBackground(Color.white);
   	p1.add(up);

    u.setBounds(760,120,100,30);   //30,120
	u.setFont(f);
	u.setForeground(Color.black);
    u.setBackground(Color.white);
   	p1.add(u);


    quantity.setBounds(1010,120,200,30);
	quantity.setFont(f);
	quantity.setForeground(Color.black);
	p1.add(quantity);

    quant.setBounds(1140,120,110,30);
	quant.setFont(f);
	quant.setForeground(Color.black);
	p1.add(quant);

    disc.setBounds(130,170,200,30);
	disc.setFont(f);
	disc.setForeground(Color.black);
	p1.add(disc);

    
    dis.setBounds(295,170,100,30);
	dis.setFont(f);
	dis.setForeground(Color.black);
	p1.add(dis);
    dis.addFocusListener(l);

    cgst.setBounds(600,170,200,30);
	cgst.setFont(f);
	cgst.setForeground(Color.black);
	p1.add(cgst);

    c.setBounds(760,170,100,30);
	c.setFont(f);
	c.setForeground(Color.black);
	p1.add(c);

    sgst.setBounds(1010,170,200,30);
	sgst.setFont(f);
	sgst.setForeground(Color.black);
	p1.add(sgst);

    sg.setBounds(1140,170,110,30);
	sg.setFont(f);
	sg.setForeground(Color.black);
	p1.add(sg);

    csnm.setBounds(130,225,200,30);
	csnm.setFont(f);
	csnm.setForeground(Color.black);
	p1.add(csnm);



    cn.setBounds(295,225,100,30);
	cn.setFont(f);
	cn.setForeground(Color.black);
	p1.add(cn);

    cno.setBounds(600,225,200,30);
	cno.setFont(f);
	cno.setForeground(Color.black);
	p1.add(cno);

    ctx.setBounds(760,225,100,30);
	ctx.setFont(f);
	ctx.setForeground(Color.black);
	p1.add(ctx);


    cusphn.setBounds(1010,225,350,30);
	cusphn.setFont(f);
	cusphn.setForeground(Color.black);
    p1.add(cusphn);

    ph.setBounds(1140,225,110,30);
	ph.setFont(f);
    ph.setBackground(Color.white);
	ph.setForeground(Color.black);
	p1.add(ph);

    add.setBounds(530,275,100,30);
    p1.add(add);

    clear.setBounds(670,275,180,30);
    p1.add(clear);


        model = new DefaultTableModel()
        {

            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }
        };
        Object []column={"Sl.No.","Product Id","Product Name","Size","Unit_price","Quantity","total"};


        tb=new JTable();
        tb.setModel(model);
        model.setColumnIdentifiers(column);
        tb.setFillsViewportHeight(true);            // to use the entire hiegth of the scroll pane
         tb.getColumnModel().getColumn(0).setPreferredWidth(0);

        scrpn=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      	scrpn.setFont(f);
         scrpn.setBounds(80, 340, 1200, 200);
	    scrpn.setForeground(Color.black);

        scrpn.setVisible(true);
        p1.add(scrpn,BorderLayout.CENTER);

    	ok.setBounds(420,590,205,45);


	cancel.setBounds(695,590,200,45);
    p1.add(ok);
    p1.add(cancel);


    ok.addActionListener(this);
    cancel.addActionListener(this);
    add.addActionListener(this);
    clear.addActionListener(this);

    frame.setVisible(true);

}  //end of constructor




public void actionPerformed(ActionEvent e)
	{

    if(e.getSource()==pro_list)
        {
          String sel=pro_list.getItemAt(pro_list.getSelectedIndex()).toString();
                            try
                             {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select name,grp_supp,size,sp,gst,disc,sold_quant from product_item where prod_id='"+sel+"' ");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                                name=(String)rs.getString("name");
                                grp_supp=(String)rs.getString("grp_supp");
                                size=(String)rs.getString("size");
                                sp=rs.getInt("sp");
                                gst=rs.getInt("gst");
                                disi=rs.getInt("disc");
                                sold_quant=rs.getInt("sold_quant");

                            }    //end of while loop

                            u.setText(Integer.toString(sp));
                            
                            c.setText(Double.toString(gst/2));
                            c.setEditable(false);
                            sg.setText(Double.toString(gst/2));
                            sg.setEditable(false);
                            quant.setText("1");
                            dis.setText("0");
                            total=((sp*gst)/100);
                            total+=sp;


                        }
                            }
catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

        }
                if(e.getSource()==add)
        {
                   int ctr=0,ctrr=0;
                   for(int i=0;i<check.size();i++)
                   {
                      
                       if(pro_list.getItemAt(pro_list.getSelectedIndex()).toString().equals(check.elementAt(i).toString()))
                       {
                          int disp=Integer.parseInt(model.getValueAt(i, 8).toString());
                           
                           int disn=Integer.parseInt(dis.getText().toString());
                           
                           if(disn==disp){
                           ctr=i;
                           ctrr=i==0?1:i;
                           }
                           
                       }
                   }

                    String quants;


                    quants=(String)quant.getText();
                    
                    if(pro_list.getItemAt(pro_list.getSelectedIndex())==null||u.getText().toString().equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Please select a product");
                    }
                   
                    else

                    {
                         if(quants.equals(""))
                               {
                          JOptionPane.showMessageDialog(null,"Quantity Cannot be Empty");
                                }    // end of if (to check for empty fields)
                         else
                         {

                                  int temp=dis.getText().equals("")?0:Integer.parseInt(dis.getText());
                                   if(temp>disi)
                                        {
                 JOptionPane.showMessageDialog(null,"Maximum Discount Allowed on this product is: "+disi+"%");
                                dis.setText("");
                                        }  // end of discount check
                                   else
                                   {
                                        if(ctr==0&&ctrr==0)
                                        {
                                      total-=(total*temp)/100;  ///calculating discount
                                      total*=Integer.parseInt(quants);
                                      Object ob[]=new Object[]{++ct,pro_list.getItemAt(pro_list.getSelectedIndex()).toString(),name,size,sp,quant.getText(),c.getText(),sg.getText(),dis.getText(),total};
                    model.addRow(ob);
                    check.add(pro_list.getItemAt(pro_list.getSelectedIndex()).toString());

                    u.setText("");
                    c.setText("");
                    sg.setText("");
                    ctx.setEditable(false);
                    cn.setEditable(false);
                                        }
                                        else
                                        {
                                            
                                        int q=Integer.parseInt(model.getValueAt(ctr, 5).toString())+Integer.parseInt(quant.getText());
                                            model.setValueAt(q, ctr, 5);
                                           total*=q;
          model.setValueAt(total, ctr, 9);
u.setText("");
                    c.setText("");
                    sg.setText("");
                    
                                        }
                    }
                         }
                    }


        }
if(e.getSource()==clear)
		{
            int sel=tb.getSelectedRow();
            if(sel!=-1)
            {
                if(sel+1<ct)
                {
               int i= Integer.parseInt(tb.getValueAt(sel+1, 0).toString());
                ct--;
                model.removeRow(sel);
                for(int l=sel;l<ct-1;l++)
                {
                    tb.setValueAt(i-1, sel, 0);
                    i= Integer.parseInt(tb.getValueAt(++sel, 0).toString());
                }
                    tb.setValueAt(i-1, sel, 0);
                }
                else
                {
                 
                    model.removeRow(sel);
                    ct--;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please Select a Row for Deletion");

            }
           total=0; 
 for(int i=0;i<check.size();i++)
                   {
                   check.remove(sel);
                   }
        }

        if(e.getSource()==ok)
		{
            if((ph.getText().toString()=="")||(cn.getText().toString()==""))
            {
                JOptionPane.showMessageDialog(null, "Please enter Cusomer Details");
            }
            else{

                Object o=new Object();
                Vector pv=new Vector();
                Vector qv=new Vector();
                Vector dv=new Vector();
                Vector tv=new Vector();
            for(int i=0;i<tb.getRowCount();i++)
            {
                o=tb.getValueAt(i,1);
                System.out.println("1 ss "+tb.getValueAt(i, 1));

                pv.add(o);
                o=tb.getValueAt(i,5);
                qv.add(o);
                o=tb.getValueAt(i,7);
                dv.add(o);
                o=tb.getValueAt(i,9);
                tv.add(o);
                ps+=pv.elementAt(i)+",";
                qs+=qv.elementAt(i)+",";
                ds+=dv.elementAt(i)+",";
                ts+=tv.elementAt(i)+",";
             }

                try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                                  PreparedStatement st=con.prepareStatement("INSERT INTO `billing`(`date`, `time`, `cstno`,`products`,`quantity`,`disc`,`total`,`custname`) VALUES (?,?,?,?,?,?,?,?)");
                                  st.setString(1,d.getText());
                                  System.out.println("1"+d.getText());
                                  st.setString(2,t.getText());
                                  System.out.println("2"+t.getText());
                                  st.setLong(3,Long.parseLong(ph.getText()));
                                  System.out.println("Customer"+ph.getText().toString());
                                  st.setString(4,ps);
                                  st.setString(5,qs);
                                  st.setString(6,ds);
                                  st.setString(7,ts);
                                  st.setString(8, cn.getText().toString());
                                  st.executeUpdate();
                                   JOptionPane.showMessageDialog(null,"Bill inserted successfully");
                              //     billprint_2.setrows(tb.getRowCount());
                                   new billprint_2(Integer.parseInt(b.getText().toString()));
                                   frame.setVisible(false);

                        }
                                             }
                              catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block


            }    // end of for loop(i)


}
        if(e.getSource()==cancel)
		{
            frame.setVisible(false);
            p1.setVisible(false);
            new manager_area();



        }//close of the if that checks for the button pressed is cancel

}



public static void main(String []args)
 {
    new billing_form();

}


}   	//end of class