package Utils;

import java.util.ArrayList;
import java.util.Date;

public class Data {

    private String name;
    private int age;
    private String department;
    private String designation;
    private Boolean availability;
    private ArrayList duty;
    private Date date;
    private int noOfStudents;
    private int noOfInvigilators;

    public Data(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }

    int getAge(){
        return age;
    }

    void setAge(int age){
        this.age = age;
    }
    
    String getDesignation(){
        return designation;
    }

    void setDesignation(String designation){
        this.designation = designation;
    }

    String getDepartment(){
        return department;
    }

    void setDepartment(String department){
        this.department = department;
    }

    Boolean getAvaibility(){
        return availability;
    }

    void setAvaibility(Boolean avail){
        this.availability = avail;
    }

    Date getDate(){
        return date;
    }

    void setDate(Date date){
        this.date = date;
    }

    int getNoOfStudents(){
        return noOfStudents;
    }

    void setNoOfStudents(int noOfStudents){
        this.noOfStudents = noOfStudents;
    }

    int getNoOfInvigilators(){
        return noOfInvigilators;
    }

    void setNoOfInvigilators(int noOfInvigilators){
        this.noOfInvigilators = noOfInvigilators;
    }

}
