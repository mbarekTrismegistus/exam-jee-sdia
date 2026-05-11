package com.ettaleby.mbarek.examjeesdia.dto;

import com.ettaleby.mbarek.examjeesdia.enums.CasqueInclus;
import com.ettaleby.mbarek.examjeesdia.enums.TypeMoto;
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
public class MotoDTO extends VehiculeDTO {
    private int cylindree;
    private TypeMoto typeMoto;
    private CasqueInclus casqueInclus;
}