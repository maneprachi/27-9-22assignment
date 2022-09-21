package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility{
	
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreaOrgImg;
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreaOrgImg() {
		return CreaOrgImg;
	}

	//buiseness library
	public void clickOnOrganization() {
		CreaOrgImg.click();
	}
	

}
