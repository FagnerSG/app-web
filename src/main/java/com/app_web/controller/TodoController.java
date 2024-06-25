package com.app_web.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app_web.entity.Todo;
import com.app_web.service.TodoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/todos")
public class TodoController {
    public TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @ApiOperation(value = "Create a todo")
    @PostMapping
    @RequestMapping(value="/todo", method=RequestMethod.POST)
    List<Todo> create(@RequestBody Todo todo) {
        return todoService.create(todo);
    };

    @ApiOperation(value = "View a list of available todos", response = List.class)
    @GetMapping
    @RequestMapping(value="/todo", method=RequestMethod.GET)
    List<Todo> list() {
        return todoService.list();
    }

    @ApiOperation(value = "Update a todo")
    @PutMapping
    @RequestMapping(value="/todo", method=RequestMethod.PUT)
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @ApiOperation(value = "Delete a todo")
    @DeleteMapping("/{id}")
    @RequestMapping(value="/todo", method=RequestMethod.DELETE)
    List<Todo> delete(@PathVariable()Long id) {
        return todoService.delete(id);
    }

}
