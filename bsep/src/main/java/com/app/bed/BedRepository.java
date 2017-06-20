package com.app.bed;

import org.springframework.data.repository.CrudRepository;

public interface BedRepository extends CrudRepository<Bed, Long> {

	Bed findById(Long id);
	
	void deleteById(Long id);
}
