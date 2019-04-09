package com.teacher.teacherscheduler.data;


import com.teacher.teacherscheduler.models.Student;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student, Integer> {
    //Student findByName(String name);

//    Student findAllStudents(String name);

    Student findAllStudentsByName(String search);
//    Student findOne(String studentName);
}



//CrudRepository ===>  create read Update Delete
