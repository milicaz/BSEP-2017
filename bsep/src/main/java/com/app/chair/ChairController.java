package com.app.chair;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/chairs")
public class ChairController {
	
	private final ChairService chairService;
	
	@Autowired
	public ChairController(final ChairService chairService){
		this.chairService = chairService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Chair> findAll(){
		return chairService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public Chair findOne(@PathParam("id") Long id){
		return chairService.findById(id);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathParam("id") Long id){
		Optional.ofNullable(chairService.findById(id.longValue())).orElseThrow(() -> new ResourceNotFoundException());
		chairService.deleteById(id.longValue());
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Chair put(@Valid @RequestBody Chair chair){
		Optional.ofNullable(chairService.findById(chair.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return chairService.save(chair);
	}

}
