package vtiger.TestWithGenericUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class CreateOrganizationTest {

	public static void main (String[]args) throws IOException, InterruptedException {
		WebDriver driver = null;
		
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		String BROWSER=putil.readDataFromFile("browser");
		String URL = putil.readDataFromFile("url");
		String USERNAME = putil.readDataFromFile("username");
		String PASSWORD = putil.readDataFromFile("password");
		
	    String ORGNAME = eutil.readDataFromExcel("Organization", 1, 2)+jutil.getRandomNumber();
	    System.out.println(ORGNAME);
	    
	    if(BROWSER.equalsIgnoreCase("chrome")) {
	    	//WebDriverManager.chromedriver().setup();
	    	driver= new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox")) {
	    	//WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else {
	    	System.out.println("Invalid browser name");
	    }
	    
	    wutil.maximiseWindow(driver);
	    wutil.waitForDOMLoad(driver);
	    driver.get(URL);
	    
	    //Step 3: login to app
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        
        //Step 4: Navigate to Organizations
        driver.findElement(By.linkText("Organizations")).click();
		
        //Step 5: Click on create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
        //Step 6: Create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
        //Step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
       Thread.sleep(2000); 
		//Step 8: logout
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wutil.mouseHoverOn(driver, ele1);
		driver.findElement(By.linkText("Sign Out")).click();
        
	    
		
		
		
		
		
		
		
		
		
		
		
	}
}
