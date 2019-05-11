package com.qa.todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qa.todo.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	User findByuId(Long uId);
	List<User> findByUsernameAndPassword(String username, String password);
	List<User> findAllByUsername(String username);
	
}
