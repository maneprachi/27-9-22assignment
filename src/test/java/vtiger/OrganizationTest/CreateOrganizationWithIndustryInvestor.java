package vtiger.OrganizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryInvestor {
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
     Sheet sh = wb.getSheet("Organization");
     Row rw = sh.getRow(4);
     Cell cel = rw.getCell(2);
     String ORGNAME = cel.getStringCellValue();
     
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
     
     //Step 3: login to app
     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
			
		//Step3 : Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step5: Create organization with mandatory field
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
		//Step6: Select electronics in the industry dropdownlist
		WebElement ele = driver.findElement(By.name("industry"));
		Select select=new Select(ele);
		select.selectByValue("Electronics");
		
		//Step7: Choose investor from type dropdown list
		WebElement element = driver.findElement(By.name("accounttype"));
		Select select1=new Select(element);
		select1.selectByValue("Investor");
		
		
		//Step8: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//Step9: logout
		Actions actions=new Actions(driver);
		WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		actions.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
