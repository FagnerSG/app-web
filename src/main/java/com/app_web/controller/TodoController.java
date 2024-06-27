package com.app_web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app_web.entity.Todo;
import com.app_web.service.TodoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @ApiOperation(value = "Create um novo Todo")
    @PostMapping("/todo")
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    };

    @ApiOperation(value = "Get Todo por ID")
    @GetMapping("/todo")
    List<Todo> list() {
        return todoService.list();
    }

    @ApiOperation(value = "Atualiza a Todo")
    @PutMapping("/todo")
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @ApiOperation(value = "Delete a Todo por ID")
    @DeleteMapping("/todo/{id}")
    List<Todo> delete(@PathVariable("id") String id) {
        return todoService.delete(id);
    }

}
