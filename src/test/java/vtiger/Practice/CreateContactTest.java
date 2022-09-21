package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactTest {
	 public static void main (String[]args) {
			
			//Step1: Launch the browser
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://localhost:8888");
			
			//Step2: Login to app
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			//Step3 : Navigate to contact link
			driver.findElement(By.linkText("Contacts")).click();
			
			//Step4: click on create contact look up image
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			//Step5: Create contact with mandatory field
			driver.findElement(By.name("lastname")).sendKeys("thorat");
			
			//Step6: Save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
            //Step7: logout
			Actions actions=new Actions(driver);
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			actions.moveToElement(ele).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
}
}
