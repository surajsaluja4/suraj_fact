/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author suraj
 */
public interface key {

    MouseListener cal1=new MouseListener() {
Color bg1;

        public void mouseClicked(MouseEvent e) {
            
        }

        public void mousePressed(MouseEvent e) {
           
            Component Button=e.getComponent();
            if(Button.isEnabled()){
                String bg=Button.getBackground().toString();
                
                if(bg1==Color.white){
                    Button.setBackground(Color.green);
                    bg1=Color.green;
                }
                else if(bg1==Color.green)
                {
                    Button.setBackground(Color.red);
                    bg1=Color.red;
                }
                else{
                    Button.setBackground(Color.white);
                    bg1=Color.white;
                }

            }
        }
        

        public void mouseReleased(MouseEvent e) {
           
        }

        public void mouseEntered(MouseEvent e) {
            Component Button=e.getComponent();
           bg1=Button.getBackground();
            if(Button.isEnabled()){
                String bg=Button.getBackground().toString();
                if(bg=="green"){
                    Button.setBackground(Color.red);
                }
                else if(bg=="red"){
                    Button.setBackground(Color.green);
                }
                else{
                   // Button.setBackground(Color.white);
                   
                }
            }
        }

        public void mouseExited(MouseEvent e) {
            e.getComponent().setBackground(bg1);
        }
    };
   KeyListener num=new KeyListener() {

            public void keyTyped(KeyEvent evt) {

            }

            public void keyPressed(KeyEvent evt) {
             if((evt.getKeyChar()>='0'&&evt.getKeyChar()<='9')||(evt.getKeyCode()==8)||(evt.getKeyCode()==evt.VK_ENTER))
             {

             }
             else
             {
                evt.getComponent().setEnabled(false);
             JOptionPane.showMessageDialog(null,"Please Enter The Numaric Value(0-9)", "Error",JOptionPane.ERROR_MESSAGE);
              evt.getComponent().setEnabled(true);
             }
            }

            public void keyReleased(KeyEvent evt) {

            }
        };

        KeyListener varchar=new KeyListener() {

            public void keyTyped(KeyEvent evt) {

            }

            public void keyPressed(KeyEvent evt) {
             if((evt.getKeyChar()>='0'&&evt.getKeyChar()<='9'))
             {
                evt.getComponent().setEnabled(false);
             JOptionPane.showMessageDialog(null," Numaric Value(0-9) Not Allowed", "Error",JOptionPane.ERROR_MESSAGE);
              evt.getComponent().setEnabled(true);
             }
             else
             {

             }
            }

            public void keyReleased(KeyEvent evt) {

            }
        };
        FocusListener focus=new FocusListener() {

        public void focusGained(FocusEvent e) {
            e.getComponent().setBackground(e.getComponent().getBackground());
        }

        public void focusLost(FocusEvent e) {
            e.getComponent().setBackground(e.getComponent().getBackground());
        }
    };


}
