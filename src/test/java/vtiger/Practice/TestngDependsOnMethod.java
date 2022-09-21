package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngDependsOnMethod {
	
@Test
	
	public void CreateCustomerTest()
	{
		//Assert.fail();
		System.out.println("Customer created"); //to make this test script fail we use Assert.fail
	} //here modify customer depends upon create customer test method ,in this createcustomertest method
	//fails so modify test customer is also failed bcz it is dependent on create customer, so only delete customer
	//method will execute.
	
	@Test(dependsOnMethods="CreateCustomerTest")
	public void modifyCustomerTest()
	{
		System.out.println("Customer modified");
	}
	
	@Test(dependsOnMethods={"CreateCustomerTest","modifyCustomerTest"})
	public void deleteCustomerTest()
	{
		//Assert.fail();
		System.out.println("Customer deleted");
		Assert.fail();
	}
	//to make one test dependent on other we use dependsOnMethod

}
