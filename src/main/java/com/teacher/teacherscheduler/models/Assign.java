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

    @OneToOne
    @JoinColumn(name="course_id")
    private Course course;

   public Assign(){

   }
//
//    public Assign(String period, Teacher teacher, Student student, Course course) {
//        this.period = period;
//        this.teacher = teacher;
//        this.student = student;
//        this.course = course;
//    }

    public Assign(String period, Teacher teacher, Student student, Course course) {
        this.period = period;
        this.teacher = teacher;
        this.student = student;
        this.course = course;
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



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
