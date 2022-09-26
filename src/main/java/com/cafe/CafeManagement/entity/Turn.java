package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;
    @Column(name = "salary")
    private double salary;

    @OneToMany(mappedBy = "turn_")
    private List<StaffTurn> staffTurns = new ArrayList<>();
}
