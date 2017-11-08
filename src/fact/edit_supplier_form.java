//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class edit_supplier_form extends JFrame implements ActionListener,key
{
      JLabel reg,name_label,address_label,id_label,prod,remark_label,gst_label,any;
      String name,address,id,gst,remark;
	  JTextField n,i,g;
      JTextArea a,rem;
      JPanel pr,p1,p2;
      JCheckBox cb[];
      JButton regis,can;
       JButton Back=new JButton("<<<Back");

      String stu,text,names,addresss,phns,gsts, pros,rems,us;
      String[] yu=new String[100];
      int ed;
          Vector st = new Vector(100);


    JScrollPane sp;

edit_supplier_form(String ss,int key,int ed)
{
    this.ed=ed;          // WILL CONTAIN THE DETAIL WHETER TO DELETE OR EDIT THE DATA
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(key==1)
        {
                text="id";
                    ss=ss.substring(4);
                    us=ss;
                }
               
        
        else if(key==2)
        {
            text="gst";
            us=ss;
        }
        
        else if(key==3)
        {
            text="phone";
            us=ss;
        }

    setResizable(false);
            try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=0;

                        if(con!=null)
                            {


                        PreparedStatement ps=con.prepareStatement("select * from suppliers where`"+text+"`="+ss+" AND `status`='Active'");
                                System.out.println(ps);
                        ResultSet rs=ps.executeQuery();
                                
                        while(rs.next())
                            {
                            //      String stu,text,names,addresss,phns,gsts, pros,rems
                              names=rs.getString("name");
                              addresss=rs.getString("address");
                              phns=rs.getString("phone");
                              gsts=rs.getString("gst");
                              pros=rs.getString("products");
                              rems=rs.getString("remarks");
                            } //end of while loop
                                    yu=pros.split(",");               // the string has the details of the produts the supplier sells
                                    for(String s:yu)
                                    {
                                        System.out.println(s);
                                    }

                        }  // end of if
                             }

                                   catch(Exception exception)
                                {
                                     JOptionPane.showMessageDialog(null,"No Such Supplier Exits");
                                     key=100;
                                     System.out.println(exception);
                                }    //end of catch block


		Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		Font f10=new Font("Lucida Handwriting",Font.BOLD, 20);
		Font f11=new Font("Baskerville Old Face",Font.BOLD, 20);
		Font f12=new Font("Baskerville Old Face",Font.BOLD, 17);
		Font f13=new Font("Imprint MT Shadow",Font.PLAIN, 30);
		Font f14=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
		Font f15=new Font("Lucida Calligraphy",Font.BOLD,17	);
		Font f16=new Font("Lucida Handwriting",Font.BOLD,50);
		Font f17=new Font("Aerial",Font.PLAIN,25);
		setSize(900,800);

        pr=new JPanel();
        p1=new JPanel();//for the scroll pane
        p1.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//to be checked


		pr.setLayout(null);
        pr.setBounds(0,0,900,800);
		pr.setBackground(Color.white);
		add(pr);

	reg=new JLabel("Edit Supplier  :");
	name_label=new JLabel("Name   :");
	address_label=new JLabel("Address   :");
	id_label=new JLabel("Phone  :");
    gst_label=new JLabel("Supplier GST NO. :");
    prod=new JLabel("Products offered  :");
    remark_label=new JLabel("Remark   :");
    any=new JLabel("(If Any)");
	n=new JTextField(25);            //text field for name
    n.addKeyListener(varchar);
	a=new JTextArea(0,0);          //text area for address
    rem=new JTextArea(0,0);          //text area for remark
   	i=new JTextField(25);          //text field for Phone Number
    i.addKeyListener(num);
	g=new JTextField(25);          //text field for supplier_gst_no


    //pr.addItem("Bedsheets");       // to be inserted from the database


    try
                          {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                       // int i=0;

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select name from product_group ");
                        ResultSet rs=ps.executeQuery();

                        while(rs.next())
                            {
                                st.add((String)rs.getString("name"));

                            } //end of while loop


                        }  // end of if
                             }

                                   catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block
    cb=new JCheckBox[100];
        int j=0,y=0;
        int im=st.size()-1;
        p1.setPreferredSize(new Dimension(80,39*im));
        p1.setBackground(Color.white);
        sp=new JScrollPane(p1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      	sp.setFont(f11);
         if(st.isEmpty())
        {
            JLabel l=new JLabel("No Product");
            JLabel l2=new JLabel(" Found");
            l.setBounds(30,0,140,50);
            l.setFont(f10);
            l.setForeground(Color.BLACK);
            p1.add(l);
            l2.setBounds(40,40,180,50);
            l2.setFont(f10);
            l2.setForeground(Color.BLACK);
            p1.add(l2);

        }
        else
        {
        for(im=st.size()-1;im>=0;im--)
                        {
                        cb[j]=new JCheckBox((String)st.elementAt(im));
                         cb[j].setBounds(0,y,100,29);
                         cb[j].setBackground(Color.white);
                         p1.add(cb[j]);
                         y=y+30;
                         ++j;
        }
                         

        }
        for(int ty=0;ty<yu.length;ty++)
{
            if(yu[ty]!=null)
            cb[Integer.parseInt(yu[ty])-1].setSelected(true);

     }

                       


        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setBounds(420, 370, 200, 83);
	    sp.setForeground(Color.black);

        sp.setVisible(true);
        pr.add(sp,BorderLayout.CENTER);

	regis=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    regis.setBorder(null);
	can=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    can.setBorder(null);

	reg.setBounds(240,20,600,100);
	reg.setFont(f9);
	reg.setForeground(Color.red);

    name_label.setBounds(150,120,180,30);
	name_label.setFont(f10);
	name_label.setForeground(Color.BLACK);
    pr.add(name_label);

	n.setBounds(420,120,200,30);
	n.setFont(f11);
	n.setForeground(Color.black);
	pr.add(n);
    n.setText(names);


	address_label.setBounds(150,170,170,30);
	address_label.setFont(f10);
	address_label.setForeground(Color.black);


	a.setBounds(420,170,200,80);
	a.setFont(f11);
	a.setForeground(Color.black);
    a.setText(addresss);

    Border border = BorderFactory.createLineBorder(Color.GRAY);
    a.setBorder(BorderFactory.createCompoundBorder(border,
    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    pr.add(a);


    id_label.setBounds(150,270,200,30);
	id_label.setFont(f10);
	id_label.setForeground(Color.black);
	pr.add(id_label);

	i.setBounds(420,270,200,30);
	i.setFont(f11);
	i.setForeground(Color.black);
    i.setText(phns);

    gst_label.setBounds(150,320,230,30);
    gst_label.setFont(f10);
	gst_label.setForeground(Color.black);
	pr.add(gst_label);

    g.setBounds(420,320,200,30);
	g.setFont(f11);
	g.setForeground(Color.black);
    pr.add(g);
    g.setText(gsts);
    g.setEditable(false);

    prod.setBounds(150,370,230,30);
    prod.setFont(f10);
	prod.setForeground(Color.black);

    remark_label.setBounds(150,470,230,30);
    remark_label.setFont(f10);
	remark_label.setForeground(Color.black);
     pr.add(remark_label);


     any.setBounds(150,500,230,30);
    any.setFont(f10);
	any.setForeground(Color.black);
     pr.add(any);

    rem.setBounds(420,470,200,80);
	rem.setFont(f11);
	rem.setForeground(Color.black);
    pr.add(rem);
    rem.setText(rems);

     border = BorderFactory.createLineBorder(Color.GRAY);
    rem.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));








    regis.setBounds(210,590,205,45);
    regis.setBackground(Color.white);


	can.setBounds(460,590,200,45);
	can.setBackground(Color.white);





        regis.addActionListener(this);
        can.addActionListener(this);
        Back.addActionListener(this);

         pr.add(reg);
         pr.add(regis);
         pr.add(can);
         pr.add(i);

	pr.add(name_label);
    pr.add(address_label);
	pr.add(prod);


	pr.setVisible(true);
    setVisible(true);
    if(ed==3)
    {


        p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(0, 0, 900, 800);
        add(p2);
        pr.setBounds(65,60,750,600);
		remove(pr);
        p2.add(pr);
       pr .setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK,2), "Supplier's Details", TitledBorder.LEFT, TitledBorder.TOP,f9));
       regis.setVisible(false);
       can.setVisible(false);

       Back.setBounds(800, 10 , 80, 30);
       Back.setBackground(Color.BLUE);
       Back.setForeground(Color.white);
       Back.setBorder(null);
       p2.add(Back);






        n.setBorder(null);i.setBorder(null);
        n.setBackground(Color.white);
        n.setForeground(Color.GRAY);
        i.setBackground(Color.white);
        i.setForeground(Color.GRAY);
        g.setBorder(null);a.setBorder(null);
        g.setBackground(Color.white);
        g.setForeground(Color.GRAY);
        a.setBackground(Color.white);
        a.setForeground(Color.GRAY);
        rem.setBackground(Color.white);
       rem.setForeground(Color.GRAY);
        rem.setBorder(null);
        reg.setText("");

        if(rems.equals(""))
        {
            rem.setText("\n \nNO Remarks Found");
        }
        for(im=st.size()-1;im>=0;im--)
        {
            cb[im].setVisible(false);
        }
         y=0;
          for(int ty=0;ty<yu.length;ty++)
{
            if(yu[ty]!=null)
            {
            cb[Integer.parseInt(yu[ty])-1].setBounds(0, y, 100, 29);
                cb[Integer.parseInt(yu[ty])-1].setVisible(true);
                y+=30;
                cb[Integer.parseInt(yu[ty])-1].setForeground(Color.GRAY);
                cb[Integer.parseInt(yu[ty])-1].setEnabled(false);
                cb[Integer.parseInt(yu[ty])-1].setFont(f11);
            }
     }


    }
    if(ed==2||ed==3)
    {
//NIGAREM
        n.setEditable(false);
        i.setEditable(false);
        g.setEditable(false);
        a.setEditable(false);
        rem.setEditable(false);

    }
    if(key==100)
    {
                 setVisible(false);
                                     new edit_supplier(ed);

    }


}  //end of constructor


