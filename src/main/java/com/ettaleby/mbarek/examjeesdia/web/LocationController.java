package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.LocationDTO;
import com.ettaleby.mbarek.examjeesdia.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO create(@RequestBody LocationDTO dto) {
        return locationService.createLocation(dto);
    }

    @GetMapping("/{id}")
    public LocationDTO getById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping
    public List<LocationDTO> getAll() {
        return locationService.getAllLocations();
    }

    @GetMapping("/vehicule/{vehiculeId}")
    public List<LocationDTO> getByVehicule(@PathVariable Long vehiculeId) {
        return locationService.getLocationsByVehicule(vehiculeId);
    }

    @PatchMapping("/{id}/retour")
    public LocationDTO returnVehicule(@PathVariable Long id) {
        return locationService.returnVehicule(id);
    }
}