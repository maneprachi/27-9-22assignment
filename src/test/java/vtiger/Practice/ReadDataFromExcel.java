package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static void main(String[]args) throws EncryptedDocumentException, IOException {
		
		//Step1: load the file location into file input stream
         FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\test data.xlsx"); 
         
        //Step2: Create work book
         Workbook wb = WorkbookFactory.create(fis);		
         
        //Step3: Get into sheet
         Sheet sh = wb.getSheet("Organization");
         
        //Step4: Get into the row
         Row row = sh.getRow(4);
         
        //Step5: Get into the cell
         Cell cel = row.getCell(2);
         
        //Step6: read the value present in the cell
         String value = cel.getStringCellValue();
         System.out.println(value);
		
	}

}
