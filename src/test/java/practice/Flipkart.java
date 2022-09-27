package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart {
	public static void main (String[]args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
	    WebDriver driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
	   // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	    driver.get("https://www.flipkart.com/");
	    driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();   
	    driver.findElement(By.name("q")).sendKeys("winter heater");
	    driver.findElement(By.xpath("//div[text()='winter water heater']")).click();
	    driver.findElement(By.xpath("(//a[text()='LE - EASE LITE Instant Heat Winter Season Shock-Proof &...'])[1]")).click();
	  
	    Set<String> window = driver.getWindowHandles();
	    for(String st:window) {          
	    	   
	    	   System.out.println(st);
	           driver.switchTo().window(st);
	           
	    }
	      
	      driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	           
	    

}
}


