package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "starting_date")
    private Date startingDate;
    @Column(name = "gender")
    private boolean gender;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "staff")
    private List<StaffTurn> staffTurns = new ArrayList<>();

    @OneToMany(mappedBy = "staff")
    private List<Bill> bills = new ArrayList<>();
}
