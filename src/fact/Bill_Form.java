/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suraj
 */
public class Bill_Form implements FocusListener,ItemListener,ActionListener{

    JFrame frame;
    JComboBox name_text,percentage_text,cust_name_text;
    JButton add,remove,submit,cancel;
    JPanel panel_firm,panel_form,panel_table,panel_submit,panel_tot_table,tot,panel_add_btn,panel_bg;
    JLabel firm_name,firm_logo;
    JLabel date,time,invoice_number,product_name,product_price,quantity,cust_name,cust_gst,cust_phno,discount,tax_percentage,frieght;
    JLabel total_add,quantity_add,total_total;
    JTextField date_text,time_text,invoice_text,price_text,quantity_text,cust_gst_text,cust_phn_text,discount_text,frieght_text;
   String gst,mobile;
   String invoice_string=null,date_string=null,time_string=null,product_name_string=null,price_string=null,quantity_string=null,discount_string=null,cust_name_string=null,custgst_string=null;
   String friegt_string=null,tax_percentage_string=null,cust_phno_string=null,hsn=null,size=null,id=null;
    static JTable table,total_table;
    Connection con;
    search sbm,sbm1;
    Vector gstv,check=new Vector();
    static DefaultTableModel model,model_tot;
    int cust_id,max_dis;
    JScrollPane scrpn,tot_scrpn;
    long mob_number;

    public Bill_Form() {

        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_bg=new JPanel();
        frame.setSize(screensize.width(), screensize.hieght());
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel_bg.setLayout(null);
        panel_bg.setBackground(Color.white);
        
/*panel firm*/
        panel_firm=new JPanel(null);
        panel_firm.setBackground(Color.white);
        panel_firm.setBounds(0, 0, frame.getWidth(), 100);

        firm_logo=new JLabel(new ImageIcon(Seller_Details.logo_image));
        firm_name=new JLabel(Seller_Details.Firm_Name);
        firm_name.setFont(Seller_Details.firm_font);

        firm_name.setBounds(frame.getWidth()/2-150, 25, 300, 30);
        firm_logo.setBounds(100, 0, 100, 100);

        panel_firm.add(firm_name);
        panel_firm.add(firm_logo);
       
       /* panel firm ends*/
        
        panel_form=new JPanel(null);
        panel_form.setBounds(20, 100, frame.getWidth()-40, 200);
        panel_form.setBackground(Color.white);
        panel_form.setSize(frame.getWidth()-40,200);
        invoice_number=new JLabel("Bill No.");
        invoice_text=new JTextField(20);
        date=new JLabel("Date");
        date_text=new JTextField(20);
        time=new JLabel("Time");
        time_text=new JTextField(20);
//java.awt.Rectangle[x=0,y=100,width=221,height=30]
//java.awt.Rectangle[x=100,y=100,width=121,height=30]

        int i=-1;
        int j=0;
        int k=Seller_Details.bill_label_space;
        int l=Seller_Details.bill_textfield_space;
        int lst=Seller_Details.bill_left_space_text_field;
        int lsl=Seller_Details.bill_left_space_label;
        invoice_number.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        invoice_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        date.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        date_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        time.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        time_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);

        product_name=new JLabel("Product Name");
        name_text=new JComboBox();
          sbm=new search(name_text, Connection1.dbmanager_name, "product_item", "name", "");
         name_text.setEditable(true);
         name_text.addItemListener(sbm);
        name_text.addMouseListener(sbm);
        //name_text.addFocusListener(sbm);
        product_price=new JLabel(" Unit Price");
        name_text.setModel(sbm);
        price_text=new JTextField();
        quantity=new JLabel("Quantity");
        quantity_text=new JTextField();
        j++;
        i=-1;
product_name.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        System.out.println(product_name.getBounds());
name_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        quantity.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        quantity_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        product_price.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        price_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);

discount=new JLabel("Discount");
discount_text=new JTextField();
tax_percentage=new JLabel("Tax %age");
gstv=new Vector();
        gstv.add("0.00");
        gstv.add("0.25");
        gstv.add("3.00");
        gstv.add("5.00");
        gstv.add("12.00");
        gstv.add("18.00");
        gstv.add("28.00");
percentage_text=new JComboBox(gstv);
frieght=new JLabel("Frieght");
frieght_text=new JTextField();

j++;
        i=-1;
