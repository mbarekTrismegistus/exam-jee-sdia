package com.ettaleby.mbarek.examjeesdia.mapper;

import com.ettaleby.mbarek.examjeesdia.dto.MotoDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VehiculeDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VoitureDTO;
import com.ettaleby.mbarek.examjeesdia.entities.*;

public class VehiculeMapper {

    public static VoitureDTO toDTO(Voiture voiture) {
        if (voiture == null) return null;
        VoitureDTO dto = VoitureDTO.builder()
                .nombrePortes(voiture.getNombrePortes())
                .typeCarburant(voiture.getTypeCarburant())
                .boiteVitesse(voiture.getBoiteVitesse())
                .build();
        fillCommonFields(dto, voiture);
        return dto;
    }

    public static Voiture toEntity(VoitureDTO dto) {
        if (dto == null) return null;
        Voiture voiture = new Voiture();
        voiture.setNombrePortes(dto.getNombrePortes());
        voiture.setTypeCarburant(dto.getTypeCarburant());
        voiture.setBoiteVitesse(dto.getBoiteVitesse());
        fillCommonEntityFields(voiture, dto);
        return voiture;
    }

    public static MotoDTO toDTO(Moto moto) {
        if (moto == null) return null;
        MotoDTO dto = MotoDTO.builder()
                .cylindree(moto.getCylindree())
                .typeMoto(moto.getTypeMoto())
                .casqueInclus(moto.getCasqueInclus())
                .build();
        fillCommonFields(dto, moto);
        return dto;
    }

    public static Moto toEntity(MotoDTO dto) {
        if (dto == null) return null;
        Moto moto = new Moto();
        moto.setCylindree(dto.getCylindree());
        moto.setTypeMoto(dto.getTypeMoto());
        moto.setCasqueInclus(dto.getCasqueInclus());
        fillCommonEntityFields(moto, dto);
        return moto;
    }

    public static VehiculeDTO toDTO(Vehicule vehicule) {
        if (vehicule instanceof Voiture v) {
            return toDTO(v);
        } else if (vehicule instanceof Moto m) {
            return toDTO(m);
        }
        return null;
    }

    private static void fillCommonFields(VehiculeDTO dto, Vehicule entity) {
        dto.setId(entity.getId());
        dto.setMarque(entity.getMarque());
        dto.setModele(entity.getModele());
        dto.setMatricule(entity.getMatricule());
        dto.setPrixParJour(entity.getPrixParJour());
        dto.setDateMiseEnService(entity.getDateMiseEnService());
        dto.setStatut(entity.getStatut());
        if (entity.getAgence() != null) {
            dto.setAgenceId(entity.getAgence().getId());
        }
    }

    private static void fillCommonEntityFields(Vehicule entity, VehiculeDTO dto) {
        entity.setId(dto.getId());
        entity.setMarque(dto.getMarque());
        entity.setModele(dto.getModele());
        entity.setMatricule(dto.getMatricule());
        entity.setPrixParJour(dto.getPrixParJour());
        entity.setDateMiseEnService(dto.getDateMiseEnService());
        entity.setStatut(dto.getStatut());
    }
}