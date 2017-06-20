package com.app.shelf;

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
@RequestMapping(path = "/shelfs")
public class ShelfController {
	
	private final ShelfService shelfService;
	
	@Autowired
	public ShelfController(final ShelfService shelfService){
		this.shelfService = shelfService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Shelf> findAll(){
		return shelfService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public Shelf findOne(@PathParam("id") Long id){
		return shelfService.findById(id);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathParam("id") Long id){
		Optional.ofNullable(shelfService.findById(id.longValue())).orElseThrow(() -> new ResourceNotFoundException());
		shelfService.deleteById(id.longValue());
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Shelf put(@Valid @RequestBody Shelf shelf){
		Optional.ofNullable(shelfService.findById(shelf.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return shelfService.save(shelf);
	}

}
