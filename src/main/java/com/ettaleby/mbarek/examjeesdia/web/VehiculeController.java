package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.VehiculeDTO;
import com.ettaleby.mbarek.examjeesdia.enums.StatutVehicule;
import com.ettaleby.mbarek.examjeesdia.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final VehiculeService vehiculeService;

    @GetMapping("/{id}")
    public VehiculeDTO getById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }

    @GetMapping
    public List<VehiculeDTO> getAll() {
        return vehiculeService.getAllVehicules();
    }

    @GetMapping("/agence/{agenceId}")
    public List<VehiculeDTO> getByAgence(@PathVariable Long agenceId) {
        return vehiculeService.getVehiculesByAgence(agenceId);
    }

    @GetMapping("/statut/{statut}")
    public List<VehiculeDTO> getByStatut(@PathVariable StatutVehicule statut) {
        return vehiculeService.getVehiculesByStatut(statut);
    }

    @PatchMapping("/{id}/statut")
    public VehiculeDTO updateStatut(@PathVariable Long id, @RequestParam StatutVehicule statut) {
        return vehiculeService.updateVehiculeStatut(id, statut);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
    }
}