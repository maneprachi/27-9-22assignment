package Testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.ObjectRepository.OrgnizationInfoPage;

public class CreateMultipleOrgDataProviderTest {
	
	ExcelFileUtility eutil=new ExcelFileUtility();
	JavaUtility jutil= new JavaUtility();
	PropertyFileUtility putil= new PropertyFileUtility();
	WebDriverUtility wutil= new WebDriverUtility();
	WebDriver driver;
	
	@Test(dataProvider="OrgData")
	public void createMultipleOrgTest(String org, String industry) throws IOException {
		String BROWSER=putil.readDataFromFile("browser");
		String URL = putil.readDataFromFile("url");
		String USERNAME = putil.readDataFromFile("username");
		String PASSWORD = putil.readDataFromFile("password");
	    String ORGNAME = eutil.readDataFromExcel("Organization", 4, 2);
		String INDUSTRY = eutil.readDataFromExcel("Organization", 1, 2);
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
		    LoginPage lp=new LoginPage(driver);
		    lp.loginToApp(USERNAME, PASSWORD);
		    
		    //navigate to organizations
		    HomePage hp=new HomePage(driver);
		    hp.clickOOrganizationLink();
		    
		    //click on create new organization
		    OrganizationPage op=new OrganizationPage(driver);
		    op.clickOnOrganization();
		    
		    //create new organization with industry and save
		    CreateOrganizationPage cnp=new CreateOrganizationPage(driver);
		    cnp.createNewOrg(ORGNAME, INDUSTRY);
		    
		    //validate
		    OrgnizationInfoPage oip=new OrgnizationInfoPage(driver);
		    String OrgHeader=oip.getOrgHeader();
		    System.out.println(OrgHeader);
		    if(OrgHeader.contains(ORGNAME)) {
		    	System.out.println("pass");
		    }
		    else {
		    	System.out.println("fail");
		    }
		    //logout
		    hp.signOutApp(driver);
		    System.out.println("signout successfully");
		
	}
	
	@DataProvider(name="OrgData")
	public Object[][]getData() throws EncryptedDocumentException, IOException{
		return eutil.readMultipleDataFromExcel("MulyipleOrg");
			
	}
}
