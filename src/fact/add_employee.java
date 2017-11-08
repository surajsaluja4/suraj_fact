//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.Border;

class add_employee extends JFrame implements ActionListener,key
{

	  JLabel reg,name,address,phone,gender,user,pass,cpass,salary,addr_l,mno;
	  JTextField n,s,u,sa,em,c,mn;
      JTextArea addr_t;
      JPasswordField p,cp;
	  Checkbox male,female;
int emp_id;
	  JPanel pr;
	  CheckboxGroup genders;
   	  JButton regis,can;
      String stu;

add_employee()
{

		Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		Font f10=new Font("Lucida Handwriting",Font.BOLD, 20);
		Font f11=new Font("Baaddr_lerville Old Face",Font.BOLD, 20);
		Font f12=new Font("Baaddr_lerville Old Face",Font.BOLD, 17);
		Font f13=new Font("Imprint MT Shadow",Font.PLAIN, 30);
		Font f14=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
		Font f15=new Font("Lucida Calligraphy",Font.BOLD,17	);
		Font f16=new Font("Lucida Handwriting",Font.BOLD,50);
		Font f17=new Font("Aerial",Font.PLAIN,25);
		setSize(1080,760);

        pr=new JPanel();
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//to be checked

		pr.setSize(1080,580);
		pr.setBounds(200,200,1080,580);
		pr.setLayout(null);
		pr.setBackground(Color.white);
		add(pr);

	reg=new JLabel("Registration Portal For Employee");
	name=new JLabel("Name");
	phone=new JLabel("Phone");
	user=new JLabel("UserName");
	pass=new JLabel("Password");
	cpass=new JLabel("Confirm Password");
    salary=new JLabel("Salary");
    addr_l =new JLabel("Address");
    mno=new JLabel("Machine Number");

	n=new JTextField(25);            //text field for name
    n.addKeyListener(varchar);
	em=new JTextField(25);           //text field for phone
    mn=new JTextField();
	u=new JTextField(25);    //text field for user name
	p=new JPasswordField(25);         //text field for password
	cp=new JPasswordField(25);                               //text field for cnfrm password
    sa=new JTextField(25);                          //text field for salary
    sa.addKeyListener(num);
    mn.addKeyListener(num);
	addr_t=new JTextArea(25,25);                            //text field for securtiy key
         Border border = BorderFactory.createLineBorder(Color.GRAY);
    addr_t.setBorder(BorderFactory.createCompoundBorder(border,
    BorderFactory.createEmptyBorder(10, 10, 10, 10)));




	regis=new JButton(new ImageIcon("img/admin_area_manager_addnew/register.png"));
    regis.setBorder(null);
	can=new JButton(new ImageIcon("img/admin_area_manager_addnew/cancel.png"));
    can.setBorder(null);

	reg.setBounds(300,20,650,100);
	reg.setFont(f9);
	reg.setForeground(Color.red);

	name.setBounds(200,120,100,30);
	name.setFont(f10);
	name.setForeground(Color.black);


	n.setBounds(470,120,150,30);
	n.setFont(f11);
	n.setForeground(Color.black);
	pr.add(n);



	phone.setBounds(200,170,250,30);
	phone.setFont(f10);
	phone.setForeground(Color.black);

    mno.setBounds(200, 220, 300, 30);
    mno.setForeground(Color.BLACK);
    mno.setFont(f10);

    mn.setBounds(470, 220, 150, 30);
    mn.setFont(f10);
    mn.setForeground(Color.black);

	em.setBounds(470,170,150,30);
	em.setFont(f11);
	em.setForeground(Color.black);
    em.addKeyListener(num);



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


	salary.setBounds(200,420,250,30);
	salary.setFont(f10);
	salary.setForeground(Color.black);


	sa.setBounds(470,420,150,30);
	sa.setFont(f11);
	sa.setForeground(Color.black);

	addr_l.setBounds(200,470,250,30);
	addr_l.setFont(f10);
	addr_l.setForeground(Color.black);



	addr_t.setBounds(470,470,150,80);
	addr_t.setFont(f11);
	addr_t.setForeground(Color.black);


	regis.setBounds(320,590,205,45);
    regis.setBackground(Color.white);


	can.setBounds(570,590,200,45);
	can.setBackground(Color.white);

    regis.addActionListener(this);
    can.addActionListener(this);

    pr.add(reg);
    pr.add(addr_t);
    pr.add(regis);
    pr.add(can);
    pr.add(sa);
    pr.add(addr_l);
    pr.add(salary);
    pr.add(cp);
	pr.add(cpass);
   	pr.add(u);
	pr.add(p);
	pr.add(pass);
    pr.add(phone);
    pr.add(em);
    pr.add(mn);
    pr.add(mno);
	pr.add(name);
	pr.add(n);

	pr.setVisible(true);
    setVisible(true);


}  //end of constructor


public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==regis)
		{

                   String name,phone,user,pass,cpass,salary,addr_l,mns;
                	name=(String)n.getText();
                    phone=(String)em.getText();
                    pass=(String)p.getText();
                    cpass=(String)cp.getText();
                    user=(String)u.getText();
                    salary=(String)sa.getText();
                   addr_l=(String)addr_t.getText();
                   mns=(String)mn.getText();

                    if(name.equals("")||phone.equals("")||pass.equals("")||cpass.equals("")||user.equals("")||salary.equals("")||addr_l.equals(""))
                    {

                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");

                    }    //close of the if checking any empty field

                    else
                    {
                        if(pass.equals(cpass))
                        {
                             if(Integer.parseInt(salary) <= 2500)
                                {

                          JOptionPane.showMessageDialog(null,"Salary Cannot Be less Than  Rs.2500");
                          sa.setText("");
                                }   //close of the if checking for the salary
                              else
                             {
                             try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbadmin, Connection1.root, Connection1.pass);
                        Connection con1=DriverManager.getConnection(Connection1.dbemployee, Connection1.root, Connection1.pass);

                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select UserName from login_credentials where UserName='"+user+"' ");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                                stu=(String)rs.getString("UserName");
                            }//end of while loop

                        if(user.equals(stu))
                             {
                                  JOptionPane.showMessageDialog(null,"User Name Already Exists...... TRY ANOTHER");
                                  u.setText("");
                             } //end of the if(user.equals(stu))
                        else
                              {

                                  PreparedStatement st=con.prepareStatement("INSERT INTO `login_credentials`(`name`, `phone`,`UserName`, `Password`,`salary`,`status`,`position`,`address`,`machine`) VALUES (?,?,?,?,?,?,?,?,?)");
                                  st.setString(1,name);
                                  st.setString(2,phone);
                                  st.setString(3,user);
                                  st.setString(4,pass);
                                  st.setString(5,salary);
                                  st.setString(6,"Active");
                                  st.setString(7,"Employee");
                                  st.setString(8,addr_l);
                                  st.setString(9, mns);
                                  st.executeUpdate();
                                  
                                  PreparedStatement st1=con.prepareStatement("Select * from `login_credentials`");
                                  rs=st1.executeQuery();
                                  while(rs.next()){
                                       emp_id=rs.getInt(1);
                                  }
                                  System.out.println(emp_id);
                                  st=con1.prepareStatement("INSERT INTO `"+Calendar.getInstance().get(Calendar.YEAR)+"`(`id`) VALUES (?)");
                                  st.setInt(1, emp_id);
                                  st.executeUpdate();
                                  System.out.println(st);
                                  JOptionPane.showMessageDialog(null,"Employee Succesfully registerd");



                        }//end of else of if(user.equals(stu))

                            }// end of if(con!=null)




                             }//end of the try block
                             catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

                              }// end of else block o the if(salary<2500)
                         }//close of the if checking for pass=cpass
                    } //close of the else for the if (any empty field)
        }    //close of the if that checks for the button pressed is regis


        if(e.getSource()==can)
		{
            setVisible(false);
            pr.setVisible(false);
            new manager_area().st_true(3);



        }//close of the if that checks for the button pressed is can


}  //close of the action performed function


public static void main(String []args)
 {
    new add_employee();

}


}   	//end of class