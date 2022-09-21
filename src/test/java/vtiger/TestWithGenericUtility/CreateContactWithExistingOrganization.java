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

public class CreateContactWithExistingOrganization {
public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=null;
		
		//Create object of all the Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//read all the data required for the test script
		String BROWSER = pUtil.readDataFromFile("browser");
		String URL = pUtil.readDataFromFile("url");
		String USERNAME = pUtil.readDataFromFile("username");
		String PASSWORD = pUtil.readDataFromFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
		
		//login To App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Create organization with mandatory fields and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate for Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Org created");
		}
		else 
		{
			System.out.println("Org not created");
		}
		
		//Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Create contact with Organization and save
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		    // switch from parent to child
	    wUtil.switchToWindow(driver, "Accounts");
	    //Thread.sleep(2000);
	    driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	    Thread.sleep(2000);
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.linkText(ORGNAME)).click();
	       //switch from child to parent
	    wUtil.switchToWindow(driver, "Contacts");
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate for contacts
	    String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("Contact Created -- PASS");
		}
		else
		{
			System.out.println("Contact not created --- FAIL");
		}
		
		//Logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out successfull");
		
	}
}

//instead of using precreated organisation we create our own organization .if we use pre created oganization 
//if another ATester has test case to delete that organisation due to this our test script fail.
//if we are creating our organization if it is deleted by someone there is no chances to test script
//failure. Automation rule say that never create dependancy between test script.
