package com.bootcamp.bootcoin.repository;

import com.bootcamp.bootcoin.entity.Bootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcoinRepository extends ReactiveMongoRepository<Bootcoin, Integer>{

}
