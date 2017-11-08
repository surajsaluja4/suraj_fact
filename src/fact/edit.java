/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author suraj
 */
public class edit implements fonts{
    JFrame frame;
    JPanel panel;
    JLabel username;
    JTextField usernamet;
    int width,height;
    edit(){
    frame=new JFrame();
    frame.setLayout(null);
    panel=new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.WHITE);
    username=new JLabel("Hello");
    username.setFont(f8);
    usernamet=new JTextField();
    width=screensize.width();
    height=screensize.hieght();
    frame.setSize(width, height);
    panel.setBounds(0, 0, width, height);
    username.setBounds(100, 100,100,50);
    panel.add(username);
    panel.setVisible(true);
    frame.add(panel);
    frame.setVisible(true);
    }
    public static void main(String[] args) {
        new edit();
    }
}
