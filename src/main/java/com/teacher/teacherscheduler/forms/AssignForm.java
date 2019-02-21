package com.teacher.teacherscheduler.forms;

import com.teacher.teacherscheduler.models.Student;
import com.teacher.teacherscheduler.models.Teacher;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AssignForm {
//    private List<Teacher> teachers;
//    private List<Student> students;
    private Teacher teacher;
    private Student student;
//    private Course course;

    @NotNull
    private int assignId;

    @NotNull
    private int teacherId;

    @NotNull
    private int courseId;

    @NotNull
    private int studentId;




   public AssignForm(){

   }

    public AssignForm(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }

    //    public AssignForm(Teacher teachers, Iterable<Teacher> students) {
//        this.teachers = teachers;
//        this.students = students;
//    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
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

    public void setStudent(Student students) {
        this.student = students;
    }


//    public List<Teacher> getTeachers() {
//        return teachers;
//    }
//
//    public void setTeachers(List<Teacher> teachers) {
//        this.teachers = teachers;
//    }
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    public int getAssignId() {
        return assignId;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
}