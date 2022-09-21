package vtiger.Practice;

import org.testng.annotations.Test;

public class TestngPractice {
	

	@Test(priority= -1)
	
	public void CreateCustomerTest()
	{
		System.out.println("Customer created");
	}
	
	@Test(priority=2)
	public void modifyCustomerTest()
	{
		System.out.println("Customer modified");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		System.out.println("Customer deleted");
	}

	
	//Here test cases are executed by default in alphabetically order, to change the order of execution we give
	//priority, so by giving priority it will execute prioritywise
}  //lowest priority executes first
   //Default value for priority is 0,means if we dont give pririty to any test case by default that test
  //case will execute first. Priority accepts negative values also


