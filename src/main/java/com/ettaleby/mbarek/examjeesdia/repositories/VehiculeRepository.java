package com.ettaleby.mbarek.examjeesdia.repositories;

import com.ettaleby.mbarek.examjeesdia.entities.Vehicule;
import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    List<Vehicule> findByAgenceId(Long agenceId);
    List<Vehicule> findByStatut(StatutVehicule statut);
}