package com.cafe.CafeManagement.service;

import com.cafe.CafeManagement.dto.TblDTO;

import java.util.List;

public interface TblService {
    List<TblDTO> getAllTables();

    TblDTO findById(long id);

    TblDTO create(TblDTO tblDTO);

    TblDTO update(TblDTO tblDTO, long id);

    TblDTO del(long id);
}
