package com.qa.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.qa.todo.model.Task;
import com.qa.todo.repository.TaskRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskrepository;
	
	@RequestMapping (value = "tasks", method = RequestMethod.GET)

	public Iterable<Task> list() {
		return taskrepository.findAll();
	}
	
	@RequestMapping (value = "tasks", method = RequestMethod.POST)
	public String addTask(@RequestBody Task task) {
		taskrepository.save(task);
		return "added to list";
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.PUT)
	public String updateTask(@RequestBody Task newTask, @PathVariable String identifier) {
		Task task = taskrepository.findById(identifier).get();
		task.setText(newTask.getText());
		taskrepository.save(task);
		return "task changed";
	}
	
	@RequestMapping (value = "tasks/{identifier}", method = RequestMethod.DELETE)
	public String deleteTask(@PathVariable String identifier) {
		Task task = taskrepository.findById(identifier).get();
		taskrepository.delete(task);
		return "task deleted";
	}
	
}
