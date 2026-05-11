package com.ettaleby.mbarek.examjeesdia.service;

import com.ettaleby.mbarek.examjeesdia.dto.MotoDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VehiculeDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VoitureDTO;
import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;

import java.util.List;

public interface VehiculeService {
    VoitureDTO createVoiture(VoitureDTO dto);
    VoitureDTO getVoitureById(Long id);
    List<VoitureDTO> getAllVoitures();

    MotoDTO createMoto(MotoDTO dto);
    MotoDTO getMotoById(Long id);
    List<MotoDTO> getAllMotos();

    VehiculeDTO getVehiculeById(Long id);
    List<VehiculeDTO> getVehiculesByAgence(Long agenceId);
    List<VehiculeDTO> getVehiculesByStatut(StatutVehicule statut);
    List<VehiculeDTO> getAllVehicules();

    VehiculeDTO updateVehiculeStatut(Long id, StatutVehicule statut);
    void deleteVehicule(Long id);
}