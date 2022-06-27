package Utils;

public class Main {
	
	public static void main(String[] args) {
		String f1 = "Internproject/src/main/java/DataSheet1.xlsx";
		String f2 = "Internproject/src/main/java/DataSheet2.xlsx";
		
		String s1 = "Sheet1";
		String s2 = "Sheet1";
		
	    Reader r1 = new Reader(f1, s1, f2, s2);
	    r1.test();
	}
}
