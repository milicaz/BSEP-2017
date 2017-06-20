package com.app.shelf;

import org.springframework.data.repository.CrudRepository;

public interface ShelfRepository extends CrudRepository<Shelf, Long> {
	
	Shelf findById(Long id);
	void deleteById(Long id);

}
