package vtiger.GenericUtility;


import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
/**
 * this class consist of all basic configuration annotations of testng
 * @author Admin
 *
 */
public class BaseClass {
	public ExcelFileUtility eutil=new ExcelFileUtility();
	public JavaUtility jutil= new JavaUtility();
	public PropertyFileUtility putil= new PropertyFileUtility();
	public WebDriverUtility wutil= new WebDriverUtility();
	public DatabaseUtility dbutil=new DatabaseUtility();
	public WebDriver driver=null;
	
	@BeforeSuite(groups={"smoke","regeression"})
	public void bsConfig() throws SQLException {
		
		dbutil.connectToDB();
		Reporter.log("-----db connection successfull----");
	}
	//@Parameters("BROWSER")//it will read value from suit xml file use when u want to do compatibility testing
	//@BeforeTest//it is use when u want to do dist parallel exe
	@BeforeClass(groups={"smoke","regeression"})
	public void bcConfig() throws IOException {   //compablity testing put String BROWSER inside bracket
		String BROWSER = putil.readDataFromFile("browser"); //and comment this line
		String URL = putil.readDataFromFile("url");
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.log(BROWSER+"----browser launched-----",true);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			Reporter.log(BROWSER+"----browser launched-----",true);
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		wutil.maximiseWindow(driver);
		wutil.waitForDOMLoad(driver);
		driver.get(URL);
			
	}
	@BeforeMethod(groups={"smoke","regeression"})
	public void bmConfig() throws IOException {
		String USERNAME=putil.readDataFromFile("username");
		String PASSWORD=putil.readDataFromFile("password");
		LoginPage lp =new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("----login successfull",true);
	}
	
	@AfterMethod(groups={"smoke","regeression"})
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.signOutApp(driver);
		Reporter.log("-----logout successsfull---",true);
	}
	
	//@AfterTest
	@AfterClass(groups={"smoke","regeression"})
	public void acConfig() {
		driver.close();
		Reporter.log("----browser closed----",true);
		
	}
	
	@AfterSuite(groups={"smoke","regeression"})
	public void asConfig() throws SQLException {
		dbutil.closeDB();
		Reporter.log("-----db closed---",true);
		
	}
	



}

	

