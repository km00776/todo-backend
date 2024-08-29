package com.karthicodes.todo.todo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
 

@RestController
public class TodoController {
    
    @RequestMapping("/hello")
    public String hello() {
        return "karthi";
    }
}
