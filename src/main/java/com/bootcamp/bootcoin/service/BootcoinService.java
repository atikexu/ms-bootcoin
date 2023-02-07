package com.bootcamp.bootcoin.service;

import com.bootcamp.bootcoin.entity.Bootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcoinService {

    Flux<Bootcoin> getAll();
    Mono<Bootcoin> getMonederoById(Integer id);
    Mono<Bootcoin> createMonedero(Bootcoin monederoDto);
    Mono<Bootcoin> updateMonedero(Bootcoin monederoDto);
    Mono<Bootcoin> deleteMonedero(Integer id);
	Mono<Bootcoin> getFindPhone(String phone);
}
