package com.app_web.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app_web.entity.Todo;

@EnableScan
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long>{

}
