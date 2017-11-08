//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import  javax.swing.event.TableModelEvent;
class stock_entry extends JFrame implements ActionListener
{

    JLabel dat,bill,mmd,stock,slas0,slas1,prod,quantity,pricper,fol,cp,pe1,addc,sp,pe,gst,disc,minprof,extra3,extra4,remark,ifa;
    JTextField m,d,y,b,quant,pr,c,ac,s,g,dis,pro;
    JComboBox pro_list;
    JButton ok,cancel,add,clear;
    JScrollPane scrpn;
       Vector list;
        Font f9=new Font("Modern No. 20",Font.BOLD, 40);
        Font f10=new Font("Modern No. 20",Font.PLAIN, 13);
		Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 25);
        JPanel p1,p;
        JTable tb;
        DefaultTableModel model;
        int ct=0;
stock_entry()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	


        setExtendedState(JFrame.MAXIMIZED_BOTH);   // for maxamizing the frame


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
		add(p1);

        stock=new JLabel("Stock Entry");
        dat=new JLabel("Date :");
        prod=new JLabel("Products List :");
        bill=new JLabel("Bill No.:");
        prod=new JLabel("Products List:");
        slas0=new JLabel("/");
        slas1=new JLabel("/");
        mmd=new JLabel("dd                     mm                   yyyy");



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
        minprof=new JLabel("Min. Profit:");
        remark=new JLabel("Remarks :");
        ifa=new JLabel("If Any");

        extra3=new JLabel();
        extra4=new JLabel();


        ok=new JButton("Ok");
        cancel=new JButton("Cancel");
        add=new JButton("Add");

        clear=new JButton("Clear The Selected Row");


        quant=new JTextField(25);
        pr=new JTextField(25);
        c=new JTextField(25);
        d=new JTextField(1);
        m=new JTextField(1);
        y=new JTextField(3);
        ac=new JTextField(25);
        g=new JTextField(25);
        s=new JTextField(25);
        dis=new JTextField(25);
        pro=new JTextField(25);




        stock.setBounds(520,20,450,40);
        stock.setFont(f9);
        stock.setForeground(Color.red);
        stock.setBackground(Color.white);
        p1.add(stock);


    ok=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    ok.setBorder(null);
	cancel=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    cancel.setBorder(null);


    dat.setBounds(130,110,180,30);
	dat.setFont(f);
	dat.setForeground(Color.black);
	p1.add(dat);

    d.setBounds(210,113,40,28);
	d.setFont(f);
	d.setForeground(Color.black);
	p1.add(d);



    slas0.setBounds(260,110,40,40);
	slas0.setFont(f);
	slas0.setForeground(Color.black);
	p1.add(slas0);

    m.setBounds(280,113,40,28);
	m.setFont(f);
	m.setForeground(Color.black);
	p1.add(m);

    slas1.setBounds(330,110,40,40);
	slas1.setFont(f);
	slas1.setForeground(Color.black);
	p1.add(slas1);

    y.setBounds(350,113,60,28);
	y.setFont(f);
	y.setForeground(Color.black);
	p1.add(y);

    mmd.setBounds(218,136,360,28);
    mmd.setFont(f10);
	mmd.setForeground(Color.black);
	p1.add(mmd);

    prod.setBounds(520,113,360,30);
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

    pro_list.setBounds(690,113,180,30);
	pro_list.setFont(f);
	pro_list.setForeground(Color.black);
    pro_list.setBackground(Color.white);
   	p1.add(pro_list);




    quantity.setBounds(940,113,200,30);
	quantity.setFont(f);
	quantity.setForeground(Color.black);
	p1.add(quantity);

    quant.setBounds(1070,113,100,30);
	quant.setFont(f);
	quant.setForeground(Color.black);
	p1.add(quant);
