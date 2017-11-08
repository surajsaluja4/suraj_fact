/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Enumeration;
import javax.swing.JCheckBox;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author suraj
 */
public class Mark_attandance {
JCheckBox att[][];
JLabel id[],name[],user_name[];
Vector emp_id=new Vector();
Vector emp_Name=new Vector();
Vector Present=new Vector();
 Vector Absent=new Vector();
 Vector emp_user_name=new Vector();
JFrame frame;
JPanel panel,PanelBack,panelmian;
JScrollPane pane;
    public Mark_attandance() {
        
         frame=new JFrame();
         frame.setSize(900, 700);
         frame.setLayout(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         panel=new JPanel();
         panel.setLayout(null);
         panelmian=new JPanel();
         panelmian.setLayout(null);
         get_Employee();
         panelmian.setBackground(Color.white);
         panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(frame.getWidth()-200, emp_id.size()*50));

        pane=new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBorder(null);
        PanelBack=new JPanel();
        PanelBack.setLayout(new BorderLayout());
        PanelBack.add(pane,BorderLayout.CENTER);
        PanelBack.setBounds(0, 100, frame.getWidth()-20, frame.getHeight()-150);
        PanelBack.setBackground(Color.WHITE);
        panelmian.add(PanelBack);
panelmian.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.add(panelmian);
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
            System.out.println("size "+l);
            int i=0;
            while(e.hasMoreElements()){
                i++;
                String emp_ids=e.nextElement().toString();
                String emp_name=emp_Name.elementAt(i).toString();
                String emp_user=emp_user_name.elementAt(i).toString();
//                id[i]=new JLabel("Emp"+emp_ids);
//                name[i]=new JLabel(emp_name);
//                user_name[i]=new JLabel(emp_user);
//                id[i].setBounds(100, (i*50)+50, 50, 50);
//                name[i].setBounds(200, (i*50)+50, 50, 50);
//                user_name[i].setBounds(300, (i*50)+50, 50, 50);
//
//
//                panel.add(id[i]);
//                panel.add(name[i]);
//                panel.add(user_name[i]);
//
            }
            for(i=1;i<=31;i++){
                for(int j=1;j<=l;j++){
                    System.out.println("i "+i+"j "+j);
                    att[i][j]=new JCheckBox();
                att[i][j].setBackground(Color.white);
                att[i][j].setBounds((i*100)+300, (j*50)+50, 50, 50);
                panel.add(att[i][j]);
                }
            }
            Connection con2= DriverManager.getConnection(Connection1.dbemployee, Connection1.root, Connection1.pass);
            Statement stmt1 = con2.createStatement();
             sql="SELECT * FROM `login_credentials` WHERE `status`='Active' and `position`='Employee'";
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new Mark_attandance();
    }

}
