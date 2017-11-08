/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
/**
 *
 * @author suraj
 */
public class CreateSummary implements ActionListener,FocusListener,ItemListener{
JFrame frame;
JPanel panel;
JLabel type,gstno,name,value,gsttax,percentage,total,bill,date;
JTextField gstnot,valuet,gsttaxt,totalt,billt;
JComboBox typec,gstpercentagec,namec;
UtilDateModel model = new UtilDateModel();
JDatePanelImpl datePanel = new JDatePanelImpl(model);
JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
Vector typev=new Vector();
Vector gstv=new Vector();
Vector invoicetype=new Vector();
JButton submit;
JCheckBox ecom;
Connection con;
int found=0;
public CreateSummary() {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        panel=new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        date=new JLabel("Date");
        type=new JLabel("type");
        gstno=new JLabel("GST Number");
        bill=new JLabel("Bill Number");
        name=new JLabel("Firm Name");
        percentage=new JLabel("GST Percentage");
        value=new JLabel("Bill Value");
        gsttax=new JLabel("Gst Tax");
        total=new JLabel("Total Value");


        typev.add("Sale");
        typev.add("Purchase");

        gstv.add(0.00);
        gstv.add(0.25);
        gstv.add(3.00);
        gstv.add(5.00);
        gstv.add(12.00);
        gstv.add(18.00);
        gstv.add(28.00);

        invoicetype.add("Regular");
        invoicetype.add("Sez Supplies with Payment");
        invoicetype.add("Sez Supplies without Payment");
        invoicetype.add("Deemed Export");

        typec=new JComboBox(typev);
        namec=new JComboBox();
         search sbm=new search(namec,Connection1.dbmanager, "GST", "Name", "Gst");
         namec.setEditable(true);
         namec.addItemListener(sbm);
namec.addMouseListener(sbm);
namec.addFocusListener(sbm);
namec.getEditor().setItem("Products");
namec.getEditor().getEditorComponent().setForeground(Color.gray);
         namec.setModel(sbm);
        billt=new JTextField();
        gstnot=new JTextField();
        valuet=new JTextField();
        gstpercentagec=new JComboBox(gstv);
        gsttaxt=new JTextField();
        totalt=new JTextField();
        panel.add(date);
        date.setBounds(50, 50, 150, 50);
        datePicker.setBounds(300, 50, 200, 50);
        datePicker.setBackground(Color.white);
        panel.add(datePicker);



        name.setBounds(50, 100, 100, 50);
        panel.add(name);

        namec.setBounds(300, 100, 200, 40);
        panel.add(namec);

        gstno.setBounds(50, 150, 100, 40);
        panel.add(gstno);

        gstnot.setBounds(300, 150, 200, 40);
        gstnot.setEnabled(false);
        gstnot.setForeground(Color.BLACK);
        panel.add(gstnot);

        bill.setBounds(50, 200, 100, 40);
        panel.add(bill);

        billt.setBounds(300, 200, 200, 40);
        panel.add(billt);

        value.setBounds(50, 250, 100, 40);
        panel.add(value);

        valuet.setBounds(300, 250, 200, 40);
         panel.add(valuet);
        
         percentage.setBounds(50, 300, 100, 40);
         panel.add(percentage);

         gstpercentagec.setBounds(300, 300, 200, 40);
        panel.add(gstpercentagec);

        gsttax.setBounds(50, 350, 100, 40);
        panel.add(gsttax);


        gsttaxt.setBounds(300, 350, 200, 40);
        panel.add(gsttaxt);

        total.setBounds(50, 400, 100, 40);
        panel.add(total);

        totalt.setBounds(300, 400, 200, 40);
        panel.add(totalt);

        type.setBounds(50, 450, 100, 50);
panel.add(type);
        typec.setBounds(300, 450, 200, 40);
        panel.add(typec);


        frame.add(panel);
        frame.setVisible(true);

        submit=new JButton("submit");
        submit.setBounds(200, 500, 100, 50);
        panel.add(submit);
        submit.addActionListener(this);
        namec.getEditor().getEditorComponent().addFocusListener(this);
       gstpercentagec.addItemListener(this);
}
    public static void main(String[] args) {
        new CreateSummary();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            //System.out.println("Hello In Submit");
            String a=namec.getSelectedItem().toString();
            //System.out.println("aga  "+a);
            if(gstnot.isEnabled()){
                try{
                Class.forName("com.mysql.jdbc.Driver");
                         con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=0;

                        if(con!=null)
                            {

                        PreparedStatement ps=con.prepareStatement("INSERT INTO `gst` (`Name`, `GST_No`) VALUES (?,?);");
                               // System.out.println("ps "+ps);
                                ps.setString(1, a);
                                ps.setString(2, gstnot.getText().toString());
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "New Gst Number Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Cannot Create Connection", "Error Message", JOptionPane.ERROR_MESSAGE);
                        }
                }catch(Exception ex1){
                    // System.out.println("Exception saving new gst "+ex1);
                }

            }
            try{
                Class.forName("com.mysql.jdbc.Driver");
                         con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
if(con!=null)
                            {

                        PreparedStatement ps=con.prepareStatement("INSERT INTO `summary`(`Bill Number`, `Date`, `Name`, `GST_No`, `Bill Value`, `Gst Percentage`, `cgst`, `sgst`, `Total`, `Type`) VALUES (?,?,?,?,?,?,?,?,?,?);");
                               String ac=datePicker.getModel().getValue().toString();

                               //String sd=selectedDate.toString();
                                ps.setInt(1, Integer.parseInt(billt.getText().toString()));
                                ps.setString(2,ac.substring(4, 11)+ac.substring(24, 28));
                                ps.setString(3,namec.getSelectedItem().toString());
                                ps.setString(4, gstnot.getText().toString());
                                ps.setFloat(5, Float.parseFloat(valuet.getText().toString()));
                                ps.setFloat(6,Float.parseFloat(gstpercentagec.getSelectedItem().toString()));
                                ps.setFloat(7,Float.parseFloat(gsttaxt.getText().toString()));
                                ps.setFloat(8, Float.parseFloat(gsttaxt.getText().toString()));
                                ps.setFloat(9, Float.parseFloat(totalt.getText().toString()));
                                ps.setString(10, typec.getSelectedItem().toString());
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Saved", "Message", JOptionPane.PLAIN_MESSAGE);
}                           
            }catch(Exception save){
                System.out.println("exception "+save);
            }

