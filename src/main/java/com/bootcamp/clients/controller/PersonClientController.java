package com.bootcamp.clients.controller;

import com.bootcamp.clients.dto.PersonClientDto;

import com.bootcamp.clients.resource.PersonClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client/person")
public class PersonClientController {

    @Autowired
    private PersonClientResource personClientResource;

    @PostMapping
    public Mono<PersonClientDto> create(@RequestBody PersonClientDto personClientDto){
        return personClientResource.create(personClientDto);
    }

    @PutMapping
    public Mono<PersonClientDto> update(@RequestBody PersonClientDto personClientDto){
        return personClientResource.update(personClientDto);
    }

    @GetMapping
    public Flux<PersonClientDto> findAll(){
        return personClientResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody PersonClientDto personClientDto){
        return personClientResource.delete(personClientDto);
    }

}
