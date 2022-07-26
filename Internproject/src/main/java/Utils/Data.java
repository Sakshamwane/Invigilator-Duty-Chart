package Utils;

import java.util.ArrayList;
import java.util.Date;

public class Data {

    private String name;
    private int age;
    private String department;
    private String designation;
    private Boolean availability;
    public ArrayList<Date> duty= new ArrayList<Date>();
    private int currentDuties=0;
    public int totalDuty;
   

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

    int getTotalDuty() {
        if (getDesignation().toLowerCase().trim() == "professor")
            this.totalDuty = 1;
        else if (getDesignation().toLowerCase().trim() == "associate professor")
            this.totalDuty = 2;
        else if (getDesignation().toLowerCase().trim() == "assistant professor"|| getDesignation().toLowerCase() == "asstt.w/s supdt.")
            this.totalDuty = 3;
        else if (getDesignation().toLowerCase().trim() == "head" || getDesignation().toLowerCase() == "dean"|| getDesignation().toLowerCase() == "director")
            this.totalDuty = 0;
        else
            this.totalDuty = 10;
        return totalDuty;
    }
    int getNoOfDuties(){
        return currentDuties;
    }
    void increaseNoOfDuites(){
        this.currentDuties++;
    }
}
