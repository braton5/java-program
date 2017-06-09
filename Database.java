
package database;
import java.sql.*;
public class Database {
  public static void main(String[] args) {
        query();
    }
    public static void query() {
        Connection conn = null;
        try {
            // Register the JDBC driver
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            // Open a connection
            System.out.println("Connecting to the database...");
            String jdbcUrl = "jdbc:mysql://localhost/Braton";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(jdbcUrl, user, password); 
 // Execute a query
            String sql = "SELECT FNAME,LNAME FROM Student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);           
            // Extract data from the result set
            while(rs.next()) {
                String fname = rs.getString("FNAME");
                String lname = rs.getString("LNAME");
                //Display the result set
                System.out.println("------------------------------");
                System.out.print("FIRST NAME:" + fname);
                System.out.println(" LAST NAME:" + lname);
                System.out.println("");
            }    
            // Close resources
            System.out.println("Closing the resources...");
            rs.close();
            stmt.close();
            conn.close();
           conn = null;
 } catch(SQLException se) {
            // Handle SQL exception
            se.printStackTrace();
        } catch(Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        } finally {
// Close resources
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch(SQLException se) {
                    se.printStackTrace();
            }
        }
    }
}

