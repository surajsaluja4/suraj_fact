/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author suraj
 */
public class JDatep {

    UtilDateModel model = new UtilDateModel();
JDatePanelImpl datePanel = new JDatePanelImpl(model);
JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
JFrame frame;
JPanel panel1;
JComboBox b;
    public JDatep() {
        frame=new JFrame();
        frame.setSize(500, 500);
        panel1=new JPanel();
        frame.add(panel1);
        panel1.setBackground(Color.white);
        panel1.add(datePicker);
        frame.setVisible(true);
        System.out.println(datePicker);
        b=new JComboBox();
        panel1.add(b);
        b.getParent();
        System.out.println(b.getComponents().getClass().toString());
      //  System.out.println(model.getMonth());


    }
    public static void main(String[] args) {
        new JDatep();

    }



}
