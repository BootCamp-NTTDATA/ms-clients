package com.bootcamp.clients.service;

import com.bootcamp.clients.entity.PersonClient;
import com.bootcamp.clients.repository.IPersonClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PersonClientServiceImpl implements IPersonClientService {

    @Autowired
    IPersonClientRepository iPersonClientRepository;

    @Override
    public Mono<PersonClient> save(PersonClient personClient) {
        return iPersonClientRepository.save(personClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iPersonClientRepository.deleteById(id);
    }

    @Cacheable(value = "PerCliAll")
    @Override
    public Flux<PersonClient> findAll() {
        return iPersonClientRepository.findAll();
    }

    @Cacheable(value = "PerCliId")
    @Override
    public Mono<PersonClient> findById(String id) {
        return iPersonClientRepository.findById(id);
    }



}
