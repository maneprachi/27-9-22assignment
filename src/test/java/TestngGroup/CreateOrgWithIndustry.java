package TestngGroup;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import vtiger.GenericUtility.BaseClass;
import vtiger.ObjectRepository.CreateOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationPage;
import vtiger.ObjectRepository.OrgnizationInfoPage;

public class CreateOrgWithIndustry extends BaseClass {
	@Test(groups="regeression")    //we have to add in base class to all annotation i.e @beforesuit(groups="smoke")
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
    if(OrgHeader.contains(ORGNAME)) {
    	System.out.println("pass");
    }
    else {
    	System.out.println("fail");
    }
    	
    }
	 @Test(groups="regeression")      //in this 2 test are present from that we know which test is impacted so insted of running entire
	 //class as regeression only one method can be run as regional regeression testing
	    public void demoTest() {

		 System.out.println("this is regional regeression testing");
}
}
