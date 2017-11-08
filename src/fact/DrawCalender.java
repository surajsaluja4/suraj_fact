/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class DrawCalender implements ItemListener,key,ActionListener{
    JButton CalanderDays[],todayb;
    JComboBox Months;
    Calendar cal=Calendar.getInstance();
    JLabel DaysLabel[];
    JFrame frame;
    JPanel panel;
    JLabel Labels[];
int No_Of_Days;
Vector  list=new Vector();
Vector Years=new Vector();

Font f2=new Font("Baskerville Old Face",Font.BOLD, 20);
JComboBox Monthcb,Yearcb;
    public DrawCalender() {
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
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
      Monthcb.setSelectedIndex(cal.get(Calendar.MONTH));
      for(int i=1900;i<=Calendar.getInstance().get(Calendar.YEAR);i++){
          Years.add(i);
      }
      Yearcb=new JComboBox(Years);
      Yearcb.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
              Draw();
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
         
      Monthcb.setBounds(200, 50, 200, 50);
      Yearcb.setBounds(500, 50, 200, 50);
      panel.add(Monthcb);
      panel.add(Yearcb);
        frame.add(panel);
todayb=new JButton("Today");
todayb.setBounds(500,600, 100, 50);
panel.add(todayb);

        frame.setVisible(true);
Monthcb.addItemListener(this);
Yearcb.addItemListener(this);
todayb.addActionListener(this);
    }
    public int getfirst_day(){
      //  System.out.println("Date"+cal.getTime());
        int date=cal.get(Calendar.DATE);
        int day=cal.get(Calendar.DAY_OF_WEEK);
        int first_day=(day-(date%7))+1;
        if(first_day<0){
            first_day+=7;
        }
        return first_day;
    }
    public void removeCal(){
         for(int i=1;i<43;i++){
            panel.remove(CalanderDays[i]);
        }
    }
    public void Draw(){
       // setstate();
        int fd=getfirst_day();
        int j=1;
        int k=1;
        int date=1;
        int nxt=1;
        int prev=ret_days((cal.get(Calendar.MONTH))-1)-fd+2;
     
        CalanderDays=new JButton[43];
        for(int i=1;i<43;i++){
            CalanderDays[i]=new JButton();
            CalanderDays[i].setBounds((k*100)-30, (j*55)+100, 90, 50);
            CalanderDays[i].setBackground(Color.white);
            CalanderDays[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            CalanderDays[i].setFont(f2);
            CalanderDays[i].setRolloverEnabled(false);
            CalanderDays[i].setFocusPainted(false);
            CalanderDays[i].setFocusable(false);
            CalanderDays[i].addFocusListener(focus);
            CalanderDays[i].addMouseListener(cal1);
            k++;
            if(i%7==0)
            {
                j++;
                k=1;
            }
            panel.add(CalanderDays[i]);
            if(i<fd)
            {
             
                CalanderDays[i].setText(Integer.toString(prev));
                prev++;
                CalanderDays[i].setEnabled(false);
            }
            if(i>=fd)
            {
                CalanderDays[i].setText(Integer.toString(date));
                date++;
            }
            if(date>ret_days(cal.get(Calendar.MONTH))+1){
                CalanderDays[i].setText(Integer.toString(nxt));
                nxt++;
                CalanderDays[i].setEnabled(false);
            }
            if((cal.get(Calendar.MONTH)==Calendar.getInstance().get(Calendar.MONTH))&&(cal.get(Calendar.YEAR)>=Calendar.getInstance().get(Calendar.YEAR))){
                if(Integer.parseInt(CalanderDays[i].getText().toString())>Calendar.getInstance().get(Calendar.DATE)){
                    CalanderDays[i].setEnabled(false);
                }
            }
            if((cal.get(Calendar.MONTH)>Calendar.getInstance().get(Calendar.MONTH))&&(cal.get(Calendar.YEAR)>=Calendar.getInstance().get(Calendar.YEAR))){
                    CalanderDays[i].setEnabled(false);

            }
            
        }
    }
        public int ret_days(int m){

                switch(m){
                case 0:
                No_Of_Days=31;
                    break;
            case 1:
               if((Calendar.getInstance().get(Calendar.YEAR))%4==0)
                   No_Of_Days=29;
               else
                   No_Of_Days=28;
                break;

             case 2:
                No_Of_Days=31;
                break;
              case 3:
                No_Of_Days=30;
                break;
              case 4:
                No_Of_Days=31;
                break;
             case 5:
                No_Of_Days=30;
                break;
             case 6:
                No_Of_Days=31;
                break;
                case 7:
                No_Of_Days=31;
                break;
              case 8:
                No_Of_Days=30;
                break;
              case 9:
                No_Of_Days=31;
                break;
             case 10:
                No_Of_Days=30;
                break;
             case 11:
               No_Of_Days=31;
                break;

               }
                return No_Of_Days;
}
    public static void main(String[] args) {
        new DrawCalender();
    }

    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==Monthcb){
        cal.set(Calendar.MONTH, Monthcb.getSelectedIndex());
        }

        else if(e.getSource()==Yearcb){
            cal.set(Calendar.YEAR, Integer.parseInt(Yearcb.getSelectedItem().toString()));
        }

        removeCal();
        Draw();

    }
    public void today(){
       Calendar now=Calendar.getInstance();
       cal.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
       removeCal();
       Draw();
       setstate();
    }
    public void setstate(){
        Monthcb.setSelectedIndex(cal.get(Calendar.MONTH));
        Yearcb.setSelectedItem(cal.get(Calendar.YEAR));
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==todayb){
            today();
        }
    }
}
