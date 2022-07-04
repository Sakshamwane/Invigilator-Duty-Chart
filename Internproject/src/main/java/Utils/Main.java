package Utils;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public Date d = new Date();
	
	public static void main(String[] args) {
		String f1 = "Internproject/src/main/java/file3.xlsx";
		String f2 = "Internproject/src/main/java/DataSheet2.xlsx";
		
		String s1 = "Regular";
		String s2 = "Sheet1";
		
	    Reader r1 = new Reader(f1, s1, f2, s2);
		r1.store();
		r1.print();
	    
	}
}
