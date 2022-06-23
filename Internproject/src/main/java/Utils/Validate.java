package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Validate {

	public XSSFSheet[] arr;

	public Validate(XSSFSheet sheet1, XSSFSheet sheet2) {

		arr = new XSSFSheet[] { sheet1, sheet2 };

	}

	int isNamePresent() {
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			x = 0;
			for (int j = 0; j < arr[i].getRow(0).getLastCellNum(); j++) {
				Cell columnName = arr[i].getRow(0).getCell(j);
				if (columnName.getStringCellValue().compareToIgnoreCase("name") == 0) {
					x = 1;
				}
			}
		}
		return x;
	}

}