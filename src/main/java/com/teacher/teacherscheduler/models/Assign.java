package com.teacher.teacherscheduler.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assign {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    private String period;

   @OneToOne
   @JoinColumn(name="teacher_id")
    private Teacher teacher;

//    @OneToOne
//    @JoinColumn(name="student_id")
//    private Student student;



   public Assign(){

   }

    public Assign(String period, Teacher teacher) {
        this.period = period;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }



}
