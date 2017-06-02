package com.example.service;

import java.util.List;

import com.example.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TodoRepository todoRepository;

	@Override
	public Todo getTodoById(long id) {
		Todo todo = todoRepository.findOne(id);
		if (todo != null) {
			logger.info("Get todo with ID = " + id);
			return todo;
		}else {
			logger.error("Can`t get todo item with id=" + id);
			return null;
		}
	}

	@Override
	public List<Todo> getAllTodos() {
		logger.info("Get all todo items");
		return todoRepository.findAll();
	}

	@Override
	public void saveTodo(Todo todo) {
		logger.info("New Todo saved!");
		todoRepository.save(todo);
	}


	@Override
	public void deleteTodo(Long id) {
		if (todoRepository.findOne(id) != null) {
			todoRepository.delete(id);
			logger.info("Todo with id=" + id + " was deleted");
		}else {
			logger.error("Can`t find todo with id=" + id);
		}
	}

	@Override
	public List<Todo> getFinishedTodos() {
		List<Todo> todos = todoRepository.findByisFinished(true);
		if (todos.size() > 0) {
			logger.info("Get finished todos");
			return todos;
		}else {
			logger.error("Can`t get finished todos");
			return null;
		}
	}

}
