/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

/**
 *
 * @author Suraj Saluja
 */
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

  public  class search extends AbstractListModel
implements ComboBoxModel, KeyListener, ItemListener,MouseListener,FocusListener
{
ArrayList<String> db = new ArrayList<String>();
ArrayList<String> data = new ArrayList<String>();
String selection;
String selected;
JComboBox cb;
ComboBoxEditor cbe;
int currPos = 0;
String DB,Table,Name;
 String input;
public search(JComboBox jcb,String DB,String Table,String Name,String first)
{
    this.DB=DB;
    this.Table=Table;
    this.Name=Name;
    cb=jcb;
    cbe = jcb.getEditor();
//cb.addItem(first);
//db.add(first);
try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB,Connection1.root,Connection1.pass);
      
	if(con!=null)
	{
       String pq;
       int i=0;
       pq="SELECT * FROM "+Table;
      Statement stmt=con.createStatement();
       ResultSet rs=stmt.executeQuery(pq);

       while(rs.next())
       {
            String Name1=rs.getString(Name);
            db.add(Name1.toUpperCase());
            cb.addItem(Name1.toUpperCase());

            //cb.getEditor().setItem(Name1);
              }


        

//here we add the key listener to the text field that the combobox is wrapped around
cbe.getEditorComponent().addKeyListener(this);
cbe.getEditorComponent().addMouseListener(this);
cbe.getEditorComponent().addFocusListener(this);
    }
    }



	catch(Exception exception)
	{
        System.out.println(exception+" exception ");
	}
    selected=(String)cb.getSelectedItem();
    }

public void updatecontent(){
    

}
public String return_input(){

 return input;
}
public void updateModel(String in)
{
    input=in;
data.clear();
//lets find any items which start with the string the user typed, and add it to the popup list
//here you would usually get your items from a database, or some other storage...
for(String s:db)

if(s.startsWith(in.toUpperCase())){
           
data.add(s);
}
super.fireContentsChanged(this, 0, data.size());
//this is a hack to get around redraw problems when changing the list length of the displayed popups
cb.hidePopup();
cb.showPopup();
if(data.size() != 0)
cb.setSelectedIndex(0);
else if(data.size()==0)
{
    JOptionPane.showMessageDialog(null, "No such Entry Found", "OOPs!",JOptionPane.ERROR_MESSAGE);
}
}

public int getSize(){
      return data.size();
}
public Object getElementAt(int index){
    //JOptionPane.showMessageDialog(null,"index"+index);
    if(index!=-1)
    {
return data.get(index);}
    else{
        return data.indexOf(1);
    }
}

public void setSelectedItem(Object anItem)
{selection = (String) anItem;}
public Object getSelectedItem(){return selection;}
public void keyTyped(KeyEvent e){}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e)
{


String str = cbe.getItem().toString();
JTextField jtf = (JTextField)cbe.getEditorComponent();
currPos = jtf.getCaretPosition();
if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED)
{
if(e.getKeyCode() != KeyEvent.VK_ENTER )
{
cbe.setItem(str);
jtf.setCaretPosition(currPos);
}
}
else if(e.getKeyCode() == KeyEvent.VK_ENTER)
cb.setSelectedIndex(cb.getSelectedIndex());
else
{
updateModel(cb.getEditor().getItem().toString());
cbe.setItem(str);
jtf.setCaretPosition(currPos);
}
}
public void itemStateChanged(ItemEvent e)
{
cbe.setItem(e.getItem().toString());
cb.setSelectedItem(e.getItem());

}
public void mouseEntered(MouseEvent e) {


}

    public void mouseClicked(MouseEvent e) {
    updateModel("");
    cb.getEditor().setItem("");
    }

    public void mousePressed(MouseEvent e) {
       
    }

    public void mouseReleased(MouseEvent e) {
         
    }


    public void mouseExited(MouseEvent e) {

       
    }

    public void focusGained(FocusEvent e) {
        updateModel("");
           }

    public void focusLost(FocusEvent e) {
        if(cb.getEditor().getItem().toString().equals(""))
        {
         //   cb.getEditor().setItem(cb.getItemAt(0));
 
        }
    }

}