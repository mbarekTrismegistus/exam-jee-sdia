package com.ettaleby.mbarek.examjeesdia.service.impl;

import com.ettaleby.mbarek.examjeesdia.dto.AgenceDTO;
import com.ettaleby.mbarek.examjeesdia.entities.Agence;
import com.ettaleby.mbarek.examjeesdia.mapper.AgenceMapper;
import com.ettaleby.mbarek.examjeesdia.repositories.AgenceRepository;
import com.ettaleby.mbarek.examjeesdia.service.AgenceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements AgenceService {
    private final AgenceRepository agenceRepository;

    @Override
    public AgenceDTO createAgence(AgenceDTO dto) {
        Agence agence = AgenceMapper.toEntity(dto);
        agence.setId(null);
        agence = agenceRepository.save(agence);
        return AgenceMapper.toDTO(agence);
    }

    @Override
    public AgenceDTO getAgenceById(Long id) {
        Agence agence = agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable"));
        return AgenceMapper.toDTO(agence);
    }

    @Override
    public List<AgenceDTO> getAllAgences() {
        return agenceRepository.findAll()
                .stream()
                .map(AgenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AgenceDTO updateAgence(Long id, AgenceDTO dto) {
        Agence agence = agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable"));
        agence.setNom(dto.getNom());
        agence.setAdresse(dto.getAdresse());
        agence.setVille(dto.getVille());
        agence.setTelephone(dto.getTelephone());
        agence = agenceRepository.save(agence);
        return AgenceMapper.toDTO(agence);
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }
}