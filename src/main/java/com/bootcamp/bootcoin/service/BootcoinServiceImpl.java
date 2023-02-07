package com.bootcamp.bootcoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.bootcoin.entity.Bootcoin;
import com.bootcamp.bootcoin.repository.BootcoinRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class BootcoinServiceImpl implements  BootcoinService{

    @Autowired
    private BootcoinRepository monederoRepository;

    @Override
    public Flux<Bootcoin> getAll() {
        return monederoRepository.findAll();
    }

    @Override
    public Mono<Bootcoin> getMonederoById(Integer id) {
        return monederoRepository.findById(id);
    }

    @Override
    public Mono<Bootcoin> createMonedero(Bootcoin monedero) {
        return monederoRepository.save(monedero);
    }

    @Override
    public Mono<Bootcoin> updateMonedero(Bootcoin monedero) {
        return monederoRepository.findById(monedero.getId())
                .flatMap(newMonedero -> {
                	newMonedero.setId(monedero.getId());
                    newMonedero.setDocumentNumber(monedero.getDocumentNumber());
                    newMonedero.setDocumentType(monedero.getDocumentType());
                    newMonedero.setEmail(monedero.getEmail());
                    newMonedero.setPhone(monedero.getPhone());
                    newMonedero.setNumBootcoin(monedero.getNumBootcoin());
                    newMonedero.setIdCustomer(monedero.getIdCustomer());
                    return monederoRepository.save(newMonedero);
                });
    }

    @Override
    public Mono<Bootcoin> deleteMonedero(Integer id) {
        return monederoRepository.findById(id)
                .flatMap(monedero -> monederoRepository.delete(monedero)
                        .then(Mono.just(monedero)));
    }
    
    @Override
    public Mono<Bootcoin> getFindPhone(String phone) {
        return monederoRepository.findAll().filter(b -> b.getPhone().equals(phone)).next();
    }
}
