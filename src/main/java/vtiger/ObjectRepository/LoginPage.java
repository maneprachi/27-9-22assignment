package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name= "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name= "user_password")
	private WebElement PasswordEdt;
	
	@FindBy(id= "submitButton")
	private WebElement SubmitBtn ;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	
	public void loginToApp(String userName,String Password)
	{
		UserNameEdt.sendKeys(userName);
		PasswordEdt.sendKeys(Password);
		SubmitBtn.click();
	}
	
	
	

}
