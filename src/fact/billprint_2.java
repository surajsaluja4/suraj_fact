/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.sql.*;
import java.text.DecimalFormat;

/**
 *
 * @author suraj
 */
public class billprint_2 {

    JLabel GSTNo,Mob1,Mob2,Logo,Firm_Name,Address,Address2,Date,Specialty,Customer_Name,Customer_GST,Customer_Address,Customer_Number,Invoice_Number,Cust_Details,Amt_words;
Float total_amt=0.0f,dis_percentage=0.0f,friegt_val=0.0f,cgst_val=0.0f,sgst_val=0.0f,igst_val=0.0f,gross=0.0f,round_val=0.0f,amt_pay_val=0.0f;
    JLabel owner_name_signature,signauture_firm_name,amt_word_value;
    JLabel SrNO,Products_Name,Product_Hsn,Product_Quantity,Product_Rate,Product_Amount,Total_Value,Sgst_Tax,Cgst_Tax,Igst_Tax,Roundoff_value,Grand_Total,Discount,GrossDiscount,Tot_Freight;
    JLabel transport_Details,Transport_Mode,Vehicle_Number,Transport_GrNumber,Transport_place,Bank_Details,Bank_Name1,Bank_Acc1,Bank_Name2,Bank_Acc2,Bank_Name3,Bank_Acc3;
    JLabel Srnos[],Product_Names[],Product_Hsns[],Product_Quantitys[],Product_Rates[],Product_Amounts[];
    JPanel panel_firmdetail,panel_custdetail,panel_products,panel_values,panel_signature,panel_transport,panel_productheading,panel_Bank,panel_amt_word,panel_print;
JLabel tot_val_label,discount_value_label,frieght_value_label,sgst_label,gross_value_label,cgst_value_label,total_value_label,igst_value_label,round_value_label;
    JFrame frame;
    String amt_word;

    DecimalFormat df2=new DecimalFormat("#.##");
static int row_table,billno;
    public billprint_2(int bno) {
        billno=bno;
        setrows();
        
        frame=new JFrame("Billing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setUndecorated(true);
       //frame.setLocation(200, 20);
        frame.setSize(550, 842);
        frame.setBackground(Color.white);

        //Panel Firm Details
        //width:frame_width
        //height:200

        panel_firmdetail=new JPanel(null);
        panel_firmdetail.setBounds(0, 0, frame.getWidth(),200);
        panel_firmdetail.setBackground(Color.white);

        GSTNo=new JLabel(Seller_Details.GST_No);
        Mob1=new JLabel(Seller_Details.Mob1);
        Mob2=new JLabel(Seller_Details.Mob2);
        Firm_Name=new JLabel(Seller_Details.Firm_Name);
        Address=new JLabel(Seller_Details.Firm_address);
        Address2=new JLabel(Seller_Details.Firm_address2);
        Specialty=new JLabel(Seller_Details.speciality);
        Logo=new JLabel(new ImageIcon(Seller_Details.logo_image));
        Date=new JLabel("Date : 10/08/2017");
        Invoice_Number=new JLabel("Invoice Number : "+billno);

        GSTNo.setBounds(10, 10, 200, 50);
        Mob1.setBounds(frame.getWidth()-150, 20, 150, 20);
        Mob2.setBounds(frame.getWidth()-150, 40, 150, 20);
        Firm_Name.setBounds((frame.getWidth()/2)-150, 50, 300, 50);
        Specialty.setBounds((frame.getWidth()/2)-150, 100, 300, 30);
        Address.setBounds((frame.getWidth()/2)-90, 130, 180,30);
        Address2.setBounds((frame.getWidth()/2)-100, 150, 200, 30);
        Logo.setBounds(10, 50, 100, 100);
        Invoice_Number.setBounds(10, 160, 150, 20);
        Date.setBounds(frame.getWidth()-150, 160, 150, 20);


        Firm_Name.setFont(Seller_Details.firm_font);
        Logo.setBackground(Seller_Details.logo_bg);
        panel_firmdetail.add(GSTNo);
        panel_firmdetail.add(Mob1);
        panel_firmdetail.add(Mob2);
        panel_firmdetail.add(Firm_Name);
        panel_firmdetail.add(Specialty);
        panel_firmdetail.add(Address);
        panel_firmdetail.add(Address2);
        panel_firmdetail.add(Logo);
        panel_firmdetail.add(Date);
        panel_firmdetail.add(Invoice_Number);

        panel_firmdetail.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.BLACK));
        panel_custdetail=new JPanel(null);
        Cust_Details=new JLabel(Seller_Details.Customer_heading);
        Customer_Name=new JLabel("Customer Name : ");
        Customer_Address=new JLabel("Customer Address : ");
        Customer_GST=new JLabel("Customer GSTIN : ");
        Customer_Number=new JLabel("Customer Number : ");

