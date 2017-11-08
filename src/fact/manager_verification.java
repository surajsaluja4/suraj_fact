package fact;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

 class manager_verification extends JPanel implements ActionListener,key

 {

    JLabel a,b,c,d,e,f,g,rand;
	JTextField tx;
	JButton lo,ca;
    int rand_num,fin,result;
    Random r=new Random();
    Font f1=new Font("Copperplate Gothic Bold",Font.BOLD, 17);
	Font f2=new Font("Lucida Calligraphy",Font.BOLD,32	);
    static int sk;
public manager_verification()
{
        setBounds(0,0,900,900);
		setLayout(null);
        setVisible(false);
		setBackground(Color.white);
        a=new JLabel("You Have logged in With the Manger's Credentials");
        b=new JLabel("Please complete the verification Step....");
        c=new JLabel("Your One Time Key is: ");
        rand_num=r.nextInt(100);                                                 //range may be edited later
        rand=new JLabel(Integer.toString(rand_num));
        d=new JLabel("Enter Your Result:");
        e=new JLabel(new ImageIcon("img/verification/access.png"));

        tx=new JTextField(25);
        tx.addKeyListener(num);
        lo=new JButton(new ImageIcon("img/verification/login.png"));
        ca=new JButton(new ImageIcon("img/verification/cancel.png"));
        lo.setBorder(null);
        lo.setBackground(Color.white);
        ca.setBorder(null);
        ca.setBackground(Color.white);

        a.setFont(f1);
        b.setFont(f2);
        c.setFont(f1);
        d.setFont(f1);
        rand.setFont(f1);
        tx.setFont(f1);





        e.setBounds(0,0,200,200);
        a.setBounds(200,90,600,20);

        b.setBounds(5,220,800,40);
        c.setBounds(200,360,300,20);
        d.setBounds(200,420,300,20);
        rand.setBounds(440,360,100,20);
        tx.setBounds(440,420,100,20);
        lo.setBounds(160,460,200,200);
        ca.setBounds(360,460,200,200);






















        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(rand);
        add(tx);
        add(lo);
        add(ca);








       













    lo.addActionListener(this);
    ca.addActionListener(this);

}
public  void abc(int d)
{
   sk=d;

}


public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==lo)
		{
           result=Integer.parseInt(tx.getText());
             fin=rand_num*sk;
           if(fin==result)
           {
               setVisible(false);
               Main m=new Main();
               m.close();
             //  setVisible(false);
               new manager_area();
           }
           else
           {
            JOptionPane.showMessageDialog(null,"Result did not match");
            setVisible(false);
            new Main();
           }
        }
       else
        {
            setVisible(false);
            new Main();
        }
}


 }