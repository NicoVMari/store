package com.nicovmari.store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders_t")
@IdClass(OrderProductId.class)
public class Orders {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private int quantity;
    @Column(name = "unit_price")
    private double unitPrice;
}
