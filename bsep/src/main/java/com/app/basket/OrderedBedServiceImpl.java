package com.app.basket;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class OrderedBedServiceImpl implements OrderedBedService {
	
	private final OrderedBedRepository orderedBedRepo;
	
	@Autowired
	public OrderedBedServiceImpl(final OrderedBedRepository orderedBedRepo) {
		this.orderedBedRepo = orderedBedRepo;
	}
	
	@Override
	public Iterable<OrderedBed> findAll() {
		return orderedBedRepo.findAll();
	}

	@Override
	public OrderedBed findOne(Long id) {
		return orderedBedRepo.findOne(id);
	}

	@Override
	public OrderedBed save(OrderedBed orderedBed) {
		return orderedBedRepo.save(orderedBed);
	}

	@Override
	public void delete(Long id) {
		orderedBedRepo.delete(id);
	}
	
}
