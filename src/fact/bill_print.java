package fact;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class bill_print implements ActionListener
 {
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,tax,bill,item,size,unit,date,time,cstno,total,l11,gst,cin,pan,auth,thank,nice;
    JLabel log,user,pass,loginas;
	JTextField u;
    JPasswordField p;
	JComboBox la;
	JButton lo;
    admin_verification av;
    manager_verification mv;
//    setDecoration(null);
   File file = new File("Hello.txt");

    static JFrame frame=new JFrame();

        Font f=new Font("Modern No. 20",Font.BOLD, 25);
        Font f1=new Font("Lucida Handwriting",Font.BOLD, 52);
		Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
		Font f3=new Font("Baskerville Old Face",Font.BOLD, 17);
		Font f4=new Font("Imprint MT Shadow",Font.ITALIC,15);
		Font f5=new Font("Copperplate Gothic Bold",Font.ITALIC, 14);
		Font f6=new Font("Lucida Calligraphy",Font.BOLD,17	);
		Font f7=new Font("Lucida Handwriting",Font.BOLD,50);
		Font f8=new Font("Lucida Handwriting",Font.BOLD,17);

   bill_print()
   {
        frame.setSize(900,800);
        frame.setLayout(null);
        frame.setResizable(false);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
                 av=new admin_verification();
                 mv=new manager_verification();


         p1=new JPanel();
         p2=new JPanel();

         p1.setBounds(0,0,900,195);
         p2.setBounds(0,195,900,530);


          p1.setBackground(Color.white);
          p2.setBackground(Color.white);

          p1.setLayout(null);
          p2.setLayout(null);

          frame.add(p1);
          frame.add(p2);
          frame.add(av);
          frame.add(mv);




        l1=new JLabel(new ImageIcon("img/main/logo1.png"));
        l2=new JLabel(new ImageIcon("img/main/login_icon.jpg"));
        l3=new JLabel("SHREE RAM TEXO FAB");
        tax=new JLabel("Tax Invoice/Receipt");
        l4=new JLabel("Symbol of trust and Quality");
        l5=new JLabel("9,Patel Nagar,Near Khadi Ashram");
        l6=new JLabel("Panipat,Haryana");
        l7=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l8=new JLabel("**********************************************************************************************************************************************************************************");
        l9=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l10=new JLabel("**********************************************************************************************************************************************************************************");
        l11=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");       bill=new JLabel("Bill No. :");
        total=new JLabel("Total :");
        date=new JLabel("Date:");
        time=new JLabel("Time:");
        cstno=new JLabel("Cust. no.:");
        item=new JLabel("  SlNo              Item Name                                                Size                              Qty                 UnitPrice                  Disc%                    Cgst%                      Sgst%                 Total");
        gst=new JLabel("GSTIN :1234566fdd");
        cin=new JLabel("CIN NO :1234566fdd");
        pan=new JLabel("PAN NO :1234566fdd");
        auth=new JLabel("Authorized Signatory");
        thank=new JLabel("Thank You For Shopping With Us!!!!!");
        nice=new JLabel("   Have A Nice Day");





        l3.setFont(f1);
        l3.setForeground(Color.decode("#00a69c"));
        l4.setFont(f6);
        l5.setFont(f4);
        l6.setFont(f4);
        tax.setFont(f4);
        thank.setFont(f2);
        nice.setFont(f2);



        l1.setBounds(0,10,190,190);
        tax.setBounds(410,0,160,40);
   		l3.setBounds(180, 30, 800, 150);
 		l4.setBounds(590, 140, 300, 30);
 		l5.setBounds(650, 10, 300, 20);
        l6.setBounds(710, 30, 130, 20);

        l7.setBounds(0,140,900,100);
        bill.setBounds(6,0,130,30 );
        date.setBounds(780,0,130,30);
        time.setBounds(780,20,130,30);
        cstno.setBounds(6,20,130,30);
        l8.setBounds(0,33,900,30);
        item.setBounds(0,46,900,30);
        l10.setBounds(0,58,900,30);
        l9.setBounds(0,378,900,30);
        total.setBounds(0,390,100,30);
        l11.setBounds(0,402,900,30);
        gst.setBounds(0,420,900,30);
        cin.setBounds(370,420,900,30);
        pan.setBounds(760,420,900,30);
        auth.setBounds(760,480,900,30);
        thank.setBounds(260,460,900,30);
        nice.setBounds(310,480,900,30);



                l2.setBounds(-50, 190 , 380, 360);         //in panel 2

        p1.add(tax);
        p2.add(date);
        p2.add(time);
        p2.add(cstno);
        p2.add(l8);
        p2.add(item);
        p2.add(total);
        p2.add(l11);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p2.add(bill);
        p2.add(l10);
        p2.add(l9);
        p2.add(gst);
        p2.add(cin);
        p2.add(pan);
        p2.add(auth);
        p2.add(thank);
        p2.add(nice);

	
    p1.add(l1);






        frame.setVisible(true);


   }
   public void actionPerformed(ActionEvent e)
	{
		 String welcomename="",sti="",pus="";
            String s=(String)u.getText();
            String pas=(String)p.getText();

       if(e.getSource()==lo)
		{

           String pos="";
          int sk=0;
            if(s.equals("")||pas.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL DETAILS");

            }
            else
            {
try
            {

            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(Connection1.dbadmin, Connection1.root, Connection1.pass);
			PreparedStatement ps=con.prepareStatement("select * from login_credentials where UserName='"+s+"' AND  `Password` =  '"+pas+"'");
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
              welcomename=(String)rs.getString("name");
              sti=(String)rs.getString("username");
              pus=(String)rs.getString("password");   // pass
              pos=(String)rs.getString("position");
              sk=rs.getInt("security");

			 	}


                if(s.equals(sti)&&pas.equals(pus))
            {
                JOptionPane.showMessageDialog(null,welcomename+" Logged in");
                sti="";
                pus="";
                s="";
                pas="";

                if(pos.equals("Admin"))
                {
                    av.abc(sk);
                p2.setVisible(false);
                p1.setVisible(false);
                av.setVisible(true);
                }
                if(pos.equals("Manager"))
                {
                    mv.abc(sk);

                p2.setVisible(false);
                p1.setVisible(false);
                mv.setVisible(true);
                }


            }
            else
            {
                JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD DID NIT MATCH");
                u.setText("");
                p.setText("");

            }

                     }

            catch(Exception exception)
                 {
                     System.out.println(exception);

                    }

                 }


}




            else if(s.equals("bbm")&&pas.equals("bbm"))                         // to be edited later using value from database
            {
                frame.setVisible(false);
                frame.setVisible(true);
                p2.setVisible(false);
                p1.setVisible(false);
                mv.setVisible(true);

            }
            else if(s.equals("staff")&&pas.equals("bbm"))                         // to be edited later using value from database
            {
               p2.setVisible(false);
                p1.setVisible(false);
                    close();
                    new staff_area();

            }

            else
            {
               JOptionPane.showMessageDialog(null,"Credentials did not match");

            }

        }





    void close()
{
    p1.setVisible(false);
    p2.setVisible(false);
    av.setVisible(false);
    mv.setVisible(false);
    frame.setVisible(false);
}

    public static void main(String[] args)
    {
          new bill_print();

    }

}










