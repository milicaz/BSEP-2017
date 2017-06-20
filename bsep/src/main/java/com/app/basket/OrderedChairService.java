package com.app.basket;

public interface OrderedChairService {

	Iterable<OrderedChair> findAll();
	OrderedChair findOne(Long id);
	OrderedChair save(OrderedChair orderedChair);
	void delete(Long id);
}
