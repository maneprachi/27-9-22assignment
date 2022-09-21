package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDrown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDrown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
    //initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDrown() {
		return industryDropDrown;
	}
	
	public WebElement getTypeDropDrown() {
		return typeDropDrown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library
	public void createNewOrg(String orgName) {
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName, String indType) {
		
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(indType, industryDropDrown);
		saveBtn.click();
	}
	
	public void createNewOrg(String orgName, String indType,String type) {
		OrgNameEdt.sendKeys(orgName);
		handleDropDown(indType, industryDropDrown);
		handleDropDown(type, typeDropDrown);
		saveBtn.click();
	}
	
	
	
	
	

}
