package com.ettaleby.mbarek.examjeesdia.repositories;

import com.ettaleby.mbarek.examjeesdia.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Agence findByNom(String nom);
}