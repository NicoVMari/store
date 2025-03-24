package com.nicovmari.store.service;


import com.nicovmari.store.dao.SupplierDao;
import com.nicovmari.store.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierDao supplierDao;


    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return new ResponseEntity<>(supplierDao.findAll(), HttpStatus.OK);
    }
}
