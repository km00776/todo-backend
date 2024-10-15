package com.karthicodes.todo.todo.api.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthicodes.todo.todo.TodoRepository;
import com.karthicodes.todo.todo.api.model.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class TodoController {
    @Autowired
     private TodoRepository todoRepository;
    
     @GetMapping("/todos/{id}")
     public List<Todo> getTodosById() {
      return todoRepository.findAll();
    }
    // temperary endpoint, we should be deleting todo and id
    @GetMapping("/todos")
    public List<Todo> getTodos() {
     return todoRepository.findAll();
    }
    @PostMapping("/todos/createTodo")
    public Todo PostUser(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }


    @DeleteMapping("/todos/deleteTodo/${id}")
    public String deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
        return id;
    }
    }


