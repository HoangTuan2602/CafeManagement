package com.cafe.CafeManagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_encoded")
    private Date dateEncoded;
    @Column(name = "total_price")
    private double totalPrice;
    @ManyToOne()
    @JoinColumn(name = "tbl_id")
    private Tbl tbl;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @ManyToOne()
    @JoinColumn(name = "bill_detail_id")
    private BillDetail billDetail;
}
