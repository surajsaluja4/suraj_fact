/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;



import java.awt.event.ItemEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author suraj
 */
public class PanelTest implements key,ActionListener{
JFrame frame;
JPanel panel;
JLabel Labels[];
JButton Days[],Submit;
int fd;
String month;
int No_Of_Days;
String Month;
Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
Color opaque=new Color(10, 10, 10, 0);
Color c=new Color(238, 238, 238);
Vector  list=new Vector();
JComboBox Monthcb,Yearcb;
Calendar cal= Calendar.getInstance();
    public PanelTest() {
        
        
                frame=new JFrame();
        frame.setSize(900, 700);
      panel=new JPanel();
      panel.setLayout(null);
      panel.setBackground(Color.white);
      frame.add(panel);
      
      list.add("January");
      list.add("February");
      list.add("March");
      list.add("April");
      list.add("May");
      list.add("June");
      list.add("July");
      list.add("August");
      list.add("September");
      list.add("October");
      list.add("November");
      list.add("December");
      Monthcb=new JComboBox(list);
      Monthcb.setBounds(200, 50, 200, 50);
      panel.add(Monthcb);
      Monthcb.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                System.out.println("Item"+e.getItem().toString());
                int jj=Monthcb.getSelectedIndex();
                System.out.println("Index "+jj);
                cal.set(Calendar.MONTH, jj);
                Calculatefirstday();
            }
        });
      Labels=new JLabel[8];
      for(int i=1;i<=7;i++){
          Labels[i]=new JLabel();
          Labels[i].setBounds(i*100, 100, 100, 50);
          panel.add(Labels[i]);
      }
      Labels[1].setText("Sun");
      Labels[2].setText("Mon");
      Labels[3].setText("Tue");
      Labels[4].setText("Wed");
      Labels[5].setText("Thu");
      Labels[6].setText("Fri");
      Labels[7].setText("Sat");

      fd=Calculatefirstday();
        Submit=new JButton("Submit");
        Submit.setBounds(300, 500, 100, 50);
        panel.add(Submit);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("bg"+Days[20]);
    Submit.addActionListener(this);
    }

    public void DrawCalendar(){
panel.removeAll();
panel.add(Monthcb);
        int mnth=cal.get((Calendar.MONTH));
      int No_of_Day=ret_days((mnth+1));
        System.out.println("No Of Day"+No_of_Day);
        Days=new JButton[43];
        int d=1;
        int j=1;
        int k=1;
        int l=1;
        int m=1;
        for(int i=1;i<=42;i++){



            Days[i]=new JButton();
            Days[i].setText(toString(k)+toString(j));
            Days[i].setBounds((k*100)-30, (j*55)+100, 90, 50);

            if(i%7==0)
            {
                j++;
                k=0;
            }
            if(i<fd){

             //Days[i].setVisible(false);
            Days[i].setEnabled(false);
                System.out.println(No_of_Day);
            Days[i].setText(toString((No_of_Day+1)-(fd)+i));
            }
            else{
                Days[i].setText(toString(l));
                l++;
            }
            if(l>cal.get(Calendar.DATE)+1){
                //Days[i].setBackground(Color.gray);
            }
            if(l>(No_of_Day+1)){

                Days[i].setEnabled(false);

            //Days[i].setBackground(c);
                Days[i].setText(toString(m));
                m++;

            }
            Days[i].setBackground(Color.white);
            Days[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            Days[i].setFont(f2);
            Days[i].setRolloverEnabled(false);
            Days[i].setFocusPainted(false);
            Days[i].setFocusable(false);
            Days[i].addFocusListener(focus);
            Days[i].addMouseListener(cal1);
            panel.add(Days[i]);
            k++;



        }
    }
    public int Calculatefirstday(){
        //Monthcb.setSelectedIndex(cal.get(Calendar.MONTH));
        int date=cal.get(Calendar.DATE);
        int day=cal.get(Calendar.DAY_OF_WEEK);
        int first_day=(day-(date%7))+1;
        if(first_day<0){
            first_day+=7;
        }
        DrawCalendar();
        switch(first_day){
            case 1:
                System.out.println("Sunday");

                break;
            case 2:
                System.out.println("Sunday");
                break;
             case 3:
                System.out.println("TuesDay");
                break;
              case 4:
                System.out.println("WednesDay");
                break;
              case 5:
                System.out.println("Thurday");
                break;
             case 6:
                System.out.println("Friday");
                break;
             case 7:
                System.out.println("Saturday");
                break;
        }

        return first_day;
    }

    public static void main(String[] args) {
        new PanelTest();
    }
    public void setMonth(int a){
        Calendar.getInstance().setTime(new java.util.Date(2016, 10, 27));
    }
    public int ret_days(int m){

                switch(m){
                case 1:
                No_Of_Days=31;
                    break;
            case 2:
               if((Calendar.getInstance().get(Calendar.YEAR))%4==0)
                   No_Of_Days=29;
               else
                   No_Of_Days=28;
                break;

             case 3:
                No_Of_Days=31;
                break;
              case 4:
                No_Of_Days=30;
                break;
              case 5:
                No_Of_Days=31;
                break;
             case 6:
                No_Of_Days=30;
                break;
             case 7:
                No_Of_Days=31;
                break;
                case 8:
                No_Of_Days=31;
                break;
              case 9:
                No_Of_Days=30;
                break;
              case 10:
                No_Of_Days=31;
                break;
             case 11:
                No_Of_Days=30;
                break;
             case 12:
               No_Of_Days=31;
                break;

               }
                return No_Of_Days;
}
public String ret_month(int m){

                switch(m){
                case 1:
                Month= "January";
                    break;
            case 2:
                Month= "February";
                break;
             case 3:
                Month= "March";
                break;
              case 4:
                Month= "April";
                break;
                case 5:
                Month= "May";
                break;
              case 6:
                Month= "June";
                break;
             case 7:
                Month= "July";
                break;
             case 8:
                Month= "August";
                break;
                case 9:
                Month= "September";
                break;
              case 10:
                Month= "October";
                break;
              case 11:
                Month= "November";
                break;
             case 12:
                Month= "December";
                break;
             

               }
                return Month;
}
    private String toString(int d) {
        return Integer.toString(d);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Hello");
        int i;
        if(e.getSource()==Submit){
            System.out.println("Submit Pressed");
            String p="";
            String ab="";
            for(i=1;i<=42;i++)
            {
                if(Days[i].getBackground()==Color.green){
                    p+=Days[i].getText().toString()+",";
                }
                else if(Days[i].getBackground()==Color.red){
                    ab+=Days[i].getText().toString()+",";
                }
            }
            try{
            Class.forName("com.mysql.jdbc.Driver");
                         Connection con1=DriverManager.getConnection(Connection1.dbemployee, Connection1.root, Connection1.pass);
                      Statement stmt = con1.createStatement();
                         //String sql="UPDATE `"+Calendar.getInstance().get(Calendar.YEAR)+"` SET `"+ret_month(Calendar.getInstance().get(Calendar.MONTH))+"`="+p+" "+ab+" WHERE `id`=`10`";
                      String sql= " UPDATE `"+Calendar.getInstance().get(Calendar.YEAR)+"` SET `"+ret_month(Calendar.getInstance().get(Calendar.MONTH))+"`='"+p+"_"+ab+"' where `id`=10";
                         System.out.println(sql);
                         stmt.executeUpdate(sql);
                         System.out.println("Updated");
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
    }

}
