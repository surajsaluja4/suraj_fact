import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class register_staff extends JFrame implements ActionListener
{

	  JLabel reg,name,city,state,gender,user,pass,cpass,salary,post;
	  JTextField n,c,s,u,p,cp,sa,po;
	  Checkbox male,female;
      JComboBox statec;
	  JPanel pr;
	  CheckboxGroup genders;
   	  JButton regis,can;
      String stu;

register_staff()
{

		Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		Font f10=new Font("Lucida Handwriting",Font.BOLD, 20);
		Font f11=new Font("Baskerville Old Face",Font.BOLD, 20);
		Font f12=new Font("Baskerville Old Face",Font.BOLD, 17);
		Font f13=new Font("Imprint MT Shadow",Font.PLAIN, 30);
		Font f14=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
		Font f15=new Font("Lucida Calligraphy",Font.BOLD,17	);
		Font f16=new Font("Lucida Handwriting",Font.BOLD,50);
		Font f17=new Font("Aerial",Font.PLAIN,25);
		setVisible(true);
		pr=new JPanel();

		pr.setVisible(true);

		//to be checked
setSize(1080,700);
		pr.setSize(1080,580);
		pr.setBounds(200,200,1080,580);
		pr.setLayout(null);
		pr.setBackground(Color.white);
		add(pr);

	reg=new JLabel("Registration Portal For Staff");
	name=new JLabel("Name");
	city=new JLabel("City");
	state=new JLabel("State");
	gender=new JLabel("Gender");
	user=new JLabel("UserName");
	pass=new JLabel("Password");
	cpass=new JLabel("Confirm Password");
    salary=new JLabel("Salary");
    post =new JLabel("Post");


	n=new JTextField(25);
	c=new JTextField(25);
	s=new JTextField(25);
	u=new JTextField(25);
	p=new JTextField(25);
	cp=new JTextField(25);
    sa=new JTextField(25);
	po=new JTextField(25);

	genders=new CheckboxGroup();
	male=new Checkbox("Male",genders,true);
	female=new Checkbox("Female",genders,false);

	statec=new JComboBox();
	statec.addItem("Haryana");
	statec.addItem("Delhi");

	regis=new JButton("Register");
	can=new JButton("Cancel");

	reg.setBounds(300,20,600,100);
	reg.setFont(f9);
	reg.setForeground(Color.red);
	pr.add(reg);

	name.setBounds(200,120,100,30);
	name.setFont(f10);
	name.setForeground(Color.black);
	pr.add(name);


	n.setBounds(470,120,150,30);
	n.setFont(f11);
	n.setForeground(Color.black);
	pr.add(n);

	city.setBounds(200,170,250,30);
	city.setFont(f10);
	city.setForeground(Color.black);
	pr.add(city);


	c.setBounds(470,170,150,30);
	c.setFont(f11);
	c.setForeground(Color.black);
	pr.add(c);

	gender.setBounds(200,220,250,30);
	gender.setFont(f10);
	gender.setForeground(Color.black);
	pr.add(gender);

	male.setBounds(470,220,150,30);
	male.setFont(f11);
	male.setForeground(Color.black);
	pr.add(male);

	female.setBounds(620,220,150,30);
	female.setFont(f11);
	female.setForeground(Color.black);
	pr.add(female);

	state.setBounds(200,270,250,30);
	state.setFont(f10);
	state.setForeground(Color.black);
	pr.add(state);

	statec.setBounds(470,270,150,30);
	statec.setFont(f11);
	statec.setForeground(Color.black);
	pr.add(statec);

	user.setBounds(200,320,200,30);
	user.setFont(f10);
	user.setForeground(Color.black);
	pr.add(user);


	u.setBounds(470,320,150,30);
	u.setFont(f11);
	u.setForeground(Color.black);
	pr.add(u);

	pass.setBounds(200,370,250,30);
	pass.setFont(f10);
	pass.setForeground(Color.black);
	pr.add(pass);


	p.setBounds(470,370,150,30);
	p.setFont(f11);
	p.setForeground(Color.black);
	pr.add(p);

	cpass.setBounds(200,420,250,30);
	cpass.setFont(f10);
	cpass.setForeground(Color.black);
	pr.add(cpass);


	cp.setBounds(470,420,150,30);
	cp.setFont(f11);
	cp.setForeground(Color.black);
	pr.add(cp);


	salary.setBounds(200,470,250,30);
	salary.setFont(f10);
	salary.setForeground(Color.black);
	pr.add(salary);


	sa.setBounds(470,470,150,30);
	sa.setFont(f11);
	sa.setForeground(Color.black);
	pr.add(sa);

	post.setBounds(200,520,250,30);
	post.setFont(f10);
	post.setForeground(Color.black);
	pr.add(post);


	po.setBounds(470,520,150,30);
	po.setFont(f11);
	po.setForeground(Color.black);
	pr.add(po);

	regis.setBounds(320,590,110,55);
	pr.add(regis);

	can.setBounds(470,590,100,50);
	pr.add(can);

    regis.addActionListener(this);

    can.addActionListener(this);

}  //end of constructor



public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource()==regis)
		{
           String name,city,user,pass,cpass,gender="Male",state,salary,post,pss;
                	name=(String)n.getText();
                    city=(String)c.getText();
                    pass=(String)p.getText();
                    cpass=(String)cp.getText();
                    user=(String)u.getText();
                    salary=(String)sa.getText();
                    post=(String)po.getText();
                    if(male.getState())
                    {
                            gender="Male";

                    }
                    if(female.getState())
                    {
                            gender="Female";

                    }
                    state=(String)statec.getSelectedItem();

                    if(name.equals("")||city.equals("")||pass.equals("")||cpass.equals("")||user.equals("")||salary.equals("")||post.equals(""))
                    {

                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");

                    }
                    else
                    {
                        if(pass.equals(cpass))
                    {
			try
	{
                Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bbmgroups","root","");

	if(con!=null)
	{
                        PreparedStatement ps=con.prepareStatement("select UserName from registrationstaff where UserName='"+user+"' ");
                        ResultSet rs=ps.executeQuery();
                     
                        
			while(rs.next())
	       {

            stu=(String)rs.getString("UserName");
             

		//	pss=(String)rs.getString("Password");
            }
            
		
        

           if(user.equals(stu))
           {
               JOptionPane.showMessageDialog(null,"User Name Already Exists...... TRY ANOTHER");
           }
           else
           {


      PreparedStatement st=con.prepareStatement("INSERT INTO `registrationstaff`(`Name`, `City`, `Gender`, `State`, `UserName`, `Password`, `Salary`,`Post`) VALUES (?,?,?,?,?,?,?,?)");
      st.setString(1,name);
      st.setString(2,city);
      st.setString(3,gender);
      st.setString(4,state);
      st.setString(5,user);
      st.setString(6,pass);
      st.setString(7,salary);
      st.setString(8,post);


	   st.executeUpdate();

        JOptionPane.showMessageDialog(null,name+" SuccessFully Registed");

            setVisible(false);
        new bbm1();
           }
            }   //END OF IF(CON!=NULL)


	}    //end of try block
	catch(Exception exception)
	{

		System.out.println(exception);
	}    //end of catch block

            }  //end of if(pass==cpass)
                       else
                       {
                        JOptionPane.showMessageDialog(null,name+" PASSWORDS DID NOT MATCH");
                       }  //end of else
                    }//end of else(if all the fields are filled)
        }    //end of if(e==register)


		if(e.getSource()==can)
		{

            setVisible(false);
        new bbm1();
        }

}          //end of function action performed


public static void main(String []args)
 {
    new register_staff();

}


}   	//end of class