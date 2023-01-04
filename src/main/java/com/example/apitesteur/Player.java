package com.example.apitesteur;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Player {

    @Id
    private Long id;
    private String nom;
    private String prenom;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nom_equipe", nullable=false)
    private Equipe equipe;
}