discount.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        System.out.println(product_name.getBounds());
discount_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        tax_percentage.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        percentage_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        frieght.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        frieght_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);

        cust_name=new JLabel("Customer Name");

        cust_name_text=new JComboBox();
        cust_name_text.setEditable(true);
         sbm1=new search(cust_name_text, Connection1.dbmanager_name, "gst", "name","");
        cust_name_text.addItemListener(sbm1);
        cust_name_text.setModel(sbm1);
        cust_name_text.addMouseListener(sbm1);
        cust_gst=new JLabel("Gst Number");
        cust_gst_text=new JTextField();
        cust_phno=new JLabel("Phone Number");

        cust_phn_text=new JTextField();
        j++;
        i=-1;
        cust_name.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        cust_name_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        cust_gst.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        cust_gst_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);
        cust_phno.setBounds(++i*(panel_form.getWidth()/6)+lsl, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-k, (panel_form.getHeight()/4)-20);
        cust_phn_text.setBounds(++i*(panel_form.getWidth()/6)+lst, j*(panel_form.getHeight()/4), (panel_form.getWidth()/6)-l, (panel_form.getHeight()/4)-20);



/*
        invoice_number.setFont(Seller_Details.bill_label_font);
        invoice_text.setFont(Seller_Details.bill_text_field_font);
        date.setFont(Seller_Details.bill_label_font);
        date_text.setFont(Seller_Details.bill_text_field_font);
         time.setFont(Seller_Details.bill_label_font);
        time_text.setFont(Seller_Details.bill_text_field_font);
  */

       



        panel_form.add(invoice_number);
        panel_form.add(invoice_text);
        panel_form.add(date);
        panel_form.add(date_text);
        panel_form.add(time);
        panel_form.add(time_text);
        panel_form.add(product_name);
        panel_form.add(name_text);
        panel_form.add(quantity);
        panel_form.add(quantity_text);
        panel_form.add(product_price);
        panel_form.add(price_text);
        panel_form.add(discount);
        panel_form.add(discount_text);
        panel_form.add(tax_percentage);
        panel_form.add(percentage_text);
        panel_form.add(frieght);
        panel_form.add(frieght_text);
        panel_form.add(cust_name);
        panel_form.add(cust_name_text);
        panel_form.add(cust_gst);
        panel_form.add(cust_gst_text);
        panel_form.add(cust_phno);
        panel_form.add(cust_phn_text);




Component c[]=panel_form.getComponents();
       for(Component cu:c){
           cu.setBackground(Color.white);
          if(cu.getClass()==invoice_number.getClass()){
              cu.setFont(Seller_Details.bill_label_font);
          }
          else if(cu.getClass()==invoice_text.getClass()){
              cu.setFont(Seller_Details.bill_text_field_font);

          }
       }


       /* panel form ends*/

        /* panel add_btn starts*/

       panel_add_btn=new JPanel(null);
       panel_add_btn.setBounds(20, panel_form.getY()+panel_form.getHeight(), frame.getWidth()-40, 50);
       panel_add_btn.setBackground(Color.white);

       add=new JButton("Add");
       remove=new JButton("Remove");

       add.setBounds((panel_add_btn.getWidth()/2)-100, 0, 100, 30);
       remove.setBounds((panel_add_btn.getWidth()/2)+50, 0, 100, 30);
       
       panel_add_btn.add(add);
       panel_add_btn.add(remove);

       /* panel add_btn ends*/

       /*panel table starts*/
panel_table=new JPanel(null);
       panel_table.setBounds(20, panel_add_btn.getY()+panel_add_btn.getHeight(), frame.getWidth()-40, 260);
       panel_table.setBackground(Color.YELLOW);
       panel_table.setBackground(Color.white);
       table=new JTable();
       model = new DefaultTableModel()
        {

            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }
        };
        Object []column={"Sl.No.","Product Name","Product id","Hsn Code","Size","Unit_price","Quantity","total"};

        table.setModel(model);
        model.setColumnIdentifiers(column);
        table.setFillsViewportHeight(true);            // to use the entire hiegth of the scroll pane
         table.getColumnModel().getColumn(0).setPreferredWidth(0);

        scrpn=new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      	//scrpn.setFont(f);
         
	    scrpn.setBackground(Color.black);
    JPanel p1=new JPanel(new BorderLayout());
       p1.setBounds(20, 0,panel_table.getWidth()-40, panel_table.getHeight()-29);
        scrpn.setVisible(true);
        p1.add(scrpn,BorderLayout.CENTER);

