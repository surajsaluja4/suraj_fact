package fact;

import javax.swing.*;
public class test extends JFrame {
JScrollPane scrpn;
   test()
   {

       JFrame f=new JFrame();
       f.setSize(1200,200);

        scrpn=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        f.setContentPane(scrpn);

    add(scrpn);
//         scrpn.setBounds(0, 0, 1200, 200);
	   setVisible(true);
   }
   public static void main(String[] args)
   {
       new test();
   }
}
//}
//public class TabbedPaneTest {
//    public static void main(String [] a) {
//        final JFrame frame = new JFrame();
//        frame.setSize(500, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//        frame.setContentPane(pane);
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                frame.setVisible(true);
//            }
//        });
//   }
//}