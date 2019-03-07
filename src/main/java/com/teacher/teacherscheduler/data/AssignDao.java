package com.teacher.teacherscheduler.data;

import com.teacher.teacherscheduler.models.Assign;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface AssignDao extends CrudRepository<Assign, Integer> {
}
