package vtiger.OrganizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithExistingOrganization {
public static void main (String[]args) throws InterruptedException, EncryptedDocumentException, IOException {
	WebDriver driver;
    
    //Generate random number
	Random r = new Random();
	int RANDOM = r.nextInt(500);
	
	//Step 1: Read all the necessary data
	//read data from property file ----> Common Data
	FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
    Properties pObj = new Properties();
    pObj.load(fisp);
    String BROWSER = pObj.getProperty("browser");
    String URL = pObj.getProperty("url");
    String USERNAME = pObj.getProperty("username");
    String PASSWORD = pObj.getProperty("password");
    
    //read data from Excel Sheet -----> Test Data
    FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\test data.xlsx");
    Workbook wb = WorkbookFactory.create(fise);
    Sheet sh = wb.getSheet("Contact");
    Row rw = sh.getRow(1);
    Cell cel = rw.getCell(2);
    String LASTNAME = cel.getStringCellValue();
    
    //Step 2: launch the browser -- run time polyporphism
    if(BROWSER.equalsIgnoreCase("chrome"))
    {
    	driver = new ChromeDriver();
    	System.out.println("--- chrome browser launched ----");
    }
    else if(BROWSER.equalsIgnoreCase("Firefox"))
    {
    	driver = new FirefoxDriver();
    	System.out.println("---- Firefox browser launched----");
    }
    else
    {
    	System.out.println("-invalid browser name-");
    	driver = new ChromeDriver();
    	System.out.println("--- chrome browser launched ----");
    }
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get(URL);
    
	//Step2: Login to app
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
		//Step3 : Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step4: click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step5: Create contact with mandatory field
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step6: Choose any existing organization
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		String parent = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
	       for(String st:win) {            //to get multiple ids we use for each loop
	    	    System.out.println(st);
	            driver.switchTo().window(st); 
	           
	       }
	       driver.findElement(By.linkText("Qsp")).click();
	      // Thread.sleep(6000);
	       driver.switchTo().window(parent);
		
		//Step7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
        //Step8: logout
		Actions actions=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();

}

}
