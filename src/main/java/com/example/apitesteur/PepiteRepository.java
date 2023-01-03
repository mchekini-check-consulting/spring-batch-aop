package com.example.apitesteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PepiteRepository extends JpaRepository<Pepite, Long> {
}
