package com.example.apitesteur.batch;

import com.example.apitesteur.Personne;
import com.example.apitesteur.PersonneRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PersonneWriter implements ItemWriter<Personne> {
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public void write(List<? extends Personne> list) throws Exception {

        personneRepository.saveAll(list);


    }
}
