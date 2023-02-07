package com.bootcamp.bootcoin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bootcoin")
@Data
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class Bootcoin {

    @Id
    private Integer id;
    private String documentType;
    private String documentNumber;
    private String phone;
    private String email;
    private String idCustomer;
    private Integer numBootcoin;
}