panel_table.add(p1);
       /* panel table ends */
/*panel total table*/
total_table=new JTable();
model_tot = new DefaultTableModel()
        {

            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }

        };
        Object []column_tot={"Total "," ","","","","","Quantity","","","total"};

        total_table.setModel(model_tot);
        model_tot.setColumnIdentifiers(column_tot);
        total_table.setFillsViewportHeight(true);            // to use the entire hiegth of the scroll pane
      total_table.getColumnModel().getColumn(0).setPreferredWidth(0);
Object []data_tot={"","total_products","","","","","Total Quantity","Total_Payment"};
model_tot.addRow(data_tot);
column_tot[6]="150";
column_tot[9]="550";
total_table.setModel(model_tot);
total_table.setRowSelectionAllowed(false);
total_table.setTableHeader(null);
//total_table.setBounds(20, 210,table.getWidth(),50);
 tot_scrpn=new JScrollPane(total_table, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      	//scrpn.setFont(f);

	    tot_scrpn.setBackground(Color.black);
    panel_tot_table=new JPanel(new BorderLayout());
       panel_tot_table.setBounds(20, panel_table.getHeight()-30,panel_table.getWidth()-40, 30);
       total_table.setRowHeight(30);
       total_table.setShowGrid(false);
    
       total_table.setBorder(null);
       tot_scrpn.setBorder(null);
       panel_tot_table.setBorder(null);
        tot_scrpn.setVisible(true);
        panel_tot_table.add(tot_scrpn,BorderLayout.CENTER);


panel_table.add(panel_tot_table);
panel_submit=new JPanel();
panel_submit.setBounds(20, panel_table.getY()+panel_table.getHeight(), frame.getWidth()-40, 270);
panel_submit.setBackground(Color.white);
//panel_table.setBackground(Color.black);
submit=new JButton(new ImageIcon("img/edit_admin/submit.png"));
    submit.setBorder(null);
	cancel=new JButton(new ImageIcon("img/edit_admin/cancel.png"));
    cancel.setBorder(null);

    submit.setBounds((panel_submit.getWidth()/2)-100, 0, 100, 30);
       cancel.setBounds((panel_submit.getWidth()/2)+50, 0, 100, 30);

panel_submit.add(submit);
panel_submit.add(cancel);

        panel_bg.add(panel_submit);
        panel_bg.add(panel_table);
       panel_bg.add(panel_add_btn);
       panel_bg.add(panel_form);
        panel_bg.add(panel_firm);
frame.add(panel_bg);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        price_text.setEditable(false);
        cust_gst_text.setEditable(false);
        price_text.setBorder(invoice_text.getBorder());
        cust_gst_text.setBorder(invoice_text.getBorder());
        price_text.setBackground(Color.white);
        cust_gst_text.setBackground(Color.white);

        

        getBill_Details();
submit.addActionListener(this);
        cust_name_text.getEditor().getEditorComponent().addFocusListener(this);
name_text.addActionListener(this);
       percentage_text.addItemListener(this);
        name_text.getEditor().getEditorComponent().addFocusListener(this);
add.addActionListener(this);
remove.addActionListener(this);
name_text.addItemListener(this);
    }
    public static void main(String[] args) {
        new Bill_Form();
    }

 public void focusGained(FocusEvent e) {
      if(e.getSource()==cust_name_text.getEditor().getEditorComponent()){
          cust_gst_text.setEditable(true);
            cust_gst_text.setText("");
      }
    }


    public void itemStateChanged(ItemEvent e) {
        
       if(e.getSource()==percentage_text){
//           String abc=percentage_text.getSelectedItem().toString();
//           float tax=Float.parseFloat(price_text.getText())*((Float.parseFloat(abc)/2)/100);
//           //gsttaxt.setText(Float.toString(tax));
//           float totalvaluef=((tax)*2)+Float.parseFloat(price_text.getText().toString());
//           //totalt.setText(Float.toString(totalvaluef));

       }
       if(e.getSource()==name_text){
           System.out.println("item name_text changed");
           String item_name=name_text.getItemAt(name_text.getSelectedIndex()).toString();
           System.out.println("item name "+item_name);
           if(item_name==null)
           {

           }
           else
           {
          try{
              Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(Connection1.dbmanager, Connection1.root, Connection1.pass);

                if(con!=null){

                    PreparedStatement ps=con.prepareStatement("SELECT * FROM `product_item` WHERE `name`='"+item_name+"'");
                    ResultSet rs=ps.executeQuery();
                    System.out.println(ps);
                if(rs.next())
                {
//JOptionPane.showMessageDialog(null, "ps "+ps);
                 String prod_price=rs.getString("sp");
                    System.out.println("price "+prod_price);
                    price_text.setText(prod_price);
                    quantity_text.setText("1");
                    discount_text.setText("0");
                    frieght_text.setText("0");
                    System.out.println("gst "+rs.getString("gst").toString()+".0");
                    percentage_text.setSelectedItem(rs.getString("gst").toString());
                    max_dis=rs.getInt("disc");


                }
                else {
                        JOptionPane.showMessageDialog(null, "Select Correct Product");
                        name_text.requestFocus();

                }

        }
          }catch(Exception ex_name){
              System.out.println("exception "+ex_name);
          }
           }
        }
       
    }

    public void focusLost(FocusEvent e) {
      if(e.getSource()==cust_name_text.getEditor().getEditorComponent())
        {
            gst=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(Connection1.dbmanager, Connection1.root, Connection1.pass);
                String a=cust_name_text.getSelectedItem().toString();
                if(con!=null){

                    PreparedStatement ps=con.prepareStatement("select * FROM `gst` WHERE `Name` = '"+a+"'");
                    ResultSet rs=ps.executeQuery();
                    System.out.println(ps);
                    while(rs.next()){
                        gst=rs.getString(3);
                        mobile=rs.getString(4);
                        System.out.println("gst empty "+gst.isEmpty());
                    }
                    System.out.println("gst "+gst);
                       new_gst1(a);
                                           cust_gst_text.setText(gst);
                                           cust_phn_text.setText(mobile);
                        cust_gst_text.setEditable(false);
                        cust_gst_text.setFont(Seller_Details.gst_font);
                        cust_gst_text.setBackground(Color.white);




                }

            }catch(Exception exc){
                System.out.println(exc);
            }
        }
      /*if(e.getSource()==name_text.getEditor().getEditorComponent()){
          String item_name=name_text.getSelectedItem().toString();
          try{
              Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(Connection1.dbmanager, Connection1.root, Connection1.pass);

                if(con!=null){

                    PreparedStatement ps=con.prepareStatement("SELECT * FROM `product_item` WHERE `name`='"+item_name+"'");
                    ResultSet rs=ps.executeQuery();
                    System.out.println(ps);
                if(rs.next())
                {
                
                 String prod_price=rs.getString("sp");
                    System.out.println("price "+prod_price);
                    price_text.setText(prod_price);
                    quantity_text.setText("1");
                
                }
                else {
                        JOptionPane.showMessageDialog(null, "Select Correct Product");
                        name_text.requestFocus();
                    
                }
                }
          }catch(Exception item_name_ex)
          {
              System.out.println("item name exception "+item_name_ex);
          }

      }*/
    }


