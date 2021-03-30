
package db;
import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement insertClient;
    public static PreparedStatement getClient;
    public static PreparedStatement updateClient;
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection(
   "jdbc:mysql://localhost:3306/clientsol11", "root","incapp");
            st=c.createStatement();
            insertClient=c.prepareStatement("insert into "
      + "client_info (name,gender,dob,country,address,"
                    + "language) values (?,?,?,?,?,?)");
            getClient=c.prepareStatement("select * from "
      + "client_info where name like ?");
            updateClient=c.prepareStatement("update client_info  "
 + "set name=?,gender=?,dob=?,country=?,address=?,language=?  "
                    + "where cid=?");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
