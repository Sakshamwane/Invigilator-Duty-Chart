package Utils;

import java.util.Date;
import java.io.FileOutputStream;

public class Main {

	public Date d = new Date();
	
	public static void main(String[] args) {

		FileOutputStream outputStream;
		String f1 = "Internproject/src/main/java/file3.xlsx";
		String f2 = "Internproject/src/main/java/DataSheet2.xlsx";
		
		String s1 = "Regular";
		String s2 = "Sheet1";

		String f3 = "Internproject/src/main/java/Datefile.xlsx";
		String s3 = "Sheet1";
		
	    Reader r1 = new Reader(f1, s1, f2, s2);
		r1.store();
		// r1.print();
		r1.readHeader(f3, s3);
		// r1.printHeader();
	    
		try {
			outputStream = new FileOutputStream("ResultSheet.xlsx");
			r1.generateFile(outputStream);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
