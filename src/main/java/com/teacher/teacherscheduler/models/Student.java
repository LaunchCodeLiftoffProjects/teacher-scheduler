package com.teacher.teacherscheduler.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //specify this annotation as store this class in DB
public class Student {


    @Id
    @GeneratedValue // this create unique id for every student.
    private int id;


    @NotNull
    @Size(min=1, max = 15, message="please enter valid name")
    private String name;


    @NotNull
    @Size(min=1, max = 15)
    private String grade;

    @NotNull
    private String emailId ;

    // Default constructor is used for main
    public Student(){

    }

    // this constructor used for parameterised

    public Student(String name, String grade, String emailId) {
        this.name = name;
        this.grade = grade;
        this.emailId = emailId;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setStudent(Student student) {
    }
}
