package fact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public  class add_product extends JPanel implements ActionListener
{
JButton pgc,pic,edit,back;
// manager_area_products map;

Font f=new Font("Baskerville Old Face",Font.CENTER_BASELINE, 30);
add_product()
{
        setBounds(0,240,900,530);
        setLayout(null);
        setVisible(false);
	    setBackground(Color.WHITE);
        back=new JButton("Back");
        pgc=new JButton("Product Group Creation");
        pic=new JButton("Product Item Creation");
       edit=new JButton("Make Changes");
//        map=new manager_area_products();

        pgc.setBorder(null);
        pgc.setBackground(Color.white);
        pgc.setForeground(Color.blue);
        pgc.setFont(f);

        pic.setBorder(null);
        pic.setBackground(Color.white);
        pic.setForeground(Color.blue);
        pic.setFont(f);


        edit.setBorder(null);
        edit.setBackground(Color.white);
        edit.setForeground(Color.blue);
        edit.setFont(f);

        back.setBackground(Color.WHITE);
        back.setForeground(Color.RED);
        back.setFont(f);
        back.setBorder(null);

        back.setBounds(0,40,140,40);



        pgc.setBounds(230,105,400,55);
        pic.setBounds(230,160,400,55);
        edit.setBounds(230, 215, 400, 55);

        add(back);
        add(pic);
        add(pgc);
        add(edit);
        back.addActionListener(this);
        pic.addActionListener(this);
        pgc.addActionListener(this);
        edit.addActionListener(this);
        setVisible(false);


}

public void actionPerformed(ActionEvent e)
	{

		if(e.getSource()==pic)
		{
         
            manager_area.close();
            new add_product_item();
        }

		if(e.getSource()==pgc)
		{
            manager_area.close();
            new add_product_group();
        }
if(e.getSource()==back)
		{
         setVisible(false);
         new manager_area().st_true(1);

        }
}

}
