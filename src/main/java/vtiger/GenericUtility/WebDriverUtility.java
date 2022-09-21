package vtiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
   /** 
    * This class will contain all the generic methods related to webdriver action
    * @author Admin
    *
    */
public class WebDriverUtility {
     /**
      * This method will maximise the window
      * @param driver
      */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will wait for 20 seconds fotthe entire DOM Load
	 * @param driver
	 */
	public void waitForDOMLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * this method will wait for an element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait for an element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method is a custom wait where it will wait for the perticular element
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(1000);
				count++;
			}
			
		}
	}
	/**
	 * this method willhandle drop down using select class based on index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 *  this method willhandle drop down using select class based on visible text
	 * @param element
	 * @param visibletext
	 */
	public void handleDropDown(WebElement element,String visibletext) {
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	/**
	 * this method willhandle drop down using select class based on value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will perform mouse hover action on perticular element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will double click on perticular element
	 * @param driver
	 * @param element
	 */
	public void doubleCickOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will double click on page
	 * @param driver
	 */
	public void doubleCickOn(WebDriver  driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will right click on page
	 * @param driver
	 */
	public void rightClickOn(WebDriver  driver){
	    Actions act=new Actions(driver);
	    act.contextClick().perform();
	}
	/** 
	 * this method will right click on perticular element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver  driver,WebElement element){
	    Actions act=new Actions(driver);
	    act.contextClick(element).perform();
	}
	/**
	 * this method will perform drag and drop from src element to target element
	 * @param driver
	 * @param srcElement
	 * @param targetElement
	 */
	public void dragAndDropOn(WebDriver  driver,WebElement srcElement,WebElement targetElement) {
		 Actions act=new Actions(driver);
		 act.dragAndDrop(srcElement, targetElement).perform();
	}
	/** 
	 * This method will press the enter key and release 
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * this method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will get the text of alert popup
	 * @param driver
	 * @return
	 */
	public String getTextofAlert(WebDriver driver) {
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	/**
	 * this method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will handle frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);	
	}
	
	/**
	 * this method will handle frame based on frame element	
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will switch the control back to immediate parent
	 * @param driver
	 */
	public void toParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * this method will come out of all the frame
	 * @param driver
	 */
	public void toDefaultWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * this method will switch fromonewindow to another window based on partialwindow title
	 * @param driver
	 * @param PartialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String  PartialWinTitle) {
		//Step1: get all the win Ids
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step2: iterate thru all the win Ids
		Iterator<String> it = windowIds.iterator();
		
		//Step3: navigate to each window and check the title
		while(it.hasNext())
		{
			//capture the individual window id
			String winId=it.next();
			String currentTitle = driver.switchTo().window(winId).getTitle();
			if(currentTitle.contains(PartialWinTitle));
			{
				break;
			}
		}
	}
	
	/**
	 * this method will take screen shot and save in screenshots folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException 
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\Screenshots\\"+screenShotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();   //used for reporting
	}
	
	/**
	 * this method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView();",element);
		//int y=element.getLocation().getY();
		//js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
}
