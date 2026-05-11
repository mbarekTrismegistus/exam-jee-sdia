package com.ettaleby.mbarek.examjeesdia.service;

import com.ettaleby.mbarek.examjeesdia.dto.LocationDTO;
import java.util.List;

public interface LocationService {
    LocationDTO createLocation(LocationDTO dto);
    LocationDTO getLocationById(Long id);
    List<LocationDTO> getAllLocations();
    List<LocationDTO> getLocationsByVehicule(Long vehiculeId);
    LocationDTO returnVehicule(Long locationId);
}