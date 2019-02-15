package com.teacher.teacherscheduler.data;


import com.teacher.teacherscheduler.models.Student;
import com.teacher.teacherscheduler.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeacherDao extends CrudRepository<Teacher, Integer> {
}