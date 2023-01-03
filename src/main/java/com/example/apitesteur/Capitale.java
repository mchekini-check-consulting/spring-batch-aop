package com.example.apitesteur;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capitale extends Ville {

    private String monument;


    public void test(){
        System.out.println("je suis une capitale");

    }
}
