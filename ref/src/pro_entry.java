import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class pro_entry extends JFrame implements ActionListener

 {
	JPanel pr;
   	JLabel prod,prn,prt,prs,qt,sz,cp,sp,pcp;
	JTextField p,q,s,co,se,com;
	JComboBox pt,ps;
	JButton ok,ca;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    String e1,e2,e3,e4,e5,e6,e7,e8;
pro_entry()
{
    setSize(1080,700);
	Font f15=new Font("Lucida Calligraphy",Font.BOLD,50);
	Font f16=new Font("Lucida Handwriting",Font.BOLD,17);
	Font f17=new Font("Aerial",Font.PLAIN,17);
	setVisible(true);
		pr=new JPanel();

		pr.setVisible(true);

		//to be checked

		pr.setSize(1080,580);
		pr.setBounds(200,200,1080,580);
		pr.setLayout(null);
		pr.setBackground(Color.white);
		add(pr);

    prod=new JLabel("PRODUCT ENTRY");
     prn=new JLabel("Product Number:");
	prt=new JLabel("Product Type:");
    prs=new JLabel("Supplier:");
    qt=new JLabel("Quantity:");
     sz=new JLabel("Size:");
	pcp=new JLabel("Company:");
    cp=new JLabel("Cost Price:");
    sp=new JLabel("Selling Price:");



	p=new JTextField(25);
	q=new JTextField(25);
    s=new JTextField(25);
	co=new JTextField(25);
    se=new JTextField(25);
	com=new JTextField(25);

	pt=new JComboBox();
	pt.addItem("Bedsheets");
	pt.addItem("Blankets");
	pt.addItem("Cushions");
	pt.addItem("Quilts");
	pt.addItem("Pillowcovers");
	pt.addItem("Curtains");


	ps=new JComboBox();
	ps.addItem("JKM Textiles");
	ps.addItem("BKM Handlooms");
	ps.addItem("Gopal Blankets");
	ps.addItem("H.R pvt. Lmtd");
	ps.addItem("Vinod Fabrics");
	ps.addItem("Sagar Textiles");

	ok=new JButton("ENTER");
	ca=new JButton("Cancel");



	prod.setBounds(350,20,600,100);
	prod.setFont(f15);
	prod.setForeground(Color.green);
	pr.add(prod);

	prn.setBounds(200,120,210,50);
	prn.setFont(f16);
	prn.setForeground(Color.black);
	pr.add(prn);


	p.setBounds(470,120,150,30);
	p.setFont(f17);
	p.setForeground(Color.black);
	pr.add(p);

	prt.setBounds(200,170,210,50);
	prt.setFont(f16);
	prt.setForeground(Color.black);
	pr.add(prt);


	pt.setBounds(470,170,150,30);
	pt.setFont(f17);
	pt.setForeground(Color.black);
	pr.add(pt);


	prs.setBounds(200,220,100,50);
	prs.setFont(f16);
	prs.setForeground(Color.black);
	pr.add(prs);


	ps.setBounds(470,220,150,30);
	ps.setFont(f17);
	ps.setForeground(Color.black);
	pr.add(ps);


	qt.setBounds(200,270,210,50);
	qt.setFont(f16);
	qt.setForeground(Color.black);
	pr.add(qt);


	q.setBounds(470,270,150,30);
	q.setFont(f17);
	q.setForeground(Color.black);
	pr.add(q);

	sz.setBounds(200,320,100,50);
	sz.setFont(f16);
	sz.setForeground(Color.black);
	pr.add(sz);


	s.setBounds(470,320,150,30);
	s.setFont(f17);
	s.setForeground(Color.black);
	pr.add(s);

	cp.setBounds(200,370,210,50);
	cp.setFont(f16);
	cp.setForeground(Color.black);
	pr.add(cp);


	co.setBounds(470,370,150,30);
	co.setFont(f17);
	co.setForeground(Color.black);
	pr.add(co);

	sp.setBounds(200,420,210,50);
	sp.setFont(f16);
	sp.setForeground(Color.black);
	pr.add(sp);


	se.setBounds(470,420,150,30);
	se.setFont(f17);
	se.setForeground(Color.black);
	pr.add(se);

	pcp.setBounds(200,470,210,50);
	pcp.setFont(f16);
	pcp.setForeground(Color.black);
	pr.add(pcp);


	com.setBounds(470,470,150,30);
	com.setFont(f17);
	com.setForeground(Color.black);
	pr.add(com);



    ok.setBounds(350,570,100,30);
	pr.add(ok);


	ca.setBounds(500,570,100,30);
	pr.add(ca);



    ok.addActionListener(this);
    ca.addActionListener(this);




}
public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==ok)
		{

            s1=(String)p.getText();
             s2=(String)pt.getSelectedItem();
             s3=(String)ps.getSelectedItem();

            s4=(String)q.getText();
             s5=(String)s.getText();
             s6=(String)co.getText();
 
            s7=(String)se.getText();

             s8=(String)com.getText();
              
            if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")||s7.equals("")||s8.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL DETAILS");

            }
            else
            {
            try
            {

            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement ps=con.prepareStatement("select * from products where`Product_No.`='"+s1+"'");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{

              e1=(String)rs.getString("Product_No.");
		 	}
            if(s1.equals(e1))
            {
                JOptionPane.showMessageDialog(null,"Product Number Exists");

            }
            else
            {
                PreparedStatement st=con.prepareStatement("INSERT INTO `products`(`Product_No.`, `Product_Type`, `Supplier`, `Quantity`, `Size`, `Company`,`Cost_Price`,`Selling_Price`) VALUES (?,?,?,?,?,?,?,?)");
      st.setString(1,s1);
      st.setString(2,s2);
      st.setString(3,s3);
      st.setString(4,s4);
      st.setString(5,s5);
      st.setString(6,s8);
      st.setString(7,s6);
      st.setString(8,s7);



	   st.executeUpdate();

        JOptionPane.showMessageDialog(null," Product Added");

            setVisible(false);
        new bbm1();
         p.setText("");
        q.setText("");
         s.setText("");
         co.setText("");
         se.setText("");
         com.setText("");



            }

                     }

            catch(Exception exception)
                 {
                     System.out.println(exception);
                 }
}
        }
 if(e.getSource()==ca)
		{

            setVisible(false);
     new bbm1();
        }

}


}