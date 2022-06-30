package Utils;

import java.util.ArrayList;
import java.util.Date;

public class Main {

	public Date d = new Date();
	
	public static void main(String[] args) {
		String f1 = "Internproject/src/main/java/DataSheet1.xlsx";
		String f2 = "Internproject/src/main/java/DataSheet2.xlsx";
		
		String s1 = "Sheet1";
		String s2 = "Sheet1";
		
	    //Reader r1 = new Reader(f1, s1, f2, s2);
	    //r1.test();

		//Arraylist <Data>
		ArrayList<Data> professors = new ArrayList<Data>(100);


		//Adding 10 professors to the list
		professors.add(new Data("Professors_1", "CSE", "Associate professor"));
		professors.add(new Data("Professors_2", "ME", "Assistant professor"));
		professors.add(new Data("Professors_3", "IT", "Professor"));

		for (int i=0; i<professors.size(); i++){
			Data currentObj = professors.get(i);
			System.out.println("Name: " + currentObj.getName());
			System.out.println("Age: " + currentObj.getName());
			System.out.println("Department: " + currentObj.getDepartment());
			System.out.println("Designation: " + currentObj.getDesignation());
			System.out.println("Availability: " + currentObj.getAvaibility());
			System.out.println("No. of students: " + currentObj.getNoOfStudents());
			System.out.println("No. of invigilators: " + currentObj.getNoOfInvigilators());
			
		}
	}
}
