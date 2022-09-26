package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "tbl")
    private List<Bill> bills = new ArrayList<>();
}
