package com.example.controller;

import java.util.List;

import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.TodoService;

import javax.validation.Valid;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
    @GetMapping("/api/todo")
	@ResponseBody
    public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@PostMapping("/api/todo")
	public void saveTodo(@Valid @RequestBody Todo todo) { todoService.saveTodo(todo); }

    @GetMapping("/api/todo/{id}")
	@ResponseBody
    public Todo getTodo(@PathVariable("id") long id) {
		return todoService.getTodoById(id);
	}

	@DeleteMapping("/api/todo/{id}")
	public void deleteById(@PathVariable("id") Long id) { todoService.deleteTodo(id); }
}


