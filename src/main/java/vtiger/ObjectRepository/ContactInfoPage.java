package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//declaration
	@FindBy(xpath="//span[@class'dvHeaderText']")
	private WebElement contactHeaderTxt;
	
	//initialization 
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getContactHeaderTxt() {
		return contactHeaderTxt;
	}
	
	//buisiness libirary
	/**
	 * 
	 * @return
	 */
	public String getContactHeader() {
		return contactHeaderTxt.getText();
	}

}
