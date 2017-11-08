/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.JScrollBar;

/**
 *
 * @author suraj
 */
public class Attandence {
    JFrame frame;

    JPanel panel,panelBack,panelBack2,ScrollingPane,ScrollingPane2;
    JButton Submit;
    JScrollPane sp,datesp;
    JCheckBox att[][];
    JLabel empname[],empid[],empuser[],Dates[],NameTitle,UserTitle,IdTitle;
    String Name,id,username;
    Vector Namelist=new Vector(),idlist=new Vector(),userlist=new Vector();
    int total_employee;
    public Attandence() {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screensize.width(),screensize.hieght());
        panel=new JPanel(null);
        ScrollingPane=new JPanel();
        ScrollingPane2=new JPanel();
        ScrollingPane.setLayout(null);
        ScrollingPane2.setLayout(null);
        ScrollingPane2.setBackground(Color.white);
        panel.setBackground(Color.white);
        ScrollingPane.setBackground(Color.white);
        Draw();
        ScrollingPane.setPreferredSize(new Dimension(screensize.width()-100,Namelist.size()*100));
        ScrollingPane2.setPreferredSize(new Dimension(34*50,Namelist.size()*100));
        sp=new JScrollPane(ScrollingPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        datesp=new JScrollPane(ScrollingPane2, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        datesp.setBorder(null);
        JScrollBar sb=new JScrollBar(JScrollBar.HORIZONTAL, 10, 10, 10, 20);
        datesp.setHorizontalScrollBar(sb);
        panelBack=new JPanel();
        panelBack.setLayout(new BorderLayout());
        panelBack.add(sp,BorderLayout.CENTER);
        panelBack.setBounds(0, 200, screensize.width()-100, screensize.hieght()-300);
        panel.add(panelBack);
        panelBack2=new JPanel();
        panelBack2.setLayout(new BorderLayout());
        panelBack2.add(datesp,BorderLayout.CENTER);
        panelBack2.setBounds(400, 0, screensize.width()-420, Namelist.size()*100);
        ScrollingPane.add(panelBack2);
        frame.add(panel);
        frame.setVisible(true);
    }
public void getEmployee(){
    try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection(Connection1.dbadmin, Connection1.root, Connection1.pass);
            Statement stmt = con1.createStatement();
            String sql="SELECT * FROM `login_credentials` WHERE `status`='Active' and `position`='Employee'";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                Namelist.add(rs.getString("name"));
                idlist.add("emp"+rs.getInt("id"));
                userlist.add(rs.getString("username"));
            }
    }
    catch(Exception e){
        System.out.println("Exception "+e);
    }

}
public void Draw(){
    getEmployee();
    total_employee=Namelist.size();
    NameTitle=new JLabel("Employee Name");
    IdTitle=new JLabel("Employee Id");
    UserTitle=new JLabel("User Name");
    NameTitle.setBounds(120, 50, 100, 50);
    IdTitle.setBounds(25, 50, 100, 50);
    UserTitle.setBounds(220, 50, 100, 50);
    ScrollingPane.add(NameTitle);
    ScrollingPane.add(UserTitle);
    ScrollingPane.add(IdTitle);
    empname=new JLabel[total_employee+1];
    empid=new JLabel[total_employee+1];
    empuser=new JLabel[total_employee+1];
    att=new JCheckBox[total_employee][31];
    Dates=new JLabel[31];
    for(int i=0;i<31;i++){
        Dates[i]=new JLabel(Integer.toString(i+1));
        Dates[i].setBounds((i*50)+50, 50, 50, 50);
        ScrollingPane2.add(Dates[i]);
    }
    for(int i=0;i<total_employee;i++){
        empname[i]=new JLabel(Namelist.elementAt(i).toString());
        empid[i]=new JLabel(idlist.elementAt(i).toString());
        empuser[i]=new JLabel(userlist.elementAt(i).toString());
        empid[i].setBounds(50, (i*100)+100, 100, 50);
        empname[i].setBounds(150, (i*100)+100, 100, 50);
        empuser[i].setBounds(250, (i*100)+100, 100, 50);
        ScrollingPane.add(empname[i]);
        ScrollingPane.add(empid[i]);
        ScrollingPane.add(empuser[i]);
        for(int j=0;j<31;j++){
            att[i][j]=new JCheckBox();
            att[i][j].setBounds((j*50)+50, (i*100)+100, 50, 50);
            att[i][j].setBackground(Color.white);
            ScrollingPane2.add(att[i][j]);
        }
    }
}
    public static void main(String[] args) {
        new Attandence();
    }
}
