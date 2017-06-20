package com.app.profileActivation;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long>{

	Iterable<Profile> findByEmail(String email);
}
