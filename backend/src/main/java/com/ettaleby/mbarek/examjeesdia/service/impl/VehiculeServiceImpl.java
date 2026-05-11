package com.ettaleby.mbarek.examjeesdia.service.impl;

import com.ettaleby.mbarek.examjeesdia.dto.MotoDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VehiculeDTO;
import com.ettaleby.mbarek.examjeesdia.dto.VoitureDTO;
import com.ettaleby.mbarek.examjeesdia.entities.*;
import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;
import com.ettaleby.mbarek.examjeesdia.mapper.VehiculeMapper;
import com.ettaleby.mbarek.examjeesdia.repositories.*;
import com.ettaleby.mbarek.examjeesdia.service.VehiculeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements VehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final VoitureRepository voitureRepository;
    private final MotoRepository motoRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public VoitureDTO createVoiture(VoitureDTO dto) {
        Voiture voiture = VehiculeMapper.toEntity(dto);
        voiture.setId(null);
        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new EntityNotFoundException("Agence introuvable"));
            voiture.setAgence(agence);
        }
        voiture = voitureRepository.save(voiture);
        return VehiculeMapper.toDTO(voiture);
    }

    @Override
    public VoitureDTO getVoitureById(Long id) {
        Voiture v = voitureRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Voiture introuvable"));
        return VehiculeMapper.toDTO(v);
    }

    @Override
    public List<VoitureDTO> getAllVoitures() {
        return voitureRepository.findAll()
                .stream()
                .map(VehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MotoDTO createMoto(MotoDTO dto) {
        Moto moto = VehiculeMapper.toEntity(dto);
        moto.setId(null);
        if (dto.getAgenceId() != null) {
            Agence agence = agenceRepository.findById(dto.getAgenceId())
                    .orElseThrow(() -> new EntityNotFoundException("Agence introuvable"));
            moto.setAgence(agence);
        }
        moto = motoRepository.save(moto);
        return VehiculeMapper.toDTO(moto);
    }

    @Override
    public MotoDTO getMotoById(Long id) {
        Moto m = motoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Moto introuvable"));
        return VehiculeMapper.toDTO(m);
    }

    @Override
    public List<MotoDTO> getAllMotos() {
        return motoRepository.findAll()
                .stream()
                .map(VehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO getVehiculeById(Long id) {
        Vehicule v = vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable"));
        return VehiculeMapper.toDTO(v);
    }

    @Override
    public List<VehiculeDTO> getVehiculesByAgence(Long agenceId) {
        return vehiculeRepository.findByAgenceId(agenceId)
                .stream()
                .map(VehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculeDTO> getVehiculesByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut)
                .stream()
                .map(VehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculeDTO> getAllVehicules() {
        return vehiculeRepository.findAll()
                .stream()
                .map(VehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO updateVehiculeStatut(Long id, StatutVehicule statut) {
        Vehicule v = vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable"));
        v.setStatut(statut);
        vehiculeRepository.save(v);
        return VehiculeMapper.toDTO(v);
    }

    @Override
    public void deleteVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
}