package com.cafe.CafeManagement.controller;

import com.cafe.CafeManagement.dto.TblDTO;
import com.cafe.CafeManagement.service.TblService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tables")
public class TblController {
    private final TblService tblService;

    public TblController(TblService tblService) {
        this.tblService = tblService;
    }

    @GetMapping()
    public List<TblDTO> getAllTables()
    {
        return tblService.getAllTables();
    }

    @GetMapping("/{id}")
    public TblDTO findById(@PathVariable long id)
    {
        return tblService.findById(id);
    }

    @PostMapping()
    public TblDTO create(@RequestBody TblDTO model)
    {
        return tblService.create(model);
    }

    @PutMapping("/{id}")
    public TblDTO update (@RequestBody TblDTO model, @PathVariable long id)
    {
        return tblService.update(model, id);
    }

    @DeleteMapping("/{id}")
    public TblDTO deleteTable(@PathVariable long id){
        return tblService.del(id);
    }
}
