package com.bootcamp.bootcoin.controller;

import com.bootcamp.bootcoin.service.BootcoinService;
import com.bootcamp.bootcoin.entity.Bootcoin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/bootcoin")
public class BootcoinController {

    @Autowired
    private BootcoinService monederoService;

    @GetMapping
    public Flux<Bootcoin> getAll(){
      return monederoService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Bootcoin> getMonederoById(@PathVariable Integer id){
        return monederoService.getMonederoById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<Bootcoin> createMonedero(@RequestBody Bootcoin monederoDto){
        return monederoService.createMonedero(monederoDto);
    }

    @PutMapping
    public Mono<Bootcoin> updateMonedero(@RequestBody Bootcoin monederoDto) {
        return monederoService.updateMonedero(monederoDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Bootcoin> deleteMonedero(@PathVariable Integer id){
        return monederoService.deleteMonedero(id);
    }
    
    @GetMapping("/findphone/{phone}")
    public Mono<Bootcoin> getFindPhone(@PathVariable String phone){
        return monederoService.getFindPhone(phone);
    }
}
