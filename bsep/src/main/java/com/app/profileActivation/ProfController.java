package com.app.profileActivation;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.MailService;
import com.app.user.UserService;

@RestController
@RequestMapping(path="/profiles")
public class ProfController {

	private final ProfileService profileService;
	private final UserService userService;
	private final MailService mailService;
	
	@Autowired
	public ProfController(final ProfileService profileService, final UserService userService,
			final MailService mailService) {
		this.profileService = profileService;
		this.userService = userService;
		this.mailService = mailService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Profile> findAll(){
		return profileService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public Profile findOne(@PathParam("id") Long id){
		return profileService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Profile> save(@Valid @RequestBody Profile profile){
		if(userService.findOne(profile.getEmail())!=null)
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		if(profileService.findByEmail(profile.getEmail()).iterator().hasNext())
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		Profile saved = profileService.save(profile);
		String message = "Link for activation: " + "http://localhost:8080/#/activation?id="+saved.getId();
		try{
			mailService.sendMail(saved.getEmail(), message,"Sign Up");
		}catch(MailException e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathParam("id") Long id){
		Optional.ofNullable(profileService.findOne(id)).orElseThrow(() -> new ResourceNotFoundException());
		profileService.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Profile put(@Valid @RequestBody Profile profile){
		Optional.ofNullable(profileService.findOne(profile.getId())).
			orElseThrow(() -> new ResourceNotFoundException());
		return profileService.save(profile);
	}
	
}
