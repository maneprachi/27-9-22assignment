package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {
	public static void main (String[]args) throws InterruptedException {
	
	//Step1: Launch the browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://localhost:8888");
	
	//Step2: Login to app
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	//Step3 : Navigate to organization link
	driver.findElement(By.linkText("Organizations")).click();
	
	//Step4: click on create organization look up image
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//Step5: Create organization with mandatory field
	driver.findElement(By.name("accountname")).sendKeys("QJsp");
	
	//Step6: Select helthcare in the industry dropdownlist
	WebElement ele = driver.findElement(By.name("industry"));
	Select select=new Select(ele);
	select.selectByValue("Finance");
	
	//Step7: Save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	Thread.sleep(2000);
	//Step8: logout
	Actions actions=new Actions(driver);
	WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	actions.moveToElement(ele1).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	
	

}
}
