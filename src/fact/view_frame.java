package fact;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
class view_frame   implements ActionListener
{
    static JFrame frame=new JFrame();
    JLabel sup,searchby,search_label;
    JTextField search;
    JPanel p;
    JButton back,main_menu,menu,add,delete;
    JScrollPane scrpn;
    JButton naya,edit,del;
    JComboBox srby;
    String selected="";
    static JTable tb;
      int sl=0;
        

        static DefaultTableModel model;
Font f=new Font("Modern No. 20",Font.PLAIN, 20);
Font f9=new Font("Modern No. 20",Font.BOLD, 40);
Font f8=new Font("Times New Roman",Font.ITALIC, 20);
Object []column=new Object[9];
Object []data=new Object[9];
int key=0;


    view_frame(final int key)
    {
        this.key=key;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setExtendedState(JFrame.MAXIMIZED_BOTH);   // for maxamizing the frame
        p=new JPanel();
        p.setLayout(null);
		p.setBackground(Color.white);

  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

       int width=Toolkit.getDefaultToolkit().getScreenSize().width;
       int hieght=Toolkit.getDefaultToolkit().getScreenSize().height;
        p.setSize(width,hieght);
    	frame.add(p);

frame.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
                System.out.println("opened");
           model.fireTableChanged(null);
            }

            public void windowClosing(WindowEvent e) {
            }

            public void windowClosed(WindowEvent e) {
                frame.dispose();
            }

            public void windowIconified(WindowEvent e) {
               
            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {
             table_access("select * from suppliers where `status`='Active' ");
             table_access("select * from suppliers where `status`='Inactive' ");
            }

            public void windowDeactivated(WindowEvent e) {
                int m=model.getRowCount();

                            for(int i=m-1;i>=0;i--)
            {
            model.removeRow(i);            }

                }
        });
        search_label=new JLabel("Search this table");
    column[0]="Sl.No.";
    column[1]="Supplier Id";
    column[2]="Supplier Name";
    column[3]="Address";
    column[4]="Phone Number";
    column[5]="GST Number";
    column[6]="Products Offered";
    column[7]="Remarks";
    column[8]="Status";
    search=new JTextField(0);
    search.setToolTipText("search this table");
    searchby=new JLabel("  Search By:");
            searchby.setFont(f8);

        sup=new JLabel("Suppliers Data");
        back=new JButton("Go Back");             //new ImageIcon("img/org/back1.png")
        main_menu=new JButton("  Main Menu");

        back.setBounds(0,0,30,28);
        back.setBorder(null);
        back.setFont(f8);
        back.setBackground(Color.white);
        back.setForeground(Color.red);


        main_menu.setBounds(1180,70,160,30);
        main_menu.setFont(f8);
        main_menu.setBorder(null);
        main_menu.setBackground(Color.white);
        main_menu.setForeground(Color.blue);

        naya=new JButton(" Add New Supplier");
        edit = new JButton("Edit Supplier's Data");
        del=new JButton("Delete Supplier's Data ");

                naya.setBorder(null);
        naya.setFont(f8);
        naya.setBackground(Color.white);
        naya.setForeground(Color.black);

        edit.setBorder(null);
        edit.setFont(f8);
        edit.setBackground(Color.white);
        edit.setForeground(Color.black);

        del.setBorder(null);
        del.setFont(f8);
        del.setBackground(Color.white);
        del.setForeground(Color.black);
        

//        main_menu.setBorder(null);
//        main_menu.setFont(f8);
//        main_menu.setBackground(Color.white);
//        main_menu.setForeground(Color.black);


        Vector list=new Vector(3);
        list.add("Supplier's Name");
        list.add("Supplier's Phone Number");
        list.add("Supplier's Gst Number");


        srby=new JComboBox(list);
        srby.setBackground(Color.white);

                back.setBounds(20, 90, 100, 30);
                naya.setBounds(120, 90, 150, 30);
                edit.setBounds(280, 90, 170, 30);
                del.setBounds(460, 90, 200, 30);
                search.setBounds(680, 90, 200, 30);
                search_label.setBounds(680, 90, 170, 27);
                searchby.setBounds(890, 90, 200, 30);
                srby.setBounds(999, 90, 170, 30);
                main_menu.setBounds(1180, 90, 170, 30);

                srby.setSelectedItem(srby.getItemAt(0));



                naya.setFont(f8);
                edit.setFont(f8);
                del.setFont(f8);
                search_label.setFont(f8);
