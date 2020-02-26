package com.spring.rest.webservices.socialmedia.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.spring.rest.webservices.socialmedia.entity.Post;
import com.spring.rest.webservices.socialmedia.entity.User;
import com.spring.rest.webservices.socialmedia.exception.UserNotFoundException;
import com.spring.rest.webservices.socialmedia.repository.PostRepository;
import com.spring.rest.webservices.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserJPAController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable Integer id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException(String.format("User is not found with id %s", id));
		
		Resource<User> userResource = new Resource<>(user.get());
		ControllerLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		userResource.add(linkTo.withRel("all-users"));
		
		return userResource;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		User savedUser = userRepository.save(user);
		/*
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		*/
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserAllPosts(@PathVariable Integer id){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException(String.format("User is not found with id %s", id));
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable Integer id, @RequestBody Post post){
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException(String.format("User is not found with id %s", id));
		User savedUser = user.get();
		post.setUser(savedUser);
		Post savedPost = postRepository.save(post);
		return new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
	}
}
