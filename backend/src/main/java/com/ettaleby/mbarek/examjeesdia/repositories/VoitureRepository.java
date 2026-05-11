package com.ettaleby.mbarek.examjeesdia.repositories;

import com.ettaleby.mbarek.examjeesdia.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}