//130,110,180,30
    pricper.setBounds(130,170,200,30);
	pricper.setFont(f);
	pricper.setForeground(Color.black);
	p1.add(pricper);

    fol.setBounds(105,190,200,30);
	fol.setFont(f10);
	fol.setForeground(Color.black);
	p1.add(fol);

    pr.setBounds(308,170,100,30);
	pr.setFont(f);
	pr.setForeground(Color.black);
	p1.add(pr);

    extra3.setBounds(455,430,100,30);
	extra3.setFont(f);
    extra3.setForeground(Color.black);
	p1.add(extra3);

    cp.setBounds(520,170,200,30);
	cp.setFont(f);
	cp.setForeground(Color.black);
	p1.add(cp);

    pe1.setBounds(650,170,36,30);
    p1.add(pe1);

    c.setBounds(690,170,100,30);
	c.setFont(f);
	c.setForeground(Color.black);
	p1.add(c);

    addc.setBounds(940,170,200,30);
	addc.setFont(f);
	addc.setForeground(Color.black);
	p1.add(addc);

    ac.setBounds(1070,170,100,30);
	ac.setFont(f);
	ac.setForeground(Color.black);
	p1.add(ac);

    sp.setBounds(130,225,200,30);
	sp.setFont(f);
	sp.setForeground(Color.black);
	p1.add(sp);

    pe.setBounds(268,225,36,30);
    p1.add(pe);


    s.setBounds(308,225,100,30);
	s.setFont(f);
	s.setForeground(Color.black);
	p1.add(s);

    extra4.setBounds(1090,380,300,30);
	extra4.setFont(f);
	extra4.setForeground(Color.black);
	p1.add(extra4);




    disc.setBounds(520,225,350,30);
	disc.setFont(f);
	disc.setForeground(Color.black);
    p1.add(disc);

    dis.setBounds(766,225,100,30);
	dis.setFont(f);
	dis.setForeground(Color.black);
	p1.add(dis);

    minprof.setBounds(940,225,350,30);
	minprof.setFont(f);
	minprof.setForeground(Color.black);
    p1.add(minprof);

    pro.setBounds(1070,225,100,30);
	pro.setFont(f);
    pro.setEditable(false);
    pro.setBackground(Color.white);
	pro.setForeground(Color.black);
	p1.add(pro);

    add.setBounds(530,275,100,30);
    p1.add(add);

    clear.setBounds(670,275,180,30);
    p1.add(clear);


        model = new DefaultTableModel()
        {
            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }};
        Object []column={"Sl.No.","Product_Id.","Quantity","CostPrice","ExtraCost","SellingPrice","MaxDiscount"};


        tb=new JTable();
        tb.setModel(model);
        model.setColumnIdentifiers(column);
        tb.setFillsViewportHeight(true);            // to use the entire hiegth of the scroll pane
        tb.getColumnModel().getColumn(0).setPreferredWidth(0);
         //tb.setRowSelectionAllowed(false);

         
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
    
    setVisible(true);

}  //end of constructor


 
public void actionPerformed(ActionEvent e)
	{


        if(e.getSource()==add)
        {
                  String date,prods,compns,supps,mas,szs,quants,sps,pps,cps,diss,excs,mins;
                  

                    date=d.getText()+"/"+m.getText()+"/"+y.getText();
                    quants=(String)quant.getText();
                    sps=(String)s.getText();
                    pps=(String)pr.getText();
                    cps=(String)c.getText();
                    diss=(String)dis.getText();
                    excs=(String)ac.getText();
                    mins=(String)pro.getText();

                    if(date.equals("")||quants.equals("")||sps.equals("")||pps.equals("")||cps.equals("")||diss.equals("")||excs.equals(""))
                               {
                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");
                                }    // end of if (to check for empty fields)
                    else
                    {
                    prods=pro_list.getItemAt(pro_list.getSelectedIndex()).toString();

                        int sa=(Integer.parseInt(cps)/Integer.parseInt(pps));
                    cps=Integer.toString(sa);
                    sa=(Integer.parseInt(excs)/Integer.parseInt(pps));
                    excs=Integer.toString(sa);
                  d.setEditable(false);
                  m.setEditable(false);
                  y.setEditable(false);
                 //d.getText()+"/"+m.getText()+"/"+y.getText(),\
                  
                  Object ob[]=new Object[]{++ct,pro_list.getItemAt(pro_list.getSelectedIndex()).toString(),quant.getText(),cps,excs,s.getText(),dis.getText()};
                    model.addRow(ob);
                   
                    quant.setText("");
                    s.setText("");
                    pr.setText("");
                    c.setText("");
                    dis.setText("");
                    ac.setText("");
                    pro.setText("");

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
 
        }

        if(e.getSource()==ok)
		{
                String date=d.getText()+"/"+m.getText()+"/"+y.getText();
                Object o=new Object();
                Vector v=new Vector();
                

            for(int i=0;i<tb.getRowCount();i++)
            {
                for(int j=0;j<7;j++)
                {
                o=tb.getValueAt(i, j);

                v.add(i, o);

                }
                                             try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                                System.out.print(date);
                                 PreparedStatement st=con.prepareStatement("INSERT INTO `stock_entry`(`date`, `prod_id`, `quantity`,`cp`,`add_cost`,`sp`,`disc`) VALUES (?,?,?,?,?,?,?)");
                                  st.setString(1,date);
                                  st.setString(2,v.elementAt(5).toString());
                                  st.setString(3,v.elementAt(4).toString());
                                  st.setString(4,v.elementAt(3).toString());
                                  st.setString(5,v.elementAt(2).toString());
                                  st.setString(6,v.elementAt(1).toString());
                                  st.setString(7,v.elementAt(0).toString());
                                  st.executeUpdate();
                                  String a=v.elementAt(5).toString();
                                  char[] g=a.toCharArray();
                                  int cont=0;
                                  while(g[cont]!='/')
                                  {
                                      cont++;
                                  }
                            cont= Integer.parseInt(v.elementAt(5).toString().substring(cont+1));
                                  st=con.prepareStatement("UPDATE `product_item` SET `sold_quant` = "+v.elementAt(4)+" WHERE `id`="+cont+"");
                                  System.out.println(st);
                                  st.executeUpdate();

                                   JOptionPane.showMessageDialog(null,"Stock Entry SuccessFull");

                                   
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
            setVisible(false);
            p1.setVisible(false);
            new manager_area().st_true(1);



        }//close of the if that checks for the button pressed is cancel

}



public static void main(String []args)
 {
    new stock_entry();

}


}   	//end of class