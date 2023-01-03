package com.example.apitesteur;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PepiteResource {

    private final PepiteService pepiteService;

    public PepiteResource(PepiteService pepiteService) {
        this.pepiteService = pepiteService;
    }

    @GetMapping("get-all-pepites")
    public List<Pepite> getPepites() {
        return pepiteService.getAllPepites();
    }

    @PostMapping("/create-pepite")
    public ResponseEntity createPepite(@RequestBody Pepite pepite){

        pepiteService.createPepite(pepite);
        return ResponseEntity.ok("Pepite Created");
    }

    @PutMapping("/update-pepite")
    public ResponseEntity updatePepite(@RequestBody Pepite pepite){
        pepiteService.updatePepite(pepite);
        return ResponseEntity.ok("Pepite Updated");
    }

    @DeleteMapping("/delete-pepite/{id}")
    public ResponseEntity updatePepite(@PathVariable("id") Long id){
        pepiteService.deletePepite(id);
        return ResponseEntity.ok("Pepite Deleted");
    }

    @GetMapping("async")
    public String test() throws InterruptedException { // Process 1
        pepiteService.test();  // Process 2
        return "la demande a été prise en compte";   // Process 1
    }


    @DeleteMapping("delete-all-pepites")
    public ResponseEntity updatePepite(){
        pepiteService.deleteAllPepites();
        return ResponseEntity.ok("All Pepites Deleted");
    }

}
