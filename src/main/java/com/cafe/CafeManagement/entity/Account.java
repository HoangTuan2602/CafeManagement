package com.cafe.CafeManagement.entity;

import lombok.*;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private boolean role;

    @OneToMany(mappedBy = "account")
    private List<Staff> staffs = new ArrayList<>();
}
