package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministrationLnk;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    //utilization
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}
    
	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}
	
	public WebElement getAdministrationLnk() {
		return AdministrationLnk;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//business logic
	/**
	 * this method will click on organization link
	 */
	public void clickOOrganizationLink() {
		OrganizationLnk.click();
	}
	
	/**
	 * this method will click on contact link
	 */
	public void clickOnContactLink() {
		ContactsLnk.click();
	}
	
	public void signOutApp(WebDriver driver) {
		mouseHoverOn(driver,AdministrationLnk);
		SignOutLnk.click();
	}
	
}
