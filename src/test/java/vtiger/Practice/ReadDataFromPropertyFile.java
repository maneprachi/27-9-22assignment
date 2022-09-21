package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main (String[]args) throws IOException {
		
		//Step1: load the file location into file input stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties"); 
		
		//Step2: create object of properties
		Properties pObj= new Properties();
		
		//Step3: load the data into properties
		pObj.load(fis);
		
		//Step4: use the key and read the value
		String Browser=pObj.getProperty("browser");
		System.out.println(Browser);
		
		String Url=pObj.getProperty("url");
		System.out.println(Url);
		
		
	}

}
