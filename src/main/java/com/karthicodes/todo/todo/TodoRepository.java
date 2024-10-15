package com.karthicodes.todo.todo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.karthicodes.todo.todo.api.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
    
}
