//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.teacher.teacherscheduler.models;

import javax.persistence.*;

@Entity
public class Classroom {

    @Id
    @GeneratedValue
    private int id;

    private String classroomName;
    private String classPeriod1;
    private String classPeriod2;
    private String classPeriod3;
    private String classPeriod4;
    private String classPeriod5;



    @OneToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Classroom() {
    }

    public Classroom(String aName, String aclassPeriod1, String aclassPeriod2, String aclassPeriod3, String aclassPeriod4, String aclassPeriod5, Teacher ateacher) {
        this();
        this.classroomName = aName;
        this.classPeriod1 = aclassPeriod1;
        this.classPeriod2 = aclassPeriod2;
        this.classPeriod3 = aclassPeriod3;
        this.classPeriod4 = aclassPeriod4;
        this.classPeriod5 = aclassPeriod5;
        this.teacher = ateacher;

//        this.id = aclassroomId;

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
        this.classPeriod1 = classPeriod1;
    }

    public String getClassPeriod2() {
        return this.classPeriod2;
    }

    public void setclassPeriod2(String classPeriod2) {
        this.classPeriod2 = classPeriod2;
    }

    public String getClassPeriod3() {
        return this.classPeriod3;
    }

    public void setclassPeriod3(String classPeriod3) {this.classPeriod3 = classPeriod3;
    }

    public String getClassPeriod4() {
        return this.classPeriod4;
    }

    public void setclassPeriod4(String classPeriod4) {
        this.classPeriod4 = classPeriod4;
    }

    public String getClassPeriod5() {
        return this.classPeriod5;
    }

    public void setclassPeriod5(String classPeriod5) {
        this.classPeriod5 = classPeriod5;
    }
    public int getId() { return id;
    }
    public void setClassroom (Classroom classroom){

    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
