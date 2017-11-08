package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class admin_area_admincp extends JPanel implements ActionListener
{
JButton edit,error,other,back,logout;
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
admin_area_admincp()
{
    setBounds(0,270,900,530);
    setLayout(null);
    setVisible(false);
	setBackground(Color.WHITE);
        back=new JButton("Back");
        edit=new JButton("Edit Admin's Data");
        error=new JButton("Monitor Error");
        other=new JButton("For Internal uses");
        logout=new JButton("LogOut");
        
        error.setBorder(null);
        error.setBackground(Color.white);
        error.setForeground(Color.blue);
        error.setFont(f);

        edit.setBorder(null);
        edit.setBackground(Color.white);
        edit.setForeground(Color.blue);
        edit.setFont(f);

        other.setBorder(null);
        other.setBackground(Color.white);
        other.setForeground(Color.blue);
        other.setFont(f);

        back.setBackground(Color.WHITE);
        back.setForeground(Color.RED);
        back.setFont(f);
        back.setBorder(null);

        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.RED);
        logout.setFont(f);
        logout.setBorder(null);

        back.setBounds(0,40,140,40);
        logout.setBounds(730,40,140,40);


        edit.setBounds(310,105,260,55);
        error.setBounds(280,160,310,55);
        other.setBounds(310,215,260,55);

        add(back);
        add(edit);
        add(error);
        add(other);
        add(logout);

        back.addActionListener(this);
        logout.addActionListener(this);
        edit.addActionListener(this);




}

public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==edit)
		{
            setVisible(false);
            admin_area.close();
            new Edit_admin_data();


        }
         if(e.getSource()==logout)
		{

        setVisible(false);
        admin_area.close();
        new Main();
        }
        if(e.getSource()==back)
		{
            setVisible(false);
            new admin_area();


        }
}

}
