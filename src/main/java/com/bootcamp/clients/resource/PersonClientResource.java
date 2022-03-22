package com.bootcamp.clients.resource;

import com.bootcamp.clients.dto.PersonClientDto;
import com.bootcamp.clients.entity.DocumentType;
import com.bootcamp.clients.entity.PersonClient;
import com.bootcamp.clients.service.IPersonClientService;
import com.bootcamp.clients.util.MapperUtil;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PersonClientResource extends MapperUtil {

    @Autowired
    private IPersonClientService iPersonClientService;

    public Mono<PersonClientDto> create(PersonClientDto personClientDto){
        PersonClient personClient = map(personClientDto,PersonClient.class);
        personClient.setId(new ObjectId().toString());
        personClient.setCreatedAt(LocalDateTime.now());
        Mono<PersonClient> entity = iPersonClientService.save(personClient);
       return entity.map(x -> map(x,PersonClientDto.class));
    }

    public Flux<PersonClientDto> findAll(){
       return iPersonClientService.findAll().map(x-> map(x,PersonClientDto.class));
    }

    public Mono<PersonClientDto> update(PersonClientDto personClientDto){

        return iPersonClientService.findById(personClientDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(p->{
                    PersonClient personClient = map(personClientDto,PersonClient.class);

                    personClient.setUpdatedAt(LocalDateTime.now());
                    return iPersonClientService.save(personClient).map(y-> map(y,PersonClientDto.class));
                });
    }


    public Mono<PersonClientDto> findById(String id){
        return iPersonClientService.findById(id)
                .switchIfEmpty(Mono.error(new Exception()))
                .map(x-> map(x,PersonClientDto.class));
    }



    public Mono<Void> delete(PersonClientDto personClientDto)
    {
        return iPersonClientService.findById(personClientDto.getId())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(x->iPersonClientService.deleteById(personClientDto.getId()));
    }



}
