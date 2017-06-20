package com.app.chair;


public interface ChairService {
	
	Iterable<Chair> findAll();
	Chair findById(Long id);
	Chair save(Chair chair);
	void deleteById(Long id);

}
