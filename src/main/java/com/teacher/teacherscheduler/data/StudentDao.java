package com.teacher.teacherscheduler.data;


import com.teacher.teacherscheduler.models.Student;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student, Integer> {
}



//CrudRepository ===>  create read Update Delete
