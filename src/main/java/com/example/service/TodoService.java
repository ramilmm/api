package com.example.service;

import java.util.List;
import com.example.model.Todo;

public interface TodoService {
	Todo getTodoById(long id);
	List<Todo> getAllTodos();
	void saveTodo(Todo todo);
	void updateTodo(Todo todo);
	void deleteTodo(Long id);
}
