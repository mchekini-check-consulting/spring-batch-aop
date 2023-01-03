package com.example.apitesteur;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Pepite {

    @Id
    private Long id;
    private String sender;
    private String url;
    private String description;
    private Integer price;



}
