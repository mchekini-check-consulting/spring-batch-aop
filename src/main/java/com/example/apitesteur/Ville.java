package com.example.apitesteur;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {

    private String nom;
    private String pays;


    public void test(){
        System.out.println("je suis une ville");

    }
}
