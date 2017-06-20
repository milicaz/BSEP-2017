package com.app.basket;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BasketServiceImpl implements BasketService{
	
	private final BasketRepository basketRepo;
	private List<Basket> basket;
	private List<Basket> basket1;
	
	@Autowired
	public BasketServiceImpl(final BasketRepository basketRepo){
		this.basketRepo = basketRepo;
	}
	
	@Override
	public Iterable<Basket> findAll() {
		return basketRepo.findAll();
	}

	@Override
	public Basket findOne(Long id) {
		return basketRepo.findOne(id);
	}

	@Override
	public Basket save(Basket basket) {
		return basketRepo.save(basket);
	}

	@Override
	public void delete(Long id) {
		basketRepo.delete(id);
	}

}
