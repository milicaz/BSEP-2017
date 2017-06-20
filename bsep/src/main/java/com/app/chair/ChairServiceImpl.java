package com.app.chair;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChairServiceImpl implements ChairService {
	
	private final ChairRepository chairRepo;
	
	@Autowired
	public ChairServiceImpl(final ChairRepository chairRepo){
		this.chairRepo = chairRepo;
	}
	
	@Override
	public Iterable<Chair> findAll() {
		return chairRepo.findAll();
	}

	@Override
	public Chair findById(Long id) {
		return chairRepo.findById(id);
	}

	@Override
	public Chair save(Chair chair) {
		return chairRepo.save(chair);
	}

	@Override
	public void deleteById(Long id) {
		chairRepo.deleteById(id);
		
	}

}
