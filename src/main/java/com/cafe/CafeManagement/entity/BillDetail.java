package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "billDetail")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "billDetail")
    private List<Bill> bills = new ArrayList<>();

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private double price; // total price product
}
