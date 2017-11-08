package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class manager_area_transaction_area extends JPanel implements ActionListener
{
JButton daily,monthly,yearly,current,back;
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
manager_area_transaction_area()
{
        setBounds(0,240,900,530);
        setLayout(null);
        setVisible(false);
	    setBackground(Color.WHITE);
        back=new JButton("Back");
        daily=new JButton("Daily Selling Data");
        monthly=new JButton("Monthly Selling Data");
        yearly=new JButton("Yearly Selling Data");
        current=new JButton("Current Financial Status");
        
        monthly.setBorder(null);
        monthly.setBackground(Color.white);
        monthly.setForeground(Color.blue);
        monthly.setFont(f);

        daily.setBorder(null);
        daily.setBackground(Color.white);
        daily.setForeground(Color.blue);
        daily.setFont(f);

        yearly.setBorder(null);
        yearly.setBackground(Color.white);
        yearly.setForeground(Color.blue);
        yearly.setFont(f);

        current.setBorder(null);
        current.setBackground(Color.white);
        current.setForeground(Color.blue);
        current.setFont(f);

        back.setBackground(Color.WHITE);
        back.setForeground(Color.RED);
        back.setFont(f);
        back.setBorder(null);

        back.setBounds(0,40,140,40);

        

        daily.setBounds(300,105,260,55);
        monthly.setBounds(280,160,310,55);
        yearly.setBounds(285,215,310,55);
        current.setBounds(280,270,340,55);

        add(back);
        add(daily);
        add(monthly);
        add(yearly);
        add(current);
        
        back.addActionListener(this);
        daily.addActionListener(this);




}

public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==daily)
		{
            

        }
if(e.getSource()==back)
		{
            setVisible(false);
            new manager_area();


        }
}

}
