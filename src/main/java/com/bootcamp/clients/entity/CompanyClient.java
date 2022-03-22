package com.bootcamp.clients.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class CompanyClient extends Person{
    private String ruc;
    private String tradeName;
}
