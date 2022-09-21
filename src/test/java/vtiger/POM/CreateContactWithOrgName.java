package vtiger.POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateContactPage;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.ObjectRepository.OrgnizationInfoPage;

public class CreateContactWithOrgName {
	public static void main (String[]args) throws IOException {
		WebDriver driver = null;
		
		JavaUtility jutil=new JavaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//read all the necessary data 
		String BROWSER=putil.readDataFromFile("browser");
		String URL = putil.readDataFromFile("url");
		String USERNAME = putil.readDataFromFile("username");
		String PASSWORD = putil.readDataFromFile("password");
		
		String ORGNAME = eutil.readDataFromExcel("Contact", 4, 3)+jutil.getRandomNumber();
		String LASTNAME = eutil.readDataFromExcel("Contact", 4, 2);
		
	    
		//step3: launch the browser
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
	    
	    //Step5:navigate to organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOOrganizationLink();
		
		//Step6:click on create organization look up image
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganization();
		
		//Step7:create organization with mandatory fields and save
		CreateOrganizationPage cnp=new CreateOrganizationPage(driver);
		cnp.createNewOrg(ORGNAME);
		
		//Step8:Validate for organization
		OrgnizationInfoPage oip=new OrgnizationInfoPage(driver);
		  String OrgHeader = oip.getOrgHeader();
		  if(OrgHeader.contains(ORGNAME))
		  {
			  System.out.println("org created");
		  }
		  else
		  {
			  System.out.println("org not created");
		  }
        //Step9:Navigate to contact link
		  hp.clickOnContactLink();
		  
		//Sttep 10:click on create contact lookup image
		  ContactPage cp=new ContactPage(driver);
		  cp.ClickOnCreateContactsImg();
		  
		//Step 11: create contact with organization and save
	    CreateContactPage cnc=new CreateContactPage(driver);
	    cnc.createNewContact(LASTNAME, ORGNAME, driver);
	    
	   //Step 12:validate for contacts
		 ContactInfoPage cip=new ContactInfoPage(driver);
		 String ContactHeader = cip.getContactHeader();
		 System.out.println(ContactHeader);

		  if(ContactHeader.contains(LASTNAME))
		  {
			  System.out.println("contact created--pass");
		  }
		  else
		  {
			  System.out.println("contact not created--Fail");
		  }
		  
         //step 13: logout
		  hp.signOutApp(driver);
		  System.out.println("sign out successfully");

}
}
