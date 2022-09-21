package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationInfoPage {
	
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Orgheader;
	
	//initialization
	public OrgnizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgheader() {
		return Orgheader;
	}
	
	//business library
	public String getOrgHeader() {
		return Orgheader.getText();
	}
	

}
