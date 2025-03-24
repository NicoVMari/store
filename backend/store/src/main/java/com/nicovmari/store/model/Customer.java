package com.nicovmari.store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customer_t")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "id_customer")
    private long id;

    private String name;
    private String address;
    private String email;
}
