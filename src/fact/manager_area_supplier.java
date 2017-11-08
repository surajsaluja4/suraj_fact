package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class manager_area_supplier extends JPanel implements ActionListener
{
JButton back,add,edit,delete,view;
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
 manager_area ma;
manager_area_supplier()
{

        System.out.println("manager area supplier called");
    setBounds(0,240,900,530);
    setLayout(null);
    setVisible(false);
	setBackground(Color.white);
        back=new JButton("Back");
        add=new JButton(new ImageIcon("img/manager_supplier/add.jpg"));
        edit=new JButton(new ImageIcon("img/manager_supplier/edit.png"));
        delete=new JButton(new ImageIcon("img/manager_supplier/delete.jpg"));
        view=new JButton(new ImageIcon("img/manager_supplier/view.png"));

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
        add.setBounds(40,130,200,200);
        edit.setBounds(315,25,200,200);
        delete.setBounds(605,120,200,200);
        view.setBounds(270,230,310,220);

        add(back);
        add(add);
        add(edit);
        add(delete);
        add(view);
back.addActionListener(this);
add.addActionListener(this);
edit.addActionListener(this);
delete.addActionListener(this);
view.addActionListener(this);

}

public void actionPerformed(ActionEvent e)
	{
		// Side Buttons Main Window
		if(e.getSource()==back)
		{

            setVisible(false);
            ma=new manager_area();
           // ma.st_true(5);

       

        }
        	if(e.getSource()==add)
		{

                 manager_area.close();
                 new add_supplier();
        }
           	if(e.getSource()==edit)
		{

                 manager_area.close();
                 new edit_supplier(1);
        }
           	if(e.getSource()==delete)
		{

                 manager_area.close();
                 new edit_supplier(2);
        }
           	if(e.getSource()==view)
		{

                 manager_area.close();
                 new view_supplier();
        }
    }
}