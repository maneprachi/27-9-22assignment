package Testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.ObjectRepository.OrgnizationInfoPage;

public class CreateOrgWithIndustry extends BaseClass {
	@Test
	public void createOrgWithIndustryTest() throws IOException
	
	{
		
    String ORGNAME=eutil.readDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
    String INDUSTRY=eutil.readDataFromExcel("Organization", 4, 3);
    
    //navigate to organizations
    HomePage hp=new HomePage(driver);
    hp.clickOOrganizationLink();
    Reporter.log("---click on org link---",true);
    
    //click on create new organization
    OrganizationPage op=new OrganizationPage(driver);
    op.clickOnOrganization();
    Reporter.log("---click on create new org lookup img---",true);
    
    //create new organization with industry and save
    CreateOrganizationPage cnp=new CreateOrganizationPage(driver);
    cnp.createNewOrg(ORGNAME, INDUSTRY);
    Reporter.log("---new org created---",true);
    
    //validate
    OrgnizationInfoPage oip=new OrgnizationInfoPage(driver);
    String OrgHeader=oip.getOrgHeader();
    System.out.println(OrgHeader);
    Assert.assertEquals(OrgHeader.contains(ORGNAME), true);
   // Assert.assertTrue(OrgHeader.contains(ORGNAME));
    /*if(OrgHeader.contains(ORGNAME)) {
    	System.out.println("pass");
    }
    else {
    	System.out.println("fail");
    }*/
    
	}
}
