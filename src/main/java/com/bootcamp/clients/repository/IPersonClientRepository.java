package com.bootcamp.clients.repository;

import com.bootcamp.clients.entity.PersonClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonClientRepository extends ReactiveMongoRepository<PersonClient, String> {

}
