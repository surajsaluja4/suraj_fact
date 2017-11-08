/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fact;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author suraj
 */
public class Seller_Details {

    public static final String GST_No="GSTIN:06AB123JHDGAAH";
    public static final String Firm_Name="VINOD FABRICS";
    public static final String Mob1="MOB1:+919812075551";
    public static final String Mob2="MOB2:+9215675551";
    public static final String Firm_address="Gali No. 2 Babail Road";
    public static final String Firm_address2="Panipat 132103 (Haryana)";
    public static final String speciality="Manufacturers And Traders : All Kind Of Bedsheets";
    public static final String logo_image="img/main/LOGO_BILL1.png";
    public static final String owner_name="Vinod Kumar";
    public static final String Customer_heading="Customer Details";
    public static final String Transport_heading="Transport Details";
    public static Font firm_font=new Font("Lucida Handwriting",Font.BOLD, 30);
    public static Color logo_bg=Color.WHITE;
    public static final String product_sr_heading="Sr.No";
    public static final String product_name_heading="Product Name";
    public static final String product_hsn_heading="HSN";
    public static final String product_unit_heading="Unit Price";
    public static final String product_qty_heading="Quantity";
    public static final String product_amount_heading="Amount";
    public static final String bank_Details="Bank Details";
    public static final String bank_name1="Bank Name : HDFC BANK";
    public static final String bank_acc1="A/C No. : 0111111111111111";
    public static final String bank_name2="Bank Name : HDFC BANK";
    public static final String bank_acc2="A/C No. : 0111111111111111";
    public static final String bank_name3="Bank Name : HDFC BANK";
    public static final String bank_acc3="A/C No. : 0111111111111111";
    public static final String discount="Discount @ xyz%age";
    public static final String total_value="Total Amount";
    public static final String frieght="Frieght (If Any)";
    public static final String gross="Total Gross Discount";
    public static final String sgst="SGST@ xyz%age";
    public static final String cgst="CGST@ xyz%age";
    public static final String igst="IGST@ xyz%age";
    public static final String round="Round Off";
    public static final String grand_total="Grand Total";
    public static final String amt_words="Ammount Words";
   public static Font bill_text_field_font=new Font("Lucida Handwriting",Font.BOLD, 20);
   public static Font bill_label_font=new Font("Lucida Handwriting",Font.BOLD, 20);
   public static Font gst_font=new Font("",Font.PLAIN, 15);
   public static int bill_textfield_space=50;
   public static int bill_label_space=0;
   public static int bill_left_space_label=50;
   public static int bill_left_space_text_field=30;
   public static String bill_details_error="Bill Details  Can  Not Be Empty";
   public static String bill_products_error="Product Details  Can  Not Be Empty";
   public static String cust_details_error="Customer Details  Can  Not Be Empty";
 public static String item_name_empty_error="Select Atleast One Product";
 public static String tax_percentage_empty_error="Select Tax Percentage";
public static String cust_empty_error="Select Atleast One Customer";
public static String timeStamp = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(Calendar.getInstance().getTime());




}
