package vtiger.Practice;

import org.testng.annotations.Test;

public class TestngInvocation {
	
@Test(invocationCount=3,priority=1)
	
	public void CreateCustomerTest()
	{
		System.out.println("Customer created");
	}
	
	@Test
	public void modifyCustomerTest()
	{
		System.out.println("Customer modified");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("Customer deleted");
	}
      //To run the same test script more than one time :invocation count
	//default value for invocation count is 1
	//Always priority given first preferance while executing.
     //It executes 5 times
	//3 times create customer is execute
	//1 time modify customer
	//1 time delete customer

}
