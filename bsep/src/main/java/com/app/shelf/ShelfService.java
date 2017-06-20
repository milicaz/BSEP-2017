package com.app.shelf;

public interface ShelfService {

	Iterable<Shelf> findAll();
	Shelf findById(Long id);
	Shelf save(Shelf shelf);
	void deleteById(Long id);

}
