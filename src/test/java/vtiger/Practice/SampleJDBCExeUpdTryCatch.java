package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExeUpdTryCatch {
	public static void main(String[]args) throws SQLException {
	Driver driverRef= new Driver();
	Connection con=null;
	try {

	//Step1: register the driver/database
	DriverManager.registerDriver(driverRef);
	
	//Step2: get the connection with database-provide database name
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
	
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
	}
	catch(Exception e) {                                  //if exception not handle we have to execute con.close so we have to put in finally block.
		
	}
	finally{
	//Step5: close the database
			con.close();
			System.out.println("Database closed");
	}
}

}
//If there is mistake in the program we get the exception due to this next lines won't be executed. Database is not closed.due to this database might be 
//currupted or unwanted database is to be inserted.so it is very tedious job.at any situation con.close this statement to be executing.
