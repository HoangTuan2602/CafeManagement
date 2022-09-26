package com.cafe.CafeManagement.service;

import com.cafe.CafeManagement.dto.TurnDTO;

import java.util.List;

public interface TurnService {
    List<TurnDTO> getAllTurns();
    TurnDTO findById(long id);
    TurnDTO create(TurnDTO turnDTO);
    TurnDTO update(TurnDTO turnDTO, long id);
    TurnDTO del(long id);
}
