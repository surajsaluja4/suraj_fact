import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

 class login extends JPanel implements ActionListener

 {
	
   	JLabel log,user,pass,loginas;
	JTextField u,p;
	JComboBox la;
	JButton lo,ca;


    
login()
{
	Font f15=new Font("Lucida Calligraphy",Font.BOLD,50);
	Font f16=new Font("Lucida Handwriting",Font.BOLD,17);
	Font f17=new Font("Aerial",Font.PLAIN,17);
	setVisible(false);
   
	
        setBounds(200,300,700,500);
		setLayout(null);
		setBackground(Color.white);
		

    log=new JLabel("LOGIN PORTAL");
	user=new JLabel("User");
	pass=new JLabel("Password");
    loginas=new JLabel("Login As");


	u=new JTextField(25);
	p=new JTextField(25);

	la=new JComboBox();
	la.addItem("Admin");
	la.addItem("Staff");
	la.addItem("Customer");


	lo=new JButton("Login");
	ca=new JButton("Cancel");

   

	log.setBounds(80,20,500,100);
	log.setFont(f15);
	log.setForeground(Color.DARK_GRAY);
	add(log);

	user.setBounds(150,140,100,30);
	user.setFont(f16);
	user.setForeground(Color.black);
	add(user);


	u.setBounds(300,140,150,30);
	u.setFont(f17);
	u.setForeground(Color.black);
	add(u);

	pass.setBounds(150,200,250,30);
	pass.setFont(f16);
	pass.setForeground(Color.black);
	add(pass);


	p.setBounds(300,200,150,30);
	p.setFont(f17);
	p.setForeground(Color.black);
	add(p);


	loginas.setBounds(150,260,250,30);
	loginas.setFont(f16);
	loginas.setForeground(Color.black);
	add(loginas);

    la.setBounds(300,260,150,30);
	la.setFont(f17);
	la.setForeground(Color.black);
	add(la);


    lo.setBounds(170,340,90,30);
	add(lo);

	ca.setBounds(320,340,90,30);
	add(ca);



    lo.addActionListener(this);
    ca.addActionListener(this);




}
public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==lo)
		{

            String WelcomeName="",sti="",pus="";
            String s=(String)u.getText();
            String pas=(String)p.getText();
            String sel=(String)la.getSelectedItem();
            if(s.equals("")||pas.equals(""))
            {
                 JOptionPane.showMessageDialog(null,"PLEASE FILL IN ALL DETAILS");

            }
            else
            {
            if(sel.equals("Customer"))
            {
               		 try
		{
            
            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement ps=con.prepareStatement("select * from registration where UserName='"+s+"' AND  `Password` =  '"+pas+"'");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{

             WelcomeName=(String)rs.getString("Name");
			  sti=(String)rs.getString("UserName");
              pus=(String)rs.getString("Password");

			 	}
            if(s.equals(sti)&&pas.equals(pus))
            {
                JOptionPane.showMessageDialog(null,"Sorry!!!!   "+WelcomeName+" \nSome Error In The System Would Be Resolved soon\nPlease Try Later  ");

            }
            else
            {
                JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD DID NIT MATCH");
		
            }

                     }

            catch(Exception exception)
                 {
                     System.out.println("ENTERIES DID NOT MATCH");
                 }
}

if(sel.equals("Staff")||sel.equals("Admin"))
            {
               		 try
		{

            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");
			PreparedStatement ps=con.prepareStatement("select * from registrationstaff where UserName='"+s+"' AND  `Password` =  '"+pas+"'");
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{

             WelcomeName=(String)rs.getString("Name");
			 String st=(String)rs.getString("UserName");
             sti=(String)rs.getString("UserName");
              pus=(String)rs.getString("Password");

			
              //JOptionPane.showMessageDialog(null,WelcomeName+" Logged in");
			}
               

			 if(s.equals(sti)&&pas.equals(pus))
            {
                JOptionPane.showMessageDialog(null,WelcomeName+" Logged in");
                u.setText("");
                p.setText("");
                setVisible(false);
                   new option_admin();
                bbm1.close();
              
                
                
                   }
            else
            {
                JOptionPane.showMessageDialog(null,"USERNAME OR PASSWORD DID NIT MATCH");

            }




        }
                 catch(Exception exception)
                 {
                     System.out.println("ENTERIES DID NOT MATCH");
                 }
}
}
        }//end of else if any field empty
        if(e.getSource()==ca)
		{
            //JOptionPane.showMessageDialog(null,"will return to the home panel");
             new bbm1();
        }


}
/*
public static void main(String []args)
{
 new login() ;
}*/
}