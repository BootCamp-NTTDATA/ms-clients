package com.bootcamp.clients.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentTypeDto {
    private String id;
    private String name;
}
