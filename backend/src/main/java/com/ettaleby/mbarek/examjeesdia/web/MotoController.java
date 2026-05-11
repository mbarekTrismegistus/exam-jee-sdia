package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.MotoDTO;
import com.ettaleby.mbarek.examjeesdia.service.VehiculeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motos")
@RequiredArgsConstructor
public class MotoController {

    private final VehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MotoDTO create(@RequestBody MotoDTO dto) {
        return vehiculeService.createMoto(dto);
    }

    @GetMapping("/{id}")
    public MotoDTO getById(@PathVariable Long id) {
        return vehiculeService.getMotoById(id);
    }

    @GetMapping
    public List<MotoDTO> getAll() {
        return vehiculeService.getAllMotos();
    }
}