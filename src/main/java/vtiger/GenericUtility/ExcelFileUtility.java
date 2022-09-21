package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	/**
	 * This method will read the data from excel sheet with sheet name.
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		Row r=s.getRow(row);
		Cell c=r.getCell(cel);
		String value=c.getStringCellValue();
		wb.close();
		return value;
	}
	/**
	 * This method will return the total number of rows in the sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		int data=s.getLastRowNum();
		wb.close();
		return data;
	}
	/**
	 * This method will write data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException 
	{
	FileInputStream fis=new FileInputStream(IConstantUtility.ExcelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet s=wb.getSheet(sheet);
	Row r=s.getRow(row);
	Cell c=r.createCell(cel);
	c.setCellValue(value);
	
	FileOutputStream fos=new FileOutputStream(IConstantUtility.ExcelFilePath);
	wb.write(fos);
	wb.close();
	}
	/**
	 * this method will read all the data present in sheet and return 2 dimessional object array
	 * which can be fed to data provider
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet s=wb.getSheet(sheet);
		int lastRow=s.getLastRowNum();
		int lastCell=s.getRow(0).getLastCellNum();
		Object[][]data= new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastRow;j++) {
				data[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}


