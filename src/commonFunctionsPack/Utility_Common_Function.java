package commonFunctionsPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_Common_Function {

	public static void Evidence_File_Creator(String filename, String RequestBody, String ResponseBody) throws IOException
	{
		
		File NewFile = new File("C:\\Users\\ADMIN\\Desktop\\IB\\Git\\Uploads\\New folder\\" + filename + ".txt");
		System.out.println("A new text file created to record request and response of the API" + NewFile.getName());
		
		FileWriter datawrite = new FileWriter(NewFile);
		datawrite.write("request body :" +RequestBody+ "\n\n");
		datawrite.write("response body :" +ResponseBody);
		datawrite.close();
		System.out.println("Request Body and Response Body are saved in : " +NewFile.getName());
		
	}
	
	public static ArrayList<String> ReadDataExcel(String sheetName, String testCaseName) throws IOException 
	{
		ArrayList<String> ArrayData = new ArrayList<String>();
		//Step 1: Create the object of file input stream
		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\IB\\Git\\Uploads\\New folder\\API_TC2.xlsx");
		//Step 2: Access the excel file
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//Step 3: Access the sheet name
		int countofsheet = workbook.getNumberOfSheets();
		for(int i=0 ; i<countofsheet ; i++)
		{
			String filesheetname = workbook.getSheetName(i);
			//System.out.println(filesheetname);
			if(filesheetname.equalsIgnoreCase(sheetName)) 
			{
				//Step 4: Access the row from where data is supposed to be fetched
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				//Row r = rows.next();
				while(rows.hasNext()) 
				{
					Row r1 = rows.next();
					if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
					
						Iterator<Cell> cellvalues = r1.cellIterator();
						while(cellvalues.hasNext()) 
						{
							String testdata = cellvalues.next().getStringCellValue();
							ArrayData.add(testdata);
							//System.out.println(testdata);
						}
					}
				}
			}/*
			else 
			{
				System.out.println("This Sheet " +filesheetname+ " doesn't exist ");	
			}*/
				
		}
		workbook.close();
		return ArrayData;
	}

}