public void new_gst1(String a){
  
    if(gst==null)
                {

                   String new_gst= JOptionPane.showInputDialog(null, "Pls Enter The GST Number Of "+a, "New Gst Input", JOptionPane.INFORMATION_MESSAGE);
                   if(new_gst.isEmpty()){
                       JOptionPane.showMessageDialog(null, "GST Number Can not Be Blank");
                       new_gst1(a);

                   }
                   else
                   {
                      long mob=new_mob(a);
                       gst=new_gst;

                       try{
 Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                                  PreparedStatement st=con.prepareStatement("INSERT INTO `gst`(`Name`, `Gst_No`,`Mob_No`) VALUES (?,?,?)");
                                  st.setString(1, a.toUpperCase());
                                  st.setString(2, gst);
                                  st.setString(3, Long.toString(mob));
                                  st.executeUpdate();
                                  PreparedStatement ps=con.prepareStatement("select * from gst");
                                  ResultSet rs=ps.executeQuery();
String gst_check="";
                                  while(rs.next())
                                  {
                                  cust_id=rs.getInt("id");
                                  gst_check=rs.getString("Gst_No");

                                  }
if(!(gst_check.equals(gst))){
   JOptionPane.showMessageDialog(null, "Cannot Save New Gst ");
}


                       }
                       }
                       catch(Exception new_gst_ex)
                       {
                           JOptionPane.showMessageDialog(null, "Cannot Save New Gst "+new_gst_ex);
                           System.out.println("gst add exc "+new_gst_ex);
                       }
                     
                   }
                       }

}
public long new_mob(String a)
{
     mob_number=0;
    String new_mobile= JOptionPane.showInputDialog(null, "Pls Enter The Mobile Number Of "+a, "New Gst Input", JOptionPane.INFORMATION_MESSAGE);
                   if(new_mobile.isEmpty()){
                       JOptionPane.showMessageDialog(null, "Mobile Number Can not Be Blank");
                       new_mob(a);

                   }
                   else
                   {


     mob_number=Long.parseLong(new_mobile);
                   }
    return mob_number;
}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String product_list="",discount_list="",quantity_list="",gst_list="",price_list="";
            float total_val=0;
            for(int i=0;i<table.getRowCount();i++){
            product_list+=model.getValueAt(i, 2)+",";
            //discount_list=model.getValueAt(i, 9)+",";
            quantity_list+=model.getValueAt(i, 6)+",";
            //gst_list=model.getValueAt(i, 6)+",";
            price_list+=model.getValueAt(i, 4)+",";
            total_val+=Float.parseFloat(model.getValueAt(i, 7).toString());
                System.out.println("pl "+product_list);
                System.out.println("ql "+quantity_list);
                System.out.println("price l "+price_list);
                System.out.println("tot "+total_val);

            }
            //JOptionPane.showMessageDialog(null, cust_name_string);
            System.out.println("customer"+cust_name_string);
            if(cust_name_string==null){
            JOptionPane.showMessageDialog(null, Seller_Details.cust_empty_error);
        }
             else if((gst.isEmpty())||(cust_phno_string.isEmpty())){
                 JOptionPane.showMessageDialog(null, Seller_Details.cust_details_error);
           }