p.add(naya);
p.add(back);
p.add(edit);
p.add(del);
p.add(search);
p.add(searchby);
p.add(srby);
p.add(main_menu);
        search.setFont(f8);
        sup.setBounds(540,20,450,40);
        sup.setFont(f9);
        sup.setForeground(Color.black);
        sup.setBackground(Color.white);
        p.add(sup);

         model = new DefaultTableModel()
        {

            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }
        };


        tb=new JTable();
        tb.setModel(model);
        model.setColumnIdentifiers(column);
        tb.setFillsViewportHeight(true);            // to use the entire hiegth of the scroll pane
         tb.getColumnModel().getColumn(0).setPreferredWidth(0);
        

        scrpn=new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      	scrpn.setFont(f);
         scrpn.setBounds(30, 120, width-60, hieght-200);
	    scrpn.setForeground(Color.black);

        scrpn.setVisible(true);
        p.add(scrpn,BorderLayout.CENTER);
      
     


         search.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                int m=model.getRowCount();

            for(int i=m-1;i>=0;i--)
            {
            model.removeRow(i);
                System.out.println("value of i"+i+model.getRowCount());
            }
                data=new Object[9];
                table_access("select * from `suppliers` WHERE `"+selected+"` LIKE '%"+search.getText()+"%' AND `status`='Active'");

                table_access("select * from `suppliers` WHERE `"+selected+"` LIKE '%"+search.getText()+"%' AND `status`='Inactive'");



                           }

            public void removeUpdate(DocumentEvent e) {
                   int m=model.getRowCount();

            for(int i=m-1;i>=0;i--)
            {
            model.removeRow(i);
            }
                data=new Object[9];
                table_access("select * from `suppliers` WHERE `"+selected+"` LIKE '%"+search.getText()+"%' AND `status`='Active'");
                table_access("select * from `suppliers` WHERE `"+selected+"` LIKE '%"+search.getText()+"%' AND `status`='Inactive'");

            }

            public void changedUpdate(DocumentEvent e) {

            }
        });


naya.addActionListener(this);
edit.addActionListener(this);
del.addActionListener(this);



         back.addActionListener(this);
         main_menu.addActionListener(this);
        frame.setVisible(true);

    }
    public static void main(String []args)
 {

    new view_frame(1);

}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            frame.setVisible(false);
            new view_supplier();
        }
        if(e.getSource()==main_menu)
        {
            frame.setVisible(false);
            new manager_area();
        }
  if(e.getSource()==naya)
        {
            frame.setVisible(false);
             new add_supplier();
             //add_supplier.getframe(frame);
        }
        if(e.getSource()==edit)
        {
            frame.setVisible(false);
           // new edit_supplier(1);
            //edit_supplier.getframe(frame);
        }
  if(e.getSource()==del)
        {
            frame.setVisible(false);
            //new edit_supplier(2);
             //edit_supplier.getframe(frame);
        }


}

   public  void table_access(String sql)
   {
       
       System.out.println(sql+"called");
       if(srby.getSelectedIndex()==0)
            selected="name";
        if(srby.getSelectedIndex()==1)
            selected="phone";
        if(srby.getSelectedIndex()==2)
            selected="gst";

        String temp="",temp1="";
         Vector st = new Vector(100);


         try
                             {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null && key==1)
                            {
                        PreparedStatement ps=con.prepareStatement(sql);
                        ResultSet rs=ps.executeQuery();
                                System.out.println("sql1"+sql+"key"+key);
                        while(rs.next())
                            {
                                temp1="";
                                data[0]=++sl;
                                data[1]="SUP0"+Integer.toString(rs.getInt("id"));
                                data[2]=(String)rs.getString("name");
                                data[3]=(String)rs.getString("address");
                                data[4]=rs.getString("phone");
                                data[5]=rs.getString("gst");
                                temp=rs.getString("products");
                                data[7]=rs.getString("remarks");
                                data[8]=rs.getString("status");
                                    PreparedStatement ps1=con.prepareStatement("select name from product_group ");
                                     ResultSet rs1=ps1.executeQuery();
                                      int r=0;
                                     
                        while(rs1.next())
                            {
                                st.add(r++,(String)rs1.getString("name"));
                                System.out.println("rs1"+rs1.getString("name"));

                            } //end of while loop
                                   String[] yu=temp.split(",");               // the string has the details of the produts the supplier sells
                                   System.out.println("yu l"+yu.length);
                                   System.out.println("Hello1");
                                    System.out.println("st element"+st.size());

                                   System.out.println("Hello2");
                                   for(String s:yu)
                                    {
                                        System.out.println("yu"+s);
                                        temp1+=(String)st.elementAt(Integer.parseInt(s)-1)+",\n";
                                        System.out.println("temp  "+temp1);
                                    }
                                System.out.println("temp1"+temp1);
                                
             data[6]=temp1;
                                System.out.println("data2"+data[1]);

                         model.addRow(data);
                        }    //end of while loop

                        // tb.setRowHeight(60);

                        }
                            }
catch(Exception exception)
                                {
                            		System.out.println(exception);
                                }    //end of catch block

   }

}