        Cust_Details.setBounds(10, 10, (frame.getWidth()/2)-20, 20);
        Customer_Name.setBounds(10, 30, (frame.getWidth()/2)-20, 20);
        Customer_Address.setBounds(10, 50, (frame.getWidth()/2)-20, 20);
        Customer_Number.setBounds(10, 70, (frame.getWidth()/2)-20, 20);
        Customer_GST.setBounds(10, 90, (frame.getWidth()/2)-20, 20);

        panel_custdetail.add(Cust_Details);
        panel_custdetail.add(Customer_Name);
        panel_custdetail.add(Customer_GST);
        panel_custdetail.add(Customer_Number);
        panel_custdetail.add(Customer_Address);


        panel_custdetail.setBounds(0, 200, frame.getWidth()/2, 110);
        panel_custdetail.setBackground(Color.white);
        panel_custdetail.setBorder(BorderFactory.createMatteBorder(0,1, 1, 1, Color.BLACK));
       



        panel_transport=new JPanel(null);
        transport_Details=new JLabel(Seller_Details.Transport_heading);
        Transport_Mode=new JLabel("Transport Mode : ");
        Transport_GrNumber=new JLabel("GL Number : ");
        Transport_place=new JLabel("Transport Place : ");
        Vehicle_Number=new JLabel("Vehicle Number : ");

        transport_Details.setBounds(10, 10, (frame.getWidth()/2)-20, 20);
        Transport_Mode.setBounds(10, 30, (frame.getWidth()/2)-20, 20);
        Transport_place.setBounds(10, 50, (frame.getWidth()/2)-20, 20);
        Vehicle_Number.setBounds(10, 70, (frame.getWidth()/2)-20, 20);
        Transport_GrNumber.setBounds(10, 90, (frame.getWidth()/2)-20, 20);

        panel_transport.add(transport_Details);
        panel_transport.add(Transport_Mode);
        panel_transport.add(Transport_place);
        panel_transport.add(Vehicle_Number);
        panel_transport.add(Transport_GrNumber);

        panel_transport.setBounds(frame.getWidth()/2,200 , frame.getWidth()/2, 110);
        panel_transport.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        panel_transport.setBackground(Color.white);


        panel_productheading=new JPanel(null);
        SrNO=new JLabel(Seller_Details.product_sr_heading);
        Products_Name=new JLabel(Seller_Details.product_name_heading);
        Product_Hsn=new JLabel(Seller_Details.product_hsn_heading);
        Product_Quantity=new JLabel(Seller_Details.product_qty_heading);
        Product_Rate=new JLabel(Seller_Details.product_unit_heading);
        Product_Amount=new JLabel(Seller_Details.product_amount_heading);

        SrNO.setBounds(15, 0, 50, 20);
        Products_Name.setBounds(65, 0, 100, 20);
        Product_Hsn.setBounds(frame.getWidth()-350, 0, 50, 20);
        Product_Quantity.setBounds(frame.getWidth()-275, 0, 75, 20);
        Product_Rate.setBounds(frame.getWidth()-200, 0, 100, 20);
        Product_Amount.setBounds(frame.getWidth()-100, 0, 100, 20);

