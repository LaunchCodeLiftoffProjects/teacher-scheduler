package com.teacher.teacherscheduler.data;


import com.teacher.teacherscheduler.models.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClassroomDao extends CrudRepository<Classroom, Integer> {

}