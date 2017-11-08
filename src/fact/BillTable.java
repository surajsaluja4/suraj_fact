/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author suraj
 */
public class BillTable {
JFrame frame;
JPanel panelscroll,panelback,panel;
JTable table;
JScrollPane sp;
DefaultTableModel model;
Object []column=new Object[14];
Object []data=new Object[14];
static JFrame frameselected;
static String getselected;

Font f10=new Font("Times New Roman",Font.PLAIN, 20);
    public BillTable() {
        frame=new JFrame();
        panel=new JPanel(null);
        panelback=new JPanel();
        panelback.setLayout(new BorderLayout());
        panelscroll=new JPanel();
        panel.setBackground(Color.white);
        panelscroll.setPreferredSize(new Dimension(screensize.width(), 300));
        panelscroll.setBackground(Color.white);
        table();
        JLabel lb=new JLabel("hsh");
        panelscroll.add(lb);
        //panelscroll.add(table);

        sp=new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setBorder(null);
        panelback.add(sp);
        panelback.setBounds(30, 100, screensize.width()-100, screensize.hieght()-250);
        panel.add(panelback);
        frame.add(panel);
        frame.setSize(screensize.width(), screensize.hieght()-100);
        frame.setVisible(true);

    }
    public void create_table(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
             if(con!=null){
            String sql="SELECT * FROM `billing` where status='true'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
int i=0;
            while(rs.next()){
                data[0]=++i;
                //System.out.println("rs 1"+rs.getInt(1));
                data[1]=rs.getInt("id");
                //System.out.println("rs 1"+rs.getString(2));
                data[2]=rs.getString("date");
//                System.out.println("rs 1"+rs.getString(3));
                data[3]=rs.getString("time");
//                System.out.println("rs 1"+rs.getLong(4));
                data[4]=rs.getLong("cstno");
//                System.out.println("rs 5"+rs.getString(5));
                data[5]=rs.getString("gst_tax");
//                System.out.println("rs 5"+rs.getString(6));
                String products=rs.getString("products");
                String allproducts="<html>";
                String prodsize="<html>";
                String prodquant="<html>";
                String proddis="<html>";
                String sp="<html>";
                String total2="<html>";
                float total_val=0;
                float tot_f=0;
                String[] s=products.split(",");
                for(String product:s){

                    System.out.println("product "+product);
                    String sql1="SELECT * FROM `product_item` where prod_id=\""+product+"\"";
                    System.out.println("sql query "+sql1);
                    PreparedStatement productquery=con.prepareStatement(sql1);
                    ResultSet pr=productquery.executeQuery();
                    while(pr.next()){
                        allproducts+=pr.getString("name")+"<br>";
                        prodsize+=pr.getString("size")+"<br>";
                        sp+=pr.getString("sp")+"<br>";
                        tot_f=tot_f+Float.parseFloat(pr.getString("sp"));

                    }
                    System.out.println("Total Value "+tot_f);
                }
                data[5]=allproducts+"</html>";

//                System.out.println("rs 5"+rs.getString(7));
                data[6]=prodsize+"</html>";
//                System.out.println("rs 5"+rs.getString(8));
                String[] quant=rs.getString("quantity").split(",");
                for(String quantity:quant){
                    prodquant+=quantity+"<br>";
                }
                data[7]=prodquant+"</html>";
                data[8]=sp+"</html>";
//                String[] dis=rs.getString("disc").split(",");
//                for(String discount:dis){
//                    proddis+=discount+"<br>";
//                }
                
                String[] totals=rs.getString("total").split(",");
                for(String tot:totals){
                    total2+=tot+"<br>";
                    total_val+=Float.parseFloat(tot);
                }
                Float tot_db=Float.parseFloat(rs.getString("total"));
                float dis=Float.parseFloat(rs.getString("disc"));
                data[9]=(dis*tot_db)/100;
                data[10]=tot_db-Float.parseFloat(data[9].toString());
                data[11]=rs.getString("frieght");
                data[12]=(Float.parseFloat(rs.getString("gst_tax"))*Float.parseFloat(data[10].toString())/100);
                data[13]=Float.parseFloat(data[10].toString())+Float.parseFloat(data[11].toString())+Float.parseFloat(data[12].toString());
                model.addRow(data);
            }
             }


        } catch (Exception ex) {
            System.out.println("exception create table"+ex);
        }

    }
    public void table(){
        try{
        
        column[0]="Sr.No.";
    column[1]="Bill Number";
    column[2]="Bill Date";
    column[3]="Bill Time";
    column[4]="Customer Number";
    column[5]="Items";
    column[6]="Size";
    column[7]="Quantity";
    column[8]="Unit Price";
    column[9]="Discount";
    column[10]="Taxable value";
   column[11]="Frieght";
  column[12]="Tax";
        model = new DefaultTableModel()
        {

            @Override
 public boolean isCellEditable(int row, int column) {
        return false;
    }

        };


        table=new JTable();
        table.setModel(model);
        model.setColumnIdentifiers(column);
        table.setFillsViewportHeight(true);
        table.setFont(f10);
        create_table();
        updateRowHeights();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateRowHeights()
{
    for (int row = 0; row < table.getRowCount(); row++)
    {
        int rowHeight = table.getRowHeight();

        for (int column = 0; column < table.getColumnCount(); column++)
        {
            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
            rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
        }

        table.setRowHeight(row, rowHeight);
    }
}
    public void getTabledata(){

    }
    public static void getkey(String k){
        getselected=k;
    }
    public void getFrame(JFrame f){
        frameselected=f;
    }
    public static void main(String[] args) {
        new BillTable();
    }

}
