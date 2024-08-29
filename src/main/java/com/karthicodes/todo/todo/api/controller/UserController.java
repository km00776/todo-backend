package com.karthicodes.todo.todo.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karthicodes.todo.todo.api.model.User;
import com.karthicodes.todo.todo.service.UserService;
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);   
        if(user.isPresent()) {
            return (User) user.get();
        }
        return null;
    }
    
}
 