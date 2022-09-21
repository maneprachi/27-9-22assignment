package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all the generic methods related to property file
 * @author Admin
 *
 */

public class PropertyFileUtility {
	/**
	 * This method will read the key from property file and return the value.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromFile(String key) throws IOException {
		{
			FileInputStream fis= new FileInputStream(IConstantUtility.PropertyFilePath);
			Properties pObj= new Properties();
			pObj.load(fis);
			String value=pObj.getProperty(key);  
			return value;
		}
	}

}
