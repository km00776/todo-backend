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
import org.springframework.web.bind.annotation.PutMapping;


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
    public Todo postTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @PutMapping("/todos/updateTodo/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo updatedTodo) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);

        if(existingTodo == null) {
            throw new RuntimeException( "Todo not found: " + id);
        }

        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());

        return todoRepository.save(existingTodo);

    }


    @DeleteMapping("/todos/deleteTodo/{id}")
    public String deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
        return id;
    }
    }


