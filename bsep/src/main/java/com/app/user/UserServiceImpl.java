package com.app.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(final UserRepository userRepo){
		this.userRepo = userRepo; 
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User findOne(String email) {
		// TODO Auto-generated method stub
		return userRepo.findOne(email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		userRepo.delete(email);
	}
	

}
