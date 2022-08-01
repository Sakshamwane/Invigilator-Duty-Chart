package Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class Reader {

	static XSSFWorkbook workBook1; // permanent faculties data
	static XSSFSheet sheet1;
	static XSSFWorkbook workBook2; // contract faculties data
	static XSSFSheet sheet2;

	static XSSFWorkbook headerWorkBook;
	static XSSFSheet headerWorkSheet;

	public ArrayList<Data> professors = new ArrayList<Data>();
	public ArrayList<Data> contract = new ArrayList<Data>();
	public ArrayList<Header> header = new ArrayList<Header>();
	public ArrayList<Data> finalList = new ArrayList<Data>();
	public String branch_keyword[] = { "Civil", "Electrical", "Industrial", "Central", "Computer Engineering",
			"Telecommunication", "Mechanical", "Instrumentation", "Information", "Application", "Biomedical",
			"Pharmacy", "Management", "MBA", "Physics", "Chemistry", "Mathematics", "Humanities" };

	// Parameterized constructor
	public Reader(String FilePath1, String SheetName1, String FilePath2, String SheetName2) {
		try {

			workBook1 = new XSSFWorkbook(FilePath1);

			sheet1 = workBook1.getSheet(SheetName1);

			workBook2 = new XSSFWorkbook(FilePath2);

			sheet2 = workBook2.getSheet(SheetName2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void readHeader(String filePathForHeader, String sheetName) {
		try {
			headerWorkBook = new XSSFWorkbook(filePathForHeader);
			headerWorkSheet = headerWorkBook.getSheet(sheetName);
			for (int i = 1; i < headerWorkSheet.getPhysicalNumberOfRows(); i++) {
				header.add(new Header(headerWorkSheet.getRow(i).getCell(0).getDateCellValue(),
						headerWorkSheet.getRow(i).getCell(1).getNumericCellValue()));
			}
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}

	}

	void store() {
		try {
			for (int i = 4, j = 0; i < sheet1.getPhysicalNumberOfRows(); i++) {
				if (sheet1.getRow(i).getCell(0).getCellType() == CellType.STRING) {
					// System.out.println("i");
					continue;
				} else {
					professors.add(new Data(sheet1.getRow(i).getCell(1).toString()));
					professors.get(j).setDesignation(sheet1.getRow(i).getCell(2).toString());
					professors.get(j).setDepartment(sheet1.getRow(i).getCell(3).toString());
					professors.get(j).getTotalDuty();
					j++;
				}
			}
			for (int i = 3, j = 0; i < sheet2.getPhysicalNumberOfRows() - 1; i++, j++) {
				contract.add(new Data(sheet2.getRow(i).getCell(1).toString()));
				contract.get(j).setDesignation("Contract faculty");
				contract.get(j).setDepartment(sheet2.getRow(i).getCell(2).toString());
			}
			// for(int i=0;i<professors.size();i++){
			// System.out.println(professors.get(i).getDepartment());
			// }
			for (int i = 0; i < branch_keyword.length; i++) {
				for (int j = 0; j < professors.size(); j++) {
					// System.out.println(professors.get(j).getDepartment());
					if (professors.get(j).getDepartment().contains(branch_keyword[i])) {
						finalList.add(professors.get(j));
						// System.out.println(finalList.add(professors.get(j)));
					}
				}
				for (int k = 0; k < contract.size(); k++) {
					// System.out.println(contract.get(k).getDepartment());
					if (contract.get(k).getDepartment().contains(branch_keyword[i])) {
						finalList.add(contract.get(k));
						// System.out.println(finalList.add(contract.get(k)));
					}
				}
			}
		} catch (Exception e) {
			e.getCause();
			System.out.println(e.getMessage());
		}
	}

	void generateFile(FileOutputStream outputStream) throws SQLException, IOException {

		XSSFWorkbook resultWorkbook = new XSSFWorkbook();
		XSSFSheet resultSheet = resultWorkbook.createSheet("Sheet 1");
		CreationHelper createHelper = resultWorkbook.getCreationHelper();
		try {
			Row row1Row = resultSheet.createRow(0);
			Cell cell2 = row1Row.createCell(0);
			cell2.setCellValue(
					"Shri G. S. Institute of Technology & Science Indore -452003\nUG/PG Examination April 2022\n Invigilation Duty Chart\n\n(Exam Time is 11:00 AM TO 02:00 PM)\nReporting Time for Invigilators is 10:30 AM Sharp in ATC-308\n(II FLOOR ATC BUILDING)\n\n");

			Font newFont = cell2.getSheet().getWorkbook().createFont();
			newFont.setBold(true);
			// newFont.setColor(10);
			newFont.setFontHeightInPoints((short) 7);
			// newFont.setItalic(true);

			CellStyle cellStyle1 = resultWorkbook.createCellStyle();
			cellStyle1.setAlignment(HorizontalAlignment.CENTER);
			cellStyle1.setVerticalAlignment(VerticalAlignment.TOP);
			cellStyle1.setWrapText(true);
			cellStyle1.setFont(newFont);
			cell2.setCellStyle(cellStyle1);

			resultSheet.addMergedRegion(new CellRangeAddress(0, 3, 0, header.size() + 2));
			for (int counter = 0; counter < finalList.size(); counter++) {
				Row row = resultSheet.createRow(counter + 10);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue(counter + 1);
				Cell cell = row.createCell(1);
				cell.setCellValue(finalList.get(counter).getName());
			}

			Row row = resultSheet.createRow(4);
			Cell cell1c = row.createCell(0);
			cell1c.setCellValue("Duty Chart No.");
			Cell cell2c = row.createCell(1);
			cell2c.setCellValue("Exam Dates");



			for (int counter = 0; counter < header.size(); counter++) {
				CellStyle cellStyle = resultWorkbook.createCellStyle();
				cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yy"));
				Cell cell = row.createCell(counter + 2);
				cell.setCellValue(header.get(counter).getDate());
				cell.setCellStyle(cellStyle);
			}

			Duty duty = new Duty();
			duty.FillDuty(finalList, header);
			resultSheet.createRow(finalList.size() + 10);
			for (int i = 0; i < finalList.size(); i++) {
				for (int j = 0; j < header.size(); j++) {
					if (finalList.get(i).duty.contains(header.get(j).getDate())) {
						resultSheet.getRow(i + 10).createCell(j + 2).setCellValue(1);;
						header.get(j).increaseTotalD();
						resultSheet.getRow(i + 10).createCell(header.size() + 2)
								.setCellValue(finalList.get(i).duty.size());
						resultSheet.getRow(finalList.size() + 10).createCell(j + 2)
								.setCellValue(header.get(j).getTotalD());
					}
				}
				// System.out.println(professors.get(i).getDesignation());
			}
			resultSheet.autoSizeColumn(1);
			resultWorkbook.write(outputStream);
			resultWorkbook.close();
		} catch (Exception e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

}