//           else if(Integer.parseInt(discount_string)>max_dis){
//               JOptionPane.showMessageDialog(null, "Discount Cannot Be Greater Than "+max_dis+"%");
//           }
            else {
            try{


                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
                        if(con!=null)
                            {
                                  PreparedStatement st=con.prepareStatement("INSERT INTO `billing`(`bill_no`, `date`, `time`, `cstno`, `gst_tax`, `products`, `quantity`, `disc`, `total`, `status`,`frieght`) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                                  st.setInt(1,Integer.parseInt(invoice_text.getText()));
                                  st.setString(2, date_text.getText().toString());
                                  st.setString(3, time_text.getText());
                                  st.setString(4,cust_gst_text.getText().toString());
                                  st.setString(5, percentage_text.getSelectedItem().toString());
                                  st.setString(6, product_list);
                                  st.setString(7, quantity_list);
                                  st.setString(8, discount_text.getText().toString());
                                  st.setString(9,Float.toString(total_val));
                                  st.setString(10, "True");
                                  st.setFloat(11,Float.parseFloat(frieght_text.getText().toString()));
                                  st.executeUpdate();
                                  System.out.println("st "+st);

                                  PreparedStatement ps=con.prepareStatement("select bill_no from billing where bill_no="+Integer.parseInt(invoice_text.getText()));
                                  System.out.println("ps "+ps);
                                  ResultSet rsbill=ps.executeQuery();
                                  int billcheck=0;
                                  if(rsbill.next()){
                                      JOptionPane.showMessageDialog(null, "Bill "+invoice_text.getText()+"Saved SuccessFully");
                                      frame.dispose();
                                      
                                      new billprint_2(Integer.parseInt(invoice_text.getText()));
                                  }
                                  else{
                                      JOptionPane.showMessageDialog(null, "Bill "+invoice_text.getText()+"Cannot Be Saved","OOPS",JOptionPane.WARNING_MESSAGE);
                                      new Bill_Form();
                                  }



                        }

            }catch(Exception bill_make)
            {
                JOptionPane.showMessageDialog(null, "Can Not Save A New Bill "+bill_make);
            }
            }
        }
       if(e.getSource()==add){
           System.out.println("name text"+name_text.getEditor().getItem().toString());
       
           invoice_string=invoice_text.getText().toString();
           date_string=date_text.getText().toString();
           time_string=time_text.getText().toString();
           product_name_string=sbm.return_input();
           price_string=price_text.getText().toString();
           discount_string=discount_text.getText().toString();
           quantity_string=quantity_text.getText().toString();
           tax_percentage_string=percentage_text.getSelectedItem().toString();
           friegt_string=frieght_text.getText().toString();
           cust_name_string=sbm1.return_input();
           cust_phno_string=cust_phn_text.getText().toString();
           System.out.println("pname"+product_name_string);
        if(product_name_string==null){
          
           JOptionPane.showMessageDialog(null, Seller_Details.item_name_empty_error);

           }
        else if((percentage_text.getSelectedItem().toString().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, Seller_Details.tax_percentage_empty_error);
        }
//        else 
        else if((invoice_string.isEmpty())||(date_string.isEmpty())||(time_string.isEmpty())){
               JOptionPane.showMessageDialog(null, Seller_Details.bill_details_error);
           }
           else if((price_string.isEmpty())||(quantity_string.isEmpty())||(discount_string.isEmpty()||(friegt_string.isEmpty()))){
               JOptionPane.showMessageDialog(null, Seller_Details.bill_products_error);
           }
//          
           else  {
                Float discount_rs= (Float.parseFloat(discount_string)*Float.parseFloat(price_string))/100;
               int sno=0;
                   int ctr=0,ctrr=0;
                   for(int i=0;i<check.size();i++)
                   {

                       if(name_text.getEditor().getItem().toString().equals(check.elementAt(i).toString()))
                       {
                           System.out.println("in check");
                        //  float disp=Float.parseFloat(model.getValueAt(i, 8).toString());
                          //  System.out.println("disp"+disp);
//                            int raten=Integer.parseInt(model.getValueAt(i, 4).toString());
//                           int ratep=Integer.parseInt(price_text.getText().toString());

                           //if((discount_rs==disp)){
                              
                           ctr=i;
                           ctrr=i==0?1:i;
                          // }

                       }
                   }

               


                    
                                        if(ctr==0&&ctrr==0)
                                        {
                                        add_table_item(name_text.getEditor().getItem().toString());
                                            
                                         Object ob[]=new Object[]{++sno,name_text.getEditor().getItem().toString(),id,hsn,size,price_text.getText().toString(),quantity_text.getText().toString(),Float.parseFloat(price_text.getText().toString())*Integer.parseInt(quantity_text.getText())};
                    model.addRow(ob);
                    check.add(name_text.getEditor().getItem().toString());

                    
                                        }
                                        else
                                        {

                                        int q=Integer.parseInt(model.getValueAt(ctr, 6).toString())+Integer.parseInt(quantity_text.getText());
                                            model.setValueAt(q, ctr, 6);
                                         float total=Float.parseFloat(model.getValueAt(ctr, 5).toString())*q;
          model.setValueAt(total, ctr, 7);


                                        }
                    }
                         }
                    


        }
        
    public void getBill_Details(){
  try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(Connection1.dbmanager, Connection1.root, Connection1.pass);
                if(con!=null){

                    PreparedStatement ps=con.prepareStatement("select * from billing");
                    ResultSet rs=ps.executeQuery();
                    System.out.println(ps);
                    int bno=0;
                    
                    while(rs.next()){
                         bno=rs.getInt("bill_no");
                        System.out.println("bill no "+bno);
                    }
                    
                    invoice_text.setText(Integer.toString(++bno));
                    date_text.setText(Seller_Details.timeStamp.substring(0, 10));
                    time_text.setText(Seller_Details.timeStamp.substring(11));
                    
}
  }catch(Exception bill_error){
      System.out.println("Bill Error "+bill_error);
  }
    }
  public void add_table_item(String product_name){
try{
      Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(Connection1.dbmanager, Connection1.root, Connection1.pass);
                if(con!=null){

                    PreparedStatement ps=con.prepareStatement("SELECT * FROM `product_item` WHERE `name`='"+name_text.getEditor().getItem()+"'");
                    ResultSet rs=ps.executeQuery();
                    System.out.println(ps);
                    
                    while(rs.next()){
                       hsn=rs.getString("hsn_code");
                       size=rs.getString("size");
                       id=rs.getString("prod_id");
                    }
                }
}catch(Exception product_table){
    System.out.println("Exception Product table "+product_table);
}
  }
}
