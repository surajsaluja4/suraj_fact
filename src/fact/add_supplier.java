//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.Border;

class add_supplier extends JFrame implements ActionListener,key
{
      JLabel reg,name,address,id,prod,remark,gst,any;
	  JTextField n,i,g;
      JTextArea a,rem;
      JPanel pr,p1;
      JCheckBox cb[];
      JButton regis,can;
      String stu;
      static JFrame f1;
          Vector st = new Vector(100);


    JScrollPane sp;

add_supplier()
{
   setResizable(false);
	
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

	reg=new JLabel("Add New Supplier  :");
	name=new JLabel("Name   :");
	address=new JLabel("Address   :");
	id=new JLabel("Phone  :");
    gst=new JLabel("Supplier GST NO. :");
    prod=new JLabel("Products offered  :");
    remark=new JLabel("Remark   :");
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
                        int i=0;

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select name from product_group ");
                        ResultSet rs=ps.executeQuery();

                        while(rs.next())
                            {
                                st.add(i,(String)rs.getString("name"));

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
                       // ++j;*/


       sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setBounds(420, 370, 200, 83);
	    sp.setForeground(Color.black);

        sp.setVisible(true);
        pr.add(sp,BorderLayout.CENTER);

	regis=new JButton(new ImageIcon("img/admin_area_manager_addnew/register.png"));
    regis.setBorder(null);
	can=new JButton(new ImageIcon("img/admin_area_manager_addnew/cancel.png"));
    can.setBorder(null);

	reg.setBounds(240,20,600,100);
	reg.setFont(f9);
	reg.setForeground(Color.red);

    name.setBounds(150,120,180,30);
	name.setFont(f10);
	name.setForeground(Color.BLACK);
    pr.add(name);

	n.setBounds(420,120,200,30);
	n.setFont(f11);
	n.setForeground(Color.black);
	pr.add(n);


	address.setBounds(150,170,170,30);
	address.setFont(f10);
	address.setForeground(Color.black);


	a.setBounds(420,170,200,80);
	a.setFont(f11);
	a.setForeground(Color.black);

    Border border = BorderFactory.createLineBorder(Color.GRAY);
    a.setBorder(BorderFactory.createCompoundBorder(border,
    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    pr.add(a);


    id.setBounds(150,270,200,30);
	id.setFont(f10);
	id.setForeground(Color.black);
	pr.add(id);


	i.setBounds(420,270,200,30);
	i.setFont(f11);
	i.setForeground(Color.black);

    gst.setBounds(150,320,230,30);
    gst.setFont(f10);
	gst.setForeground(Color.black);
	pr.add(gst);

    g.setBounds(420,320,200,30);
	g.setFont(f11);
	g.setForeground(Color.black);
    pr.add(g);

    prod.setBounds(150,370,230,30);
    prod.setFont(f10);
	prod.setForeground(Color.black);

    remark.setBounds(150,470,230,30);
    remark.setFont(f10);
	remark.setForeground(Color.black);
     pr.add(remark);

     any.setBounds(150,500,230,30);
    any.setFont(f10);
	any.setForeground(Color.black);
     pr.add(any);

    rem.setBounds(420,470,200,80);
	rem.setFont(f11);
	rem.setForeground(Color.black);
    pr.add(rem);

     border = BorderFactory.createLineBorder(Color.GRAY);
    rem.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));








    regis.setBounds(210,590,205,45);
    regis.setBackground(Color.white);


	can.setBounds(460,590,200,45);
	can.setBackground(Color.white);





        regis.addActionListener(this);
        can.addActionListener(this);

         pr.add(reg);
         pr.add(regis);
         pr.add(can);
         pr.add(i);

	pr.add(name);
    pr.add(address);
	pr.add(prod);


	pr.setVisible(true);
    setVisible(true);


}  //end of constructor


public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==regis)
		{

                   String name,address,id,gst,remark;
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
                        PreparedStatement ps=con.prepareStatement("select gst from suppliers where gst='"+gst+"'");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                                stu=(String)rs.getString("gst");
                            }//end of while loop

                        if(gst.equals(stu))
                             {
                                  JOptionPane.showMessageDialog(null,"Supplier Already Exists...... TRY ANOTHER");
                                  n.setText("");
                                  g.setText("");
                             } //end of the if(gst.equals(stu))
                        else
                              {

                                  PreparedStatement st=con.prepareStatement("INSERT INTO `suppliers`(`name`, `address`,`phone`, `gst`, `products`,`remarks`,`status`)VALUES (?,?,?,?,?,?,?)");
                                  st.setString(1,name);
                                  st.setString(2,address);
                                  st.setString(3,id);
                                  st.setString(4,gst);
                                  st.setString(5,v);
                                  st.setString(6,remark);
                                  st.setString(7,"Active");
                                  st.executeUpdate();
                               ps=con.prepareStatement("select id from suppliers where gst='"+gst+"'");
                                rs=ps.executeQuery();
                                while(rs.next())
                            {
                                stu=(String)rs.getString("id");
                            }//end of while loop


                                JFrame f=new JFrame();
                                int bn=JOptionPane.showConfirmDialog(f,name+" SuccessFully Added\n Your Supplier Number is:  SUP0"+stu+" \n Want to enter more Product?");
if(bn==JOptionPane.YES_OPTION)
{
    n.setText("");
    a.setText("");
    i.setText("");
    g.setText("");
    rem.setText("");

}
else if(bn==JOptionPane.NO_OPTION)
{
            setVisible(false);
            p1.setVisible(false);
              if(f1==null)
            new manager_area().st_true(4);
            else
            f1.setVisible(true);

}




                        }//end of else of if(user.equals(stu))

                            }// end of if(con!=null)




                             }//end of the try block
                             catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

                              }// end of else block o the if(salary<2500)
              
              }//close of the if checking for pressed button is ok


        if(e.getSource()==can)
		{
            setVisible(false);  
            p1.setVisible(false);
            if(f1==null)
            new manager_area().st_true(4);
            else
            f1.setVisible(true);

        }//close of the if that checks for the button pressed is can


}  //close of the action performed function
public static void getframe(JFrame fr){
    fr.getClass();
       f1=fr;
}
public static void main(String []args)
 {

    new add_supplier();

}


}   	//end of class