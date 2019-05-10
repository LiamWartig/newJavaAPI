package com.qa.todo.repository;

import com.qa.todo.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String>{

}
