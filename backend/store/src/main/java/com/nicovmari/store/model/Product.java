package com.nicovmari.store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_t")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @Column(name = "id_product")
    private long id;

    @Column(name = "product_name")
    private String productName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;
}
