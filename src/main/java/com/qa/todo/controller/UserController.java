package com.qa.todo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.todo.model.User;
import com.qa.todo.repository.UserRepository;


@RestController
@RequestMapping("/users/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping (value = "getUser/{uId}", method = RequestMethod.GET)
	public User retrieve(@PathVariable Long uId) {
		return userRepository.findByuId(uId);
	}
	
	@RequestMapping (value="getAllUsers",method = RequestMethod.GET)
	public Iterable<User> retrieve(){
		return userRepository.findAll();
	}
	
	@RequestMapping (value = "addUser", method = RequestMethod.POST)
	public String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "user added";
	}
		
	@RequestMapping (value = "updateUser/{uId}", method = RequestMethod.PUT)
	public String updateUser(@RequestBody User newUser, @PathVariable Long uId) {
		User user = userRepository.findByuId(uId);
        BeanUtils.copyProperties(user, newUser);
		userRepository.save(user);
		return "user ID updated";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public Long login(@RequestBody User user) {
		List<User> activeUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
		return activeUser.get(0).getuId();
	}
	
	
}