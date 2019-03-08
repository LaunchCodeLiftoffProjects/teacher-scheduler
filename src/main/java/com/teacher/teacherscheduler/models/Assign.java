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

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

//    @OneToOne
//    @JoinColumn(name="course_id")
//    private Course course;

   public Assign(){

   }

    public Assign(String period, Teacher teacher, Student student) {
        this.period = period;
        this.teacher = teacher;
//        this.course = course;
        this.student = student;
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
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
