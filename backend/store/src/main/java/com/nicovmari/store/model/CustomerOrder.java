package com.nicovmari.store.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.View;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "v_customer_orders")
public class CustomerOrder {

    @Id
    @Column(name = "order_product_id")
    private String  orderProductId;

    @Column(name = "id_customer")
    private long idCustomer;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "id_order")
    private long idOrder;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "total_product_price")
    private double totalProductPrice;

    @Column(name = "total_order_price")
    private double totalOrderPrice;

}
