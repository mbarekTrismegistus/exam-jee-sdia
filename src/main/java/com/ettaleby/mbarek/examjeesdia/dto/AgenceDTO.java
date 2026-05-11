package com.ettaleby.mbarek.examjeesdia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenceDTO {
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private String telephone;
}