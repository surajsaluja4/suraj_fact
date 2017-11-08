//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.util.Vector;


class add_product_item extends JFrame implements ActionListener,key
{

    JLabel prod,name,under,unit,size,company,supplier,open,quantity,pricper,fol,cp,pe1,addc,sp,pe,gst,disc,minprof,extra1,extra2,extra3,extra4;
    JTextField n,sz,sz1,sz2,sz3,cmp,quant,pr,c,ac,s,dis,pro;

    JComboBox pro_list,sz_unit,sup_list,g;
    JButton ok,cancel;
    Vector list3,list4,gstlist;
        Font f9=new Font("Modern No. 20",Font.BOLD, 40);
        Font f10=new Font("Modern No. 20",Font.PLAIN, 15);
		Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
	  JPanel p1;

add_product_item()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		

  //        frame =new JFrame();
        setExtendedState(JFrame.MAXIMIZED_BOTH);   // for maxamizing the frame

        
        p1=new JPanel();


		//to be checked


       int width=Toolkit.getDefaultToolkit().getScreenSize().width;
       int hieght=Toolkit.getDefaultToolkit().getScreenSize().height;
       p1.setSize(width,hieght);
      // p1.setBounds(200,200,1080,580);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		add(p1);

        prod=new JLabel("Product Item Creation");
        name=new JLabel("Name:");
        under=new JLabel("Under:");
        unit=new JLabel("Measure As:");
        size=new JLabel("Size:");
        company=new JLabel("Company :");
        supplier=new JLabel("Suppliers:");
        open=new JLabel("Opening Balance");
        quantity=new JLabel("Quantity:");
        pricper=new JLabel("Price Per:");
        fol=new JLabel("(applicable for cp and extra cost)");
        cp=new JLabel("CostPrice:");
        addc=new JLabel("ExtraCost:");
        sp=new JLabel("Selling Price:");
        pe=new JLabel(new ImageIcon("img/product_item/ruppe.png"));
        pe1=new JLabel(new ImageIcon("img/product_item/ruppe.png"));
        gst=new JLabel(" GST % :");
        disc=new JLabel("Max Liable Discount:");
        minprof=new JLabel("HSN Code");
        extra1=new JLabel("*");
        extra2=new JLabel("*");
        extra3=new JLabel();
        extra4=new JLabel();


        ok=new JButton("Ok");
        cancel=new JButton("Cancel");

        n=new JTextField(25);
        sz=new JTextField();
        sz1=new JTextField(25);
        sz2=new JTextField(25);
        sz3=new JTextField(25);
        cmp=new JTextField(25);
        quant=new JTextField(25);
        pr=new JTextField(25);
        c=new JTextField(25);
        ac=new JTextField(25);
        Vector gstv=new Vector();
        gstv.add(0.00);
        gstv.add(0.25);
        
g=new JComboBox();
g.addItem("0.00");
g.addItem("0.25");
g.addItem("3.00");
        g.addItem("5.00");
        g.addItem("12.00");
        g.addItem("18.00");
        g.addItem("28.00");
g.setSelectedItem("5.00");
      //  g=new JTextField(25);
        s=new JTextField(25);
        dis=new JTextField(25);
        pro=new JTextField(25);

        Vector list=new Vector(100);
        String[] list2={"Length*Breadth","Length*Breadth*Height","Meter","Pieces","Pairs"};
         list3=new Vector(100);
         list4=new Vector(100);
         gstlist=new Vector(100);

         try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=0;

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select name,symbol,gst from product_group ");
                        ResultSet rs=ps.executeQuery();

