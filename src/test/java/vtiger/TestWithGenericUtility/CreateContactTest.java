package vtiger.TestWithGenericUtility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

public class CreateContactTest {
	public static void main(String[]args) throws IOException {
		WebDriver driver = null;
		//Step1: Create object of all utilities
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//Step2: Read all necessery data
		String BROWSER = putil.readDataFromFile("browser");
		String URL = putil.readDataFromFile("url");
		String USERNAME = putil.readDataFromFile("username");
		String PASSWORD = putil.readDataFromFile("password");
	
		String LASTNAME = eutil.readDataFromExcel("Contact", 1, 2)+jutil.getRandomNumber();
		String LEADSOURCE=eutil.readDataFromExcel("Contact", 1, 3);
		System.out.println(LEADSOURCE);
		
		//Step3: launch the browser-run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
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
		
		//Step4: login to app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step5 : Navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
			
		//Step6: click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
		//Step7: Create contact with mandatory field
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		WebElement ele1 =driver.findElement(By.name("leadsource"));
		wutil.handleDropDown(LEADSOURCE, ele1);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step8: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.waitForElementToBeVisible(driver, element);
		wutil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();

		}

}
