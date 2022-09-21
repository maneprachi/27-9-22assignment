package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[]args) throws SQLException {
		
		Driver driverRef= new Driver();
		
		//Step1: register the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step2: get the connection with database-provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step4: execute a query- provide a table name
		ResultSet result = state.executeQuery("select * from clientinfo;");
		
		//resultset is an interface it provides getters method to retrive the data.to get the data stored in coloumn one by one we can't use
		//for each loop becoz data entered is either of int, string,long so it is not possible to convert. we can't use for loop becoz in that we have to 
		//give the condition but if we don't know the condition then it is not possible.for that we use while loop and next method if the cursor is in 1st 
		//row then it will check the next row is present or not,if it is there it will go to the next row & check next row is present or not if it is not
		//there loop will be terminated.
		
		while(result.next()) {
			
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
	
		//Step5: close the database
		con.close();
		
		
	}
}
