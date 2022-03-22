package com.bootcamp.clients.resource;

import com.bootcamp.clients.dto.CompanyClientDto;
import com.bootcamp.clients.dto.PersonClientDto;
import com.bootcamp.clients.entity.CompanyClient;
import com.bootcamp.clients.entity.PersonClient;
import com.bootcamp.clients.service.ICompanyClientService;

import com.bootcamp.clients.util.MapperUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CompanyClientResource extends MapperUtil{
    @Autowired
    private ICompanyClientService iCompanyClientService;

    public Mono<CompanyClientDto> create(CompanyClientDto companyClientDto){
        CompanyClient companyClient = map(companyClientDto,CompanyClient.class);
        companyClient.setId(new ObjectId().toString());
        companyClient.setCreatedAt(LocalDateTime.now());
        Mono<CompanyClient> entity = iCompanyClientService.save(companyClient);
        return entity.map(x -> map(x,CompanyClientDto.class));
    }

    public Flux<CompanyClientDto> findAll(){
        return iCompanyClientService.findAll().map(x-> map(x,CompanyClientDto.class));
    }

    public Mono<CompanyClientDto> update(CompanyClientDto companyClientDto){

        return iCompanyClientService.findById(companyClientDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(p->{
                    CompanyClient companyClient = map(companyClientDto,CompanyClient.class);

                    companyClient.setUpdatedAt(LocalDateTime.now());
                    return iCompanyClientService.save(companyClient).map(y-> map(y,CompanyClientDto.class));
                });
    }


    public Mono<CompanyClientDto> findById(String id){
        return iCompanyClientService.findById(id)
                .switchIfEmpty(Mono.error(new Exception()))
                .map(x-> map(x,CompanyClientDto.class));
    }



    public Mono<Void> delete(CompanyClientDto companyClientDto)
    {
        return iCompanyClientService.findById(companyClientDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x-> iCompanyClientService.deleteById(companyClientDto.getId()));
    }

}
