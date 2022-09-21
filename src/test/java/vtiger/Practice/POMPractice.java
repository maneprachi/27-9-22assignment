package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationPage;

public class POMPractice {

	public static void main(String[]args) {
		WebDriverUtility w=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		LoginPage lp= new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys("admin");
		//lp.getPasswordEdt().sendKeys("admin");
		//lp.getSubmitBtn().click();
		
		lp.loginToApp("admin", "admin");
		
		//HomePage hp=new HomePage(driver);
		//hp.getProductsLnk().click();
		//w.mouseHoverOn(driver, hp.getAdministrationLnk());
		//hp.getSignOutLnk().click();
		//hp.signOutApp(driver);
		
		/*OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganization();
		//op.clickOnCreateOrganization();
		op.passValueToSearch("Qsp");
		op.SelectFromSearchField();
		op.clickOnSearch();*/
		
		/*CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.clickOnOrganization();
		cop.clickOnCreateOrganization();
		cop.valueToOrgnizationName("Qspider");
		cop.clickOnSave();*/
		
	}
}