           // frame.setVisible(false);
           //new CreateSummary();
        }
        
    }

    public void focusGained(FocusEvent e) {
       if(e.getSource()==namec){
          // System.out.println(" focusgained");
       }
    }

    public void focusLost(FocusEvent e) {
       try{
                Class.forName("com.mysql.jdbc.Driver");
                         con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        int i=0;

                        if(con!=null)
                            {
                            String a=namec.getSelectedItem().toString();
                        PreparedStatement ps=con.prepareStatement("select * FROM `gst` WHERE `Name` = '"+a+"'");
                               // System.out.println("ps "+ps);
                        ResultSet rs=ps.executeQuery();
String gst="";
                        while(rs.next())
                            {
                             gst=rs.getString(2);
                        }
                               // System.out.println("gst no"+gst);
                        gstnot.setText(gst);
                        if(gst.equals("")){
                            //System.out.println("Helll");
                            gstnot.setEnabled(true);
                           // System.out.println("Bye");
                        }
                        }
                }catch(Exception ex){

                }
            }

    public void itemStateChanged(ItemEvent e) {
       if(e.getSource()==gstpercentagec){
           String abc=gstpercentagec.getSelectedItem().toString();
           float tax=Float.parseFloat(valuet.getText())*((Float.parseFloat(abc)/2)/100);
           gsttaxt.setText(Float.toString(tax));
           float totalvaluef=((tax)*2)+Float.parseFloat(valuet.getText().toString());
           totalt.setText(Float.toString(totalvaluef));
       }
    }
    

}
