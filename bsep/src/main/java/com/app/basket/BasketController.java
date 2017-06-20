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
@RequestMapping(path = "/baskets")
public class BasketController {
	
	private final BasketService basketService;
	
	@Autowired
	public BasketController(final BasketService basketService) {
		this.basketService = basketService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Basket> findAll(){
		return basketService.findAll();
	}
	
	@GetMapping(params="id")
	@ResponseStatus(HttpStatus.OK)
	public Basket findOne(@PathParam("id") Long id){
		return basketService.findOne(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Basket save(@Valid @RequestBody Basket basket){
		return basketService.save(basket);
	}
	
	@DeleteMapping(params="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathParam("id") Long id){
		Optional.ofNullable(basketService.findOne(id)).orElseThrow(() -> new ResourceNotFoundException());
		basketService.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Basket put(@Valid @RequestBody Basket basket){
		Optional.ofNullable(basketService.findOne(basket.getId())).orElseThrow(() -> new ResourceNotFoundException());
		return basketService.save(basket);
	}

}
