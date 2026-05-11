package com.ettaleby.mbarek.examjeesdia.mapper;

import com.ettaleby.mbarek.examjeesdia.dto.LocationDTO;
import com.ettaleby.mbarek.examjeesdia.entities.Location;

public class LocationMapper {

    public static LocationDTO toDTO(Location location) {
        if (location == null) return null;
        LocationDTO dto = LocationDTO.builder()
                .id(location.getId())
                .dateDebut(location.getDateDebut())
                .dateFin(location.getDateFin())
                .prixTotal(location.getPrixTotal())
                .build();
        if (location.getVehicule() != null) {
            dto.setVehiculeId(location.getVehicule().getId());
            dto.setVehiculeMarque(location.getVehicule().getMarque());
            dto.setVehiculeModele(location.getVehicule().getModele());
        }
        return dto;
    }

    public static Location toEntity(LocationDTO dto) {
        if (dto == null) return null;
        Location location = new Location();
        location.setId(dto.getId());
        location.setDateDebut(dto.getDateDebut());
        location.setDateFin(dto.getDateFin());
        location.setPrixTotal(dto.getPrixTotal());

        return location;
    }
}