                        while(rs.next())
                            {
                                list.add(i,(String)rs.getString("name"));
                                list4.add(i,(String)rs.getString("symbol"));
                                gstlist.add(i,(String)rs.getString("gst"));
                                i++;


                            } //end of while loop
                        ps=con.prepareStatement("select name from suppliers ");
                        rs=ps.executeQuery();
                        i=0;
                        while(rs.next())
                            {
                                list3.add(i,(String)rs.getString("name"));
                                

                                } //end of while loop
                                System.out.println(list4);

                        }  // end of if
                             }

                                   catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

         pro_list=new JComboBox(list);
         sz_unit=new JComboBox(list2);
         sup_list=new JComboBox(list3);

        prod.setBounds(480,20,450,40);
        prod.setFont(f9);
        prod.setForeground(Color.red);
        prod.setBackground(Color.white);
        p1.add(prod);


    ok=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    ok.setBorder(null);
	cancel=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    cancel.setBorder(null);



        

    name.setBounds(90,120,150,30);
	name.setFont(f);
	name.setForeground(Color.black);
	p1.add(name);


	n.setBounds(280,120,350,30);
	n.setFont(f);
	n.setForeground(Color.black);
	p1.add(n);
    n.addKeyListener(varchar);

    under.setBounds(730,120,350,30);
	under.setFont(f);
	under.setForeground(Color.black);
	p1.add(under);


    pro_list.setBounds(890,120,350,30);
    pro_list.addActionListener(this);
	pro_list.setFont(f);
	pro_list.setForeground(Color.black);
    pro_list.setBackground(Color.white);
	p1.add(pro_list);

	 company.setBounds(90,170,450,30);
	company.setFont(f);
	company.setForeground(Color.black);
	p1.add(company);

   	cmp.setBounds(280,170,350,30);
	cmp.setFont(f);
	cmp.setForeground(Color.black);
	p1.add(cmp);
    cmp.addKeyListener(varchar);

    supplier.setBounds(730,170,450,30);
	supplier.setFont(f);
	supplier.setForeground(Color.black);
	p1.add(supplier);

    sup_list.setBounds(890,170,350,30);
	sup_list.setFont(f);
    sup_list.setBackground(Color.white);
	sup_list.setForeground(Color.black);
	p1.add(sup_list);

    unit.setBounds(90,220,350,30);
	unit.setFont(f);
	unit.setForeground(Color.black);
	p1.add(unit);

    sz_unit.setBounds(280,220,350,30);
	sz_unit.setFont(f);
	sz_unit.setForeground(Color.black);
	sz_unit.setBackground(Color.white);
    sz_unit.addActionListener(this);
	p1.add(sz_unit);

    size.setBounds(730,220,450,30);
	size.setFont(f);
	size.setForeground(Color.black);
	p1.add(size);

   	sz.setBounds(890,220,350,30);
	sz.setFont(f);
	sz.setForeground(Color.black);
    p1.add(sz);
    sz.addKeyListener(num);

    

    open.setBounds(5,280,450,40);
	open.setFont(f9);
	open.setForeground(Color.blue);
	p1.add(open);

    quantity.setBounds(175,380,200,30);
	quantity.setFont(f);
	quantity.setForeground(Color.black);
	p1.add(quantity);

    quant.setBounds(355,380,100,30);
	quant.setFont(f);
	quant.setForeground(Color.black);
	p1.add(quant);
    quant.addKeyListener(num);

    pricper.setBounds(175,430,200,30);
	pricper.setFont(f);
	pricper.setForeground(Color.black);
	p1.add(pricper);

    fol.setBounds(145,450,200,30);
	fol.setFont(f10);
	fol.setForeground(Color.black);
	p1.add(fol);

    pr.setBounds(355,430,100,30);
	pr.setFont(f);
	pr.setForeground(Color.black);
	p1.add(pr);

    pr.addKeyListener(num);

    extra3.setBounds(455,430,100,30);
	extra3.setFont(f);
    extra3.setForeground(Color.black);
	p1.add(extra3);

    cp.setBounds(175,480,200,30);
	cp.setFont(f);
	cp.setForeground(Color.black);
	p1.add(cp);


    pe1.setBounds(319,480,36,30);
    p1.add(pe1);

    c.setBounds(355,480,100,30);
	c.setFont(f);
	c.setForeground(Color.black);
	p1.add(c);

    c.addKeyListener(num);

    addc.setBounds(175,530,200,30);
	addc.setFont(f);
	addc.setForeground(Color.black);
	p1.add(addc);

    ac.setBounds(355,530,100,30);
	ac.setFont(f);
	ac.setForeground(Color.black);
	p1.add(ac);
    ac.addKeyListener(num);

    sp.setBounds(665,380,200,30);
	sp.setFont(f);
	sp.setForeground(Color.black);
	p1.add(sp);

    pe.setBounds(940,380,36,30);
    p1.add(pe);


    s.setBounds(980,380,100,30);
	s.setFont(f);
	s.setForeground(Color.black);
	p1.add(s);
    s.addKeyListener(num);

    extra4.setBounds(1090,380,300,30);
	extra4.setFont(f);
	extra4.setForeground(Color.black);
	p1.add(extra4);



    gst.setBounds(665,430,200,30);
	gst.setFont(f);
	gst.setForeground(Color.black);
    p1.add(gst);

    g.setBounds(980,430,100,30);
	
	g.setForeground(Color.black);
	p1.add(g);
    //g.addKeyListener(num);

    disc.setBounds(665,480,350,30);
	disc.setFont(f);
	disc.setForeground(Color.black);
    p1.add(disc);

    dis.setBounds(980,480,100,30);
	dis.setFont(f);
	dis.setForeground(Color.black);
	p1.add(dis);
    dis.addKeyListener(num);

    minprof.setBounds(665,530,350,30);
	minprof.setFont(f);
	minprof.setForeground(Color.black);
    p1.add(minprof);

    pro.setBounds(980,530,100,30);
	pro.setFont(f);
   
    pro.setBackground(Color.white);
	pro.setForeground(Color.black);
	p1.add(pro);
    pro.addKeyListener(num);



	ok.setBounds(420,590,205,45);


	cancel.setBounds(695,590,200,45);
    p1.add(ok);
    p1.add(cancel);

    ok.addActionListener(this);
    cancel.addActionListener(this);

    setVisible(true);

}  //end of constructor


