package com.ettaleby.mbarek.examjeesdia.mapper;

import com.ettaleby.mbarek.examjeesdia.dto.AgenceDTO;
import com.ettaleby.mbarek.examjeesdia.entities.Agence;

public class AgenceMapper {

    public static AgenceDTO toDTO(Agence agence) {
        if (agence == null) return null;
        return AgenceDTO.builder()
                .id(agence.getId())
                .nom(agence.getNom())
                .adresse(agence.getAdresse())
                .ville(agence.getVille())
                .telephone(agence.getTelephone())
                .build();
    }

    public static Agence toEntity(AgenceDTO dto) {
        if (dto == null) return null;
        Agence agence = new Agence();
        agence.setId(dto.getId());
        agence.setNom(dto.getNom());
        agence.setAdresse(dto.getAdresse());
        agence.setVille(dto.getVille());
        agence.setTelephone(dto.getTelephone());
        return agence;
    }
}