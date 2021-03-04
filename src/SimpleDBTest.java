import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDBTest {

	public static void main(String[] args) {
		Connection myConnection;   // the database connection
		Statement stmt = null;   // Statement represents an SQL statement, empty at this time
		System.out.println("Connecting to the database");
		 try{
			         // load the driver
			    	   Class.forName("com.mysql.cj.jdbc.Driver");
			    	   // set up the connection
			            myConnection=DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/university" , "root", "alam205302"
							// Address 							    	 name      pass
			                );
			            
		    
	        String query     // this is the SQL query
	                = "select lastName, firstName "
	                + "from Student "
	                + "where major = 'Math' ";
	        System.out.println(query);
	            stmt = myConnection.createStatement();  // create the Statement object
	            ResultSet rs = stmt.executeQuery(query);  // use the Statement to send the query to the DB
	            // loop through the result set, displaying one row at a time
	            while (rs.next()) {
	                String lastName = rs.getString("lastName");
	                String firstName = rs.getString("firstName");

	                System.out.println(firstName + " " + lastName);
				}
	        } 
		     catch (SQLException e) {
		    	 System.err.println("SQL error");
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				System.err.println("Connection could not be made");
				e.printStackTrace();
			} 
         }
	}
