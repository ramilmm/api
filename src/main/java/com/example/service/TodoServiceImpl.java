package com.example.service;

import java.util.List;

import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoRepository todoRepository;

	@Override
	public Todo getTodoById(long id) {
		return todoRepository.findOne(id);
	}

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public void saveTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public void updateTodo(Todo todo) {
		todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.delete(id);
	}

}
