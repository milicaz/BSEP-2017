package com.app.basket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedBedRepository extends CrudRepository<OrderedBed, Long> {

}
