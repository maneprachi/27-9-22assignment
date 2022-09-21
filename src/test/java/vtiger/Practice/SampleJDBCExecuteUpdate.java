package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
public static void main(String[]args) throws SQLException {
		
		Driver driverRef= new Driver();
		
		//Step1: register the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step2: get the connection with database-provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		
		//Step3: issue create statement
		Statement state = con.createStatement();
		
		//Step4: execute a query- provide a table name
		String query="insert into clientinfo values('triveni',06,'nagpur');";
		int result=state.executeUpdate(query);
		//System.out.println(result);   //it will display how many rows affected.
		if (result==1) {
			System.out.println("data inserted");
		}else {
			System.out.println("data not inserted");
			
		}
		//Step5: close the database
				con.close();
}
}
