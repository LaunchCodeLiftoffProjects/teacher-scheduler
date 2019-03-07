package com.teacher.teacherscheduler.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity //specify this annotation as store this class in DB
public class Teacher {


    @Id
    @GeneratedValue // this create unique id for every student.
    private int id;


    @NotNull
    @Size(min=5, max = 15, message="Please enter valid Name")
    private String name;



    @NotNull
    @Email
    @Size(min=10,max=25, message= "Please enter valid emailID")
    private String emailId ;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(unique = true)
//    private  Assign assign;
    // Default constructor is used for main
    public Teacher(){

    }

    // this constructor used for parameterised

    public Teacher(String name,  String emailId) {
        this.name = name;

        this.emailId = emailId;
    }


    public void setId(int id) {
        this.id = id;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

//    public Assign getAssign() {
//        return assign;
//    }
//
//    public void setAssign(Assign assign) {
//        this.assign = assign;
//    }


}
