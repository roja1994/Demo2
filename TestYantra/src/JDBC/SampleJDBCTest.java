package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;



public class SampleJDBCTest {
	
	@Test
	public void testJDBC() {
		
		try {
			//Step 1 : Register Driver or Database
			Driver dir= new Driver();
			DriverManager.registerDriver(dir);
			//Step 2 : connect to database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
			//Step 3 : issue/create sql Statement 
			Statement state = con.createStatement();
			String query = "select * from students_info";
			//step 4 : execute sql query 
			ResultSet result=state.executeQuery(query);
			//Step 5 : Process the result
			while (result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			}
			//Step 6 : Close the connection
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}