        panel_productheading.add(SrNO);
        panel_productheading.add(Products_Name);
        panel_productheading.add(Product_Hsn);
        panel_productheading.add(Product_Quantity);
        panel_productheading.add(Product_Rate);
        panel_productheading.add(Product_Amount);


        panel_productheading.setBounds(0, 310, frame.getWidth(), 20);
        panel_productheading.setBackground(Color.white);
        panel_productheading.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));

        panel_products=new JPanel(null);
panel_products.setBounds(0, 330, frame.getWidth(),170);
panel_products.setBackground(Color.white);
panel_products.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black));



panel_Bank=new JPanel(null);
panel_Bank.setBackground(Color.WHITE);
panel_Bank.setBounds(0, 500, (frame.getWidth()/2)-100, 110);
panel_Bank.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));

Bank_Details=new JLabel(Seller_Details.bank_Details);
Bank_Name1=new JLabel(Seller_Details.bank_name1);
Bank_Acc1=new JLabel(Seller_Details.bank_acc1);
Bank_Name2=new JLabel(Seller_Details.bank_name2);
Bank_Acc2=new JLabel(Seller_Details.bank_acc2);
Bank_Name3=new JLabel(Seller_Details.bank_name3);
Bank_Acc3=new JLabel(Seller_Details.bank_acc3);

Bank_Details.setBounds(10, 10, (frame.getWidth()/2)-100, 20);
Bank_Name1.setBounds(10, 30, (frame.getWidth()/2)-100, 20);
Bank_Acc1.setBounds(10, 50, (frame.getWidth()/2)-100, 20);
Bank_Name2.setBounds(10, 70, (frame.getWidth()/2)-100, 20);
Bank_Acc2.setBounds(10, 90, (frame.getWidth()/2)-100, 20);
Bank_Name3.setBounds(10, 110,(frame.getWidth()/2)-100, 20);
Bank_Acc3.setBounds(10, 130,(frame.getWidth()/2)-100, 20);

panel_Bank.add(Bank_Details);
panel_Bank.add(Bank_Name1);
panel_Bank.add(Bank_Acc1);
panel_Bank.add(Bank_Name2);
panel_Bank.add(Bank_Acc2);
//panel_Bank.add(Bank_Name3);
//panel_Bank.add(Bank_Acc3);

panel_amt_word=new JPanel(null);;
panel_amt_word.setBackground(Color.WHITE);
panel_amt_word.setBounds(0, 610, (frame.getWidth()/2)-100, 90);
panel_amt_word.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));

Amt_words=new JLabel(Seller_Details.amt_words);
Amt_words.setBounds(10, 0, panel_amt_word.getWidth(),10);
amt_word_value=new JLabel("one Hundred Only",SwingConstants.RIGHT);
amt_word_value.setVerticalTextPosition(SwingConstants.TOP);
amt_word_value.setBounds(10, 20, panel_amt_word.getWidth()-20, panel_amt_word.getHeight()-20);

panel_amt_word.add(Amt_words);
panel_amt_word.add(amt_word_value);

panel_values=new JPanel(null);
panel_values.setBackground(Color.WHITE);
panel_values.setBounds(frame.getWidth()/2-100, 500, (frame.getWidth()/2)+100, 200);
panel_values.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));

Total_Value=new JLabel(Seller_Details.total_value);
Discount=new JLabel(Seller_Details.discount);
Tot_Freight=new JLabel(Seller_Details.frieght);
GrossDiscount=new JLabel(Seller_Details.gross);
Sgst_Tax=new JLabel(Seller_Details.sgst);
Cgst_Tax=new JLabel(Seller_Details.cgst);
Igst_Tax=new JLabel(Seller_Details.igst);
Roundoff_value=new JLabel(Seller_Details.round);
Grand_Total=new JLabel(Seller_Details.grand_total);

