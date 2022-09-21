package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	//declaration
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrganizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return OrganizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library
	/**
	 * this method will pass the value to the lastname
	 * @param lastname
	 */
	public void createNewContact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();	
	}
	
	public void createNewContact(String lastname,String leadsource) {
		lastnameEdt.sendKeys(lastname);
		handleDropDown(leadsource,leadSourceDropDown);
	}
	
	public void createNewContact(String lastname,String orgname,WebDriver driver) {
		lastnameEdt.sendKeys(lastname);
		OrganizationImg.click();
		switchToWindow(driver, "Accounts");      //accounts is a partial text in a child window present in a link
		searchEdt.sendKeys(orgname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();  //it is used for dynamic path becoz org name value is changing it is dynamic for dynamic we can write xpath like this
		switchToWindow(driver,"Contacts");
		saveBtn.click();
		}
	
	
	
	
	
	
	
	

}
