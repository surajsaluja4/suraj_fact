/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.sourceforge.jdatepicker.impl.*;
import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JCheckBox;

/**
 *
 * @author suraj
 */
public class attandance {
    UtilDateModel model = new UtilDateModel();
JDatePanelImpl datePanel = new JDatePanelImpl(model);
JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
JLabel Select_date;
JFrame frame;
JPanel panel,paneltop,panelback,panel1;
JScrollPane sp;
Vector emp_id=new Vector();
Vector emp_Name=new Vector();
Vector Present=new Vector();
 Vector Absent=new Vector();
 Vector emp_user_name=new Vector();
JCheckBox att[][];
JLabel id[],name[],user_name[];
int i;
    public attandance() {
        frame=new JFrame();
        frame.setSize(screensize.width(),screensize.hieght());
        panel=new JPanel(null);
        panel1=new JPanel(null);
paneltop=new JPanel(null);
paneltop.setBounds(0, 0, screensize.width(), 200);
paneltop.setBackground(Color.white);
panel.setBackground(Color.white);
panel1.setBackground(Color.white);
        Select_date=new JLabel("Select Date");
        Select_date.setBounds(100,50,150,50);
        datePicker.setBounds(200, 60, 150, 50);
        datePicker.setBackground(Color.white);
        model.setDate(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE));
      model.setSelected(true);
        paneltop.add(datePicker);
        paneltop.add(Select_date);
        get_Employee();
        panel.setPreferredSize(new Dimension(screensize.width()-100,500));
        sp=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelback=new JPanel(new BorderLayout());
        panelback.add(sp);
        panelback.setBounds(0, 200, screensize.width()-40, 300);
        panel1.add(panelback);
        panel1.add(paneltop);
        panel1.setBackground(Color.white);
        frame.add(panel1);
        frame.setVisible(true);
    }
   public void get_Employee(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection(Connection1.dbadmin, Connection1.root, Connection1.pass);
            Statement stmt = con1.createStatement();
            String sql="SELECT * FROM `login_credentials` WHERE `status`='Active' and `position`='Employee'";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                emp_id.add(rs.getInt(1));
                emp_Name.add(rs.getString("name"));
                emp_user_name.add(rs.getString("UserName"));
                System.out.println(rs.getInt(1));
            }

            Enumeration e = emp_id.elements();
          int l=emp_id.size();
      att=new JCheckBox[l+2][32];
      name=new JLabel[l+2];
      user_name=new JLabel[l+2];
      id=new JLabel[l+2];
      id[0]=new JLabel("Employee Id");
      id[0].setBounds(100, 50, 100, 50);
      name[0]=new JLabel("Employee Name");
      name[0].setBounds(200, 50, 100, 50);
      user_name[0]=new JLabel("User Name");
      user_name[0].setBounds(300, 50, 100, 50);
      panel.add(id[0]);
      panel.add(name[0]);
      panel.add(user_name[0]);
      while(e.hasMoreElements()){
                i++;
                String emp_ids=e.nextElement().toString();
                String emp_name=emp_Name.elementAt(i).toString();
                String emp_user=emp_user_name.elementAt(i).toString();
                id[i]=new JLabel("Emp"+emp_ids);
                name[i]=new JLabel(emp_name);
                user_name[i]=new JLabel(emp_user);
                id[i].setBounds(100, (i*50)+50, 50, 50);
                name[i].setBounds(200, (i*50)+50, 50, 50);
                user_name[i].setBounds(300, (i*50)+50, 50, 50);
                System.out.println(i+" "+e.hasMoreElements());

                panel.add(id[i]);
                panel.add(name[i]);
                panel.add(user_name[i]);
//
            }


        }
        catch(Exception e){

        }
   }
    public static void main(String[] args) {
        new attandance();
    }
}
