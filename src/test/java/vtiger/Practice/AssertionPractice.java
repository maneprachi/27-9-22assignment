package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void assertPractice() {
		System.out.println("Step1");
		System.out.println("Step1");
		//Assert.assertEquals("A", "A"); //actual and expected is matched then pass &next line executed
		Assert.assertEquals("B", "A");//fail next lines wont executed
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
	}
	
	@Test
	public void assertPractice1() {
		SoftAssert sa=new SoftAssert();
		System.out.println("testscript 2 Step1");
		sa.assertEquals(true, true);
		System.out.println("testscript 2 Step2");
		sa.assertTrue(false);//failed
		System.out.println("testscript 2 Step3");
		System.out.println("testscript 2 Step4");
		sa.assertAll();//mandatory
	}
	
	@Test
	public void assertPractice2() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		sa.assertTrue(false);
		System.out.println("Step2");
		//sa.assertAll();//next line wont executed
		Assert.assertEquals("B", "A");//fail next lines wont executed
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
	}
	
	

}
