package com.ettaleby.mbarek.examjeesdia.service;

import com.ettaleby.mbarek.examjeesdia.dto.AgenceDTO;
import java.util.List;

public interface AgenceService {
    AgenceDTO createAgence(AgenceDTO dto);
    AgenceDTO getAgenceById(Long id);
    List<AgenceDTO> getAllAgences();
    AgenceDTO updateAgence(Long id, AgenceDTO dto);
    void deleteAgence(Long id);
}