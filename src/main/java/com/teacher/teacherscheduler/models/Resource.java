package com.teacher.teacherscheduler.models;

/*
import java.util.HashMap;

public class PeriodHashMap{
    public static void main(String[] args) {

        HashMap<String, Double> period = new HashMap<>();

}
*/

/* The Resource class has a name and a set of five empty periods. A period will be a location of the classroom,
either from a drop down list or custom name. The periods should be tied to a day and reset to empty when a new schedule
is made so teacher availability functionality can be implemented.
*/

public class Resource {
    private int id;
    private static int nextid = 1;

    private String name;
    private String period1;
    private String period2;
    private String period3;
    private String period4;
    private String period5;

    public Resource() {
        id = nextid;
        nextid++;
    }

    public Resource(String aName, String period1, String period2, String period3, String period4, String period5){
        this();

        name = aName;


    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getPeriod1() {return period1;}
    public void setPeriod1() {this.period1 = period1;}

    public String getPeriod2() {return period2;}
    public void setPeriod2() {this.period2 = period2;}

    public String getPeriod3() {return period3;}
    public void setPeriod3() {this.period3 = period3;}

    public String getPeriod4() {return period4;}
    public void setPeriod4() {this.period4 = period4;}

    public String getPeriod5() {return period5;}
    public void setPeriod5() {this.period5 = period5;}
}
