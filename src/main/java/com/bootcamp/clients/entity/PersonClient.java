package com.bootcamp.clients.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class PersonClient extends Person {
    private String lastName;
    private String dni;
    private String gender;

}
