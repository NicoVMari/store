package com.nicovmari.store.dao;

import com.nicovmari.store.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier,Long> {
}
