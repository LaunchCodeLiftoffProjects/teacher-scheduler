//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.teacher.teacherscheduler.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Classroom {

    @Id
    @GeneratedValue
    private int classroomId;

    private String classroomName;
    private String classPeriod1;
    private String classPeriod2;
    private String classPeriod3;
    private String classPeriod4;
    private String classPeriod5;


    public Classroom() {    }

    public Classroom(String aName, String classPeriod1, String classPeriod2, String classPeriod3, String classPeriod4, String classPeriod5) {
        this();
        this.classroomName = aName;
    }

    public String getClassroomName() {
        return this.classroomName;
    }

    public void setClassroomName(String name) {
        this.classroomName = name;
    }

    public String getClassPeriod1() {
        return this.classPeriod1;
    }

    public void setclassPeriod1(String classPeriod1) {
        this.classPeriod1 = this.classPeriod1;
    }

    public String getClassPeriod2() {
        return this.classPeriod2;
    }

    public void setclassPeriod2(String classPeriod2) {
        this.classPeriod2 = this.classPeriod2;
    }

    public String getClassPeriod3() {
        return this.classPeriod3;
    }

    public void setclassPeriod3(String classPeriod3) {
        this.classPeriod3 = this.classPeriod3;
    }

    public String getClassPeriod4() {
        return this.classPeriod4;
    }

    public void setclassPeriod4(String classPeriod4) {
        this.classPeriod4 = this.classPeriod4;
    }

    public String getClassPeriod5() {
        return this.classPeriod5;
    }

    public void setclassPeriod5(String classPeriod5) {
        this.classPeriod5 = this.classPeriod5;
    }
    public void getId() {
        this.classroomId = this.classroomId;
    }
    public void setClassroom (Classroom classroom){

    }

}
