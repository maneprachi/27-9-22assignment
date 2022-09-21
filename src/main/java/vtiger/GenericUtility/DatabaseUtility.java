package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all the generic methods related to database 
 * @author Admin
 *
 */
public class DatabaseUtility {
	Driver driverRef;
	Connection con=null;
	public void connectToDB() throws SQLException {
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(IConstantUtility.DBUrl,IConstantUtility.DBUsername,IConstantUtility.DBPassword);
		
		}
	/**
	 * this method will close the database connection
	 * @throws SQLException
	 */
  public void closeDB() throws SQLException
  {
	  con.close();
  }
  public String executeQueryVerfyDataAndReturn(String query, int columnIndex,String expData) throws SQLException
  {
	  //execute a query
	  boolean flag=false;
	  ResultSet result = con.createStatement().executeQuery(query);
	  while(result.next())
	  {
		  String actData=result.getNString(columnIndex);
	  // verify the data with act data from database
	  if(actData.equals(expData))
	  {
		  flag=true;   //flag rising
		  break;
	  }
	  }
	  //return if exp data and act data is matching
	  if(flag)
	  {
		  System.out.println("data verified");
		  return expData;
	  }
	  else {
		  System.out.println("data not verified");
		  return "";
	  }
  }

}
