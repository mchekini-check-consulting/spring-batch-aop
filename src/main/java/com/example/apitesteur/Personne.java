package com.example.apitesteur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personne {

    @Id
    private String nom;
    private String prenom;
}
