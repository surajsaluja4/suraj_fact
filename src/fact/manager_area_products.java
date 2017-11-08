package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class manager_area_products extends JPanel implements ActionListener
{
JButton back,add,stock,delete,view;
//manager_area ma=new manager_area();
Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
//add_product ap;

manager_area_products()
{
    setBounds(0,240,900,530);
    setLayout(null);
    setVisible(false);
	setBackground(Color.white);
        back=new JButton("Back");
        add=new JButton(new ImageIcon("img/manager_product/new.jpg"));
        delete=new JButton(new ImageIcon("img/manager_product/delete.png"));
        stock=new JButton(new ImageIcon("img/manager_product/stock.png"));
        view=new JButton(new ImageIcon("img/manager_product/avail.jpg"));
//        ap=new add_product();

        back.setBorder(null);
        back.setBackground(Color.white);
      
        add.setBorder(null);
        add.setBackground(Color.white);

        stock.setBorder(null);
        stock.setBackground(Color.white);

        delete.setBorder(null);
        delete.setBackground(Color.white);

        view.setBorder(null);
        view.setBackground(Color.white);

        back.setForeground(Color.BLUE);
        back.setFont(f);

        back.setBounds(0,0,100,40);
        add.setBounds(40,150,200,200);
        stock.setBounds(310,25,200,200);
        delete.setBounds(615,125,200,200);
        view.setBounds(270,230,310,220);

        add(back);
        add(add);
        add(stock);
        add(delete);
        add(view);
back.addActionListener(this);
add.addActionListener(this);
stock.addActionListener(this);

setVisible(false);
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
         new manager_area().st_true(2);
            
            setVisible(false);
            

        }
    if(e.getSource()==stock)
		{
         manager_area.close();

            setVisible(false);
            new stock_entry();


        }


}
}