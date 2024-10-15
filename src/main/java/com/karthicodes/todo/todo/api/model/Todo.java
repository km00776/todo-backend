package com.karthicodes.todo.todo.api.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {
    @Id
    private String id;
    private String title;
    private String description;

}
