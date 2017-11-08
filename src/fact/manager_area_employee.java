package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class manager_area_employee extends JPanel implements ActionListener
{
JButton back,add,edit,delete,view;
//manager_area ma=new manager_area();
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);

manager_area_employee()
{
    setBounds(0,240,900,530);
    setLayout(null);
    setVisible(false);
	setBackground(Color.white);
        back=new JButton("Back");
        add=new JButton(new ImageIcon("img/manager_employee/add1.png"));
        delete=new JButton(new ImageIcon("img/manager_employee/delete1.png"));
        edit=new JButton(new ImageIcon("img/manager_employee/edit1.png"));
        view=new JButton(new ImageIcon("img/manager_employee/status1.png"));

        back.setBorder(null);
        back.setBackground(Color.white);

        add.setBorder(null);
        add.setBackground(Color.white);

        edit.setBorder(null);
        edit.setBackground(Color.white);

        delete.setBorder(null);
        delete.setBackground(Color.white);

        view.setBorder(null);
        view.setBackground(Color.white);

        back.setForeground(Color.BLUE);
        back.setFont(f);

        back.setBounds(0,0,100,40);
        add.setBounds(40,150,200,200);
        edit.setBounds(310,25,250,200);
        delete.setBounds(615,150,200,200);
        view.setBounds(270,230,310,220);

        add(back);
        add(add);
        add(edit);
        add(delete);
        add(view);
back.addActionListener(this);
add.addActionListener(this);
edit.addActionListener(this);
}

public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==back)
		{
            setVisible(false);
            new manager_area();


        }
        if(e.getSource()==add)
		{
        manager_area.close();
        new add_employee();

        }
            if(e.getSource()==edit)
		{
                manager_area.close();
                new edit_delete(1,"prani","login_credentials","Admins");

        }

    }
}