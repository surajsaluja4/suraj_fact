package fact;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class bill_print1 implements ActionListener
 {
    JPanel p1,p2,p3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,tax,bill,item,size,unit,date,time,cstno,total,l11,gst,cin,pan,auth,thank,nice,totamt;
    JLabel log,user,pass,loginas;
    JLabel data[],bil[],add[];
	JTextField u;
    JPasswordField p;
	JComboBox la;
	JButton lo;
    admin_verification av;
    manager_verification mv;
    JScrollPane sp;
JPanel panelmain,panelBack;


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
        String dat=billing_form.timeStamp;
        String bili=Integer.toString(billing_form.ret);
        String nam=billing_form.name;

Double totalbillamt=0.0;
   bill_print1(int row)
   {

        System.out.println("you are inside bill print");
        frame.setSize(900,700);
        //frame.setLayout(null);
        frame.setResizable(false);
        
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                 av=new admin_verification();
                 mv=new manager_verification();

         panelmain=new JPanel();
         panelmain.setLayout(null);
         p1=new JPanel();
         p2=new JPanel();
         p3=new JPanel();
p3.setVisible(true);
if((485+(row*30))>800)
{
 panelmain.setPreferredSize(new Dimension(frame.getWidth(), 585+(row*30)));
}
else{
 panelmain.setPreferredSize(new Dimension(frame.getWidth(),800));
}
p1.setBounds(0,0,900,275);
         p2.setBounds(0,275,900,10+(row*30));
         p3.setBounds(0,panelmain.getPreferredSize().height-300, 900, 200);
         System.out.println(panelmain.getPreferredSize().height);
         
         p1.setBackground(Color.white);
          p2.setBackground(Color.white);
          p3.setBackground(Color.white);

          p1.setLayout(null);
          p2.setLayout(null);
          p3.setLayout(null);

          panelmain.add(p1);
          panelmain.add(p2);
          panelmain.add(p3);


add=new JLabel[5];
add[0]=new JLabel(dat.subSequence(0, 10).toString());
add[1]=new JLabel(dat.substring(11));
add[2]=new JLabel(bili);
add[3]=new JLabel(Integer.toString(billing_form.rt));

add[0].setBounds(820, 190, 130, 30);
add[1].setBounds(820, 210, 130, 30);
add[2].setBounds(58, 190, 130, 30);
add[3].setBounds(85, 210, 130, 30);
p1.add(add[0]);
p1.add(add[1]);
p1.add(add[2]);
p1.add(add[3]);

        l1=new JLabel(new ImageIcon("img/main/logo1.png"));
        l2=new JLabel(new ImageIcon("img/main/login_icon.jpg"));
        l3=new JLabel("VINOD FABRICS");
        tax=new JLabel("Tax Invoice/Receipt");
        l4=new JLabel("Symbol of trust and Quality");
        l5=new JLabel("28,Babail Road,Panipat");
        l6=new JLabel("Panipat,Haryana");
        l7=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l8=new JLabel("**********************************************************************************************************************************************************************************");
        l9=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        l10=new JLabel("**********************************************************************************************************************************************************************************");
        l11=new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");       bill=new JLabel("Bill No. :");
        total=new JLabel("Total :");
        date=new JLabel("Date:");
        time=new JLabel("Time:");
        cstno=new JLabel("Cust.Number:");
        item=new JLabel("  SlNo              Item Name                                                Size                              Qty                 UnitPrice                  Disc%                    Cgst%                   Sgst%               Total");
        gst=new JLabel("GSTIN :1234566fdd");
        cin=new JLabel("CIN NO :1234566fdd");
        pan=new JLabel("PAN NO :1234566fdd");
        auth=new JLabel("Authorized Signatory");
        thank=new JLabel("Thank You For Shopping With Us!!!!!");
        nice=new JLabel("   Have A Nice Day");
        data=new JLabel[row*9];
        bil=new JLabel[5];
       System.out.println(billing_form.tb.getValueAt(0,1).toString());
        int y=0,tm=0;
       for(int i=0;i<row;i++)
        {
        data[tm]=new JLabel(billing_form.model.getValueAt(i,0).toString());
        data[tm+1]=new JLabel(billing_form.model.getValueAt(i,2).toString());
        data[tm+2]=new JLabel(billing_form.model.getValueAt(i,3).toString());
        data[tm+3]=new JLabel(billing_form.model.getValueAt(i,5).toString());
        data[tm+4]=new JLabel(billing_form.model.getValueAt(i,4).toString());
        data[tm+5]=new JLabel(billing_form.model.getValueAt(i,8).toString());
        data[tm+6]=new JLabel(billing_form.model.getValueAt(i,6).toString());
        data[tm+7]=new JLabel(billing_form.model.getValueAt(i,7).toString());
        data[tm+8]=new JLabel(billing_form.model.getValueAt(i,9).toString());
            System.out.println("billing"+billing_form.model.getValueAt(i,9).toString());
 totalbillamt+=(Double)billing_form.model.getValueAt(i,9);
            System.out.println("total : "+totalbillamt);
        data[tm].setBounds(10,y,100,30);
        data[tm+1].setBounds(80,y,900,30);
        data[tm+2].setBounds(277,y,900,30);
        data[tm+3].setBounds(400,y,900,30);
        data[tm+4].setBounds(475,y,900,30);
        data[tm+5].setBounds(575,y,900,30);
        data[tm+6].setBounds(662,y,900,30);
        data[tm+7].setBounds(760,y,900,30);
        data[tm+8].setBounds(830,y,900,30);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        p2.add(data[tm++]);
        y=y+30;

       }
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
        bill.setBounds(6,190,130,30 );
        bill.setBounds(6,190,130,30 );
totamt=new JLabel(totalbillamt.toString());
        date.setBounds(780,190,130,30);
        time.setBounds(780,210,130,30);
        cstno.setBounds(6,210,130,30);
        l8.setBounds(0,233,900,30);
        item.setBounds(0,246,900,30);
        l10.setBounds(0,258,900,30);
        l9.setBounds(0,378,900,30);
        total.setBounds(0,40,100,30);
        totamt.setBounds(840,40,100,30);
        l11.setBounds(0,52,900,30);
        gst.setBounds(0,70,900,30);
        cin.setBounds(370,70,900,30);
        pan.setBounds(760,70,900,30);
        auth.setBounds(760,130,900,30);
        thank.setBounds(260,110,900,30);
        nice.setBounds(310,130,900,30);



                l2.setBounds(-50, 190 , 380, 360);         //in panel 2

        p1.add(tax);
        p1.add(date);
        p1.add(time);
        p1.add(cstno);
        p1.add(l8);
        p1.add(item);
        p3.add(total);
        p3.add(totamt);
        p3.add(l11);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
        p1.add(l6);
        p1.add(l7);
        p1.add(bill);
        p1.add(l10);
        p3.add(l9);
        p3.add(gst);
        p3.add(cin);
        p3.add(pan);
        p3.add(auth);
        p3.add(thank);
        p3.add(nice);
          JButton printButton = new JButton("Print This Window");
        printButton.addActionListener(new PrintUIWindow(frame));
        printButton.setBounds(310,190,900,30);
        p3.add(printButton);
panelmain.setVisible(true);
    p1.add(l1);
        panelmain.setPreferredSize(new Dimension(frame.getWidth(), 585+(row*30)));
        sp=new JScrollPane(panelmain, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelBack=new JPanel();
        panelBack.setLayout(new BorderLayout());
        panelBack.add(sp,BorderLayout.CENTER);
        panelBack.setVisible(true);
        panelBack.setBackground(Color.BLACK);
        frame.add(panelBack);
        frame.setVisible(true);
panelBack.setBackground(Color.white);
         panelmain.setBackground(Color.white);


        frame.setVisible(true);

       // p2.setVisible(false);
        
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
          new bill_print1(1);

    }

}










