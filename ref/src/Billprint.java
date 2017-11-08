import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
class Billprint extends JFrame
 {
   	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JLabel l14,l15,l16,l17,l18,l19;
    JLabel l20,l21,l22,l23,l24,l25,l26,l27;
    JLabel l[]=new JLabel[47];
    String bil,un,pn1,pn2,pn3,pn4,q1,q2,q3,q4,d,m,y,t,cust,custname,sn,sp1,sp2,sp3,sp4;
    String pt1="",ps1="",pc1="",pt2="",ps2="",pc2="",pt3="",ps3="",pc3="",pt4="",ps4="",pc4="";
    int pr1,pr2,pr3,pr4;
    String spr1="",spr2="",spr3="",spr4="",spt="";

        int s;
        Font f=new Font("Modern No. 20",Font.BOLD, 25);
		Font f1=new Font("Lucida Handwriting",Font.BOLD, 60);
		Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
		Font f3=new Font("Baskerville Old Face",Font.BOLD, 17);
		Font f4=new Font("Imprint MT Shadow",Font.PLAIN, 30);
		Font f5=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
		Font f6=new Font("Lucida Calligraphy",Font.BOLD,17);
		Font f7=new Font("Lucida Handwriting",Font.BOLD,18);
		Font f8=new Font("Calibri",Font.PLAIN,20);

    Billprint()
    {
      setVisible(true);
      setSize(900,800);
      setLayout(null);

    p1=new JPanel();
    p2=new JPanel();
    p3=new JPanel();
    p4=new JPanel();
    p5=new JPanel();
    p6=new JPanel();
    p7=new JPanel();
    p8=new JPanel();
    p9=new JPanel();
    p10=new JPanel();


    p1.setBounds(0,0,900,170);
    p2.setBounds(0,170,900,30);
    p3.setBounds(0,200,900,100);
    p4.setBounds(0,300 ,900,40);
    p5.setBounds(0,340,900,40);
    p6.setBounds(0,380,900,40);
    p7.setBounds(0,420,900,40);
    p8.setBounds(0,460,900,40);
    p9.setBounds(0,500,900,120);
    p10.setBounds(0,620,900,200);



    p1.setBackground(Color.white);
    p2.setBackground(Color.white);
    p3.setBackground(Color.white);
    p4.setBackground(Color.LIGHT_GRAY);
    p5.setBackground(Color.white);
    p6.setBackground(Color.white);
    p7.setBackground(Color.white);
    p8.setBackground(Color.white);
    p9.setBackground(Color.white);
    p10.setBackground(Color.white);

    p1.setLayout(null);
    p2.setLayout(null);
    p3.setLayout(null);
    p4.setLayout(null);
    p5.setLayout(null);
    p6.setLayout(null);
    p7.setLayout(null);
    p8.setLayout(null);
    p9.setLayout(null);
    p10.setLayout(null);


        	 try
            {
            Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement pis=conn.prepareStatement("select * from billno");
			ResultSet ris=pis.executeQuery();

            while(ris.next())
			{

             bil=(String)ris.getString("Bill_no.");
			}
            PreparedStatement piso=conn.prepareStatement("select * from bill_data where billno='"+bil+"'");
            System.out.println(piso);
			ResultSet riso=piso.executeQuery();
            while(riso.next())
			{

            un =(String)riso.getString("Username");
			pn1 =(String)riso.getString("Pno1");
			pn2 =(String)riso.getString("Pno2");
			pn3 =(String)riso.getString("Pno3");
			pn4 =(String)riso.getString("Pno4");
			q1 =(String)riso.getString("Qno1");
			q2 =(String)riso.getString("Qno2");
			q3 =(String)riso.getString("Qno3");
			q4 =(String)riso.getString("Qno4");



			d =(String)riso.getString("Day");
			m =(String)riso.getString("Month");
			y =(String)riso.getString("Year");
			t =(String)riso.getString("Time");

            }
            System.out.println(pn1+pn2+pn3+pn4);
        if(pn2.equals("-1"))
{
        s=1;
        l[21]=new JLabel("1");
        l[22]=new JLabel("");
        l[23]=new JLabel("");
        l[24]=new JLabel("");
        q2="";q3="";q4="";
    PreparedStatement pso=conn.prepareStatement("select * from products where Product_No='"+pn1+"'");
	ResultSet rso=pso.executeQuery();
    while(rso.next())
    {
        pt1=(String)rso.getString("Product_Type");
        ps1=(String)rso.getString("Size");
        pc1=(String)rso.getString("Company");
        sp1 =(String)rso.getString("Selling_Price");
        pr1=Integer.parseInt(sp1) * Integer.parseInt(q1);
        spr1=Integer.toString(pr1);
    }
   spr1=Integer.toString(pr1);


}
else if(pn3.equals("-1"))
{
    s=2;

        l[21]=new JLabel("1");
        l[22]=new JLabel("2");
        l[23]=new JLabel("");
        l[24]=new JLabel("");
         q3="";q4="";
    PreparedStatement pso=conn.prepareStatement("select * from products where Product_No='"+pn1+"'");
	System.out.println(pso);
    ResultSet rso=pso.executeQuery();
    while(rso.next())
    {
        pt1=(String)rso.getString("Product_Type");
        ps1=(String)rso.getString("Size");
        pc1=(String)rso.getString("Company");
        sp1 =(String)rso.getString("Selling_Price");
        pr1=Integer.parseInt(sp1) * Integer.parseInt(q1);
    spr1=Integer.toString(pr1);
    }

    PreparedStatement pso2=conn.prepareStatement("select * from products where Product_No='"+pn2+"'");
	ResultSet rso2=pso2.executeQuery();
    while(rso2.next())
    {
        pt2=(String)rso2.getString("Product_Type");
        ps2=(String)rso2.getString("Size");
        pc2=(String)rso2.getString("Company");
		sp2 =(String)rso2.getString("Selling_Price");
        pr2=Integer.parseInt(sp2) * Integer.parseInt(q2);
        spr2=Integer.toString(pr2);
    }
    spr1=Integer.toString(pr1);
   spr2=Integer.toString(pr2);



}
else if(pn4.equals("-1"))
{
    System.out.println(pn1+pn2+pn3+pn4);
        s=3;
q4="";
        l[21]=new JLabel("1");
        l[22]=new JLabel("2");
        l[23]=new JLabel("3");
        l[24]=new JLabel("");

    PreparedStatement pso=conn.prepareStatement("select * from products where Product_No='"+pn1+"'");
    ResultSet rso=pso.executeQuery();
    while(rso.next())
    {
        pt1=(String)rso.getString("Product_Type");
        ps1=(String)rso.getString("Size");
        pc1=(String)rso.getString("Company");
        sp1 =(String)rso.getString("Selling_Price");
        System.out.print(sp1);
     }

    PreparedStatement psoq=conn.prepareStatement("select * from products where Product_No='"+pn2+"'");
	ResultSet rsoq=psoq.executeQuery();
    while(rsoq.next())
    {
        pt2=(String)rsoq.getString("Product_Type");
        ps2=(String)rsoq.getString("Size");
        pc2=(String)rsoq.getString("Company");
		sp2 =(String)rsoq.getString("Selling_Price");
     System.out.print(sp2);
    }

    PreparedStatement pso7=conn.prepareStatement("select * from products where Product_No='"+pn3+"'");
	ResultSet rso7=pso7.executeQuery();
    while(rso7.next())
    {
        pt3=(String)rso7.getString("Product_Type");
        ps3=(String)rso7.getString("Size");
        pc3=(String)rso7.getString("Company");
        sp3 =(String)rso7.getString("Selling_Price");

    }
   pr1=Integer.parseInt(sp1) * Integer.parseInt(q1);
   pr2=Integer.parseInt(sp2) * Integer.parseInt(q2);
   pr3=Integer.parseInt(sp3) * Integer.parseInt(q3);
   spr1=Integer.toString(pr1);
   spr2=Integer.toString(pr2);
   spr3=Integer.toString(pr3);
}
else
{

        l[21]=new JLabel("1");
        l[22]=new JLabel("2");
        l[23]=new JLabel("3");
        l[24]=new JLabel("4");

        s=4;

    PreparedStatement pso=conn.prepareStatement("select * from products where Product_No='"+pn1+"'");
	ResultSet rso=pso.executeQuery();
    while(rso.next())
    {
        pt1=(String)rso.getString("Product_Type");
        ps1=(String)rso.getString("Size");
        pc1=(String)rso.getString("Company");
        sp1 =(String)rso.getString("Selling_Price");
        pr1=Integer.parseInt(sp1) * Integer.parseInt(q1);
        spr1=Integer.toString(pr1);
    }

    PreparedStatement psoq=conn.prepareStatement("select * from products where Product_No='"+pn2+"'");
	ResultSet rsoq=psoq.executeQuery();
    while(rsoq.next())
    {
        pt2=(String)rsoq.getString("Product_Type");
        ps2=(String)rsoq.getString("Size");
        pc2=(String)rsoq.getString("Company");
        sp2=(String)rsoq.getString("Selling_Price");
        pr2=Integer.parseInt(sp2) * Integer.parseInt(q2);
        spr2=Integer.toString(pr2);
    }

 
    PreparedStatement pso7=conn.prepareStatement("select * from products where Product_No='"+pn3+"'");
	ResultSet rso7=pso7.executeQuery();
    while(rso7.next())
    {
        pt3=(String)rso7.getString("Product_Type");
        ps3=(String)rso7.getString("Size");
        pc3=(String)rso7.getString("Company");
        sp3=(String)rso7.getString("Selling_Price");
        pr3=Integer.parseInt(sp3) * Integer.parseInt(q3);
        spr3=Integer.toString(pr3);
    }

    PreparedStatement ps97=conn.prepareStatement("select * from products where Product_No='"+pn4+"'");
	ResultSet rso97=ps97.executeQuery();
    while(rso97.next())
    {
        pt4=(String)rso97.getString("Product_Type");
        ps4=(String)rso97.getString("Size");
        pc4=(String)rso97.getString("Company");
        sp4=(String)rso97.getString("Selling_Price");
        pr4=Integer.parseInt(sp4) * Integer.parseInt(q3);
        spr4=Integer.toString(pr4);
    }
}
    }  //end of try block

    catch(Exception e)
    {
        System.out.println(e);
    }

    if(un.equals("User"))
    {
         cust="Customer";
    }

    else
    {
        	 try
            {
            Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement pis=conn.prepareStatement("select * from registration where UserName='"+un+"'");
			ResultSet ris=pis.executeQuery();

            while(ris.next())
			{

             cust=(String)ris.getString("Name");
			}
             }
             catch(Exception e)
             {
                 System.out.println(e);
             }
    }

int tpr=pr1+pr2+pr3+pr4;
spt=Integer.toString(tpr);


        l[1]=new JLabel(un);
        l[2]=new JLabel(pn1);
        l[3]=new JLabel(pn2);
        l[4]=new JLabel(pn3);
        l[5]=new JLabel(pn4);

        l[6]=new JLabel(q1);
        l[7]=new JLabel(q2);
        l[8]=new JLabel(q3);
        l[9]=new JLabel(q4);

        l[10]=new JLabel(d);
        l[11]=new JLabel(m);
        l[12]=new JLabel(y);
        l[13]=new JLabel(t);

        l[14]=new JLabel("Cash");
        l[15]=new JLabel("/");
        l[16]=new JLabel("/");
        l[17]=new JLabel("Cashier 1");
        l[18]=new JLabel(cust);
        l[19]=new JLabel(bil);
        l[20]=new JLabel(bil);


l[25]=new JLabel(pt1+"  "+ps1+"  "+pc1);
l[26]=new JLabel(pt2+"  "+ps2+"  "+pc2);
l[27]=new JLabel(pt3+"  "+ps3+"  "+pc3);
l[28]=new JLabel(pt4+"  "+ps4+"  "+pc4);

l[29]=new JLabel(q1);
l[30]=new JLabel(q2);
l[31]=new JLabel(q3);
l[32]=new JLabel(q4);

l[33]=new JLabel(spr1);
l[34]=new JLabel(spr2);
l[35]=new JLabel(spr3);
l[36]=new JLabel(spr4);

l[37]=new JLabel(spt);
l[38]=new JLabel("Rs. "+spt);

String ptar1="~~~~~~~~~~~~~";
for(int i=0;i<6;i++)
{
ptar1=ptar1+ptar1;
}

l[39]=new JLabel(ptar1);
l[40]=new JLabel("Head Office :");
l[41]=new JLabel("BBM Textiles,Near SBI ATM, Amar Bhawan Chowk,Panipat 132103. Ph:+91-01802631383");
l[42]=new JLabel("Website:");
l[43]=new JLabel("https://www.bbmgroups.com");
l[44]=new JLabel("Email:");
l[45]=new JLabel("bbmtextiles@bbmgroups.com");
l[46]=new JLabel("Thank You For Visiting!!!!!!!");



    add(p1);
    add(p2);
    add(p3);
    add(p4);
    add(p5);
    add(p6);
    add(p7);
    add(p8);
    add(p9);
    add(p10);


    l1=new JLabel(new ImageIcon("img/logo.gif"));
    l2=new JLabel("BBM GROUPS");
    l3=new JLabel("Symbol of trust and Quality");
    l4=new JLabel("No.4 Dharamshala Road ");
    l5=new JLabel("Jharia,Dhanbad");
    l7=new JLabel("Bill No. :");
    l6=new JLabel("User Name :");
    l8=new JLabel("Mode:");
    l9=new JLabel("No.4 Dharamshala Road ");
    l10=new JLabel("Jharia,Dhanbad");
    l11=new JLabel("Date:");
    l12=new JLabel("Paid To:");
    l13=new JLabel("Time:");
    l14=new JLabel("Recieved From:");
    l15=new JLabel("Address:");
    l16=new JLabel("City:");
    l17=new JLabel("Pin:");
    l18=new JLabel("State:");
    l19=new JLabel("SlNo.");
    l20=new JLabel("Description");
    l21=new JLabel("Qty");
    l22=new JLabel("Amount");
    l23=new JLabel("Total:");
    l24=new JLabel("Discout(if any):");
    l25=new JLabel("~~~~~~~~~~~~~~~~");
    l26=new JLabel("Grand Total:");
    l27=new JLabel("~~~~~~~~~~~~~~~~");


    l2.setFont(f1);
	l3.setFont(f2);
	l4.setFont(f3);
	l5.setFont(f3);
    l6.setFont(f3);
    l7.setFont(f3);
    l8.setFont(f3);
    l11.setFont(f3);
    l12.setFont(f3);
    l13.setFont(f3);
    l14.setFont(f3);
    l15.setFont(f3);
    l16.setFont(f3);
    l17.setFont(f3);
    l18.setFont(f3);
    l19.setFont(f3);
    l20.setFont(f3);
    l21.setFont(f3);
    l22.setFont(f3);
    l23.setFont(f3);
    l24.setFont(f3);
    l25.setFont(f3);
    l26.setFont(f3);
    l27.setFont(f3);




    for(int ds=1;ds<47;ds++)
    {
    l[ds].setFont(f8);
    }

    l[40].setFont(f7);
    l[42].setFont(f7);
    l[44].setFont(f7);
    l[46].setFont(f7);



    l2.setForeground(Color.GRAY);


    l1.setBounds(0, 40,160, 80);
	l2.setBounds(180, 50 , 500, 60);
    l3.setBounds(500, 90, 300, 60);
 	l4.setBounds(670, 10, 350, 20);
 	l5.setBounds(670, 30, 350, 20);
    l6.setBounds(1,0,180,20);
    l7.setBounds(650,0,110,20);
    l8.setBounds(350,0,110,20);
    l11.setBounds(1,20,180,20);
    l13.setBounds(650,20,110,20);
    l12.setBounds(350,20,110,20);
    l14.setBounds(1,70,180,20);
    l19.setBounds(1,13,110,20);
    l20.setBounds(260,13,110,20);
    l21.setBounds(600,13,180,20);
    l22.setBounds(800,13,110,20);

    l[1].setBounds(100,0,180,20);
	l[2].setBounds(180,50,500,60);
    l[3].setBounds(500,90,300,60);
 	l[4].setBounds(670,10,350,20);
 	l[5].setBounds(670,30,350,20);

    l[6].setBounds(605,13,110,20);
    l[7].setBounds(605,13,110,20);
    l[8].setBounds(605,13,110,20);
    l[9].setBounds(605,13,110,20);

    l[10].setBounds(50,20,80,18);
    l[15].setBounds(70,20,80,18);
    l[11].setBounds(80,20,80,18);
    l[16].setBounds(100,20,60,18);
    l[12].setBounds(110,20,80,18);
    l[13].setBounds(700,20,110,20);
    l[14].setBounds(410,0,180,20);
    l[17].setBounds(430,20,110,20);
    l[18].setBounds(125,70,180,20);
    l[19].setBounds(723,0,110,20);

    l[21].setBounds(5,13,110,20);
    l[22].setBounds(5,13,110,20);
    l[23].setBounds(5,13,110,20);
    l[24].setBounds(5,13,110,20);


    l[25].setBounds(220,13,410,20);
    l[26].setBounds(220,13,410,20);
    l[27].setBounds(220,13,410,20);
    l[28].setBounds(220,13,410,20);

     l[33].setBounds(810,13,110,20);
     l[34].setBounds(810,13,110,20);
     l[35].setBounds(810,13,110,20);
     l[36].setBounds(810,13,110,20);

     l[37].setBounds(810,13,110,20);
     l[38].setBounds(790,83,110,20);

     l[39].setBounds(0,0,900,10);
     l[40].setBounds(3,15,230,20);
     l[41].setBounds(152,15,900,20);
     l[42].setBounds(104,40,900,20);
     l[43].setBounds(200,40,900,20);
     l[44].setBounds(470,40,900,20);
     l[45].setBounds(550,40,900,20);
     l[46].setBounds(250,80,900,20);

     l27.setBounds(780,1,210,20);
     l23.setBounds(570, 13,110,20);
     l24.setBounds(570, 43,140,20);
     l25.setBounds(690, 63,280,20);
     l26.setBounds(570, 83,140,20);



        p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
        p1.add(l5);

        p2.add(l6);
        p2.add(l[1]);
        p2.add(l7);
        p2.add(l[19]);
        p2.add(l8);
        p2.add(l[14]);


        p3.add(l11);
        p3.add(l[10]);
        p3.add(l[15]);
        p3.add(l[11]);
        p3.add(l[16]);
        p3.add(l[12]);



        p3.add(l12);
        p3.add(l[17]);

        p3.add(l13);
        p3.add(l[13]);

        p3.add(l14);
        p3.add(l[18]);
        p4.add(l19);
        p4.add(l20);
        p4.add(l21);
        p4.add(l22);


        p5.add(l[6]);
        p6.add(l[7]);
        p7.add(l[8]);
        p8.add(l[9]);

        p5.add(l[21]);
        p6.add(l[22]);
        p7.add(l[23]);
        p8.add(l[24]);

        p5.add(l[25]);
        p6.add(l[26]);
        p7.add(l[27]);
        p8.add(l[28]);

        p5.add(l[33]);
        p6.add(l[34]);
        p7.add(l[35]);
        p8.add(l[36]);

        p9.add(l23);
        p9.add(l24);
        p9.add(l25);
        p9.add(l26);
        p9.add(l27);

        p9.add(l[37]);
        p9.add(l[38]);

        p10.add(l[39]);
        p10.add(l[40]);
        p10.add(l[41]);
        p10.add(l[42]);
        p10.add(l[43]);
        p10.add(l[44]);
        p10.add(l[45]);
        p10.add(l[46]);



      }//end of the constructer
 
}
