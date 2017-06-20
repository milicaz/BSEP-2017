package com.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/login")
public class LoginController {
	
	private final UserService userService;
	
	@Autowired
	public LoginController(final UserService userService){
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> login(@RequestBody LoginDTO userDTO) {
		
		Object user = null;
		
		if(userService.findOne(userDTO.getEmail())!=null){
			user = userService.findOne(userDTO.getEmail());
		}
		else{
			throw new ResourceNotFoundException();
		}
		
		String password = getPassword(user);
		if(!password.equals(userDTO.getPassword()))
			throw new ResourceNotFoundException();
		else
			return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	private String getPassword(Object obj){
		if(obj instanceof User){
			return ((User)obj).getPassword();
		}
		
		return "";
	}

}
