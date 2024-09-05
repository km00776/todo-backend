    package com.karthicodes.todo.todo;

    import org.springframework.data.mongodb.repository.MongoRepository;

import com.karthicodes.todo.todo.api.model.User;
    
    public interface UserRepository extends MongoRepository<User, String>{
        
    }