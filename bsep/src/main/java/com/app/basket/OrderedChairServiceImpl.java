package com.app.basket;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderedChairServiceImpl implements OrderedChairService{
	
	private final OrderedChairRepository orderedChairRepo;
	
	@Autowired
	public OrderedChairServiceImpl(final OrderedChairRepository orderedChairRepo){
		this.orderedChairRepo = orderedChairRepo;
	}
	
	@Override
	public Iterable<OrderedChair> findAll() {
		return orderedChairRepo.findAll();
	}

	@Override
	public OrderedChair findOne(Long id) {
		return orderedChairRepo.findOne(id);
	}

	@Override
	public OrderedChair save(OrderedChair orderedChair) {
		return orderedChairRepo.save(orderedChair);
	}

	@Override
	public void delete(Long id) {
		orderedChairRepo.delete(id);
	}

}
