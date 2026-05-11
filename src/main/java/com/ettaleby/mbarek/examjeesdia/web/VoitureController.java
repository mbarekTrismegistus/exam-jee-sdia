package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.VoitureDTO;
import com.ettaleby.mbarek.examjeesdia.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
@RequiredArgsConstructor
public class VoitureController {

    private final VehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VoitureDTO create(@RequestBody VoitureDTO dto) {
        return vehiculeService.createVoiture(dto);
    }

    @GetMapping("/{id}")
    public VoitureDTO getById(@PathVariable Long id) {
        return vehiculeService.getVoitureById(id);
    }

    @GetMapping
    public List<VoitureDTO> getAll() {
        return vehiculeService.getAllVoitures();
    }
}