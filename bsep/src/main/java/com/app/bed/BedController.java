package com.app.bed;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(path="/beds")
public class BedController {

	private final BedService bedService;
	
	@Autowired
	public BedController(final BedService bedService){
		this.bedService = bedService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Bed> findAll(){
		return bedService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public Bed findOne(@PathParam("id") Long id){
		return bedService.findById(id);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathParam("id") Long id){
		Optional.ofNullable(bedService.findById(id.longValue())).orElseThrow(() -> new ResourceNotFoundException());
		bedService.deleteById(id.longValue());
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Bed put(@Valid @RequestBody Bed bed){
		Optional.ofNullable(bedService.findById(bed.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return bedService.save(bed);
	}
}
