package Utils;

import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

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
				header.add(new Header(headerWorkSheet.getRow(i).getCell(0).getDateCellValue()));
			}

		} catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

	void printHeader(){
		for(int i = 0; i<header.size(); i++){
			System.out.println(header.get(i).getDate());
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


	void generateFile(FileOutputStream outputStream) throws SQLException, IOException{
		
		XSSFWorkbook resultWorkbook = new XSSFWorkbook();
		XSSFSheet resultSheet = resultWorkbook.createSheet("Sheet 1");
		CreationHelper createHelper = resultWorkbook.getCreationHelper();
		try {
			Row row1Row = resultSheet.createRow(0);
			Cell cell2 = row1Row.createCell(0);
			cell2.setCellValue("SGSITS, INDORE");
			CellStyle cellStyle1 = resultWorkbook.createCellStyle();
			cellStyle1.setAlignment(HorizontalAlignment.CENTER);
			// cellStyle.setAlignment(VerticalAlignment.MIDDLE);
			cell2.setCellStyle(cellStyle1);

			resultSheet.addMergedRegion(new CellRangeAddress(0, 3, 0, header.size()+2));
			for (int counter = 0; counter < professors.size(); counter++){
				Row row = resultSheet.createRow(counter+5);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue(counter+1);
				Cell cell = row.createCell(1);
				cell.setCellValue(professors.get(counter).getName());
			}
			
			Row row =resultSheet.createRow(4);
			for(int counter = 0;counter<header.size();counter++){
				CellStyle cellStyle = resultWorkbook.createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy"));
				Cell cell = row.createCell(counter+2);
				cell.setCellValue(header.get(counter).getDate());
				cell.setCellStyle(cellStyle);
			}
				resultWorkbook.write(outputStream);
				resultWorkbook.close();
		} catch(Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

}
