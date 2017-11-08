//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Edit_admin_data  implements ActionListener,key
{
        static JFrame frame=new JFrame();

	  JLabel reg,name,phone,user,pass,cpass,sk;
	  JTextField n,em,u,s;
      JPasswordField p,cp;
      JPanel pr;
	  JButton update,can;
      String str,str_name,str_user,str_pass,str_phone,str_sk,stu;

      Font f9=new Font("Modern No. 20",Font.BOLD, 40);
      Font f10=new Font("Lucida Handwriting",Font.BOLD, 20);
	  Font f11=new Font("Baskerville Old Face",Font.BOLD, 20);


Edit_admin_data()
{

    frame.setResizable(false);
	
    frame.setSize(1080,760);
    pr=new JPanel();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pr.setSize(1080,580);
	pr.setBounds(200,200,1080,580);
	pr.setLayout(null);
	pr.setBackground(Color.white);


	frame.add(pr);

    reg=new JLabel("Update Admin's Data");
    name=new JLabel("Name");
	phone=new JLabel("Phone");
	user=new JLabel("UserName");
	pass=new JLabel("Password");
	cpass=new JLabel("Confirm Password");
    sk =new JLabel("Security Key");

    n=new JTextField(25);            //text field for name
    n.addKeyListener(varchar);
	em=new JTextField(25);           //text field for phone
    em.addKeyListener(num);
	u=new JTextField(25);    //text field for user name
	p=new JPasswordField(25);         //text field for password
	cp=new JPasswordField(25);                               //text field for cnfrm password
   	s=new JTextField(25);                            //text field for securtiy key
    s.addKeyListener(num);

    update=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    update.setBorder(null);
	can=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    can.setBorder(null);

	reg.setBounds(300,20,600,100);
	reg.setFont(f9);
	reg.setForeground(Color.red);

	name.setBounds(200,170,100,30);
	name.setFont(f10);
	name.setForeground(Color.black);


	n.setBounds(470,170,150,30);
	n.setFont(f11);
	n.setForeground(Color.black);
	pr.add(n);



	phone.setBounds(200,220,250,30);
	phone.setFont(f10);
	phone.setForeground(Color.black);


	em.setBounds(470,220,150,30);
	em.setFont(f11);
	em.setForeground(Color.black);


	user.setBounds(200,270,200,30);
	user.setFont(f10);
	user.setForeground(Color.black);
	pr.add(user);


	u.setBounds(470,270,150,30);
	u.setFont(f11);
	u.setForeground(Color.black);

	pass.setBounds(200,320,250,30);
	pass.setFont(f10);
	pass.setForeground(Color.black);


	p.setBounds(470,320,150,30);
	p.setFont(f11);
	p.setForeground(Color.black);

	cpass.setBounds(200,370,250,30);
	cpass.setFont(f10);
	cpass.setForeground(Color.black);


	cp.setBounds(470,370,150,30);
	cp.setFont(f11);
	cp.setForeground(Color.black);




	sk.setBounds(200,420,250,30);
	sk.setFont(f10);
	sk.setForeground(Color.black);



	s.setBounds(470,420,150,30);
	s.setFont(f11);
	s.setForeground(Color.black);


	update.setBounds(320,590,205,45);
    update.setBackground(Color.white);


	can.setBounds(570,590,200,45);
	can.setBackground(Color.white);

   




    try
            {

            Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(Connection1.dbadmin,Connection1.root,Connection1.pass);
            str="admin";
			PreparedStatement ps=con.prepareStatement("select * from login_credentials where position='"+str+"'");
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
              str_name=(String)rs.getString("name");
              str_phone=(String)rs.getString("phone");
              str_user=(String)rs.getString("username");
              str_pass=(String)rs.getString("password");
              str_sk=(String)rs.getString("security");
            }

            n.setText(str_name);
            u.setText(str_user);
            em.setText(str_phone);
            s.setText(str_sk);


    }

    catch (Exception exception)
    {
        System.out.println(exception);
    }


    pr.add(update);
    pr.add(can);



    pr.add(s);
    pr.add(sk);
    pr.add(reg);

    pr.add(cp);
	pr.add(cpass);
   	pr.add(u);
    pr.add(user);
	pr.add(p);
	pr.add(pass);
    pr.add(phone);
    pr.add(em);

	pr.add(name);
	pr.add(n);












	pr.setVisible(true);
    frame.setVisible(true);

    update.addActionListener(this);
    can.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
	{
        		if(e.getSource()==update)
		{

                   String name,phone,user,pass,cpass,salary,sk;
                	name=(String)n.getText();
                    phone=(String)em.getText();
                    pass=(String)p.getText();
                    cpass=(String)cp.getText();
                    user=(String)u.getText();
                    sk=(String)s.getText();

                    if(name.equals("")||phone.equals("")||pass.equals("")||cpass.equals("")||user.equals("")||sk.equals(""))
                    {

                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");

                    }    //close of the if checking any empty field

                    else
                    {
                        if(pass.equals(cpass))
                        {
                            try
                             {
                                Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbadmin,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select UserName from login_credentials where UserName='"+user+"' ");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                                stu=(String)rs.getString("UserName");
                            }//end of while loop

                        if(user.equals(stu)&&!user.equals("admin"))
                             {
                                  JOptionPane.showMessageDialog(null,"User Name Already Exists...... TRY ANOTHER");
                                  u.setText("");
                             } //end of the if(user.equals(stu))
                        else
                              {
                        PreparedStatement st=con.prepareStatement("UPDATE `login_credentials` SET `name`=? , `phone`=?,`UserName`=?, `Password`=?, `security`=? WHERE position='"+str+"'") ;
                                  st.setString(1,name);
                                  st.setString(2,phone);
                                  st.setString(3,user);
                                  st.setString(4,pass);
                                  st.setString(5,sk);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null,name+" SuccessFully Updated");
                                    frame.setVisible(false);
                                     pr.setVisible(false);
                                      new admin_area();


                             }
                        }
                            }
                                catch(Exception exception)
                            {
                            		System.out.println(exception);
                            }
                    }
                }
                }

 if(e.getSource()==can)
		{
            frame.setVisible(false);
            pr.setVisible(false);
            new admin_area();



        }



}


public static void main(String []args)
 {
    new Edit_admin_data();

}
}