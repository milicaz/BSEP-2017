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
@RequestMapping(path = "/orderedBed")
public class OrderedBedController {
	
	private final OrderedBedService orderedBedService;
	
	@Autowired
	public OrderedBedController(final OrderedBedService orderedBedService) {
		this.orderedBedService = orderedBedService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<OrderedBed> findAll(){
		return orderedBedService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public OrderedBed findOne(@PathParam("id") Long id){
		return orderedBedService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderedBed save(@Valid @RequestBody OrderedBed orderedBed){
		return orderedBedService.save(orderedBed);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathParam("id") Long id){
		Optional.ofNullable(orderedBedService.findOne(id)).orElseThrow(() -> new ResourceNotFoundException());
		orderedBedService.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public OrderedBed put(@Valid @RequestBody OrderedBed orderedBed){
		Optional.ofNullable(orderedBedService.findOne(orderedBed.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return orderedBedService.save(orderedBed);
	}

}
