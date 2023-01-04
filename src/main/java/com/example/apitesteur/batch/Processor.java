package com.example.apitesteur.batch;

import com.example.apitesteur.Personne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<Personne, Personne> {

    private static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Personne process(final Personne personne) throws Exception {

        if (personne.getNom().equals("essaid") || personne.getPrenom().equals("essaid")) return null;

        personne.setNom(personne.getNom().toUpperCase());
        personne.setPrenom(personne.getPrenom().toUpperCase());


        return personne;
    }

}
