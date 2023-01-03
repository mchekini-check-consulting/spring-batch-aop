package com.example.apitesteur;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class PepiteService {

    private final PepiteRepository pepiteRepository;

    public PepiteService(PepiteRepository pepiteRepository) {
        this.pepiteRepository = pepiteRepository;
    }

    public List<Pepite> getAllPepites() {


        log.info("appel depuis le script de test de performances");
        return pepiteRepository.findAll();
    }

    public synchronized void createPepite(Pepite pepite) {
        Long id = 1L;
        if (pepite.getId() == null) {
            List<Pepite> pepites = pepiteRepository.findAll();
            if (pepites.size() > 0) {
                for (Pepite savedPepite : pepites)
                    if (savedPepite.getId() > id) id = savedPepite.getId();
            }
            pepite.setId(id + 1);
        }
        pepiteRepository.save(pepite);
    }

    public void updatePepite(Pepite pepite) {


        pepiteRepository.save(pepite);
    }

    @Async
    CompletableFuture<String> test() throws InterruptedException {
        Thread.currentThread().sleep(30000);

        System.out.println("test dans le service");

        return CompletableFuture.completedFuture("test ok");

    }

    public void deletePepite(Long id) {
        pepiteRepository.deleteById(id);
    }

    public void deleteAllPepites() {
        pepiteRepository.deleteAll();
    }
}
