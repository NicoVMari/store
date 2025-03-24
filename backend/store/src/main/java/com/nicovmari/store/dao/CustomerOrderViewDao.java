package com.nicovmari.store.dao;

import com.nicovmari.store.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderViewDao extends JpaRepository <CustomerOrder,Long>{
    List<CustomerOrder> findByCustomerName(String customerName);
}
