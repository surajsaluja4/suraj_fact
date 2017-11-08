package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class admin_area_managercp extends JPanel implements ActionListener
{
JButton back,add,edit,delete,view,logout;
//admin_area_manager_addnew aa=new admin_area_manager_addnew();
//admin_area aa=new admin_area();
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);


admin_area_managercp()
{
    
    setBounds(0,270,900,530);
    setLayout(null);
    setVisible(false);
	setBackground(Color.WHITE);
        back=new JButton("Back");
        add=new JButton("Add New Manager");
        delete=new JButton("Delete a Manager");
        edit=new JButton("Edit Manager's details");
        view=new JButton("View Managers details");
        logout=new JButton("LogOut");


        
        add.setBorder(null);
        add.setBackground(Color.white);
        add.setForeground(Color.blue);
        add.setFont(f);

        edit.setBorder(null);
        edit.setBackground(Color.white);
        edit.setForeground(Color.blue);
        edit.setFont(f);

        delete.setBorder(null);
        delete.setBackground(Color.white);
        delete.setForeground(Color.blue);
        delete.setFont(f);

        view.setBorder(null);
        view.setBackground(Color.white);
        view.setForeground(Color.blue);
        view.setFont(f);

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

        add.setBounds(310,105,260,55);
        edit.setBounds(310,160,310,55);
        delete.setBounds(310,215,260,55);
        view.setBounds(310,270,310,55);
        add(back);
        add(add);
        add(edit);
        add(delete);
        add(view);
        add(logout);
back.addActionListener(this);
logout.addActionListener(this);
add.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==back)
		{
            setVisible(false);
            new admin_area();


        }
         if(e.getSource()==logout)
		{

        setVisible(false);
       // frame.setVisible(false);
        admin_area.close();
        new Main();
        }
        if(e.getSource()==add)
        {
           //aa.close();
            //setVisible(false);
admin_area.close();
            new admin_area_manager_addnew();
        }
    }
}