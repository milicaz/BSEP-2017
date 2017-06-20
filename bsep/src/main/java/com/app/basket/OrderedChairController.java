package com.app.basket;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "/orderedChair")
public class OrderedChairController {

	private final OrderedChairService orderedChairService;
	
	@Autowired
	public OrderedChairController(final OrderedChairService orderedChairService){
		this.orderedChairService = orderedChairService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<OrderedChair> findAll(){
		return orderedChairService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public OrderedChair findOne(@PathParam("id") Long id){
		return orderedChairService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderedChair save(@Valid @RequestBody OrderedChair orderedChair){
		return orderedChairService.save(orderedChair);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathParam("id") Long id){
		Optional.ofNullable(orderedChairService.findOne(id)).orElseThrow(() -> new ResourceNotFoundException());
		orderedChairService.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public OrderedChair put(@Valid @RequestBody OrderedChair orderedChair){
		Optional.ofNullable(orderedChairService.findOne(orderedChair.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return orderedChairService.save(orderedChair);
	}
}
