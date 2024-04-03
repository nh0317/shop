package com.example.shop.domain.payment;

import com.example.shop.domain.order.Order;
import com.example.shop.domain.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    private String payment_method;

    @OneToOne(mappedBy = "payment", fetch = FetchType.LAZY)
    private Order order;
}
