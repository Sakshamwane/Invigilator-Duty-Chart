package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
	
	static XSSFWorkbook workBook1;
	static XSSFSheet sheet1;
	static XSSFWorkbook workBook2;
	static XSSFSheet sheet2;

	
	//Parameterized constructor
	public Reader(String FilePath1, String SheetName1, String FilePath2, String SheetName2) {
		try {
			
			workBook1 = new XSSFWorkbook(FilePath1);
			
			sheet1 = workBook1.getSheet(SheetName1);
			
			workBook2 = new XSSFWorkbook(FilePath2);
			
			sheet2 = workBook2.getSheet(SheetName2);
		} catch(Exception e) {
			System.out.println(e.getMessage());		
		}
	}
	
	void test() {
//		System.out.println(sheet1.getPhysicalNumberOfRows());
//		System.out.println(sheet2.getPhysicalNumberOfRows());
		
		Validate obj = new Validate(sheet1, sheet2);
		
		if(obj.isNamePresent()) {
			System.out.println("Name is present");
		} else {
			System.out.println("Name is not present, give valid files");
		}
	}
	

}