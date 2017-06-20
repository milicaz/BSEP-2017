package com.app.basket;


public interface OrderedBedService {

	Iterable<OrderedBed> findAll();
	OrderedBed findOne(Long id);
	OrderedBed save(OrderedBed orderedBed);
	void delete(Long id);
}
