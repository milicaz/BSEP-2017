package com.app.basket;


public interface BasketService {

	Iterable<Basket> findAll();
	Basket findOne(Long id);
	Basket save(Basket basket);
	void delete(Long id);
}
