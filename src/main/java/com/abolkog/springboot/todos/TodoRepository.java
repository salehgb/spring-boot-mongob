package com.abolkog.springboot.todos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
	Todo findByTitle(String title);
	 List<Todo> findByUserId(String ueserId);

}
