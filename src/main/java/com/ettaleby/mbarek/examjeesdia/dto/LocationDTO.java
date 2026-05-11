package com.ettaleby.mbarek.examjeesdia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private double prixTotal;
    private Long vehiculeId;
    private String vehiculeMarque;
    private String vehiculeModele;
}