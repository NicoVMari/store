package com.nicovmari.store.dao;

import com.nicovmari.store.model.OrderProductId;
import com.nicovmari.store.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<Orders, OrderProductId> {
}