public void actionPerformed(ActionEvent e)
	{
        if(e.getSource()==sz_unit)
        {
          String sel=sz_unit.getItemAt(sz_unit.getSelectedIndex()).toString();
            if(sel.equals("Length*Breadth*Height"))
                {
                sz.setText("");
                sz.setVisible(false);

    sz1.setBounds(890,220,100,30);
	sz1.setFont(f);
	sz1.setForeground(Color.black);
	p1.add(sz1);
    sz1.addKeyListener(num);

    extra1.setBounds(990,220,80,30);
	extra1.setFont(f);
	extra1.setForeground(Color.black);
	p1.add(extra1);

    sz2.setBounds(1010,220,100,30);
	sz2.setFont(f);
	sz2.setForeground(Color.black);
	p1.add(sz2);
    sz2.addKeyListener(num);

    extra2.setBounds(1110,220,80,30);
	extra2.setFont(f);
	extra2.setForeground(Color.black);
	p1.add(extra2);

    sz3.setBounds(1130,220,100,30);
	sz3.setFont(f);
	sz3.setForeground(Color.black);
	p1.add(sz3);
    sz3.addKeyListener(num);
    sz1.setVisible(true);
    sz2.setVisible(true);
    sz3.setVisible(true);
    extra1.setVisible(true);
    extra2.setVisible(true);

            }   // end of if(sel.equals("Length*Breadth*Height"))
  if(sel.equals("Length*Breadth"))
                {
    sz.setText("");
    sz3.setText("");
    sz.setVisible(false);
   sz3.setVisible(false);

    sz1.setBounds(890,220,150,30);
	sz1.setFont(f);
	sz1.setForeground(Color.black);
	p1.add(sz1);

    extra1.setBounds(1057,220,80,30);
	extra1.setFont(f);
	extra1.setForeground(Color.black);
	p1.add(extra1);

    sz2.setBounds(1090,220,150,30);
	sz2.setFont(f);
	sz2.setForeground(Color.black);
	p1.add(sz2);
    sz1.setVisible(true);
    sz2.setVisible(true);
    extra1.setVisible(true);

              }         //end of if(sel.equals("Length*Breadth"))
if(sel.equals("Meter")||sel.equals("Pieces")||sel.equals("Pairs"))
                {
    sz1.setVisible(false);
    sz2.setVisible(false);
    sz3.setVisible(false);
   sz1.setText("");sz2.setText("");sz3.setText("");
    extra1.setVisible(false);
    extra2.setVisible(false);
    sz.setVisible(true);
        }              //end of if(sel.equals("Meter")||sel.equals("Pieces")||sel.equals("Pairs"))
        }                   //end of if(e.getSource()==sz_unit)



        if(e.getSource()==pro_list)
        {
         extra3.setText(list4.elementAt(pro_list.getSelectedIndex()).toString());
         extra4.setText("per "+list4.elementAt(pro_list.getSelectedIndex()).toString());

         if(gstlist.elementAt(pro_list.getSelectedIndex()).toString().equals("no"))
         {
             //g.setSelectedItem("0.00");
             g.setBackground(Color.white);
             g.setEditable(false);

         }
         else
         {
             //g.setSelectedItem("5.00");
             g.setEditable(true);
         }

        }          // end of if(e.getSource()==pro_list

        if(e.getSource()==ok)
		{
        int ctrl=0;
                    String names,unders,compns,supps,mas,szs,quants,sps,pps,cps,diss,excs,mins,prod_id="";
                    Float gsts;
                	names=(String)n.getText();
                    unders=pro_list.getItemAt(pro_list.getSelectedIndex()).toString();
                    compns=(String)cmp.getText();
                    supps=sup_list.getItemAt(sup_list.getSelectedIndex()).toString();
                    mas=sz_unit.getItemAt(sz_unit.getSelectedIndex()).toString();
                    szs=(String)sz.getText()+"*"+(String)sz1.getText()+"*"+(String)sz2.getText()+"*"+(String)sz3.getText();
                    quants=(String)quant.getText();
                    sps=(String)s.getText();
                    pps=(String)pr.getText();
                    gsts=Float.parseFloat(g.getSelectedItem().toString());
                    System.out.println("gsts"+gsts);
                    cps=(String)c.getText();
                    diss=(String)dis.getText();
                    excs=(String)ac.getText();
                    mins=(String)pro.getText();
                    int v=0;
              


                    {                    if(szs.endsWith("**"))
                     szs=szs.substring(0,szs.length()-3);
                    
                    if(szs.startsWith("*")&&szs.endsWith("*"))
                        szs=szs.substring(1,szs.length()-1);
                    
                    if(szs.startsWith("*"))
                        szs=szs.substring(1,szs.length());
                    }
                    if(names.equals("")||unders.equals("")||compns.equals("")||supps.equals("")||szs.equals("")||quants.equals("")||sps.equals("")||pps.equals("")||gsts.equals("")||cps.equals("")||diss.equals("")||excs.equals(""))
                               {
                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");
                                }    // end of if (to check for empty fields)

                    else
                    {
                    int sa=(Integer.parseInt(cps)/Integer.parseInt(pps));
                    cps=Integer.toString(sa);
                    sa=(Integer.parseInt(excs)/Integer.parseInt(pps));
                    excs=Integer.toString(sa);
                        prod_id=prod_id+unders.charAt(0)+unders.charAt(2)+names.charAt(0)+names.charAt(2)+compns.charAt(0)+compns.charAt(2)+"/"+(v+1);// slash to be replaced by id
                        String stu="";
                          try
                             {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select id,prod_id from product_item where prod_id='"+prod_id+"' ");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                            stu=(String)rs.getString("prod_id");
                            }    //end of while loop
                         ps=con.prepareStatement("select id from product_item ");
                         rs=ps.executeQuery();
                        while(rs.next())
                            {
                            v=rs.getInt("id");
                            }    //end of while loop
                            System.out.println(v);
                        if(prod_id.equals(stu))
                             {
                                 JFrame f=new JFrame();
                                int bn=JOptionPane.showConfirmDialog(f,prod_id+ " Already exists....Please confirm \n Still wish to continue?");
if(bn==JOptionPane.NO_OPTION)
{
    n.setText("");
    sz.setText("");
    sz1.setText("");
     sz2.setText("");
    sz3.setText("");
    cmp.setText("");
    quant.setText("");
    c.setText("");
     pr.setText("");
    s.setText("");
    ac.setText("");
   // //g.setSelectedItem("0.00");
    dis.setText("");
    pro.setText("");
}                       // end of if(bn==JOptionPane.NO_OPTION)
else if(bn==JOptionPane.YES_OPTION)
{
 ctrl=1;
}   // end of if(bn==JOptionPane.NO_OPTION)
                        } //end of if(prod_id.equals(stu))


                        if(!prod_id.equals(stu)||ctrl==1)
                        {

                                 PreparedStatement st=con.prepareStatement("INSERT INTO `product_item`(`prod_id`,`name`,`grp_supp`,`company`, `size`, `quantity`,`cp`,`add_cost`,`sp`, `gst`, `disc`, `sold_quant`,`hsn_code`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                  st.setString(1,prod_id);
                                  st.setString(2,names);
                                  st.setString(3,pro_list.getSelectedIndex()+1+"/"+sup_list.getSelectedIndex()+1);
                                  st.setString(4,compns);
                                  st.setString(5,szs);
                                  st.setString(6,quants);
                                  st.setString(7,cps);
                                  st.setString(8,excs);
                                  st.setString(9,sps);

                                  st.setFloat(10,gsts);
                                  st.setString(11,diss);
                                  st.setString(12,"0");
                                  st.setString(13, mins);
          st.executeUpdate();
                                    JFrame f1=new JFrame();
 int a=JOptionPane.showConfirmDialog(f1,"Prouct Item SuccessFully Added \n The Product Id is of the Item is: "+prod_id+"\nWant to enter more Product?");
if(a==JOptionPane.YES_OPTION)
{
     n.setText("");
    sz.setText("");
    sz1.setText("");
     sz2.setText("");
    sz3.setText("");
    cmp.setText("");
    quant.setText("");
    c.setText("");
     pr.setText("");
    s.setText("");
    ac.setText("");
    //g.setSelectedItem("0.00");
    dis.setText("");
    pro.setText("");

}
else if(a==JOptionPane.NO_OPTION)
{
            setVisible(false);
            p1.setVisible(false);
            new manager_area().st_true(1);


            
}


                        }//end of if(bn==JOptionPane.YES_OPTION)
                            

                        }
                        
                             }//end of the try block

                        catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block


                    } //close of the else for the if (any empty field)

        }    //close of the if that checks for the button pressed is regis


        if(e.getSource()==cancel)
		{
            setVisible(false);
            p1.setVisible(false);
            new manager_area().st_true(2);



        }//close of the if that checks for the button pressed is cancel


}  //close of the action performed function



public static void main(String []args)
 {
    new add_product_item();

}


}   	//end of class