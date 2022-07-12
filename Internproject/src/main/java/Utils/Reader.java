package Utils;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
	
	static XSSFWorkbook workBook1;
	static XSSFSheet sheet1;
	static XSSFWorkbook workBook2;
	static XSSFSheet sheet2;
	static XSSFWorkbook headerWorkBook;
	static XSSFSheet headerWorkSheet;

	public ArrayList<Data> professors = new ArrayList<Data>();
	public ArrayList<Header> header = new ArrayList<Header>();

	
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
		
		Validate obj = new Validate(sheet1, sheet2);
		
		if(obj.isNamePresent()) {
			System.out.println("Name is present");
		} else {
			System.out.println("Name is not present, give valid files");
		}

		if(obj.isDepartmentValid()){
			System.out.println("Department is present");
		} else {
			System.out.println("Department is not present give valid files");
		}
	}

	void readHeader(String filePathForHeader, String sheetName){
		try{
			headerWorkBook = new XSSFWorkbook(filePathForHeader);
			headerWorkSheet = headerWorkBook.getSheet(sheetName);
			for(int i = 1; i<headerWorkSheet.getPhysicalNumberOfRows(); i++){
				header.add(new Header(headerWorkSheet.getRow(i).getCell(0).toString()));
			}

		} catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

	void printHeader(){
		for(int i = 0; i<header.size(); i++){
			System.out.println(header.get(i));
		}
	}

	void store(){
		try{
			for(int i = 4, j = 0; i < sheet1.getPhysicalNumberOfRows(); i++, j++){
				professors.add(new Data(sheet1.getRow(i).getCell(1).toString()));
				professors.get(j).setDesignation(sheet1.getRow(i).getCell(2).toString());
				professors.get(j).setDepartment(sheet1.getRow(i).getCell(3).toString());
			}
		
			
		} catch(Exception e){
			System.out.println("Array Index Out Of Bound");
		}
	}

	void print(){
		for(int i = 0; i<professors.size(); i++){
			System.out.println(professors.get(i).getName() + "\t" + professors.get(i).getDesignation() + "\t" + professors.get(i).getDepartment());
		}
	}



}
