package com.bootcamp.clients.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends BaseEntity {
    private String numberDocument;
    private String documentType;
    private String name;
    private String address;
    private String phone;
    private String email;
}
