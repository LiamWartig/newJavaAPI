package com.qa.todo.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.qa.todo.model.Task;
import com.qa.todo.repository.TaskRepository;


@RestController
@RequestMapping("/tasks/")
public class TaskController {

	@Autowired
	private TaskRepository taskrepository;
	
	@RequestMapping (value = "getAllTasks", method = RequestMethod.GET)
	public Iterable<Task> retrieve() {
		return taskrepository.findAll();
	}
	
	@RequestMapping(value="getUsersTasks",method=RequestMethod.GET)
	public Iterable<Task> retrieveByuId(@PathVariable Long uId){
		return taskrepository.findByuId(uId);
	}
	
	@RequestMapping (value = "addTask", method = RequestMethod.POST)
	public String addTask(@RequestBody Task task) {
		taskrepository.save(task);
		return "added to list";
	}
	
	@RequestMapping (value = "update/{tId}", method = RequestMethod.PUT)
	public String updateTask(@RequestBody Task newTask, @PathVariable Long tId) {
		Task task = taskrepository.findBytId(tId);
        BeanUtils.copyProperties(task, newTask);
		taskrepository.save(task);
		return "task changed";
	}
	
	@RequestMapping (value = "delete/{tId}", method = RequestMethod.DELETE)
	public String deleteTask(@PathVariable Long tId) {
		Task task = taskrepository.findBytId(tId);
		taskrepository.delete(task);
		return "task deleted";
	}
	
}
