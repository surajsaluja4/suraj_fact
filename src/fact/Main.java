package fact;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class Main implements ActionListener
 {
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JLabel log,user,pass,loginas;
	JTextField u;
    JPasswordField p;
	JComboBox la;
	JButton lo;
    admin_verification av;
    manager_verification mv;
    //  setDecoration(null);
   File file = new File("Hello.txt");
 static  String sti="", welcomename="",pus="";

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

   Main()
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
        l3=new JLabel("VINOD FABRICS");
        l4=new JLabel("Symbol of trust and Quality");
        l5=new JLabel("28,Babail Road");
        l6=new JLabel("Panipat,Haryana");
        l7=new JLabel(new ImageIcon("img/main/panelpic.gif"));

        l3.setFont(f1);
        l3.setForeground(Color.decode("#00a69c"));
        l4.setFont(f6);
        l5.setFont(f4);
        l6.setFont(f4);




    log=new JLabel(new ImageIcon("img/main/Capture.png"));
	user=new JLabel("UserName:");
	pass=new JLabel("Password:");


	u=new JTextField(25);
	p=new JPasswordField(25);

        l1.setBounds(0,10,190,190);
   		l3.setBounds(350, 30, 800, 150);
 		l4.setBounds(590, 140, 300, 30);
 		l5.setBounds(720, 10, 300, 20);
        l6.setBounds(710, 30, 130, 20);

        l7.setBounds(0,20,900,100);

        l2.setBounds(-50, 190 , 380, 360);         //in panel 2

		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
        p1.add(l6);
        p2.add(l7);
    	p2.add(l2);
        lo=new JButton(new ImageIcon("img/main/login_button.png"));



	log.setBounds(180,80,580,200);
	log.setFont(f1);
	log.setForeground(Color.DARK_GRAY);
	p2.add(log);

	user.setBounds(340,260,100,30);
	user.setFont(f3);
	user.setForeground(Color.black);
	p2.add(user);


	u.setBounds(490,260,150,30);
	u.setFont(f3);
	u.setForeground(Color.black);
	p2.add(u);

	pass.setBounds(340,330,250,30);
	pass.setFont(f3);
	pass.setForeground(Color.black);
	p2.add(pass);


	p.setBounds(490,330,150,30);
	p.setFont(f4);
	p.setForeground(Color.black);
	p2.add(p);

    p1.add(l1);

    lo.setBounds(290,390,380,100);
    lo.setBorder(null);
    lo.setBackground(Color.white);
	p2.add(lo);



    lo.addActionListener(this);


        frame.setVisible(true);


   }
   public void actionPerformed(ActionEvent e)
	{
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
			Connection con=DriverManager.getConnection(Connection1.dbadmin,Connection1.root,Connection1.pass);
			PreparedStatement ps=con.prepareStatement("select * from login_credentials where UserName='"+s+"' AND  `Password` =  '"+pas+"'");
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
              welcomename=(String)rs.getString("name");       //for the name
              sti=(String)rs.getString("username");              // for the user name
              pus=(String)rs.getString("password");   // for the password
              pos=(String)rs.getString("position");
              sk=rs.getInt("security");

			 	}
                
                
                if(s.equals(sti)&&pas.equals(pus))
            {
                JOptionPane.showMessageDialog(null,welcomename+" Logged in");
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
                if(pos.equals("Employee"))
                {

                p2.setVisible(false);
                p1.setVisible(false);
                new staff_area();

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
          new very_first_call();
          new Main();

    }

}










