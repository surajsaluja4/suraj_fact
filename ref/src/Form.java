import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
class Form extends JFrame implements ActionListener

 {
   	JPanel pr;
   	JLabel bil,user,pro,qty,data;
	JTextField u,p,q;
    JTextArea d;
    JTable j1;
	JButton ok,bill,ca;
    String us,prod,quat,details,price,prodn,usn="user";
    String e1,e2,e3,e4,e5,e6,e7,e8;
    char c;
String day="",month="",year="",time="";

   int bilno;
    int i1=-1;
    Object []st={"Sl.No.","Product_No.","Type","Company","Size","Quantity"};
    Object [][]ob=new Object[][]{{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null},{null,null,null,null,null,null}};

   Form()
{
       setSize(1080,580);
	Font f18=new Font("Lucida Calligraphy",Font.BOLD,35);
	Font f19=new Font("Lucida Handwriting",Font.BOLD,17);
	Font f20=new Font("Aerial",Font.PLAIN,17);
	setVisible(true);
		pr=new JPanel();

		pr.setVisible(true);

		//to be checked

		pr.setSize(1080,580);
		pr.setBounds(200,200,1080,580);
		pr.setLayout(null);
		pr.setBackground(Color.white);
		add(pr);

    bil=new JLabel("BILLING PORTAL");
	user=new JLabel("Customer Name:");
	pro=new JLabel("Product Number:");
    qty=new JLabel("Quantity:");
    data=new JLabel("Details:");

	u=new JTextField(25);
	p=new JTextField(25);
    q=new JTextField(25);
    d=new JTextArea(50,50);
    //j1=new JTable(5,4);
    j1=new JTable(ob,st);
    JScrollPane sp=new JScrollPane(j1);

	ok=new JButton("Add");
    bill=new JButton("Bill");
	ca=new JButton("Cancel");



	bil.setBounds(350,20,500,100);
	bil.setFont(f18);
	bil.setForeground(Color.green);
	pr.add(bil);

	user.setBounds(200,120,250,30);
	user.setFont(f19);
	user.setForeground(Color.black);
	pr.add(user);


	u.setBounds(470,120,150,30);
	u.setFont(f20);
	u.setForeground(Color.black);
	pr.add(u);

	pro.setBounds(200,170,250,30);
	pro.setFont(f19);
	pro.setForeground(Color.black);
	pr.add(pro);


	p.setBounds(470,170,150,30);
	p.setFont(f20);
	p.setForeground(Color.black);
	pr.add(p);

	qty.setBounds(200,220,250,30);
	qty.setFont(f19);
	qty.setForeground(Color.black);
	pr.add(qty);


	q.setBounds(470,220,150,30);
	q.setFont(f20);
	q.setForeground(Color.black);
	pr.add(q);

    ok.setBounds(670,220,60,20);
	pr.add(ok);


	data.setBounds(200,270,250,30);
	data.setFont(f19);
	data.setForeground(Color.black);
	pr.add(data);


    //j1.addRow(st);
  	sp.setFont(f20);
    //d.setColumns(50);
    //d.setRows(50);
    sp.setBounds(420, 300, 550, 80);
	sp.setForeground(Color.black);
    sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    sp.setVisible(true);
	pr.add(sp);







	ca.setBounds(470,470,80,30);
	pr.add(ca);

	bill.setBounds(320,470,80,30);
	pr.add(bill);



    ok.addActionListener(this);
    ca.addActionListener(this);
    bill.addActionListener(this);




}
public void actionPerformed(ActionEvent e)
	{

          String d1,d2,d3,d4,q1,q2,q3,q4;
        		if(e.getSource()==ok)
		{

             prod=(String)p.getText();
            quat=(String)q.getText();
            if(quat.equals("0"))
            {
                JOptionPane.showMessageDialog(null,"Quantity Cannot Be Zero");
            }
            else
            {

            if(prod.equals("")||quat.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL DETAILS");

            }
            else
            {

               		 try
		{

            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement ps=con.prepareStatement("select * from products where `Product_No` = '"+prod+"' ");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
             e1=(String)rs.getString("Product_Type");
			 e2=(String)rs.getString("Selling_Price");
             e3=(String)rs.getString("Quantity");
             e4=(String)rs.getString("Product_No");
             e5=(String)rs.getString("Size");
             e6=(String)rs.getString("Company");

		 	}
            if(prod.equals(e4))
            {   i1++;
                int i45=i1+1;
                String sl=Integer.toString(i45);
                j1.getModel().setValueAt(sl,i1,0);
                j1.getModel().setValueAt(e4,i1,1);
                j1.getModel().setValueAt(e1,i1,2);
                j1.getModel().setValueAt(e6,i1,3);
                j1.getModel().setValueAt(e5,i1,4);
                j1.getModel().setValueAt(quat,i1,5);
                p.setText("");
                q.setText("");
                i45=0;

                if(i1==5)
                {
                 JOptionPane.showMessageDialog(null,"Maximum Products Reached");
                }
            }

            else
            {
                JOptionPane.showMessageDialog(null,"PRODUCT DOES NOT EXIST");

            }

                     }

            catch(Exception exception)
                 {
                     System.out.println(exception);
                 }
}





        }//end of if quat is 0
                }//

if(e.getSource()==ca)
                {

                     setVisible(false);
                        new bbm1();

                 }



                if(e.getSource()==bill)
                {
                   d1=(String)j1.getModel().getValueAt(0,1);
                   d2=(String)j1.getModel().getValueAt(1,1);
                   d3=(String)j1.getModel().getValueAt(2,1);
                   d4=(String)j1.getModel().getValueAt(3,1);
                   q1=(String)j1.getModel().getValueAt(0,5);
                   q2=(String)j1.getModel().getValueAt(1,5);
                   q3=(String)j1.getModel().getValueAt(2,5);
                   q4=(String)j1.getModel().getValueAt(3,5);
                   us=(String)u.getText();
                   if(d1.equals(null))
                   {
                       d1="-1";
                       q1="-1";
                   }
                   if(d2==null)
                   {
                       d2="-1";
                       q2="-1";
                   }
                   if(d3==null)
                   {
                       d3="-1";
                       q3="-1";
                   }
                   if(d4==null)
                   {
                       d4="-1";
                       q4="-1";
                   }


            		//DateFormat df=new SimpleDateFormat("dd/mm/yy hh:mm:ss");
 Date dateobj=new Date();

  SimpleDateFormat t=new SimpleDateFormat("yyyyMMddHH:mm:ss");
  //System.out.println(datei);
 
  String s=(String)t.format(dateobj);
  for(int i=0;i<s.length();i++)
{
    c=s.charAt(i);
    if(i<4)
    {
     year=year+c;
    }
  else if(i==4||i==5)
  {
    month=month+c;
  }
  else if(i==6||i==7)
  {
    day=day+c;
  }
  else
  {
        time=time+c;
  }

}//end of for loop


            if(us.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL DETAILS");

            }
            else
            {
                System.out.print(us);
               		 try

                     {


                     Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement pis=conn.prepareStatement("select * from registration where UserName='"+us+"' ");
			ResultSet ris=pis.executeQuery();

            while(ris.next())
			{

             usn=(String)ris.getString("UserName");
			}
           
            if(usn.equals(us))
            {
            }
             else
            {
                JOptionPane.showMessageDialog(null,"User Name Does Not Match");
                 u.setText("User");
                 us="User";

            }

             Class.forName("com.mysql.jdbc.Driver");
			Connection conni=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement bil=conni.prepareStatement("select * from billno");
			ResultSet risy=bil.executeQuery();
            while(risy.next())
			{

             bilno=(int)risy.getInt("Bill_no.");
			}
            System.out.print(bilno);
            bilno=bilno+1;
            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO `bill_data`(`Username`, `Pno1`, `Pno2`, `Pno3`, `Pno4`,`Qno1`, `Qno2`, `Qno3`, `Qno4`,`billno`,`day`,`month`,`year`,`time`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1,us);
            ps.setString(2,d1);
            ps.setString(3,d2);
            ps.setString(4,d3);
            ps.setString(5,d4);

            ps.setString(6,q1);
            ps.setString(7,q2);
            ps.setString(8,q3);
            ps.setString(9,q4);
            ps.setInt(10,bilno);
            ps.setString(11,day);
            ps.setString(12,month);
            ps.setString(13,year);
            ps.setString(14,time);

             ps.executeUpdate();
             day="";
             month="";
             year="";
             time="";


PreparedStatement in=con.prepareStatement("UPDATE `billno` SET `Bill_no.`='"+bilno+"'");

           in.executeUpdate();

              new Billprint();






         }  //end of try block





            catch(Exception exception)
                 {
                     System.out.println(exception);
                 }
}


              
              u.setText("");
              p.setText("");
              q.setText("");
              for(int i1=0;i1<4;i1++)
             {
                 for(int j=0;j<6;j++)
                 {

                j1.getModel().setValueAt("",i1,j);
                

                 }
             }

              i1=-1;

            
            




                 
}
}


}

