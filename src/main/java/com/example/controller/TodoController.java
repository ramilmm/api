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

	@CrossOrigin(origins = "*")
    @GetMapping("/api/todo")
	@ResponseBody
    public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/api/todo")
	public void saveTodo(@Valid @RequestBody Todo todo) { todoService.saveTodo(todo); }

	@CrossOrigin(origins = "*")
	@PutMapping("/api/todo")
	public void updateTodo(@Valid @RequestBody Todo todo) { todoService.saveTodo(todo);}

	@CrossOrigin(origins = "*")
    @GetMapping("/api/todo/{id}")
	@ResponseBody
    public Todo getTodo(@PathVariable("id") long id) {
		return todoService.getTodoById(id);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/api/todo/{id}")
	public void deleteById(@PathVariable("id") Long id) { todoService.deleteTodo(id); }

	@CrossOrigin(origins = "*")
	@GetMapping("/api/todo/finished")
	public List<Todo> getAllFinishedTodos() {
    	return todoService.getFinishedTodos();
	}
}


