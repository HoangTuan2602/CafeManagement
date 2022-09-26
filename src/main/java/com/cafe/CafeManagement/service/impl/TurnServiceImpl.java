package com.cafe.CafeManagement.service.impl;

import com.cafe.CafeManagement.dto.TurnDTO;
import com.cafe.CafeManagement.entity.Turn;
import com.cafe.CafeManagement.exception.InvalidRequestException;
import com.cafe.CafeManagement.repository.TurnRepository;
import com.cafe.CafeManagement.service.TurnService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnServiceImpl implements TurnService {

    private final TurnRepository turnRepository;

    public TurnServiceImpl(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    @Override
    public List<TurnDTO> getAllTurns() {
        List<TurnDTO> turnDTOList = new ArrayList<>();
        turnRepository.findAll().stream().forEach(turn -> turnDTOList.add(new TurnDTO(turn)));
        return turnDTOList;
    }

    @Override
    public TurnDTO findById(long id) {
        boolean exists = turnRepository.existsById(id);
        if (exists) {
            Optional<Turn> turn= turnRepository.findById(id);
            return new TurnDTO(turn.get());
        }
        return null;
    }

    @Override
    public TurnDTO create(TurnDTO turnDTO) {
        if (turnDTO.isNull())
        {
            throw new InvalidRequestException("Invalid request. Please check again!");
        }

        Turn turn = Turn.builder()
                .name(turnDTO.getName())
                .startTime(turnDTO.getStartTime())
                .endTime(turnDTO.getEndTime())
                .salary(turnDTO.getSalary())
                .build();
        return new TurnDTO(turn);
    }

    @Override
    public TurnDTO update(TurnDTO turnDTO, long id) {
        return null;
    }

    @Override
    public TurnDTO del(long id) {
        return null;
    }
}
