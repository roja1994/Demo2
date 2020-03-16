package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class sampleInsertQuery {
	Connection con;
	
	@Test
	public void testInsert() {
		
		try {
			//Step 1 : Register Driver or Database
			Driver dir= new Driver();
			DriverManager.registerDriver(dir);
			//Step 2 : connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
			//Step 3 : issue/create sql Statement 
			Statement state = con.createStatement();
			String query = "insert into students_info(regno,firstname,middlename,lastname) values('5','rehan','raj','singh')";
			//step 4 : execute sql query 
			int result=state.executeUpdate(query);
			//Step 5 : Process the result
			if(result == 1)
				System.out.println("The data is inserted successfully");
		} catch (Exception e) {
			System.err.println("The data is not inserted");
		} finally {
			//Step 6 : Close the connection
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
