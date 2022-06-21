package Utils;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
	
	static XSSFWorkbook workBook1;
	static XSSFSheet sheet1;
	static XSSFWorkbook workBook2;
	static XSSFSheet sheet2;

	
	//Parameterized constructor
	Reader(String file_path1, String sheet_name1, String file_path2, String sheet_name2) {
		
		try {
			
			workBook1 = new XSSFWorkbook(file_path1);
			sheet1 = workBook1.getSheet(sheet_name1);
			
			workBook2 = new XSSFWorkbook(file_path2);
			sheet2 = workBook2.getSheet(sheet_name2);
			
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		
	}
	
	

	
	
	//Function to read excel file
	ArrayList Read_xlsx(String Path) {
		//This method reads the excel files
		return null;
		
	}

}
