package com.abolkog.springboot.todos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abolkog.springboot.error.ConflictException;
import com.abolkog.springboot.error.NotFoundException;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Khalid Elshafie <abolkog@gmail.com>
 * @Created 11/09/2018 9:16 PM.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    /**
     * Get all todos
     * @return List of todos
     */
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findByUser(String id) {
        return todoRepository.findByUserId(id);
    }

    public Todo getById(String id) {
        try {
            return todoRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new NotFoundException(String.format("No Record with the id [%s] was found in our database", id));
        }
    }

    public Todo post(Todo todo) {
        if (todoRepository.findByTitle(todo.getTitle()) != null) {
            throw new ConflictException("Another record with the same title exists");
        }

        return todoRepository.insert(todo);
    }

    public void delete(String id) {
       todoRepository.deleteById(id);
    }
    
    
    
    
}