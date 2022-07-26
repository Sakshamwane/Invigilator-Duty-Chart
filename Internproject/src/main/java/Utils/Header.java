package Utils;

import java.util.Date;

public class Header {
    private Date date;
    public int assignendDuties=0;
    private double noOfStudents;
    private int noOfInvigilators;


    public void increaseDuty(){
        this.assignendDuties++;
    }

    public Header(Date date, Double noOfStudents){
        this.date = date;  
        this.noOfStudents=noOfStudents;
    }

    Date getDate(){
        return date;
    }

    void setDate(Date date){
        this.date = date;
    }

    double getNoOfStudents(){
        return noOfStudents;
    }

    void setNoOfStudents(int noOfStudents){
        this.noOfStudents = noOfStudents;
    }

    int getNoOfInvigilators(){
        return (int)noOfStudents/20;
    }

    void setNoOfInvigilators(int noOfInvigilators){
        this.noOfInvigilators = noOfInvigilators;
    }
}
