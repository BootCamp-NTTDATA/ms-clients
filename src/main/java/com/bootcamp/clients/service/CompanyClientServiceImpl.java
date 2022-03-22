package com.bootcamp.clients.service;

import com.bootcamp.clients.entity.CompanyClient;
import com.bootcamp.clients.repository.ICompanyClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyClientServiceImpl implements ICompanyClientService {

    @Autowired
    ICompanyClientRepository iCompanyClientRepository;

    @Override
    public Mono<CompanyClient> save(CompanyClient companyClient) {
        return iCompanyClientRepository.save(companyClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCompanyClientRepository.deleteById(id);
    }

    @Override
    public Mono<CompanyClient> findById(String id) {
        return iCompanyClientRepository.findById(id);
    }

    @Override
    public Flux<CompanyClient> findAll() {
        return iCompanyClientRepository.findAll();
    }
}
