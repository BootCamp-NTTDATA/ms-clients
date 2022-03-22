package com.bootcamp.clients.service;

import com.bootcamp.clients.entity.PersonClient;
import com.bootcamp.clients.repository.IPersonClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Flux<PersonClient> findAll() {
        return iPersonClientRepository.findAll();
    }

    @Override
    public Mono<PersonClient> findById(String id) {
        return iPersonClientRepository.findById(id);
    }



}
