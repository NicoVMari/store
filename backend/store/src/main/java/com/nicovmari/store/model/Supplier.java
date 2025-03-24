package com.nicovmari.store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "supplier_t")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @SequenceGenerator(name = "supplier_seq", sequenceName = "supplier_seq", allocationSize = 1)
    @Column(name = "id_supplier")
    private long id;

    @Column(name = "supplier_name")
    private String supplierName;
    private String contacts;
}
