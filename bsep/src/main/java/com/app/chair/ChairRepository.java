package com.app.chair;

import org.springframework.data.repository.CrudRepository;

public interface ChairRepository extends CrudRepository<Chair, Long> {
	
	Chair findById(Long id);
	void deleteById(Long id);

}