Total_Value.setBounds(10, 10,panel_values.getWidth()/2, 20);
Discount.setBounds(10, 30,panel_values.getWidth()/2, 20);
Tot_Freight.setBounds(10, 50,panel_values.getWidth()/2, 20);
GrossDiscount.setBounds(10, 70,panel_values.getWidth()/2, 20);
Sgst_Tax.setBounds(10, 90,panel_values.getWidth()/2, 20);
Cgst_Tax.setBounds(10, 110,panel_values.getWidth()/2, 20);
Igst_Tax.setBounds(10, 130,panel_values.getWidth()/2, 20);
Roundoff_value.setBounds(10, 150, panel_values.getWidth()/2, 20);
Grand_Total.setBounds(10, 170, panel_values.getWidth()/2, 20);

tot_val_label=new JLabel("0.00",SwingConstants.RIGHT);
discount_value_label=new JLabel("0.00",SwingConstants.RIGHT);
frieght_value_label=new JLabel("0.00",SwingConstants.RIGHT);
gross_value_label=new JLabel("0.00",SwingConstants.RIGHT);
sgst_label=new JLabel("0.00",SwingConstants.RIGHT);
cgst_value_label=new JLabel("0.00",SwingConstants.RIGHT);
igst_value_label=new JLabel("0.00",SwingConstants.RIGHT);
round_value_label=new JLabel("0.00",SwingConstants.RIGHT);
total_value_label=new JLabel("0.00",SwingConstants.RIGHT);

tot_val_label.setBounds(panel_values.getWidth()-150, 10, 130, 20);
discount_value_label.setBounds(panel_values.getWidth()-150, 30, 130, 20);
frieght_value_label.setBounds(panel_values.getWidth()-150, 50, 130, 20);
gross_value_label.setBounds(panel_values.getWidth()-150, 70, 130, 20);
sgst_label.setBounds(panel_values.getWidth()-150, 90, 130, 20);
cgst_value_label.setBounds(panel_values.getWidth()-150, 110, 130, 20);
igst_value_label.setBounds(panel_values.getWidth()-150, 130, 130, 20);
round_value_label.setBounds(panel_values.getWidth()-150, 150, 130, 20);
total_value_label.setBounds(panel_values.getWidth()-150, 170, 130, 20);


panel_values.add(Total_Value);
panel_values.add(Discount);
panel_values.add(Tot_Freight);
panel_values.add(GrossDiscount);
panel_values.add(Sgst_Tax);
panel_values.add(Cgst_Tax);
panel_values.add(Igst_Tax);
panel_values.add(Roundoff_value);
panel_values.add(Grand_Total);
panel_values.add(tot_val_label);
panel_values.add(discount_value_label);
panel_values.add(frieght_value_label);
panel_values.add(gross_value_label);
panel_values.add(sgst_label);
panel_values.add(cgst_value_label);
panel_values.add(igst_value_label);
panel_values.add(round_value_label);
panel_values.add(total_value_label);

panel_print=new JPanel();
panel_print.setBounds(frame.getWidth(), 300, 400, 600);
panel_print.setBackground(Color.white);


panel_signature=new JPanel(null);
panel_signature.setBounds(0,700,frame.getWidth(),150);
panel_signature.setBackground(Color.white);

owner_name_signature=new JLabel(Seller_Details.owner_name);
signauture_firm_name=new JLabel("For "+" "+Seller_Details.Firm_Name);

owner_name_signature.setBounds(frame.getWidth()-150, 50, 150, 20);
signauture_firm_name.setBounds(frame.getWidth()-170, 10, 150, 20);

