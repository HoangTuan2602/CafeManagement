package com.cafe.CafeManagement.controller;

import com.cafe.CafeManagement.dto.TurnDTO;
import com.cafe.CafeManagement.service.TurnService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/turns")
public class TurnController {
    private final TurnService turnService;

    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping()
    public List<TurnDTO> getAllTurns() {
        return turnService.getAllTurns();
    }

    @GetMapping("/{id}")
    public TurnDTO findById(@PathVariable Long id) {
        return turnService.findById(id);
    }

    @PostMapping()
    public TurnDTO create(@RequestBody TurnDTO model) {
        return turnService.create(model);
    }

    @PutMapping("/{id}")
    public TurnDTO update(@RequestBody TurnDTO model, @PathVariable Long id) {
        return turnService.update(model, id);
    }

    @DeleteMapping("/{id}")
    public TurnDTO del(@PathVariable Long id) {
        return turnService.del(id);
    }
}
