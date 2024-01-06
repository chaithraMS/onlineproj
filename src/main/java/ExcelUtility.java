

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility {
	/**
	 * Read data from Excel Sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo  ) throws Throwable {
    FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
		//System.out.println(value);
	}
	
	/**
	 * Write Data From Excel Sheet
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	public void writenDataIntoExcel(String SheetName, int RowNo, int ColumnNo, String data) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		//String value = cel.getStringCellValue();
		cel.setCellValue(data);
		
		FileOutputStream fo = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fo);
		
		
	}
	/**
	 * This method is used to get last row count
	 * @author DELL
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */

      public int getLastRowNo(String SheetName ) throws Throwable {
    	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
    	  Workbook wb = WorkbookFactory.create(fi);
    	 Sheet sh = wb.getSheet(SheetName);
    	 int count = sh.getLastRowNum();
    	 return count;
      }
      /**
       * this method is used to arraylist fetching data in excelsheet
       */
      
      public void getList(String SheetName, WebDriver driver) throws Throwable 
      {
        FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sh = wb.getSheet(SheetName);
        int count = sh.getLastRowNum();
        for(int i=0;i<=count;i++)
        {
        	String key= sh.getRow(i).getCell(0).getStringCellValue();
        	String value= sh.getRow(i).getCell(1).getStringCellValue();
        	if(key.equals("docemail")) {
        		value=value+"a"+getRandomNumber();
        	}
        	driver.findElement(By.name(key)).sendKeys(value);
        }
      }
      /**
       * this method is used to Map fetching data in excel sheet using key and value 
       * @param sheetName
       * @return
       * @throws Throwable
       */
      
      public Map<String, String> getList(String sheetName) throws Throwable
      
      {
    	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
    	  Workbook wb = WorkbookFactory.create(fi);
    	  Sheet sh = wb.getSheet(sheetName);
    	  int count = sh.getLastRowNum();
    	  Map<String , String> map = new HashMap<String, String>();
    	  for(int i=0; i<=count;i++)
    	  {
    		 String key = sh.getRow(i).getCell(0).getStringCellValue();
    		 String value = sh.getRow(i).getCell(1).getStringCellValue();
    		 map.put(key, value);
    	  }
    	  return map;
      }
      /**
       * This is used for  read data from excel using in TestNg
       * @param SheetName
       * @return
       * @throws Throwable
       */
      public  Object[][] readMultipleData(String SheetName) throws Throwable
      {
    	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
    	  Workbook wb = WorkbookFactory.create(fi);
    	  Sheet sh = wb.getSheet(SheetName);
    	  int lastROW = sh.getLastRowNum() +1;
    	  short lastCell = sh.getRow(0).getLastCellNum();
    	  
    	  Object[][] obj = new Object[lastROW][lastCell];
    	  for(int i=0;i<lastROW;i++)
    	  {
    		  for(int j=0;j<lastCell;j++)
    		  {
    			  obj[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
    		  }
    	  }
    	  return obj;
      }
    
      
}
