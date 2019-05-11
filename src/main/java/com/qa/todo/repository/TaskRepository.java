package com.qa.todo.repository;

import com.qa.todo.model.Task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String>{

	Task findBytId(Long tId);
	List<Task> findByuId(Long uId);
	@Override
	List<Task> findAll();
	
}
