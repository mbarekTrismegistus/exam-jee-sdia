package com.ettaleby.mbarek.examjeesdia.service.impl;

import com.ettaleby.mbarek.examjeesdia.dto.LocationDTO;
import com.ettaleby.mbarek.examjeesdia.entities.Location;
import com.ettaleby.mbarek.examjeesdia.entities.Vehicule;
import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;
import com.ettaleby.mbarek.examjeesdia.mapper.LocationMapper;
import com.ettaleby.mbarek.examjeesdia.repositories.LocationRepository;
import com.ettaleby.mbarek.examjeesdia.repositories.VehiculeRepository;
import com.ettaleby.mbarek.examjeesdia.service.LocationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    @Transactional
    public LocationDTO createLocation(LocationDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(dto.getVehiculeId())
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable"));

        if (vehicule.getStatut() != StatutVehicule.DISPONIBLE) {
            throw new IllegalStateException("Le véhicule n'est pas disponible");
        }

        long days = ChronoUnit.DAYS.between(dto.getDateDebut(), dto.getDateFin());
        if (days <= 0) days = 1;
        double prixTotal = days * vehicule.getPrixParJour();

        Location location = LocationMapper.toEntity(dto);
        location.setId(null);
        location.setPrixTotal(prixTotal);
        location.setVehicule(vehicule);

        vehicule.setStatut(StatutVehicule.LOUE);
        vehiculeRepository.save(vehicule);

        location = locationRepository.save(location);
        return LocationMapper.toDTO(location);
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location loc = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location introuvable"));
        return LocationMapper.toDTO(loc);
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> getLocationsByVehicule(Long vehiculeId) {
        return locationRepository.findByVehiculeId(vehiculeId)
                .stream()
                .map(LocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LocationDTO returnVehicule(Long locationId) {
        Location loc = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location introuvable"));

        Vehicule vehicule = loc.getVehicule();
        if (vehicule.getStatut() == StatutVehicule.LOUE) {
            vehicule.setStatut(StatutVehicule.DISPONIBLE);
            vehiculeRepository.save(vehicule);
        }

        return LocationMapper.toDTO(loc);
    }
}