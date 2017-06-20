package com.app.bed;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BedServiceImpl implements BedService{
	
	private final BedRepository bedRepo;
	
	@Autowired
	public BedServiceImpl(final BedRepository bedRepo){
		this.bedRepo = bedRepo;
	}
	
	@Override
	public Iterable<Bed> findAll() {
		return bedRepo.findAll();
	}

	@Override
	public Bed findById(Long id) {
		return bedRepo.findById(id);
	}

	@Override
	public Bed save(Bed bed) {
		return bedRepo.save(bed);
	}

	@Override
	public void deleteById(Long id) {
		bedRepo.deleteById(id);
		
	}

}
