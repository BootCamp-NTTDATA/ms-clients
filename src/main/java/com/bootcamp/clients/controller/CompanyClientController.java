package com.bootcamp.clients.controller;

import com.bootcamp.clients.dto.CompanyClientDto;
import com.bootcamp.clients.dto.PersonClientDto;
import com.bootcamp.clients.resource.CompanyClientResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/client/company")
public class CompanyClientController {

    @Autowired
    private CompanyClientResource companyClientResource;

    @PostMapping
    public Mono<CompanyClientDto> create(@RequestBody CompanyClientDto companyClientDto){
        return companyClientResource.create(companyClientDto);
    }

    @PutMapping
    public Mono<CompanyClientDto> update(@RequestBody CompanyClientDto companyClientDto){
        return companyClientResource.update(companyClientDto);
    }

    @GetMapping
    public Flux<CompanyClientDto> findAll(){
        return companyClientResource.findAll();
    }

    @DeleteMapping
    public Mono<Void> delete(@RequestBody CompanyClientDto companyClientDto){
        return companyClientResource.delete(companyClientDto);
    }
}
