package fact;
import java.sql.*;
import java.util.*;
public class very_first_call
 {
        //String dbname=Connection1.dbadmin_name;
    String dbname="admins";
    String cata=null;
      //  String db[] = new String[20];
         ArrayList db = new ArrayList();
        int ctr=0;
public very_first_call()
{
        try
	{

    Class.forName("com.mysql.jdbc.Driver");       
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
    Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");


    ResultSet rs=con.getMetaData().getCatalogs();
    
    while(rs.next())
    {
        
                  cata=rs.getString(1);     
                  db.add(cata);
                  ctr++;
    }

    for( int i = 0; i <db.size(); i++)
{
         
            if(dbname.equals(db.get(i).toString()))
           {
               
           ctr=1;
           break;
            }
    }
            //if(ctr!=1)
        {
            System.out.println("In Else Part");
    Statement stmt = con.createStatement();
    String sql9="CREATE DATABASE IF NOT EXISTS "+Connection1.dbadmin_name;
            System.out.println(sql9);
    stmt.execute(sql9);      // creating the database for the admin
    stmt.execute("CREATE DATABASE IF NOT EXISTS "+Connection1.dbmanager_name);      // creating the database for the manager
    stmt.execute("CREATE DATABASE IF NOT EXISTS "+Connection1.dbemployee_name);
     con=DriverManager.getConnection(Connection1.dbadmin, Connection1.root, Connection1.pass);
     stmt = con.createStatement();
    String sql = "CREATE TABLE IF NOT EXISTS login_credentials " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " name VARCHAR(255), " +
                   " phone VARCHAR(255), " +
                   " username VARCHAR(255), " +
                   " password VARCHAR(20), " +
                   " security INTEGER(20), " +
                   " salary INTEGER(50), " +
                   " status VARCHAR(20), " +
                   " position VARCHAR(20), "+
                   " address VARCHAR(250), " +
                   " machine VARCHAR(250), " +
                   "GST_Number VARCHAR(50),"+
                   " PRIMARY KEY ( id,username ))";
                     stmt.execute(sql);
                 //   sql="INSERT INTO login_credentials VALUES(1,'admin','admin@abc.com','admin','admin','2',0,'Active','Admin','','','')";
    //System.out.println("TABLE DID NOT EXIT AND HENCE CREATED");
    stmt.execute(sql);


    con1=DriverManager.getConnection(Connection1.dbmanager,Connection1.root,Connection1.pass);
     stmt = con1.createStatement();



 sql = "CREATE TABLE IF NOT EXISTS product_group " +
         "(id INTEGER PRIMARY KEY not NULL AUTO_INCREMENT, " +
         " name TEXT(30), " +
         " gst TEXT(5), " +
         " symbol VARCHAR(10), " +
          " formal_name VARCHAR(20), " +
          " deci TEXT(5))" ;

                    stmt.execute(sql);
sql = "CREATE TABLE IF NOT EXISTS suppliers " +
        "(id INTEGER PRIMARY KEY not NULL AUTO_INCREMENT, " +
        " name TEXT(30), " +
        " address VARCHAR(50), " +
        " phone VARCHAR(20), " +
        "    gst VARCHAR(20), " +
        " products VARCHAR(50),"+
        "    remarks VARCHAR(20),"+
        " status VARCHAR(50))";

stmt.execute(sql);
//prod_id`,`name`,`grp_supp`,`company`, `size`, `quantity`,`cp`,`add_cost`,`sp`, `gst`, `disc`
sql = "CREATE TABLE IF NOT EXISTS product_item " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " prod_id VARCHAR(25), " +
                   " name VARCHAR(25), " +
                   " grp_supp VARCHAR(25), " +
                   " company VARCHAR(20), " +
                   " size VARCHAR(20), " +
                   " quantity INTEGER(50), " +
                   " cp INTEGER(20), " +
                   " add_cost INTEGER(20), "+
                   " sp INTEGER(50), " +
                   " gst FLOAT(20), " +
                   " disc INTEGER(20), "+
                   " sold_quant INTEGER(50), " +
                   "hsn_code VARCHAR(5),"+
                   " PRIMARY KEY ( id ))";
                     stmt.execute(sql);

                     sql = "CREATE TABLE IF NOT EXISTS gst " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " Name VARCHAR(100), " +
                   " Gst_No VARCHAR(25), " +
                   " Mob_No VARCHAR(12), " +
                   " PRIMARY KEY ( id ))";
stmt.execute(sql);

  sql = "CREATE TABLE IF NOT EXISTS stock_entry " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " date VARCHAR(25), " +
                   " prod_id VARCHAR(25), " +
                   " quantity INTEGER(50), " +
                   " cp INTEGER(20), " +
                   " add_cost INTEGER(20), "+
                   " sp INTEGER(50), " +
                   " gst INTEGER(20), " +
                   " disc INTEGER(20), "+
                   " PRIMARY KEY ( id ))";
                     stmt.execute(sql);

                     sql = "CREATE TABLE IF NOT EXISTS billing " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                    "bill_no Integer(10),"+
                   " date VARCHAR(25), " +
                   " time VARCHAR(25), " +
                   " cstno VARCHAR(20), "+
                   "gst_tax VARCHAR(20), "+
                   " products VARCHAR(50), " +
                   " quantity VARCHAR(20), " +
                   " disc VARCHAR(20), "+
                   " total VARCHAR(20), "+
                   "status VARCHAR(10)," +
                   "frieght FLOAT(20) NOT NULL,"+
                   " PRIMARY KEY ( id ))";
                     stmt.execute(sql);
                     System.out.println("billing"+sql);

                   sql = "CREATE TABLE IF NOT EXISTS customer " +
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " name VARCHAR(25), " +
                   " phone INTEGER(25), " +
                   " PRIMARY KEY ( id ))";
                     stmt.execute(sql);
con2=DriverManager.getConnection(Connection1.dbemployee, Connection1.root, Connection1.pass);
     stmt = con2.createStatement();
                    sql = "CREATE TABLE IF NOT EXISTS  `"+Calendar.getInstance().get(Calendar.YEAR) +"`"+
                   "(id INTEGER not NULL AUTO_INCREMENT, " +
                   " January VARCHAR(900), " +
                   " February VARCHAR(900), " +
                   " March VARCHAR(900), " +
                   " April VARCHAR(900), " +
                   " June VARCHAR(900), " +
                   " July VARCHAR(900), " +
                   " August VARCHAR(900), " +
                   " September VARCHAR(900), " +
                   " October VARCHAR(900), " +
                   " November VARCHAR(900), " +
                   " December VARCHAR(900), " +
                   " PRIMARY KEY ( id ))";
                    System.out.println(sql);
                    stmt.execute(sql);

        }  // end of if

	     }     // end of try block
        catch(Exception exception)
	{
        exception.printStackTrace();
		System.out.println(exception);
	}
}
}
