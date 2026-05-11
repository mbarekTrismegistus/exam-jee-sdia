package com.ettaleby.mbarek.examjeesdia.dto;

import com.ettaleby.mbarek.examjeesdia.enums.BoiteVitesse;
import com.ettaleby.mbarek.examjeesdia.enums.TypeCarburant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class VoitureDTO extends VehiculeDTO {
    private int nombrePortes;
    private TypeCarburant typeCarburant;
    private BoiteVitesse boiteVitesse;
}