package com.app.basket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedChairRepository extends CrudRepository<OrderedChair, Long>{

}
