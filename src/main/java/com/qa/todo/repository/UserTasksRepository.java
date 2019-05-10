package com.qa.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.todo.model.UserTasks;

public interface UserTasksRepository extends CrudRepository<UserTasks, String>{

}
