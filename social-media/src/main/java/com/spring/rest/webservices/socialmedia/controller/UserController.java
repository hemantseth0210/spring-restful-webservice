package com.spring.rest.webservices.socialmedia.controller;

import java.util.List;

import javax.validation.Valid;

import com.spring.rest.webservices.socialmedia.entity.User;
import com.spring.rest.webservices.socialmedia.exception.UserNotFoundException;
import com.spring.rest.webservices.socialmedia.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
    UserDao userDao;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id){
		User user = userDao.findById(id);
		if(user == null)
			throw new UserNotFoundException(String.format("User is not found with id %s", id));
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userDao.save(user);
		/*
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		*/
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		User user = userDao.deleteById(id);
		if(user == null)
			throw new UserNotFoundException(String.format("User is not found with id %s", id));
	}
}
