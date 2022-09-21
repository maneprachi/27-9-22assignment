package TestngGroup;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationPage;

public class OrganizationTest extends BaseClass {
	@Test(groups="smoke")
	public void createOrgWithIndustryTest() throws IOException
	{
		String ORGNAME=eutil.readDataFromExcel("Organization", 4, 2)+jutil.getRandomNumber();
		 //navigate to organizations
	    HomePage hp=new HomePage(driver);
	    hp.clickOOrganizationLink();
	    Reporter.log("---click on org link---",true);
	    
	    //click on create new organization
	    OrganizationPage op=new OrganizationPage(driver);
	    op.clickOnOrganization();
	    Reporter.log("---click on create new org lookup img---",true);	

}

}