panel_signature.add(owner_name_signature);
panel_signature.add(signauture_firm_name);
setdata();
 JButton printButton = new JButton("Print This Window");
        printButton.addActionListener(new PrintUIWindow(frame));
        printButton.setBounds(200,100,100,30);

        panel_products.add(printButton);


        frame.add(panel_signature);
        frame.add(panel_print);
        frame.add(panel_amt_word);
        frame.add(panel_Bank);
        frame.add(panel_values);
        frame.add(panel_products);
        frame.add(panel_productheading);
        frame.add(panel_custdetail);
        frame.add(panel_transport);
        frame.add(panel_firmdetail);

        frame.setVisible(true);
    }
    public static void setrows(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
             if(con!=null){
            String sql="SELECT * FROM `billing` where bill_no="+billno;
                 System.out.println("===");
                 System.out.println("sql"+sql);
            PreparedStatement ps=con.prepareStatement(sql);
                 System.out.println("ps get row"+ps);
            ResultSet rs=ps.executeQuery();
int i=0;
            while(rs.next()){
                String[] pq=rs.getString("products").split(",");
                for(String p:pq){

                    System.out.println("p"+p);
                }

        row_table=pq.length;
                System.out.println("rows "+row_table);
            }

             }

    }catch(Exception get_row_ex){
            System.out.println("row exception "+get_row_ex);
    }


    }
   
    
    public void setdata(){
        
        System.out.println("Inside Set Data "+row_table);

         Srnos=new JLabel[row_table];
        Product_Names=new JLabel[row_table];
        Product_Hsns=new JLabel[row_table];
        Product_Quantitys=new JLabel[row_table];
        Product_Rates=new JLabel[row_table];
        Product_Amounts=new JLabel[row_table];

        for(int i=0;i<row_table;i++){

            Srnos[i]=new JLabel(Integer.toString(1));

            Product_Names[i]=new JLabel();
            Product_Hsns[i]=new JLabel();
           
            Product_Quantitys[i]=new JLabel();
            Product_Rates[i]=new JLabel();
        }
            get_bill_details();
//            float amt=Float.parseFloat(Product_Quantitys[i].getText().toString())*Float.parseFloat(Product_Rates[i].getText().toString());
//            System.out.println("i "+i);
      
for(int i=0;i<row_table;i++){
    Product_Amounts[i]=new JLabel(Float.toString(Integer.parseInt(Product_Quantitys[i].getText())*Float.parseFloat(Product_Rates[i].getText())));
            total_amt+=Float.parseFloat(Product_Amounts[i].getText());
    Srnos[i].setBounds(15, i*20, 50, 20);
        Product_Names[i].setBounds(65, i*20, 100, 20);
        Product_Hsns[i].setBounds(frame.getWidth()-350, i*20, 50, 20);
        Product_Quantitys[i].setBounds(frame.getWidth()-275, i*20, 75, 20);
        Product_Rates[i].setBounds(frame.getWidth()-200, i*20, 100, 20);
        Product_Amounts[i].setBounds(frame.getWidth()-100, i*20, 100, 20);

        panel_products.add(Srnos[i]);
        panel_products.add(Product_Names[i]);
        panel_products.add(Product_Hsns[i]);
        panel_products.add(Product_Quantitys[i]);
        panel_products.add(Product_Rates[i]);
        panel_products.add(Product_Amounts[i]);
        }

        calculate();
        }
    public void calculate()
    {
        tot_val_label.setText(total_amt.toString());
        float dis_val=(dis_percentage*total_amt)/100;
        discount_value_label.setText(Float.toString(dis_val));
        float gross_val=total_amt+friegt_val-dis_val;
        gross_value_label.setText(Float.toString(gross_val));
        float tax_vals=(sgst_val*gross_val)/100;
        sgst_label.setText(Float.toString(tax_vals));
        cgst_value_label.setText(Float.toString(tax_vals));
        Float tot=gross_val+tax_vals+tax_vals;
        int round_tot=Math.round(tot);

        round_value_label.setText(Float.toString(Float.valueOf(df2.format(round_tot-tot))));
        total_value_label.setText(Float.toString(round_tot));
        amt_word_value.setText("<html>"+NumberToString.NumberConvert(round_tot).toUpperCase()+" ONLY"+"</html>");

        

        

    }
    public void get_bill_details(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
             if(con!=null){
            String sql="SELECT * FROM `billing` where bill_no="+billno;
                 System.out.println("sql"+sql);
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
int i=0;
            while(rs.next()){
                //data[0]=++i;
                //System.out.println("rs 1"+rs.getInt(1));
               // data[1]=rs.getInt("id");
                //System.out.println("rs 1"+rs.getString(2));
                Date.setText("Date : "+rs.getString("date"));
dis_percentage=Float.valueOf(df2.format(Float.parseFloat(rs.getString("disc"))));
                System.out.println("discount "+dis_percentage);
                Discount.setText(Seller_Details.discount.replace("xyz",dis_percentage.toString() ));

friegt_val=Float.valueOf(df2.format(rs.getFloat("frieght")));
frieght_value_label.setText(Float.toString(friegt_val));
float percentage_tax=Float.parseFloat(rs.getString("gst_tax"));
Sgst_Tax.setText(Seller_Details.sgst.replace("xyz", Float.toString(percentage_tax/2)));
Cgst_Tax.setText(Seller_Details.cgst.replace("xyz", Float.toString(percentage_tax/2)));
sgst_val=cgst_val=percentage_tax/2;
String gst_cust=rs.getString("cstno");
Customer_GST.setText("Customer GSTIN : "+gst_cust);
 PreparedStatement cust=con.prepareStatement("SELECT * FROM `gst` WHERE `Gst_No`='"+gst_cust+"'");
                System.out.println("cust"+cust);
 ResultSet rs_cust=cust.executeQuery();
 while(rs_cust.next()){
     String cust_name=rs_cust.getString("Name");
     Customer_Name.setText(Customer_Name.getText()+cust_name);
     String cust_phn=rs_cust.getString("Mob_No");
     Customer_Number.setText(Customer_Number.getText()+cust_phn);
     Customer_Address.setText(Customer_Address.getText()+"Panipat");
 }
//                System.ofrieghtut.println("rs 1"+rs.getString(3));
                //data[3]=rs.getString("time");
//                System.out.println("rs 1"+rs.getLong(4));
                //data[4]=rs.getLong("cstno");
//                System.out.println("rs 5"+rs.getString(5));
                //data[5]=rs.getString("custname");
//                System.out.println("rs 5"+rs.getString(6));
                String products=rs.getString("products");
int k=0;
                    int m=1;
                float total_val=0;
                String[] s=products.split(",");
                for(String product:s){

                    System.out.println("product "+product);
                    String sql1="SELECT * FROM `product_item` where prod_id=\""+product+"\"";
                    System.out.println("sql query "+sql1);
                    PreparedStatement productquery=con.prepareStatement(sql1);
                    ResultSet pr=productquery.executeQuery();
                    
                    while(pr.next()){
                        Srnos[k].setText(Integer.toString(m));
                        Product_Names[k].setText(pr.getString("name"));
            Product_Hsns[k].setText(pr.getString("hsn_code"));
                        System.out.println("k"+k+pr.getString("name"));
            
            Product_Rates[k].setText(Integer.toString(pr.getInt("sp")));
            k++;
            m++;
                        
                    }
                }
                
//                System.out.println("rs 5"+rs.getString(8));
                String []quant=rs.getString("quantity").split(",");
                int l=0;
                for(String quantity:quant){
                    Product_Quantitys[l].setText(quantity);
                    l++;
                }
                
            }
             }


        } catch (Exception ex) {
            System.out.println("exception get bill details"+ex);
        }


    }
    public static void main(String[] args) {
        new billprint_2(11);
    }

    


}
