import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDBTest2 {

	public static void main(String[] args) {
		Connection myConnection;   // the database connection
		Statement stmt = null;   // Statement represents an SQL statement, empty at this time
		System.out.println("Connecting to the database");
		 try{
			         // load the driver
			    	   Class.forName("com.mysql.cj.jdbc.Driver");
			    	   // set up the connection
			            myConnection=DriverManager.getConnection(
			                "jdbc:mysql://localhost:3306/world" ,"root", "alam205302"
			                );
			            
		    
	        String query     // this is the SQL query
	                = "select country.name, Region "
					+ "from Country "
					+ "Order by name;";
	        System.out.println(query);
	            stmt = myConnection.createStatement();  // create the Statement object
	            ResultSet rs = stmt.executeQuery(query);  // use the Statement to send the query to the DB
	            // loop through the result set, displaying one row at a time
	            while (rs.next()) {
	                String name = rs.getString("Name");
	                String region = rs.getString("Region");

	                System.out.println(name + " " + region);
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
