package Utils;

import java.util.Date;

public class Header {
    private String date;
    private int noOfStudents;
    private int noOfInvigilators;

    public Header(String date){
        this.date = date;
        
    }

    String getDate(){
        return date;
    }

    void setDate(String date){
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
