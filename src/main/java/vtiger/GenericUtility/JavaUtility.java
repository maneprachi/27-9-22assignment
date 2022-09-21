package vtiger.GenericUtility;


import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate a random integer number for every execution.
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random r= new Random();
		int ran = r.nextInt(1000);
		return ran;
    }
	/**
	 * This method will return the current system date.
	 * @return
	 */
	public String getSystemDate() 
	{
		Date d=new Date();
		String date=d.toString();
		return date;	
	}
	public String getSystenDateInFormat() 
	{
		Date d= new Date();
		String[]darr=d.toString().split(" ");
		String date=darr[2];
		String month=darr[1];
		String year=darr[5];
		String time=darr[3].replace(":", "-");
		String currentdate= date+" "+month+" "+year+" "+time;
		//System.out.println(currentdate);
		return currentdate;
	}
	
}
//all java specific method we write here.for that we create seperate java class for java utility.instead of writing random method
//multiple times in a program we create here and call in main method in another class by creating object of this class.
//we create non static method becoz once create a object we can call multiple methods with object refference.