package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClassPractice {

	@BeforeGroups()
	public void bsConfig() {
		System.out.println("before suit");
	}
	
	public void asConfig() {
		System.out.println("after suit");
	}
	
	@BeforeClass
	public void bcConfig() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void bmConfig() {
		System.out.println("before method");
	}
	
	@AfterClass
	public void acConfig() {
		System.out.println("after class");
	}
	
	@AfterMethod
	public void amConfig() {
		System.out.println("after method");
	}
	
	@Test
	public void Test1() {
		System.out.println("Test -1");
	}
	
}

//all classe which we have to run 
