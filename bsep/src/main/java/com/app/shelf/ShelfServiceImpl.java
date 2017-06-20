package com.app.shelf;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShelfServiceImpl implements ShelfService{
	
	private final ShelfRepository shelfRepo;
	
	@Autowired
	public ShelfServiceImpl(final ShelfRepository shelfRepo){
		this.shelfRepo = shelfRepo;  
	}
	
	@Override
	public Iterable<Shelf> findAll() {
		return shelfRepo.findAll();
	}

	@Override
	public Shelf findById(Long id) {
		return shelfRepo.findById(id);
	}

	@Override
	public Shelf save(Shelf shelf) {
		return shelfRepo.save(shelf);
	}

	@Override
	public void deleteById(Long id) {
		shelfRepo.deleteById(id);
		
	}

}
