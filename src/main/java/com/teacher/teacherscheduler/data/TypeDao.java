package com.teacher.teacherscheduler.data;

import com.teacher.teacherscheduler.models.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface TypeDao extends CrudRepository<Type, Integer> {

}

