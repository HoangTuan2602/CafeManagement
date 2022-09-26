package com.cafe.CafeManagement.dto;


import com.cafe.CafeManagement.entity.Turn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Objects;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
public class TurnDTO {
    private Long id;
    private String name;
    private Time startTime;
    private Time endTime;
    private double salary;

    public boolean isNull() {
        return Stream.of(id, name, startTime, endTime, salary)
                .allMatch(Objects::isNull);
    }

    public TurnDTO(Turn turn)
    {
        this.id = turn.getId();
        this.name = turn.getName();
        this.startTime = turn.getStartTime();
        this.endTime = turn.getEndTime();
        this.salary = turn.getSalary();
    }
}