public void actionPerformed(ActionEvent e)
	{

    if(e.getSource()==Back)
    {
        setVisible(false);
         new view_supplier();
    }

		if(e.getSource()==regis && ed==1)
		{

                   
                	name=(String)n.getText();
                    address=(String)a.getText();
                    id=(String)i.getText();
                    gst=(String)g.getText();
                    remark=(String)rem.getText();
                    int count=0,j=0;
                    String v=new String();
                                v="";
                                            for(int im=0;im<=st.size()-1;im++)
                                              {
                         if(cb[j].isSelected())
                         {
                             count++;
                             v=v+Integer.toString(im+1)+",";  // storing the products selected
                         }
                         j++;
                                                  }   // end of for loop


                 if(name.equals("")||address.equals("")||id.equals("")||gst.equals("")||count==0)
                    {

                          JOptionPane.showMessageDialog(null,"Please Fill In All Details /n Or Select atleast one Product");

                    }    //close of the if checking any empty field

                    else
                    {
                             try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                      
                                   PreparedStatement st=con.prepareStatement("UPDATE `suppliers` SET `name`=?, `address`=?,`email`=?, `gst`=?, `products`=?,`remarks`=? where`"+text+"`="+us);
                                  st.setString(1,name);
                                  st.setString(2,address);
                                  st.setString(3,id);
                                  st.setString(4,gst);
                                  st.setString(5,v);
                                  st.setString(6,remark);

                                  st.executeUpdate();
                               st=con.prepareStatement("select id from suppliers where gst='"+gst+"'");
                               ResultSet rs=st.executeQuery();
                                while(rs.next())
                            {
                                stu=(String)rs.getString("id");
                            }//end of while loop


                               
                                JOptionPane.showMessageDialog(null,name+" SuccessFully updated\n Your Supplier Number is:  SUP0"+stu);
setVisible(false);
new edit_supplier(ed);



                        }//end of else of if(user.equals(stu))

                            }// end of if(con!=null)




                             catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

                              }// end of else block o the if(salary<2500)

              }//close of the if checking for pressed button is ok
if(e.getSource()==regis && ed==2)
		{
                                 JFrame f=new JFrame();
int bn=JOptionPane.showConfirmDialog(null," Are you Sure  \n You Want To Delete Supplier "+names);
if(bn==JOptionPane.NO_OPTION)
{
setVisible(false);
new edit_supplier(ed);

}                       // end of if(bn==JOptionPane.NO_OPTION)
else if(bn==JOptionPane.YES_OPTION)
{
   try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {

                                   PreparedStatement st=con.prepareStatement("UPDATE `suppliers` SET `status`=? where`"+text+"`="+us);


                                  st.setString(1,"Inactive");

                                  st.executeUpdate();
                                 JOptionPane.showMessageDialog(null,names+"Successfully Deleted");
setVisible(false);
new edit_supplier(ed);
                        }


}


     catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block


} //end of if(prod_id.equals(stu))

       
}
        if(e.getSource()==can)
		{
            setVisible(false);
            new edit_supplier(ed);

        }//close of the if that checks for the button pressed is can


}  //close of the action performed function



public static void main(String []args)
 {

    new edit_supplier_form("",1,1);

}


}   	//end of class