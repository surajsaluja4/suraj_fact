//under progress yet to be worked upon
package fact;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class add_product_group extends JFrame implements ActionListener,key
{

    JLabel prod,name,unit,type,symbol,formal,decimal,gst;
    JTextField n,s,fo;
    JButton ok,cancel,logout;
    Checkbox cb_gyes,cb_gno,cb_yes,cb_no,cb_simple,cb_compound;

	  JPanel p1;
	  CheckboxGroup cg_gst,cg_type,cg_decimal;

add_product_group()
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false);
	
		Font f9=new Font("Modern No. 20",Font.BOLD, 40);
		Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);

        setSize(900,800);

        p1=new JPanel();


		//to be checked

		p1.setSize(900,800);
		p1.setBounds(200,200,1080,580);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		add(p1);

        prod=new JLabel("Product Group Creation");
        name=new JLabel("Name of the Product:");
        gst=new JLabel("Allow GST Percentage:");
        unit=new JLabel("Unit Creation");
        type=new JLabel("Type:");
        symbol=new JLabel("Symbol to refer:");
        formal=new JLabel("Formal name:");
        decimal=new JLabel("Decimal:");

        logout=new JButton("Logout");
        ok=new JButton("Ok");
        cancel=new JButton("Cancel");

        n=new JTextField(25);
        s=new JTextField(25);
        fo=new JTextField(25);

        cg_gst=new CheckboxGroup();
       	cb_gyes=new Checkbox("Yes",cg_gst,true);
	    cb_gno=new Checkbox("No",cg_gst,false);

        cg_type=new CheckboxGroup();
       	cb_simple=new Checkbox("Simple",cg_type,true);
	    cb_compound=new Checkbox("Compound",cg_type,false);

        cg_decimal=new CheckboxGroup();
       	cb_yes=new Checkbox("Yes",cg_decimal,true);
	    cb_no=new Checkbox("No",cg_decimal,false);




        prod.setBounds(240,20,450,40);
        prod.setFont(f9);
        prod.setForeground(Color.red);
        prod.setBackground(Color.white);


    ok=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    ok.setBorder(null);
	cancel=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    cancel.setBorder(null);



        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.RED);
        logout.setFont(f);
        logout.setBorder(null);


    name.setBounds(100,120,350,30);
	name.setFont(f);
	name.setForeground(Color.black);


	n.setBounds(450,120,150,30);
	n.setFont(f);
	n.setForeground(Color.black);
	p1.add(n);

    n.addKeyListener(varchar);

	gst.setBounds(100,170,350,30);
	gst.setFont(f);
	gst.setForeground(Color.black);

	cb_gyes.setBounds(450,160,100,50);
	cb_gyes.setFont(f);
	cb_gyes.setForeground(Color.black);

    cb_gno.setBounds(560,160,90,50);
	cb_gno.setFont(f);
	cb_gno.setForeground(Color.black);

	unit.setBounds(300,270,450,30);
	unit.setFont(f9);
	unit.setForeground(Color.red);
	p1.add(unit);



	type.setBounds(160,370,250,30);
	type.setFont(f);
	type.setForeground(Color.black);


	cb_simple.setBounds(410,370,130,40);
	cb_simple.setFont(f);
	cb_simple.setForeground(Color.black);

	cb_compound.setBounds(560,370,180,30);
	cb_compound.setFont(f);
	cb_compound.setForeground(Color.black);

	symbol.setBounds(160,420,250,30);
	symbol.setFont(f);
	symbol.setForeground(Color.black);


	s.setBounds(410,420,150,30);
	s.setFont(f);
	s.setForeground(Color.black);
    s.addKeyListener(varchar);

	formal.setBounds(160,470,250,30);
	formal.setFont(f);
	formal.setForeground(Color.black);


	fo.setBounds(410,470,150,30);
	fo.setFont(f);
	fo.setForeground(Color.black);
    fo.addKeyListener(varchar);

	decimal.setBounds(160,520,250,30);
	decimal.setFont(f);
	decimal.setForeground(Color.black);



	cb_yes.setBounds(410,520,100,30);
	cb_yes.setFont(f);
	cb_yes.setForeground(Color.black);


	cb_no.setBounds(520,520,100,30);
	cb_no.setFont(f);
	cb_no.setForeground(Color.black);

	ok.setBounds(210,590,205,45);


	cancel.setBounds(450,590,200,45);

    ok.addActionListener(this);
    cancel.addActionListener(this);

    p1.add(prod);
    p1.add(name);
    p1.add(unit);
    p1.add(type);
    p1.add(symbol);
    p1.add(formal);
    p1.add(decimal);
    p1.add(gst);
    p1.add(n);
    p1.add(s);
    p1.add(fo);
    p1.add(ok);
    p1.add(cancel);
    p1.add(logout);
    p1.add(cb_yes);
    p1.add(cb_no);
    p1.add(cb_gyes);
    p1.add(cb_gno);
    p1.add(cb_simple);
    p1.add(cb_compound);


    setVisible(true);

}  //end of constructor


public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==ok)
		{
                System.out.println("1");

                   String nop,gs="no",symb,form,deci="no",stu="";
                	nop=(String)n.getText();
                    symb=(String)s.getText();
                    form=(String)fo.getText();
                    {     if(cb_gyes.getState())
                    {
                            gs="yes";
                    }
                     if(cb_yes.getState())
                    {
                            deci="yes";
                    }}

                    if(nop.equals("")||symb.equals("")||form.equals(""))
                    {
                          JOptionPane.showMessageDialog(null,"Please Fill In All Details");

                    }    //close of the if checking any empty field

                    else
                    {
                        
                             try
                             {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                        PreparedStatement ps=con.prepareStatement("select name from product_group where name='"+nop+"' ");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                            {
                            stu=(String)rs.getString("name");
                            }//end of while loop

                        if(nop.equals(stu))
                             {
                                  JOptionPane.showMessageDialog(null,"Product Group Already Exists");
                                  n.setText("");

                             } //end of the if(user.equals(stu))
                        else
                              {
                            
                                  PreparedStatement st=con.prepareStatement("INSERT INTO `product_group`(`name`, `gst`,`symbol`, `formal_name`, `deci`) VALUES (?,?,?,?,?)");
                                  st.setString(1,nop);
                                  st.setString(2,gs);
                                  st.setString(3,symb);
                                  st.setString(4,form);
                                  st.setString(5,deci);
                                  st.executeUpdate();
                              //      JOptionPane.showMessageDialog(null,nop+" SuccessFully Added");
                                    JFrame f=new JFrame();
 int a=JOptionPane.showConfirmDialog(f,nop+" SuccessFully Added \n"+"Want to enter more Product?");
if(a==JOptionPane.YES_OPTION)
{
    n.setText("");
    s.setText("");
    fo.setText("");

}
else if(a==JOptionPane.NO_OPTION)
{
            setVisible(false);
            p1.setVisible(false);
            new manager_area().st_true(1);

}


                        }//end of else of if(user.equals(stu))
                            }// end of if(con!=null)


                             }//end of the try block
                             catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block


                    } //close of the else for the if (any empty field)

        }    //close of the if that checks for the button pressed is regis


        if(e.getSource()==cancel)
		{
            setVisible(false);
            p1.setVisible(false);
            new manager_area().st_true(2);



        }//close of the if that checks for the button pressed is cancel


}  //close of the action performed function


public static void main(String []args)
 {
    new add_product_group();

}


}   	//end of class