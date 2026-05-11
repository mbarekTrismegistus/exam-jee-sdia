package com.ettaleby.mbarek.examjeesdia.entities;

import com.ettaleby.mbarek.examjeesdia.enums.BoiteVitesse;
import com.ettaleby.mbarek.examjeesdia.enums.TypeCarburant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("VOITURE")
@Data @NoArgsConstructor @AllArgsConstructor
public class Voiture extends Vehicule {
    private int nombrePortes;

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}