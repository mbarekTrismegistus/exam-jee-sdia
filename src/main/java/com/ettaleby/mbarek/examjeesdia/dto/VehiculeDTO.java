package com.ettaleby.mbarek.examjeesdia.dto;

import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class VehiculeDTO {
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;
    private LocalDate dateMiseEnService;
    private StatutVehicule statut;
    private Long agenceId;   // référence à l'agence, pas l'objet complet
}