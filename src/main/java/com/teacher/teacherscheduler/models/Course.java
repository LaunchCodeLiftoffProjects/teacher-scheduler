package com.teacher.teacherscheduler.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //specify this annotation as store this class in DB
public class Course {


    @Id
    @GeneratedValue // this create unique id for every student.
    private int id;


    @NotNull
    @Size(min=1, max = 15, message="Please enter valid Name")
    private String name;


    @NotNull
    @Size(min=1, max = 15, message="Please enter valid Department")
    private String department;

    @NotNull
    @Size(min=1, max = 15, message="Please enter valid Description")
    private String description;



    // Default constructor is used for main
    public Course(){

    }

    // this constructor used for parameterised



    public Course(String name, String department, String description) {
        this.name = name;
        this.department = department;
        this.description = description;

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

    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }

    public String getDescription() {return description; }

    public void setDescription(String description) { this.description = description;    }

    public void setCourse(Course course){

    }


}
