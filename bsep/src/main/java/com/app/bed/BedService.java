package com.app.bed;

public interface BedService {
	
	Iterable<Bed> findAll();
	Bed findById(Long id);
	Bed save(Bed bed);
	void deleteById(Long id);

}
