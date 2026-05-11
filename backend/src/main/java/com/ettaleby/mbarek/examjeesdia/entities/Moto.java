package com.ettaleby.mbarek.examjeesdia.entities;

import com.ettaleby.mbarek.examjeesdia.enums.CasqueInclus;
import com.ettaleby.mbarek.examjeesdia.enums.TypeMoto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("MOTO")
@Data @NoArgsConstructor @AllArgsConstructor
public class Moto extends Vehicule {
    private int cylindree;

    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;

    @Enumerated(EnumType.STRING)
    private CasqueInclus casqueInclus;
}