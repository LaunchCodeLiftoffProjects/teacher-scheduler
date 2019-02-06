package com.teacher.teacherscheduler.models;

/*
import java.util.HashMap;

public class PeriodHashMap{
    public static void main(String[] args) {

        HashMap<String, Double> period = new HashMap<>();

}
*/

/* The Classroom class has a name and a set of five empty periods. A period will be populated by one or more Resources or
be empty, either from a drop down list or custom name.
*/

public class Classroom {
    private int id;
    private static int nextid = 1;

    private String classroomName;
    private String classPeriod1;
    private String classPeriod2;
    private String classPeriod3;
    private String classPeriod4;
    private String classPeriod5;

    public Classroom() {
        id = nextid;
        nextid++;
    }

    public Classroom(String aName, String classPeriod1, String classPeriod2, String classPeriod3, String classPeriod4,
                     String classPeriod5){
        this();

        classroomName = aName;


    }
    public String getClassroomName() {return classroomName;}
    public void setClassroomName(String name) {this.classroomName = name;}

    public String getClassPeriod1() {return classPeriod1;}
    public void setclassPeriod1() {this.classPeriod1 = classPeriod1;}

    public String getClassPeriod2() {return classPeriod2;}
    public void setclassPeriod2() {this.classPeriod2 = classPeriod2;}

    public String getClassPeriod3() {return classPeriod3;}
    public void setclassPeriod3() {this.classPeriod3 = classPeriod3;}

    public String getClassPeriod4() {return classPeriod4;}
    public void setclassPeriod4() {this.classPeriod4 = classPeriod4;}

    public String getClassPeriod5() {return classPeriod5;}
    public void setclassPeriod5() {this.classPeriod5 = classPeriod5;}
}
