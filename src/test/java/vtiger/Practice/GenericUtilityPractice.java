package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {
	public static void main(String[]args) throws IOException {
		/*JavaUtility jLib=new JavaUtility();
		int random=jLib.getRandomNumber();
		System.out.println(random);
	
	    String date=jLib.getSystemDate();
	    System.out.println(date);
	
	    String d=jLib.getSystenDateInFormat();
	    System.out.println(d);
	    
	    PropertyFileUtility pLib=new PropertyFileUtility();
	    String browser=pLib.readDataFromFile("browser");
	    System.out.println(browser);
	    String URL=pLib.readDataFromFile("url");
	    System.out.println(URL);*/
	    
	    ExcelFileUtility elib= new ExcelFileUtility();
	    String orgname=elib.readDataFromExcel("Organization", 4, 2);
	    System.out.println(orgname);
	   // elib.writeDataIntoExcel("Organization", 4, 6, "Prachi");
	    //System.out.println("Data written");

}
}
