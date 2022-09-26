package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "staff_turn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffTurn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne()
    @JoinColumn(name = "turn_id")
    private Turn turn_;

    @Column(name = "total_turn")
    private int totalTurn;
    @Column(name = "salary")
    private double salary;
}
