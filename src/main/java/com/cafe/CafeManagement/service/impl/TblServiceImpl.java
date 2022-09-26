package com.cafe.CafeManagement.service.impl;

import com.cafe.CafeManagement.dto.TblDTO;
import com.cafe.CafeManagement.entity.Tbl;
import com.cafe.CafeManagement.exception.InvalidRequestException;
import com.cafe.CafeManagement.repository.TblRepository;
import com.cafe.CafeManagement.service.TblService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TblServiceImpl implements TblService {
    private final TblRepository tblRepository;

    public TblServiceImpl(TblRepository tblRepository) {
        this.tblRepository = tblRepository;
    }

    @Override
    public List<TblDTO> getAllTables() {
        List<TblDTO> tblDTOList = new ArrayList<>();
        tblRepository.findAll().stream().forEach(tbl -> tblDTOList.add(new TblDTO(tbl)));
        return tblDTOList;
    }

    @Override
    public TblDTO findById(long id) {
        boolean exists = tblRepository.existsById(id);
        if (exists) {
            Optional<Tbl> tbl = tblRepository.findById(id);
            return new TblDTO(tbl.get());
        }
        return null;
    }

    @Override
    public TblDTO create(TblDTO tblDTO) {
        if (tblDTO.isNull()) {
            throw new InvalidRequestException("invalid request. Please check again!");
        }

        Tbl tbl = Tbl.builder()
                .name(tblDTO.getName())
                .status(tblDTO.isStatus())
                .build();
        return new TblDTO(tblRepository.save(tbl));
    }

    @Override
    public TblDTO update(TblDTO tblDTO, long id) {
        if (tblDTO.isNull()) {
            throw new InvalidRequestException("invalid request. Please check again!");
        }

        Tbl updateTable = tblRepository.findById(id)
                .map(tbl -> {
                    tbl.setName(tblDTO.getName());
                    tbl.setStatus(tblDTO.isStatus());
                    return tblRepository.save(tbl);
                }).orElseGet(() -> {
                    tblDTO.setId(id);
                    return tblRepository.save(Tbl.builder()
                            .name(tblDTO.getName())
                            .status(tblDTO.isStatus())
                            .build());
                });
        return new TblDTO(updateTable);
    }

    @Override
    public TblDTO del(long id) {
        boolean exists = tblRepository.existsById(id);
        if (exists) {
            Optional<Tbl> deleteTable = tblRepository.findById(id);
            tblRepository.deleteById(id);
            return new TblDTO(deleteTable.get());
        }
        return null;
    }
}
