package com.app.user;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(final UserService userService){
		this.userService = userService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<User> findAll(){
		return userService.findAll();
	}

	@GetMapping(params = "email")
	@ResponseStatus(HttpStatus.OK)
	public User findOne(@PathParam("email") String email){
		return userService.findOne(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@Valid @RequestBody User user){
		if(userService.findOne(user.getEmail())!=null)
			throw new DataIntegrityViolationException("User alredy exists. ");
		return userService.save(user);
	}
	
	@DeleteMapping(params="email")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathParam("email") String email){
		Optional.ofNullable(userService.findOne(email)).orElseThrow(() -> new ResourceNotFoundException());
		userService.delete(email);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public User put(@Valid @RequestBody User user){
		Optional.ofNullable(userService.findOne(user.getEmail())).orElseThrow(() -> new ResourceNotFoundException());
		return userService.save(user);
	}
	
	

}
