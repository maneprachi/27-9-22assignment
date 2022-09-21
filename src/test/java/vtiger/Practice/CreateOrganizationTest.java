package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
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
		
		//Step3 : Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step4: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step5: Create organization with mandatory field
		driver.findElement(By.name("accountname")).sendKeys("Qsp");
		
		//Step6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
}
}
