package com.example.apitesteur;

import org.springframework.beans.factory.annotation.Autowired;

public class Operation {


    @Autowired
    private PepiteRepository pepiteRepository;

    public String display(int i) {
        if (i == 5) return "B";
        if (i % 3 == 0) return "A";
        return String.valueOf(i);
    }

    public int addition(int a, int b){
        return a+b;
    }

    public int multiplication(int a, int b){
        return a*b;
    }
}
