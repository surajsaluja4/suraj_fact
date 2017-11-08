

package fact;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class screensize extends JFrame
{

 static int h1,w1;
 Rectangle bounds;

   public Rectangle return_screen()
    {
    bounds=GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    return bounds;
    }
    public static int  width() {
        Dimension h=Toolkit.getDefaultToolkit().getScreenSize();
         w1=h.width;
         return w1;
      
    }
    public static int  hieght() {
        Dimension h=Toolkit.getDefaultToolkit().getScreenSize();
        h1=h.height;
         return h1;

    }
public static void main(String args[])
{
new screensize();
}
}