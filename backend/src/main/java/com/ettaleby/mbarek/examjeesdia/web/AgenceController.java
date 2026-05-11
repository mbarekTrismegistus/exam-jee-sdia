package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.AgenceDTO;
import com.ettaleby.mbarek.examjeesdia.service.AgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final AgenceService agenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgenceDTO create(@RequestBody AgenceDTO dto) {
        return agenceService.createAgence(dto);
    }

    @GetMapping("/{id}")
    public AgenceDTO getById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @GetMapping
    public List<AgenceDTO> getAll() {
        return agenceService.getAllAgences();
    }

    @PutMapping("/{id}")
    public AgenceDTO update(@PathVariable Long id, @RequestBody AgenceDTO dto) {
        return agenceService.updateAgence(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        agenceService.deleteAgence(id);
    }
}